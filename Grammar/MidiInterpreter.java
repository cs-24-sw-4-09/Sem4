import java.util.List;

import javax.sound.midi.*;

public class MidiInterpreter {
    private int bpm;
    private StringBuilder interpretationResult;

    public MidiInterpreter(int bpm) {
        this.bpm = 120; //default bpm
        this.interpretationResult = new StringBuilder();
    }

    public void interpretAST(ASTNode node){
        if(node == null) return;

        if(node instanceof BpmStatement){
            this.bpm = ((BpmStatement) node).getBpm();
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
        
        interpretationResult.append("Played sample: ").append(sample).append("\n");
        
        List<ASTNode> statements = node.getChildren();
        for (ASTNode statement : statements) {
            interpretAST(statement);
        }
    }

    private void interpretNoteStatement(NoteStatement node) {
        String note = node.getNote();
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] channels = synthesizer.getChannels();
            channels[0].noteOn(noteToMidi(note), bpm);
            Thread.sleep(500);
            channels[0].noteOff(noteToMidi(note));
            synthesizer.close();

            interpretationResult.append("Played note: ").append(note).append("\n");
            System.out.println("Updated interpretation result: " + interpretationResult.toString());
        } catch (MidiUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
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


    public String getInterpretationResult() {
        return interpretationResult.toString();
    }
}
