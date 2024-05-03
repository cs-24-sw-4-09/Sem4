    package Interpreter;

    import Grammar.*;
    import Interpreter.Nodes.*;
import Interpreter.Nodes.ASTNode;
import Interpreter.Nodes.BooleanValueNode;
import Interpreter.Nodes.BpmStatement;
import Interpreter.Nodes.ChordStatement;
import Interpreter.Nodes.IntegerValueNode;
import Interpreter.Nodes.LetStatement;
import Interpreter.Nodes.NoteStatement;
import Interpreter.Nodes.SampleStatement;

import java.util.Arrays;

    import javax.sound.midi.*;
    import Util.*;
    import java.util.List;
    import java.util.ArrayList;

    public class Visitor extends MusicLanguageBaseVisitor<ASTNode> {
        private final SymbolTable symbolTable;
        private int bpm;
        private StringBuilder interpretationResult;
        private TimingHandler timingHandler;

        public Visitor() {
            this.interpretationResult = new StringBuilder();
            this.symbolTable = new SymbolTable();
        }

        public void setTimingHandler(TimingHandler timingHandler) {
            this.timingHandler = timingHandler;
        }

        public SymbolTable getSymbolTable() {
            return symbolTable;
        }

        
        @Override
        public ASTNode visitProgram(MusicLanguageParser.ProgramContext ctx) {
            ASTNode program = new ASTNode("program");

            if(ctx == null){
                System.out.println("Error: No program found");
                return null;
            }
            for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
                visit(statementContext);
                //program.addChild(visit(statementContext));
                
                //ASTNode statementNode = visit(statementContext);
            // program.addChild(visit(statementContext));
            }
            try {
                timingHandler.play();
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
                timingHandler = new TimingHandler(4, bpm);
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
            //System.out.println("Variable: " + variable + " Value: " + value);
            LetStatement letStatement = new LetStatement(variable, value);

            symbolTable.enterSymbol(variable, value);
            return letStatement;
        }

        @Override
        public ASTNode visitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx) {
            String variable = ctx.expression().getText();
            //ASTNode symbolValue = symbolTable.retrieveSymbolValue(variable);
            //System.out.println(symbolTable.retrieveSymbol(variable));
            if (symbolTable.retrieveSymbolValue(variable) instanceof NoteStatement) {
                System.out.println("PG13 comment :)  "+symbolTable.retrieveSymbolValue(variable));
                String note = symbolTable.retrieveSymbolValue(variable).toString();
                int duration = Integer.parseInt(note.substring(0, 1));
                note = note.substring(1);
                System.out.println(" HERHE HREHRHEHREHREHNote: " + note);
                timingHandler.addNote(new Note(100, noteToMidi(note), duration), "default", 0);

            }else if(symbolTable.retrieveSymbolValue(variable) instanceof ChordStatement) {
                System.out.println("1!!!!)"+symbolTable.retrieveSymbolValue(variable));
                ChordStatement chord = (ChordStatement) symbolTable.retrieveSymbolValue(variable);

                List<String> allNotes = new ArrayList<>();
                for (String notesString : chord.getNotes()) {
                    notesString = notesString.replace("[", "").replace("]", "");
                    List<String> notes = Arrays.asList(notesString.split(", "));
                    allNotes.addAll(notes);
                }

                Note[] noteArray = new Note[allNotes.size()];
                for (int i = 0; i < allNotes.size(); i++) {
                    String note = allNotes.get(i);
                    int duration = Integer.parseInt(note.substring(0, 1));
                    note = note.substring(1);
                    noteArray[i] = new Note(100, noteToMidi(note), duration);
                }
                timingHandler.playChord(noteArray, "default");
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
        public ASTNode visitBoolean(MusicLanguageParser.BooleanContext ctx) {
            boolean bool = Boolean.parseBoolean(ctx.getText());
            return new BooleanValueNode(bool);
        }


    /*
        @Override
        public ASTNode visitNoteStatement(MusicLanguageParser.NoteStatementContext ctx) {
            String note = ctx.NOTE().getText();
            return new NoteStatement(note);
        }
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
        @Override
        public ASTNode visitPlayStatement(MusicLanguageParser.PlayStatementContext ctx) {
            String sample = ctx.getText();
            PlayStatement playStatement = new PlayStatement(sample);
            for (MusicLanguageParser.SampleStatementContext sampleStatementContext : ctx.sampleStatement()) {
                playStatement.addChild(visit(sampleStatementContext));
            }
            return playStatement;
        }
        */
        /*
        @Override
        public ASTNode visitPauseStatement(MusicLanguageParser.PauseStatementContext ctx) {
            int duration = Integer.parseInt(ctx.INT().getText());
            PauseStatement pauseStatement = new PauseStatement(duration);
            return pauseStatement;
        }
        */

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
