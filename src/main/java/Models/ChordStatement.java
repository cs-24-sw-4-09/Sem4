package Models;

import Interpreter.ASTNode;
import java.util.List;

public class ChordStatement extends ASTNode {
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

