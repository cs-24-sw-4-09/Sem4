package Interpreter.Nodes;

public class noteValueNode extends Expressions {
    private String note;

    public noteValueNode(String note) {
        super("noteValueNode");
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNoteValue(String note) {
        this.note = note;
    }
}