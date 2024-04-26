package Interpreter.Nodes;

public class StringValueNode extends ASTNode {
    private String value;

    public StringValueNode(String value) {
        super("stringValueNode");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}