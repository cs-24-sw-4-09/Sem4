package Interpreter;


import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    private String type;
    private List<ASTNode> children;

    public ASTNode(String type) {
        this.type = type;
        this.children = new ArrayList<>();
        
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    public String getType() {
        return type;
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    

}

class NoteStatement extends ASTNode {
    private String note;

    public NoteStatement(String note) {
        super("noteStatement");
        this.note = note;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }
}

class ChordStatement extends ASTNode {
    private List<String> notes;
    private int octave;

    public ChordStatement(List<String> notes, int octave) {
        super("chordStatement");
        this.notes = notes;
        this.octave = octave;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }
}

class BpmStatement extends ASTNode {
    private int bpm;

    public BpmStatement(int bpm) {
        super("bpmStatement");
        this.bpm = bpm;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }
}

class TimeSignatureStatement extends ASTNode {
    private int numerator;
    private int denominator;

    public TimeSignatureStatement(int numerator, int denominator) {
        super("timeSignatureStatement");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}

class SampleStatement extends ASTNode {
    private String sample;
    private String instrument;

    public SampleStatement(String sample, String instrument) {
        super("sampleStatement");
        this.sample = sample;
        this.instrument = instrument;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}

class PlayStatement extends ASTNode {
    private String sample;

    public PlayStatement(String sample) {
        super("playStatement");
        this.sample = sample;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
}

class PauseStatement extends ASTNode {
    private int duration;
    public PauseStatement(int duration) {
        super("pauseStatement");
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}


