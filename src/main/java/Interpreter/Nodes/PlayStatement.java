package Interpreter.Nodes;

public class PlayStatement extends Statements {
    private String sample;

    public PlayStatement(String sample) {
        super("playStatement");
        this.sample = sample;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
}