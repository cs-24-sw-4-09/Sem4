package Interpreter.Nodes;

public class BpmStatement extends Statements {
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