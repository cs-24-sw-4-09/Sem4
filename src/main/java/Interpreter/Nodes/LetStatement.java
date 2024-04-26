package Interpreter.Nodes;

public class LetStatement extends Statements {
    private String variableName;
    private ASTNode value;    

    public LetStatement(String variableName, ASTNode value) {
        super("letStatement");
        this.variableName = variableName;
        this.value = value;
    }

    public String getLet() {
        return variableName;
    }

    public void setLet(String variableName) {
        this.variableName = variableName;
    }

    public ASTNode getExpression() {
        return value;
    }

    public void setExpression(ASTNode value) {
        this.value = value;
    }
}