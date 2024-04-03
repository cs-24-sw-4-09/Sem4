package Interpreter;

import Grammar.*;
import java.util.List;
import javax.sound.midi.*;
import java.io.EOFException;

import org.antlr.v4.runtime.tree.TerminalNode;

public class MidiInterpreter {
    private int bpm;
    private StringBuilder interpretationResult;
    private Synthesizer synthesizer;
    private MidiChannel[] channels;
    private boolean isSynthOpen;

    public MidiInterpreter(int bpm) {
        this.bpm = 120; //default bpm
        this.interpretationResult = new StringBuilder();
        this.isSynthOpen = false;
        try {
            this.synthesizer = MidiSystem.getSynthesizer();
            this.synthesizer.open();
            this.channels = synthesizer.getChannels();
        } catch (MidiUnavailableException e ) {
            e.printStackTrace();
        }
    }

    public void openSynth(){
        try {
            this.synthesizer = MidiSystem.getSynthesizer();
            this.synthesizer.open();
            this.channels = synthesizer.getChannels();
            isSynthOpen = true;
            System.out.println("Synth open");
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void closeSynth(){
        if (isSynthOpen) {
            try {
                synthesizer.close();
                System.out.println("Synth closed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setEOF(boolean EOF){
        closeSynth();
    }

    public void interpretAST(ASTNode node){
        if (!isSynthOpen) {
            openSynth();
        }
        if(node == null) {
            return;         
        }

        if(node instanceof BpmStatement){
            interpretBPMStatement((BpmStatement) node);
        }
        else if(node instanceof SampleStatement){
            interpretSampleStatement((SampleStatement) node);
        }
        else if(node instanceof NoteStatement){
            interpretNoteStatement((NoteStatement) node);
        } else {
            for(ASTNode child : node.getChildren()){
                interpretAST(child);
            }
        }
    }

    private void interpretSampleStatement(SampleStatement node) {
        String sample = node.getSample();
        String instrument = node.getInstrument();
        
        channels[0].programChange(getInstrument(instrument));
        interpretationResult.append("Played sample: ").append(sample).append(" " + instrument).append("\n");
        
        List<ASTNode> statements = node.getChildren();
        for (ASTNode statement : statements) {
            interpretAST(statement);
        }
        channels[0].programChange(0);
        
    }

    private void interpretNoteStatement(NoteStatement node) {
        String note = node.getNote();
        try {

            channels[0].noteOn(noteToMidi(note), bpm);
            System.out.println();
            Thread.sleep(500);
            channels[0].noteOff(noteToMidi(note));
            
            interpretationResult.append("Played note: ").append(note).append("\n");
            System.out.println("Updated interpretation result: " + interpretationResult.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void interpretBPMStatement(BpmStatement node) {
        this.bpm = node.getBpm();}{

    }

    private int noteToMidi(String note) {
        char noteName = note.charAt(0);
        int octave = Integer.parseInt(note.substring(1));

        int noteValue;
        switch (note.charAt(0)) {
            case 'C':
                noteValue = 60;
                break;
            case 'D':
                noteValue = 62;
                break;
            case 'E':
                noteValue = 64;
                break;
            case 'F':
                noteValue = 65;
                break;
            case 'G':
                noteValue = 67;
                break;
            case 'A':
                noteValue = 69;
                break;
            case 'B':
                noteValue = 71;
                break;
            default:
                throw new IllegalArgumentException("Invalid note name: " + note);
        }

        return noteValue + (12 * (octave - 4));
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
