// Generated from ./MusicLanguage.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link MusicLanguageParser#noteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteStatement(MusicLanguageParser.NoteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#chordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChordStatement(MusicLanguageParser.ChordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#bpmStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpmStatement(MusicLanguageParser.BpmStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#timeSignatureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSignatureStatement(MusicLanguageParser.TimeSignatureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#durationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDurationStatement(MusicLanguageParser.DurationStatementContext ctx);
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
	 * Visit a parse tree produced by {@link MusicLanguageParser#instrument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrument(MusicLanguageParser.InstrumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#noteList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteList(MusicLanguageParser.NoteListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicLanguageParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(MusicLanguageParser.NoteContext ctx);
}