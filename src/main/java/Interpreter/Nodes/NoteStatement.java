package Interpreter.Nodes;

public class NoteStatement extends Statements {
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