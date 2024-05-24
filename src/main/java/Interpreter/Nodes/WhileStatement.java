package Interpreter.Nodes;

import java.util.List;

public class WhileStatement extends Statements{    
    private ASTNode condition;
    private List<ASTNode> statements;


    
    public WhileStatement(ASTNode condition, List<ASTNode> statements) {
        super("WhileStatement");
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "WhileStatement{}";
    }
    
}
