
package Interpreter;

import Grammar.*;
import Interpreter.Nodes.*;

import Util.*;
import Util.notation.Chord;
import Util.notation.Notation;
import Util.notation.Pause;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Visitor extends MusicLanguageBaseVisitor<ASTNode> {
    private final SymbolTable symbolTable;
    private final StringBuilder interpretationResult;
    

    private PlaybackHandler playbackHandler;
    public boolean insidePlayBlock = false;
    private Notation.Instrument activeInstrument = Notation.Instrument.PIANO;


    public Visitor() {
        this.interpretationResult = new StringBuilder();
        this.symbolTable = new SymbolTable();
    }
    public PlaybackHandler getPlaybackHandler() {
        return playbackHandler;
    }
    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
    @Override
    public ASTNode visitProgram(MusicLanguageParser.ProgramContext ctx) {
        ASTNode program = new ASTNode("program");

        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            visit(statementContext);
        }
        try {
            new Thread(() -> playbackHandler.startPlayback()).start();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return program;
    }

    @Override
    public ASTNode visitBpmStatement(MusicLanguageParser.BpmStatementContext ctx) {
        int bpm = Integer.parseInt(ctx.INT().getText());
        try {
            playbackHandler = new PlaybackHandler(bpm);

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
        return new BpmStatement(bpm);
    }

    @Override
    public ASTNode visitLetStatement(MusicLanguageParser.LetStatementContext ctx) {
        String variable = ctx.variable.getText();
        MusicLanguageParser.ExpressionContext expressionContext = ctx.expression();
        ASTNode value = visit(expressionContext);
        LetStatement letStatement = new LetStatement(variable, value);
        
        symbolTable.enterSymbol(variable, value);
        return letStatement;
    }

    @Override
    public ASTNode visitAddSubOperation(MusicLanguageParser.AddSubOperationContext ctx) {
        String expressionText = ctx.getText();
        IntegerValueNode integerValueNode = new IntegerValueNode(0);

        if (expressionText != null) {
            String[] components = expressionText.split("\\s*(?=[+-;])|(?<=[+-;])\\s*");

            int result = 0;

            String operator = "";

            for (String component : components) {
                component = component.trim();
                if (component.isEmpty() || component.equals(";")) {
                    continue;
                }

                if (component.equals("+") || component.equals("-")) {
                    operator = component;
                } else {
                    int value = getIntegerValue(component);
                    if (value == Integer.MIN_VALUE) {
                        System.err.println("Invalid arithmetic operation: " + component);
                        return null;
                    }
                    switch (operator) {
                        case "+":
                            result += value;
                            break;
                        case "-":
                            result -= value;
                            break;
                        default:
                            result = value;
                    }
                }
            }
            integerValueNode.setValue(result);
        }
        return integerValueNode;
    }
    

    @Override
    public ASTNode visitMultDivOperation(MusicLanguageParser.MultDivOperationContext ctx) {
        String expressionText = ctx.getText();
        IntegerValueNode integerValueNode = new IntegerValueNode(0);

        if (expressionText != null) {
            String[] components = expressionText.split("\\s*(?=[/*;])|(?<=[/*;])\\s*");

            int result = 0;

            String operator = "";

            for (String component : components) {
                component = component.trim();
                if (component.isEmpty() || component.equals(";")) {
                    continue;
                }

                if (component.equals("*") || component.equals("/")) {
                    operator = component;
                } else {
                    int value = getIntegerValue(component);
                    if (value == Integer.MIN_VALUE) {
                        System.err.println("Invalid arithmetic operation: " + component);
                        return null;
                    }
                    switch (operator) {
                        case "*":
                            result *= value;
                            break;
                        case "/":
                            result /= value;
                            break;
                        default:
                            result = value;
                    }
                }
            }
            integerValueNode.setValue(result);
        }
        return integerValueNode;
    }

    private int getIntegerValue(String variable) {
        if (symbolTable.containsSymbol(variable)) {
            ASTNode value = symbolTable.retrieveSymbol(variable);
            if (value instanceof IntegerValueNode) {
                return ((IntegerValueNode) value).getValue();
            } else if (value instanceof NoteStatement){
                String note = value.toString().substring(1);
                int amount = noteToMidi(note);
                return amount;
            } else {
                System.err.println("Invalid arithmetic operation: " + variable + " is not an integer value");
                return Integer.MIN_VALUE;
            }
        } else if (variable.matches("\\d+")) {
            return Integer.parseInt(variable);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    @Override
    public ASTNode visitLogicalOperation(MusicLanguageParser.LogicalOperationContext ctx) {
        String expressionText = ctx.getText();
        BooleanValueNode booleanValueNode = new BooleanValueNode(false);
        if (expressionText != null) {
            String[] components = expressionText.split("(?<=\\w)(?=(&&|\\|\\|))|(?<=(&&|\\|\\|))(?=\\w)");
            if (components.length != 3) {
                System.err.println("Invalid expression format: " + expressionText);
                return null;
            }
            String firstVariable = components[0].trim();
            String operator = components[1].trim();
            String secondVariable = components[2].trim();

            Object firstValue = getValue(firstVariable);
            Object secondValue = getValue(secondVariable);

            if (firstValue instanceof Boolean || firstValue instanceof BooleanValueNode) {
                boolean firstBool = (firstValue instanceof Boolean) ? (Boolean) firstValue
                        : ((BooleanValueNode) firstValue).getValue();
                boolean secondBool = (secondValue instanceof Boolean) ? (Boolean) secondValue
                        : ((BooleanValueNode) secondValue).getValue();
                switch (operator) {
                    case "&&":
                        booleanValueNode.setValue(firstBool && secondBool);
                        break;
                    case "||":
                        booleanValueNode.setValue(firstBool || secondBool);
                        break;
                    default:
                        System.err.println("Invalid operator: " + operator);
                        return null;
                }
            } else {
                System.err
                        .println("Invalid logical operation: " + firstVariable + " " + operator + " " + secondVariable);
                return null;
            }
        }
        return booleanValueNode;
    }
    

    private Object getValue(String variable) {
        if (symbolTable.containsSymbol(variable)) {
            ASTNode value = symbolTable.retrieveSymbol(variable);
            if (value instanceof BooleanValueNode || value instanceof BooleanValueNode) {
                return value;
            }
        } else if (variable.equals("true")) {
            return true;
        } else if (variable.equals("false")) {
            return false;
        }
        System.err.println("Invalid value for variable: " + variable);
        return null;
    }

    @Override
    public ASTNode visitParenthesis(MusicLanguageParser.ParenthesisContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public ASTNode visitNotOperation(MusicLanguageParser.NotOperationContext ctx) {
        ASTNode value = this.visit(ctx.expression());
        if (value instanceof BooleanValueNode) {
            boolean bool = ((BooleanValueNode) value).getValue();
            BooleanValueNode booleanValueNode = new BooleanValueNode(!bool);
            return booleanValueNode;
        } else {
            System.err.println("Invalid logical operation: " + ctx.getText());
            return null;
        }
    }

    @Override
    public ASTNode visitComparison(MusicLanguageParser.ComparisonContext ctx) {
        String expressionText = ctx.getText();
        BooleanValueNode booleanValueNode = new BooleanValueNode(false);
        if (expressionText != null) {
            String[] components = expressionText.split("(?<=\\w)(?=([<>!=]=|[<>]))|(?<=[<>!=]=|[<>])(?=\\w)");
            if (components.length != 3) {
                System.err.println("Invalid expression format: " + expressionText);
                return null;
            }
            String firstVariable = components[0].trim();
            String operator = components[1].trim();
            String secondVariable = components[2].trim();

            int firstInt = getIntegerValue(firstVariable);
            int secondInt = getIntegerValue(secondVariable);

            if (firstInt == Integer.MIN_VALUE || secondInt == Integer.MIN_VALUE) {
                System.err.println("Invalid comparison: " + firstVariable + " " + operator + " " + secondVariable);
                return null;
            }

            switch (operator) {
                case "<":
                    booleanValueNode.setValue(firstInt < secondInt);
                    break;
                case "<=":
                    booleanValueNode.setValue(firstInt <= secondInt);
                    break;
                case ">":
                    booleanValueNode.setValue(firstInt > secondInt);
                    break;
                case ">=":
                    booleanValueNode.setValue(firstInt >= secondInt);
                    break;
                case "==":
                    booleanValueNode.setValue(firstInt == secondInt);
                    break;
                case "!=":
                    booleanValueNode.setValue(firstInt != secondInt);
                    break;
                default:
                    System.err.println("Invalid operator: " + operator);
                    return null;
            }
        }
        return booleanValueNode;
    }

    @Override
    public ASTNode visitWhileStatement(MusicLanguageParser.WhileStatementContext ctx) {
        ASTNode value = null;

        while (visit(ctx.expression()) instanceof BooleanValueNode c && c.getValue()) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
            }
        }

        if (!(visit(ctx.expression()) instanceof BooleanValueNode))
            throw new RuntimeException("While condition must be a boolean");

        return value;
    }

    @Override
    public ASTNode visitIfStatement(MusicLanguageParser.IfStatementContext ctx) {
        ASTNode value = null;

        if (visit(ctx.expression()) instanceof BooleanValueNode c && c.getValue()) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
            }
        } else if (ctx.elseStatement() != null) {
            for (MusicLanguageParser.StatementContext elseStatementContext : ctx.elseStatement().statement()) {
                value = visit(elseStatementContext);
            }
        }

        if (!(visit(ctx.expression()) instanceof BooleanValueNode))
            throw new RuntimeException("If condition must be a boolean");

        return value;
    }

    @Override
    public ASTNode visitElseStatement(MusicLanguageParser.ElseStatementContext ctx) {
        ASTNode value = null;

        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            value = visit(statementContext);
        }

        return value;
    }

    @Override
    public ASTNode visitRepeatStatement(MusicLanguageParser.RepeatStatementContext ctx) {
        
        int repeat = Integer.parseInt(ctx.INT().getText());
        ASTNode value = null;

        for (int i = 0; i < repeat; i++) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
            }
        }
        return value;
    }

    @Override
    public ASTNode visitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx) {
        
        String variable = ctx.expression().getText();
        
        visit(ctx.expression());
        
        int lineNumber = ctx.getStart().getLine();
        
        if (!insidePlayBlock) {
            return null;
        }
        if (symbolTable.retrieveSymbol(variable) instanceof NoteStatement) {
            String note = symbolTable.retrieveSymbolValue(variable).toString();
            int duration = Integer.parseInt(note.substring(0, 1));
            note = note.substring(1);

            playbackHandler.addNotation("default", new Util.notation.Note(noteToMidi(note), duration, activeInstrument));
            

        } else if (symbolTable.retrieveSymbol(variable) instanceof ChordStatement) {
            
            ChordStatement chord = (ChordStatement) symbolTable.retrieveSymbolValue(variable);

            List<String> allNotes = new ArrayList<>();
            for (String notesString : chord.getNotes()) {
                notesString = notesString.replace("[", "").replace("]", "");
                List<String> notes = Arrays.asList(notesString.split(", "));
                allNotes.addAll(notes);
            }

           

            int[] tones = new int[allNotes.size()];
            int durationInBeats = Integer.parseInt(allNotes.get(0).substring(0, 1)); 
            for (int i = 0; i < allNotes.size(); i++) {
                tones[i] = noteToMidi(allNotes.get(i).substring(1));
            }

            playbackHandler.addNotation("default", new Chord(tones, durationInBeats, activeInstrument));

            

        } else if (symbolTable.retrieveSymbol("pause" + lineNumber) instanceof PauseStatement) {
            PauseStatement pause = (PauseStatement) symbolTable.retrieveSymbolValue("pause" + lineNumber);
            

            playbackHandler.addNotation("default", new Pause(pause.getDuration()));

        } else if (symbolTable.retrieveSymbol(variable) instanceof PauseStatement) {
            PauseStatement pause = (PauseStatement) symbolTable.retrieveSymbol(variable);
            

            playbackHandler.addNotation("default", new Pause(pause.getDuration()));
        }

        Statements expressionStatement = new Statements(variable);
        return expressionStatement;
    }

    @Override
    public ASTNode visitNumber(MusicLanguageParser.NumberContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        return new IntegerValueNode(value);
    }

    @Override
    public ASTNode visitString(MusicLanguageParser.StringContext ctx) {
        String stringName = ctx.getText();
        return new StringValueNode(stringName);
    }

    @Override
    public ASTNode visitNote(MusicLanguageParser.NoteContext ctx) {
        String note = ctx.getText();
        NoteStatement noteStatement = new NoteStatement(note);
        return noteStatement;
    }

    @Override
    public ASTNode visitChord(MusicLanguageParser.ChordContext ctx) {
        String chord = ctx.getText();
        String[] notes = chord.split(",");
        ChordStatement chordStatement = new ChordStatement(Arrays.asList(notes));
        return chordStatement;
    }

    @Override
    public ASTNode visitPause(MusicLanguageParser.PauseContext ctx) {
        String text = ctx.getText();
        int duration = Integer.parseInt(text.substring(0, text.length() - 1));
        PauseStatement pauseStatement = new PauseStatement(duration);

        int lineNumber = ctx.getStart().getLine();
        symbolTable.enterSymbol("pause" + lineNumber, pauseStatement);

        return pauseStatement;
    }

    @Override
    public ASTNode visitBoolean(MusicLanguageParser.BooleanContext ctx) {
        boolean bool = Boolean.parseBoolean(ctx.getText());
        return new BooleanValueNode(bool);
    }

    

    @Override
    public ASTNode visitSampleStatement(MusicLanguageParser.SampleStatementContext ctx) {
        String sample = ctx.STRING().getText();
        String instrument = ctx.INSTRUMENT().getText();
        List<MusicLanguageParser.StatementContext> statements = ctx.statement();

        activeInstrument = Notation.Instrument.parse(instrument);

        SampleStatement sampleStatement = new SampleStatement(sample, instrument, statements);
        
        symbolTable.enterSymbol(sample, sampleStatement);
        symbolTable.retrieveSymbol(sample);

        
        return sampleStatement;
    }

    @Override
    public ASTNode visitSampleCallStatement(MusicLanguageParser.SampleCallStatementContext ctx) {
        String sample = ctx.getText();
        sample = sample.substring(0, sample.length() - 3); 
        symbolTable.retrieveSymbol(sample);
        SampleStatement sampleStatement = (SampleStatement) symbolTable.retrieveSymbolValue(sample);
        for (MusicLanguageParser.StatementContext statementContext : sampleStatement.getStatements()) {
            visit(sampleStatement.getStatements().get(sampleStatement.getStatements().indexOf(statementContext)));
        }
        
        
        return null;
        
    }
    
    @Override
    public ASTNode visitPlayStatement(MusicLanguageParser.PlayStatementContext ctx) {
        insidePlayBlock = true;
        String sample = ctx.getText();
        PlayStatement playStatement = new PlayStatement(sample);
        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            playStatement.addChild(visit(statementContext));
        }
        insidePlayBlock = false;
        return playStatement;
    }
    
    @Override
    public ASTNode visitPrintStatement(MusicLanguageParser.PrintStatementContext ctx) {
        String text = ctx.STRING().getText();   
        System.out.println(text);
        return new PrintStatement(text);
    }

     @Override
     public ASTNode visitAssignmentStatement(MusicLanguageParser.AssignmentStatementContext ctx) {
          String variableName = ctx.STRING().getText();
          boolean notebool = false;
          String duration = "";
          String[] components = ctx.expression().getText().split("\\s*(?=[-+;])|(?<=[-+;])\\s*");
  
          for (String component : components) {
              ASTNode possibleNote = symbolTable.retrieveSymbol(component);
              if (possibleNote instanceof NoteStatement) {
                  duration = possibleNote.toString().substring(0, 1);
                  notebool = true;
              }
          }
  
          if (components.length == 1) {
             ASTNode findValue = symbolTable.retrieveSymbol(components[0]);
             AssignmentStatement assignementStatement = new AssignmentStatement(variableName, findValue);
             symbolTable.enterSymbol(variableName, findValue);
             return assignementStatement;
          } else {
              ASTNode value = visit(ctx.expression()); 
              AssignmentStatement assignementStatement = new AssignmentStatement(variableName, value);
              if (notebool) {
                  String intValue = midiToNote(((IntegerValueNode) value).getValue());
                  symbolTable.enterSymbol(variableName, new NoteStatement(duration + intValue));
              } else {
                  symbolTable.enterSymbol(variableName, value);
              }
              return assignementStatement;
         }
     }

    public int noteToMidi(String note) {
        String noteName;
        int octave;
        int noteValue = 0;

        if (note.contains("#")) {
            noteName = note.substring(0, 2);
            octave = Integer.parseInt(note.substring(2));
        } else {
            noteName = note.substring(0, 1);
            octave = Integer.parseInt(note.substring(1));
        }

        switch (noteName) {
            case "A":
                noteValue += 1;
                break;
            case "A#":
                noteValue += 2;
                break;
            case "B":
                noteValue += 3;
                break;
            case "C":
                noteValue += 4;
                break;
            case "C#":
                noteValue += 5;
                break;
            case "D":
                noteValue += 6;
                break;
            case "D#":
                noteValue += 7;
                break;
            case "E":
                noteValue += 8;
                break;
            case "F":
                noteValue += 9;
                break;
            case "F#":
                noteValue += 10;
                break;
            case "G":
                noteValue += 11;
                break;
            case "G#":
                noteValue += 0;
                break;
            default:
                throw new IllegalArgumentException("Invalid note name: " + noteName);
        }

        return noteValue + (octave * 12) + 20 - 12;
    }

    public String midiToNote(int midiValue) {
        int octave = (midiValue - 8) / 12;
        int noteValue = (midiValue - 20) % 12;
        String noteName;

        switch (noteValue) {
            case 1:
                noteName = "A";
                break;
            case 2:
                noteName = "A#";
                break;
            case 3:
                noteName = "B";
                break;
            case 4:
                noteName = "C";
                break;
            case 5:
                noteName = "C#";
                break;
            case 6:
                noteName = "D";
                break;
            case 7:
                noteName = "D#";
                break;
            case 8:
                noteName = "E";
                break;
            case 9:
                noteName = "F";
                break;
            case 10:
                noteName = "F#";
                break;
            case 11:
                noteName = "G";
                break;
            case 0:
                noteName = "G#";
                break;
            default:
                throw new IllegalArgumentException("Invalid MIDI value");
        }

        return noteName + octave;
    }
    
    
}
