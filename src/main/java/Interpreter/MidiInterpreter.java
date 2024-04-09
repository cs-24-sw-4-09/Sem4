package Interpreter;

import Grammar.*;
import Util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.*;
import java.io.EOFException;

import org.antlr.v4.runtime.tree.TerminalNode;

public class MidiInterpreter {
    private int bpm;
    private StringBuilder interpretationResult;
    private TimingHandler timingHandler;


    public MidiInterpreter() {
        this.interpretationResult = new StringBuilder();
        
    }

    public void interpretAST(ASTNode node) {
        if (node == null) {
            return;
        }

        if (node instanceof BpmStatement) {
            interpretBPMStatement((BpmStatement) node);
        } else if (node instanceof PlayStatement) {
            interpretPlayStatement((PlayStatement) node);
        } else {
            for (ASTNode child : node.getChildren()) {
                interpretAST(child);
            }
        }
    }
    
    private void interpretPlayStatement(PlayStatement node) { 
        List<ASTNode> statements = node.getChildren();
        for (ASTNode statement : statements) {
            if (statement instanceof SampleStatement) {
                interpretSampleStatement((SampleStatement) statement);
            } else {
                System.out.println("Error: Invalid statement in play block");
            }
        }
        interpretationResult.append("Playing: ").append(statements).append("\n");
        try {
            timingHandler.play();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void interpretSampleStatement(SampleStatement node) {
        String sample = node.getSample();
        String instrument = node.getInstrument();
        interpretationResult.append("Played sample: ").append(sample).append(" " + instrument).append("\n");

        

        List<ASTNode> statements = node.getChildren();
        for (ASTNode statement : statements) {
            if (statement instanceof NoteStatement) {
                interpretNoteStatement((NoteStatement) statement);
            } else {
                interpretAST(statement);
            }
        }
    }
    

    private void interpretNoteStatement(NoteStatement node) {
        String note = node.getNote();
        int duration = Integer.parseInt(note.substring(0, 1));
        note = note.substring(1);
        System.out.println("Note: " + note);
        timingHandler.addNote(new Note(100, noteToMidi(note), duration), "default");
        interpretationResult.append("Played note: ").append(note).append("\n");
    }

    private void interpretBPMStatement(BpmStatement node) {
        this.bpm = node.getBpm();
        {
            try {
                timingHandler = new TimingHandler(4, bpm);
            } catch (Exception e) {
                throw new RuntimeException("Nu-uhuh");
            }
        }
        interpretationResult.append("Set BPM to: ").append(bpm).append("\n");
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

        return noteValue + (octave * 12) + 20; // Note value from parsed from A-G + octave * 12 (there are 12 different
                                               // tones) + 20 (The Scale starts at 21)
    }

    public int getInstrument(String instrument) {
        switch (instrument.toUpperCase()) {
            case "PIANO":
                return 0;
            case "DRUMS":
                return 8;
            case "GUITAR":
                return 24;
            case "BASS":
                return 32;
            case "VIOLIN":
                return 40;
            case "TRUMPET":
                return 56;
            case "SAXOPHONE":
                return 64;
            case "FLUTE":
                return 72;
            case "SYNTH":
                return 80;
            default:
                throw new IllegalArgumentException("Invalid instrument: " + instrument);
        }
    }

    public String getInterpretationResult() {
        return interpretationResult.toString();
    }
}

