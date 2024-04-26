package Interpreter.Nodes;

import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    private String type;
    private List<ASTNode> children;

    public ASTNode(String type) {
        this.type = type;
        this.children = new ArrayList<>();
        
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    public String getType() {
        return type;
    }

    public List<ASTNode> getChildren() {
        return children;
    }
}