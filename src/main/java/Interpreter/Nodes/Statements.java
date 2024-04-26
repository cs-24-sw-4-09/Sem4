package Interpreter.Nodes;

public abstract class Statements extends ASTNode {
    private String type;

    public Statements(String type) {
        super("Statements");
        this.type = type;
    }
}