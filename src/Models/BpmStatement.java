package Models;

import Interpreter.ASTNode;

public class BpmStatement extends ASTNode {
    private int bpm;

    public BpmStatement(int bpm) {
        super("bpmStatement");
        this.bpm = bpm;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }
}