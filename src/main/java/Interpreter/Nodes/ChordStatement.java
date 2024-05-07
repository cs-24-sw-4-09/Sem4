package Interpreter.Nodes;

import java.util.List;

public class ChordStatement extends Statements{
    private List<String> notes;

    public ChordStatement(List<String> notes) {
        super("chordStatement");
        this.notes = notes;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return notes.toString();
    }
}