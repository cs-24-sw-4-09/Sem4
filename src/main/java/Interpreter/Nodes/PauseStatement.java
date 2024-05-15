package Interpreter.Nodes;

public class PauseStatement extends Statements{
    private int duration;

    public PauseStatement(int duration) {
        super("PauseStatement");
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "PauseStatement{" +
                "duration=" + duration +
                '}';
    }
}