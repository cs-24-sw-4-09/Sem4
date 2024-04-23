package Interpreter;

import Grammar.*;
import Models.*;

public class Visitor extends MusicLanguageBaseVisitor<ASTNode> {
    private final SymbolTable symbolTable = new SymbolTable();

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

    @Override
    public ASTNode visitLetStatement(MusicLanguageParser.LetStatementContext ctx) {
        String variable = ctx.variable.getText();
        MusicLanguageParser.ExpressionContext expressionContext = ctx.expression();
        ASTNode value = visit(expressionContext);
        System.out.println("Variable: " + variable + " Value: " + value);
        LetStatement letStatement = new LetStatement(variable, value);

        symbolTable.enterSymbol(variable, value);
        return letStatement;
    }

    @Override
    public ASTNode visitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx) {
        String variable = ctx.expression().getText();
        System.out.println(symbolTable.retrieveSymbol(variable));
        return null;
    }

    @Override
    public ASTNode visitSoundStatement(MusicLanguageParser.SoundStatementContext ctx) {
        String sound = ctx.getText();
        return new SoundStatement(sound);
    }

    @Override
    public ASTNode visitNumber(MusicLanguageParser.NumberContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        return new IntegerValueNode(value);
    }

    @Override
    public ASTNode visitString(MusicLanguageParser.StringContext ctx) {
        String stringName = ctx.getText();
        return new stringValueNode(stringName);
    }

    @Override
    public ASTNode visitNote(MusicLanguageParser.NoteContext ctx) {
        String note = ctx.getText();
        return new NoteStatement(note);
    }

    @Override
    public ASTNode visitBoolean(MusicLanguageParser.BooleanContext ctx) {
        boolean bool = Boolean.parseBoolean(ctx.getText());
        return new BooleanValueNode(bool);
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
