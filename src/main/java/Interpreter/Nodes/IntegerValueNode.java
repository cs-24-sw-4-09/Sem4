package Interpreter.Nodes;

public class IntegerValueNode extends Expressions {
    private int value;

    public IntegerValueNode(int value) {
        super("integerValueNode");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}