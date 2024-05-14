package Interpreter.Nodes;

public class AssignementStatement extends ASTNode {
    private String name;
    private ASTNode value;
    
    public AssignementStatement(String name, ASTNode value) {
        super("AssignementStatement");
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