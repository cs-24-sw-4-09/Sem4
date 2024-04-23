package Interpreter;

import Grammar.*;

public class Visitor extends MusicLanguageBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MusicLanguageParser.ProgramContext ctx) {
        ASTNode program = new ASTNode("program");
        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            ASTNode statementNode = visit(statementContext);
            program.addChild(visit(statementContext));
        }

        return program;
    }

    @Override
    public ASTNode visitBpmStatement(MusicLanguageParser.BpmStatementContext ctx) {
        int bpm = Integer.parseInt(ctx.INT().getText());
        return new BpmStatement(bpm);
    }
/*
    @Override
    public ASTNode visitNoteStatement(MusicLanguageParser.NoteStatementContext ctx) {
        String note = ctx.NOTE().getText();
        return new NoteStatement(note);
    }
*/
    @Override
    public ASTNode visitSampleStatement(MusicLanguageParser.SampleStatementContext ctx) {
        String sample = ctx.STRING().getText();
        String instrument = ctx.INSTRUMENT().getText();
        SampleStatement sampleStatement = new SampleStatement(sample, instrument);
        for (MusicLanguageParser.StatementContext statementContext : ctx.statement()) {
            sampleStatement.addChild(visit(statementContext));
        }
        return sampleStatement;
    }
    /*
    @Override
    public ASTNode visitPlayStatement(MusicLanguageParser.PlayStatementContext ctx) {
        String sample = ctx.getText();
        PlayStatement playStatement = new PlayStatement(sample);
        for (MusicLanguageParser.SampleStatementContext sampleStatementContext : ctx.sampleStatement()) {
            playStatement.addChild(visit(sampleStatementContext));
        }
        return playStatement;
    }
    */
    /*
    @Override
    public ASTNode visitPauseStatement(MusicLanguageParser.PauseStatementContext ctx) {
        int duration = Integer.parseInt(ctx.INT().getText());
        PauseStatement pauseStatement = new PauseStatement(duration);
        return pauseStatement;
    }
    */
}
