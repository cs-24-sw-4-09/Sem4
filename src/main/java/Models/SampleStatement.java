package Models;

import Interpreter.ASTNode;

public class SampleStatement extends ASTNode {
    private String sample;
    private String instrument;

    public SampleStatement(String sample, String instrument) {
        super("sampleStatement");
        this.sample = sample;
        this.instrument = instrument;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
