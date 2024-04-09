package Models;

import Interpreter.ASTNode;

public class NoteStatement extends ASTNode {
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