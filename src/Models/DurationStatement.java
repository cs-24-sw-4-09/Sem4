package Models;

import Interpreter.ASTNode;

public class DurationStatement extends ASTNode {
    private int duration;

    public DurationStatement(int duration) {
        super("durationStatement");
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
