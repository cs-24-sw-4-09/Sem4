package Interpreter.Nodes;

public class AssignmentStatement extends ASTNode {
    private String name;
    private ASTNode value;
    
    public AssignmentStatement(String name, ASTNode value) {
        super("AssignmentStatement");
        this.name = name;
        this.value = value;        
    }

    public String getName() {
        return name;
    }

    public void setValue(ASTNode value) {
        this.value = value;
    }
}