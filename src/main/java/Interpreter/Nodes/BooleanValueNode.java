package Interpreter.Nodes;

public class BooleanValueNode extends ASTNode {
    private boolean value;

    public BooleanValueNode(boolean value) {
        super("booleanValueNode");
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}