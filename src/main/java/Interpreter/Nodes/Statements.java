package Interpreter.Nodes;

public class Statements extends ASTNode {
    private String Statement;

    public Statements(String Statement) {
        super("Statements");
        this.Statement = Statement;
    }

    public String getStatement() {
        return Statement;
    }   

    public void setStatement(String Statement) {
        this.Statement = Statement;
    }
    
}