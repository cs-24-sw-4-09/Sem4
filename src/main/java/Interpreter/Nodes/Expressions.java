package Interpreter.Nodes;

public class Expressions extends ASTNode {
    private String expression;

    public Expressions(String expression) {
        super("expressionStatement");
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }   

    public void setExpression(String expression) {
        this.expression = expression;
    }
    

}