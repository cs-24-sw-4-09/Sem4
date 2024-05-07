package Interpreter;

import Grammar.*;
import Interpreter.Nodes.*;

import java.util.Arrays;

import javax.sound.midi.*;

import Util.*;
import Util.notation.Chord;
import Util.notation.Pause;

import java.util.List;
import java.util.ArrayList;

public class Visitor extends MusicLanguageBaseVisitor<ASTNode> {
    private final SymbolTable symbolTable;
    private int bpm;
    private StringBuilder interpretationResult;
    // private TimingHandler timingHandler;

    private PlaybackHandler playbackHandler;

    public Visitor() {
        this.interpretationResult = new StringBuilder();
        this.symbolTable = new SymbolTable();
    }

    @Override
    public ASTNode visitProgram(MusicLanguageParser.ProgramContext ctx) {
        System.out.println("kigher");
        ASTNode program = new ASTNode("program");

        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            visit(statementContext);
            // program.addChild(visit(statementContext));

            // ASTNode statementNode = visit(statementContext);
            // program.addChild(visit(statementContext));
        }
        try {
            System.out.println("Start Playback");
            new Thread(() -> playbackHandler.startPlayback()).start();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return program;
    }

    @Override
    public ASTNode visitBpmStatement(MusicLanguageParser.BpmStatementContext ctx) {
        int bpm = Integer.parseInt(ctx.INT().getText());
        System.out.println("BPM: " + bpm);
        try {
            playbackHandler = new PlaybackHandler(bpm);

            // timingHandler = new TimingHandler(4, bpm);
        } catch (Exception e) {
            throw new RuntimeException("Nu-uhuh");
        }
        return new BpmStatement(bpm);
    }

    @Override
    public ASTNode visitLetStatement(MusicLanguageParser.LetStatementContext ctx) {
        String variable = ctx.variable.getText();
        MusicLanguageParser.ExpressionContext expressionContext = ctx.expression();
        ASTNode value = visit(expressionContext);
        // System.out.println("Variable: " + variable + " Value: " + value);
        LetStatement letStatement = new LetStatement(variable, value);

        symbolTable.enterSymbol(variable, value);
        return letStatement;
    }

    @Override
    public ASTNode visitArithmeticOperation(MusicLanguageParser.ArithmeticOperationContext ctx) {
        System.out.println("VisitArithmeticOperation called");
        String expressionText = ctx.getText();
        System.out.println("Expression: " + expressionText);
        IntegerValueNode integerValueNode = new IntegerValueNode(0);
        int firstInt = 0;
        int secondInt = 0;
        if (expressionText != null) {
            String[] components = expressionText.split("\\s*(?=[-+*/])|(?<=[-+*/])\\s*");
            System.out.println("Components: " + Arrays.toString(components));
            if (components.length > 1) {
                System.err.println("Invalid expression format: " + expressionText);
                return null;
            }
            String firstVariable = components[0].trim();
            String operator = components[1].trim();
            String secondVariable = components[2].trim();
            
            if (symbolTable.containsSymbol(firstVariable)) {
                ASTNode firstValue = symbolTable.retrieveSymbol(firstVariable);
                firstInt = ((IntegerValueNode) firstValue).getValue();
            } else if(firstVariable.matches("\\d+")) {
                firstInt = Integer.parseInt(firstVariable);
            } else {
                System.err.println("Invalid arithmetic operation: " + firstVariable + " " + operator + " " + secondVariable);
                return null;
            }

            if(symbolTable.containsSymbol(secondVariable)) {
                ASTNode secondValue = symbolTable.retrieveSymbol(secondVariable);
                secondInt = ((IntegerValueNode) secondValue).getValue();
            } else if(secondVariable.matches("\\d+")) {
                secondInt = Integer.parseInt(secondVariable);
            } else {
                System.err.println("Invalid arithmetic operation: " + firstVariable + " " + operator + " " + secondVariable);
                return null;
            }

            switch (operator) {
                case "+":
                    integerValueNode.setValue(firstInt + secondInt);
                    break;
                case "-":
                    integerValueNode.setValue(firstInt - secondInt);
                    break;
                case "*":
                    integerValueNode.setValue(firstInt * secondInt);
                    break;
                case "/":
                    integerValueNode.setValue(firstInt / secondInt);
                    break;
                default:
                    System.err.println("Invalid operator: " + operator);
                    return null;
            }
        }
        return integerValueNode;
    }

    @Override
    public ASTNode visitLogicalOperation(MusicLanguageParser.LogicalOperationContext ctx) {
        System.out.println("VisitLogicalOperation called");
        String expressionText = ctx.getText();
        System.out.println("Expression: " + expressionText);
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
            ASTNode firstValue = symbolTable.retrieveSymbol(firstVariable);
            ASTNode secondValue = symbolTable.retrieveSymbol(secondVariable);
            if (firstValue instanceof BooleanValueNode && secondValue instanceof BooleanValueNode) {
                boolean firstBool = ((BooleanValueNode) firstValue).getValue();
                boolean secondBool = ((BooleanValueNode) secondValue).getValue();
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

    @Override
    public ASTNode visitParenthesis(MusicLanguageParser.ParenthesisContext ctx) {
        System.out.println("VisitParenthesis called");

        return null;
    }

    @Override
    public ASTNode visitNotOperation(MusicLanguageParser.NotOperationContext ctx) {
        System.out.println("VisitNotOperation called");
        String expressionText = ctx.getText();
        System.out.println("Expression: " + expressionText);
        BooleanValueNode booleanValueNode = new BooleanValueNode(false);
        if (expressionText != null) {
            String[] components = expressionText.split("!");
            if (components.length != 2) {
                System.err.println("Invalid expression format: " + expressionText);
                return null;
            }
            String operator = components[0].trim();
            String variable = components[1].trim();
            ASTNode value = symbolTable.retrieveSymbol(variable);
            if (value instanceof BooleanValueNode) {
                boolean bool = ((BooleanValueNode) value).getValue();
                booleanValueNode.setValue(!bool);
            } else {
                System.err.println("Invalid logical operation: " + operator + " " + variable);
                return null;
            }
        }
        return booleanValueNode;
    }

    @Override
    public ASTNode visitComparison(MusicLanguageParser.ComparisonContext ctx) {
        System.out.println("VisitComparison called");
        String expressionText = ctx.getText();
        System.out.println("Expression: " + expressionText);
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
            ASTNode firstValue = symbolTable.retrieveSymbol(firstVariable);
            ASTNode secondValue = symbolTable.retrieveSymbol(secondVariable);
            if (firstValue instanceof IntegerValueNode && secondValue instanceof IntegerValueNode) {
                int firstInt = ((IntegerValueNode) firstValue).getValue();
                int secondInt = ((IntegerValueNode) secondValue).getValue();
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
            } else {
                System.err.println("Invalid comparison: " + firstVariable + " " + operator + " " + secondVariable);
                return null;
            }
        }

        return booleanValueNode;
    }

    @Override
    public ASTNode visitWhileStatement(MusicLanguageParser.WhileStatementContext ctx) {
        System.out.println("VisitWhileStatement called");
        ASTNode value = null;

        while (visit(ctx.expression()) instanceof BooleanValueNode c && c.getValue()) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
                System.out.println("Statement: " + statementContext.getText());
            }
        }

        if (!(visit(ctx.expression()) instanceof BooleanValueNode))
            throw new RuntimeException("While condition must be a boolean");

        return value;
    }

    @Override
    public ASTNode visitIfStatement(MusicLanguageParser.IfStatementContext ctx) {
        System.out.println("VisitIfStatement called");
        ASTNode value = null;

        if (visit(ctx.expression()) instanceof BooleanValueNode c && c.getValue()) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
                System.out.println("Statement: " + statementContext.getText());
            }
        }

        if (!(visit(ctx.expression()) instanceof BooleanValueNode))
            throw new RuntimeException("If condition must be a boolean");

        return value;
    }

    @Override
    public ASTNode visitRepeatStatement(MusicLanguageParser.RepeatStatementContext ctx) {
        System.out.println("VisitRepeatStatement called");
        int repeat = Integer.parseInt(ctx.INT().getText());
        ASTNode value = null;

        for (int i = 0; i < repeat; i++) {
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                value = visit(statementContext);
                System.out.println("Statement: " + statementContext.getText());
            }
        }

        return value;
    }
    /*
     * @Override
     * public ASTNode visitWhileStatement(MusicLanguageParser.WhileStatementContext
     * ctx) {
     * System.out.println("VisitWhileStatement called" + ctx.expression());
     * String expressionText = ctx.expression().getText();
     * visit(ctx.expression());
     * String[] components =
     * expressionText.split("(?<=\\w)(?=([<>!=]=|[<>]))|(?<=[<>!=]=|[<>])(?=\\w)");
     * 
     * if (components.length != 3) {
     * System.err.println("Invalid expression format: " + expressionText);
     * return null;
     * }
     * 
     * // Extract the components
     * String firstVariable = components[0].trim();
     * String operator = components[1].trim();
     * String secondVariable = components[2].trim();
     * System.out.println("First variable: " + firstVariable);
     * System.out.println("Operator: " + operator);
     * System.out.println("Second variable: " + secondVariable);
     * 
     * // Evaluate the expression
     * 
     * System.out.println(symbolTable.retrieveSymbol(firstVariable));
     * int secondValue;
     * if (secondVariable.matches("\\d+")) {
     * secondValue = Integer.parseInt(secondVariable);
     * }
     * 
     * while (evaluateExpression(int1, operator, secondValue)) {
     * for (MusicLanguageParser.StatementContext statementContext : ctx.statement())
     * {
     * visit(statementContext);
     * System.out.println("Statement: " + statementContext.getText());
     * }
     * int1++;
     * }
     * 
     * 
     * return new ASTNode("while loop executed");
     * }
     * 
     * 
     * private boolean evaluateExpression(int int1, String operator, int
     * secondValue) {
     * switch (operator) {
     * case "<":
     * return int1 < secondValue;
     * case "<=":
     * return int1 <= secondValue;
     * case ">":
     * return int1 > secondValue;
     * case ">=":
     * return int1 >= secondValue;
     * case "==":
     * return int1 == secondValue;
     * case "!=":
     * return int1 != secondValue;
     * default:
     * System.err.println("Invalid operator: " + operator);
     * return false;
     * }
     * }
     */

    @Override
    public ASTNode visitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx) {
        System.out.println("visitExpressionStatement called");
        String variable = ctx.expression().getText();
        System.out.println("Variable: " + variable);
        visit(ctx.expression());
        int lineNumber = ctx.getStart().getLine();
        // System.out.println("Retrieving PauseStatement with key: " + "pause" +
        // lineNumber);
        System.out.println("Retrieved PauseStatement: " + symbolTable.retrieveSymbol("pause" + lineNumber));
        // ASTNode symbolValue = symbolTable.retrieveSymbolValue(variable);
        // System.out.println(symbolTable.retrieveSymbol(variable));
        if (symbolTable.retrieveSymbol(variable) instanceof NoteStatement) {
            System.out.println("PG13 comment :)  " + symbolTable.retrieveSymbolValue(variable));
            String note = symbolTable.retrieveSymbolValue(variable).toString();
            int duration = Integer.parseInt(note.substring(0, 1));
            note = note.substring(1);
            System.out.println("Note: " + note);

            playbackHandler.addNotation("default", new Util.notation.Note(noteToMidi(note), duration));
            // timingHandler.addNote(new Note(100, noteToMidi(note), duration), "default",
            // 0);

        } else if (symbolTable.retrieveSymbol(variable) instanceof ChordStatement) {
            System.out.println("1!!!!)" + symbolTable.retrieveSymbolValue(variable));
            ChordStatement chord = (ChordStatement) symbolTable.retrieveSymbolValue(variable);

            List<String> allNotes = new ArrayList<>();
            for (String notesString : chord.getNotes()) {
                notesString = notesString.replace("[", "").replace("]", "");
                List<String> notes = Arrays.asList(notesString.split(", "));
                allNotes.addAll(notes);
            }

            /*
             * Note[] noteArray = new Note[allNotes.size()];
             * for (int i = 0; i < allNotes.size(); i++) {
             * String note = allNotes.get(i);
             * int duration = Integer.parseInt(note.substring(0, 1));
             * note = note.substring(1);
             * noteArray[i] = new Note(100, noteToMidi(note), duration);
             * }
             */

            int[] tones = new int[allNotes.size()];
            int durationInBeats = Integer.parseInt(allNotes.get(0).substring(0, 1)); // OBS DUCTTAPE LOESNING!!!!!!!
            for (int i = 0; i < allNotes.size(); i++) {
                tones[i] = noteToMidi(allNotes.get(i).substring(1));
            }

            playbackHandler.addNotation("default", new Chord(tones, durationInBeats));

            // timingHandler.playChord(noteArray, "default");

        } else if (symbolTable.retrieveSymbol("pause" + lineNumber) instanceof PauseStatement) {
            System.out.println("PauseStatement encountered");
            PauseStatement pause = (PauseStatement) symbolTable.retrieveSymbolValue("pause" + lineNumber);
            // int duration = pause.getDuration();
            // timingHandler.addPause(duration, "default");

            playbackHandler.addNotation("default", new Pause(pause.getDuration()));

        } else if (symbolTable.retrieveSymbol(variable) instanceof PauseStatement) {
            PauseStatement pause = (PauseStatement) symbolTable.retrieveSymbol(variable);
            // int duration = pause.getDuration();
            // timingHandler.addPause(duration, "default");

            playbackHandler.addNotation("default", new Pause(pause.getDuration()));
        }

        Expressions expressionStatement = new Expressions(variable);
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
        System.out.println("kig lgie din dejlige person: " + note);
        return noteStatement;
    }

    @Override
    public ASTNode visitChord(MusicLanguageParser.ChordContext ctx) {
        String chord = ctx.getText();
        String[] notes = chord.split(",");
        ChordStatement chordStatement = new ChordStatement(Arrays.asList(notes));
        System.out.println("Chord: " + chord);
        return chordStatement;
    }

    @Override
    public ASTNode visitPause(MusicLanguageParser.PauseContext ctx) {
        System.out.println("VistitPause called");
        String text = ctx.getText();
        int duration = Integer.parseInt(text.substring(0, text.length() - 1)); // remove the '-' and parse the number
        PauseStatement pauseStatement = new PauseStatement(duration);

        int lineNumber = ctx.getStart().getLine();
        System.out.println("Adding PauseStatement with key: " + "pause" + lineNumber);
        symbolTable.enterSymbol("pause" + lineNumber, pauseStatement);

        return pauseStatement;
    }

    @Override
    public ASTNode visitBoolean(MusicLanguageParser.BooleanContext ctx) {
        boolean bool = Boolean.parseBoolean(ctx.getText());
        return new BooleanValueNode(bool);
    }

    /*
     * @Override
     * public ASTNode visitNoteStatement(MusicLanguageParser.NoteStatementContext
     * ctx) {
     * String note = ctx.NOTE().getText();
     * return new NoteStatement(note);
     * }
     */
    @Override
    public ASTNode visitSampleStatement(MusicLanguageParser.SampleStatementContext ctx) {
        String sample = ctx.STRING().getText();
        String instrument = ctx.INSTRUMENT().getText();
        SampleStatement sampleStatement = new SampleStatement(sample, instrument);
        System.out.println("Sample: " + sample + " Instrument: " + instrument);
        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            sampleStatement.addChild(visit(statementContext));
        }
        return sampleStatement;
    }
    /*
     * @Override
     * public ASTNode visitPlayStatement(MusicLanguageParser.PlayStatementContext
     * ctx) {
     * String sample = ctx.getText();
     * PlayStatement playStatement = new PlayStatement(sample);
     * for (MusicLanguageParser.SampleStatementContext sampleStatementContext :
     * ctx.sampleStatement()) {
     * playStatement.addChild(visit(sampleStatementContext));
     * }
     * return playStatement;
     * }
     */
    /*
     * @Override
     * public ASTNode visitPauseStatement(MusicLanguageParser.PauseStatementContext
     * ctx) {
     * int duration = Integer.parseInt(ctx.INT().getText());
     * PauseStatement pauseStatement = new PauseStatement(duration);
     * return pauseStatement;
     * }
     */

    @Override
    public ASTNode visitAssignementStatement(MusicLanguageParser.AssignementStatementContext ctx) {
        String variableName = ctx.STRING().getText(); // Get the variable name
        System.out.println("Variable name: " + variableName);

        ASTNode value = visit(ctx.expression()); // Get the value of the variable
        System.out.println("Value: " + value);

        AssignementStatement assignementStatement = new AssignementStatement(variableName, value);
        symbolTable.enterSymbol(variableName, value);
        return assignementStatement;
    }

    public int noteToMidi(String note) {
        char noteName;
        int octave;
        int noteValue = 0;
        if (note.contains("#")) {
            noteName = note.charAt(0);
            noteValue += 1;
            octave = Integer.parseInt(note.substring(2));
        } else {
            noteName = note.charAt(0);
            octave = Integer.parseInt(note.substring(1));
        }

        switch (noteName) {
            case 'A':
                noteValue += 1;
                break;
            case 'B':
                noteValue += 3;
                break;
            case 'C':
                noteValue += 4;
                break;
            case 'D':
                noteValue += 6;
                break;
            case 'E':
                noteValue += 8;
                break;
            case 'F':
                noteValue += 9;
                break;
            case 'G':
                noteValue += 11;
                break;
        }

        return noteValue + (octave * 12) + 20 - 12; // Note value from parsed from A-G + octave * 12 (there are 12
        // different
        // tones) + 20 (The Scale starts at 21)
    }
}
