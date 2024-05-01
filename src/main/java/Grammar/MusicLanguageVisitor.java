// Generated from MusicLanguage.g4 by ANTLR 4.13.1
package Grammar;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MusicLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MusicLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MusicLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MusicLanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#bpmStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpmStatement(MusicLanguageParser.BpmStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#sampleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleStatement(MusicLanguageParser.SampleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayStatement(MusicLanguageParser.PlayStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(MusicLanguageParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(MusicLanguageParser.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MusicLanguageParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MusicLanguageParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#assignementStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignementStatement(MusicLanguageParser.AssignementStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MusicLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#soundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoundStatement(MusicLanguageParser.SoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperation(MusicLanguageParser.LogicalOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(MusicLanguageParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pause}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPause(MusicLanguageParser.PauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MusicLanguageParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MusicLanguageParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOperation(MusicLanguageParser.NotOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Note}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(MusicLanguageParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SampleCall}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleCall(MusicLanguageParser.SampleCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MusicLanguageParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MusicLanguageParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticOperation}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperation(MusicLanguageParser.ArithmeticOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Chord}
	 * labeled alternative in {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(MusicLanguageParser.ChordContext ctx);
}