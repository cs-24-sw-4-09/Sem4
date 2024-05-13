// Generated from MusicLanguage.g4 by ANTLR 4.13.1
package Grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicLanguageParser}.
 */
public interface MusicLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MusicLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MusicLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MusicLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MusicLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#bpmStatement}.
	 * @param ctx the parse tree
	 */
	void enterBpmStatement(MusicLanguageParser.BpmStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#bpmStatement}.
	 * @param ctx the parse tree
	 */
	void exitBpmStatement(MusicLanguageParser.BpmStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#sampleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSampleStatement(MusicLanguageParser.SampleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#sampleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSampleStatement(MusicLanguageParser.SampleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayStatement(MusicLanguageParser.PlayStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayStatement(MusicLanguageParser.PlayStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(MusicLanguageParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(MusicLanguageParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(MusicLanguageParser.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(MusicLanguageParser.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MusicLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MusicLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MusicLanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MusicLanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#assignementStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignementStatement(MusicLanguageParser.AssignementStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#assignementStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignementStatement(MusicLanguageParser.AssignementStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#soundStatement}.
	 * @param ctx the parse tree
	 */
	void enterSoundStatement(MusicLanguageParser.SoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#soundStatement}.
	 * @param ctx the parse tree
	 */
	void exitSoundStatement(MusicLanguageParser.SoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#sampleCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterSampleCallStatement(MusicLanguageParser.SampleCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#sampleCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitSampleCallStatement(MusicLanguageParser.SampleCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperation(MusicLanguageParser.LogicalOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperation(MusicLanguageParser.LogicalOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(MusicLanguageParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(MusicLanguageParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pause}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPause(MusicLanguageParser.PauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pause}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPause(MusicLanguageParser.PauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(MusicLanguageParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(MusicLanguageParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(MusicLanguageParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(MusicLanguageParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotOperation(MusicLanguageParser.NotOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotOperation(MusicLanguageParser.NotOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Note}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNote(MusicLanguageParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Note}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNote(MusicLanguageParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(MusicLanguageParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(MusicLanguageParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MusicLanguageParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MusicLanguageParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperation(MusicLanguageParser.ArithmeticOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperation(MusicLanguageParser.ArithmeticOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Chord}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterChord(MusicLanguageParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Chord}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitChord(MusicLanguageParser.ChordContext ctx);
}