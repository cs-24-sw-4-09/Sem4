// Generated from c:/Users/makse/OneDrive - Aalborg Universitet/4th semester/Sem4/src/main/java/Grammar/MusicLanguage.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link MusicLanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(MusicLanguageParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(MusicLanguageParser.ElseStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MusicLanguageParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MusicLanguageParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MusicLanguageParser.AssignmentStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MusicLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MusicLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#logical_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expr(MusicLanguageParser.Logical_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#logical_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expr(MusicLanguageParser.Logical_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#logical_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expr(MusicLanguageParser.Logical_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#logical_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expr(MusicLanguageParser.Logical_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison_expr(MusicLanguageParser.Comparison_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison_expr(MusicLanguageParser.Comparison_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#add_sub_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd_sub_expr(MusicLanguageParser.Add_sub_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#add_sub_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd_sub_expr(MusicLanguageParser.Add_sub_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#mult_div_expr}.
	 * @param ctx the parse tree
	 */
	void enterMult_div_expr(MusicLanguageParser.Mult_div_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#mult_div_expr}.
	 * @param ctx the parse tree
	 */
	void exitMult_div_expr(MusicLanguageParser.Mult_div_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MusicLanguageParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MusicLanguageParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(MusicLanguageParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(MusicLanguageParser.Primary_exprContext ctx);
}