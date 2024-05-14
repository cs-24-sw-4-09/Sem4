package Interpreter.Nodes;

public class SampleCallStatement extends Statements {

    private String Sample;

    public SampleCallStatement(String Sample) {
        super("SampleCallStatement");
        this.Sample = Sample;
    }

    public void setSampleCall(String Sample) {
        this.Sample = Sample;
    }
    
    public String getSampleCall() {
        return Sample;
    }


}