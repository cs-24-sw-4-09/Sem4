package Interpreter.Nodes;

import java.util.List;

public class RepeatStatement  extends Statements{
    private ASTNode condition;
    private List<ASTNode> statements;

    public RepeatStatement(ASTNode condition, List<ASTNode> statements) {
        super("RepeatStatement");
        this.condition = condition;
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "RepeatStatement{}";
    }
    
}
