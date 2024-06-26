package Interpreter.Nodes;

public class PrintStatement extends ASTNode{
    private String text;
    
    public PrintStatement(String text) {
        super(text); 
        this.text = text;
    }
    
    public void execute() {
        System.out.println(this.text);
    }
}