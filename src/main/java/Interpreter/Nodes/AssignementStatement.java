package Interpreter.Nodes;

public class AssignementStatement extends ASTNode {
    private String name;
    
    public AssignementStatement(String name) {
        super("AssignementStatement");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}