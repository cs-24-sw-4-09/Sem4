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
	 * Enter a parse tree produced by {@link MusicLanguageParser#noteStatement}.
	 * @param ctx the parse tree
	 */
	void enterNoteStatement(MusicLanguageParser.NoteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#noteStatement}.
	 * @param ctx the parse tree
	 */
	void exitNoteStatement(MusicLanguageParser.NoteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#chordStatement}.
	 * @param ctx the parse tree
	 */
	void enterChordStatement(MusicLanguageParser.ChordStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#chordStatement}.
	 * @param ctx the parse tree
	 */
	void exitChordStatement(MusicLanguageParser.ChordStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MusicLanguageParser#timeSignatureStatement}.
	 * @param ctx the parse tree
	 */
	void enterTimeSignatureStatement(MusicLanguageParser.TimeSignatureStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#timeSignatureStatement}.
	 * @param ctx the parse tree
	 */
	void exitTimeSignatureStatement(MusicLanguageParser.TimeSignatureStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#durationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDurationStatement(MusicLanguageParser.DurationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#durationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDurationStatement(MusicLanguageParser.DurationStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MusicLanguageParser#instrument}.
	 * @param ctx the parse tree
	 */
	void enterInstrument(MusicLanguageParser.InstrumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#instrument}.
	 * @param ctx the parse tree
	 */
	void exitInstrument(MusicLanguageParser.InstrumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#noteList}.
	 * @param ctx the parse tree
	 */
	void enterNoteList(MusicLanguageParser.NoteListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#noteList}.
	 * @param ctx the parse tree
	 */
	void exitNoteList(MusicLanguageParser.NoteListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicLanguageParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(MusicLanguageParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicLanguageParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(MusicLanguageParser.NoteContext ctx);
}