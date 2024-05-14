package Interpreter.Nodes;
import java.util.List;

import Grammar.MusicLanguageParser;


public class SampleStatement extends Statements {
    private String sample;
    private String instrument;
    private List<MusicLanguageParser.StatementContext> statements;

    public SampleStatement(String sample, String instrument, List<MusicLanguageParser.StatementContext> statements) {
        super("sampleStatement");
        this.sample = sample;
        this.instrument = instrument;
        this.statements = statements;
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

    public void setStatements(List<MusicLanguageParser.StatementContext> statements) {
        this.statements = statements;
    }

    public List<MusicLanguageParser.StatementContext> getStatements() {
        return statements;
    }
}   