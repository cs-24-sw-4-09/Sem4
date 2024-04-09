// Generated from MusicLanguage.g4 by ANTLR 4.13.1
package Grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MusicLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		INSTRUMENT=32, NOTE=33, INT=34, STRING=35, INDENT=36, DEDENT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_noteStatement = 2, RULE_chordStatement = 3, 
		RULE_bpmStatement = 4, RULE_timeSignatureStatement = 5, RULE_sampleStatement = 6, 
		RULE_playStatement = 7, RULE_instrument = 8, RULE_noteList = 9, RULE_note = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "noteStatement", "chordStatement", "bpmStatement", 
			"timeSignatureStatement", "sampleStatement", "playStatement", "instrument", 
			"noteList", "note"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'note'", "';'", "'chord'", "'['", "']'", "'bpm'", "'('", "')'", 
			"'time'", "'/'", "'sample'", "'{'", "'}'", "'play'", "'Piano'", "'Guitar'", 
			"'Bass'", "'Drums'", "','", "'A'", "'A#'", "'B'", "'C'", "'C#'", "'D'", 
			"'D#'", "'E'", "'F'", "'F#'", "'G'", "'G#'", "'instrument'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INSTRUMENT", "NOTE", 
			"INT", "STRING", "INDENT", "DEDENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MusicLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MusicLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MusicLanguageParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19018L) != 0)) {
				{
				{
				setState(22);
				statement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public NoteStatementContext noteStatement() {
			return getRuleContext(NoteStatementContext.class,0);
		}
		public ChordStatementContext chordStatement() {
			return getRuleContext(ChordStatementContext.class,0);
		}
		public BpmStatementContext bpmStatement() {
			return getRuleContext(BpmStatementContext.class,0);
		}
		public TimeSignatureStatementContext timeSignatureStatement() {
			return getRuleContext(TimeSignatureStatementContext.class,0);
		}
		public SampleStatementContext sampleStatement() {
			return getRuleContext(SampleStatementContext.class,0);
		}
		public PlayStatementContext playStatement() {
			return getRuleContext(PlayStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				noteStatement();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				chordStatement();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				bpmStatement();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				timeSignatureStatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				sampleStatement();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				playStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteStatementContext extends ParserRuleContext {
		public Token octave;
		public TerminalNode NOTE() { return getToken(MusicLanguageParser.NOTE, 0); }
		public NoteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterNoteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitNoteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitNoteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteStatementContext noteStatement() throws RecognitionException {
		NoteStatementContext _localctx = new NoteStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_noteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			((NoteStatementContext)_localctx).octave = match(NOTE);
			setState(40);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChordStatementContext extends ParserRuleContext {
		public Token octave;
		public NoteListContext noteList() {
			return getRuleContext(NoteListContext.class,0);
		}
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public ChordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chordStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterChordStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitChordStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitChordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordStatementContext chordStatement() throws RecognitionException {
		ChordStatementContext _localctx = new ChordStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_chordStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			setState(43);
			match(T__3);
			setState(44);
			noteList();
			setState(45);
			match(T__4);
			setState(46);
			((ChordStatementContext)_localctx).octave = match(INT);
			setState(47);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BpmStatementContext extends ParserRuleContext {
		public Token bpm;
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public BpmStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpmStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterBpmStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitBpmStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitBpmStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BpmStatementContext bpmStatement() throws RecognitionException {
		BpmStatementContext _localctx = new BpmStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bpmStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__5);
			setState(50);
			match(T__6);
			setState(51);
			((BpmStatementContext)_localctx).bpm = match(INT);
			setState(52);
			match(T__7);
			setState(53);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeSignatureStatementContext extends ParserRuleContext {
		public Token time;
		public List<TerminalNode> INT() { return getTokens(MusicLanguageParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(MusicLanguageParser.INT, i);
		}
		public TimeSignatureStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSignatureStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterTimeSignatureStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitTimeSignatureStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitTimeSignatureStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeSignatureStatementContext timeSignatureStatement() throws RecognitionException {
		TimeSignatureStatementContext _localctx = new TimeSignatureStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timeSignatureStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__8);
			setState(56);
			match(T__6);
			setState(57);
			((TimeSignatureStatementContext)_localctx).time = match(INT);
			setState(58);
			match(T__9);
			setState(59);
			((TimeSignatureStatementContext)_localctx).time = match(INT);
			setState(60);
			match(T__7);
			setState(61);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SampleStatementContext extends ParserRuleContext {
		public Token sample;
		public InstrumentContext instrument() {
			return getRuleContext(InstrumentContext.class,0);
		}
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SampleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterSampleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitSampleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitSampleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleStatementContext sampleStatement() throws RecognitionException {
		SampleStatementContext _localctx = new SampleStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sampleStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__10);
			setState(64);
			((SampleStatementContext)_localctx).sample = match(STRING);
			setState(65);
			match(T__6);
			setState(66);
			instrument();
			setState(67);
			match(T__7);
			setState(68);
			match(T__11);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19018L) != 0)) {
				{
				{
				setState(69);
				statement();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(T__12);
			setState(76);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlayStatementContext extends ParserRuleContext {
		public List<SampleStatementContext> sampleStatement() {
			return getRuleContexts(SampleStatementContext.class);
		}
		public SampleStatementContext sampleStatement(int i) {
			return getRuleContext(SampleStatementContext.class,i);
		}
		public PlayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterPlayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitPlayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitPlayStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayStatementContext playStatement() throws RecognitionException {
		PlayStatementContext _localctx = new PlayStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_playStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__13);
			setState(79);
			match(T__11);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(80);
				sampleStatement();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__12);
			setState(87);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstrumentContext extends ParserRuleContext {
		public InstrumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterInstrument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitInstrument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitInstrument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentContext instrument() throws RecognitionException {
		InstrumentContext _localctx = new InstrumentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instrument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteListContext extends ParserRuleContext {
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public NoteListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterNoteList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitNoteList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitNoteList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteListContext noteList() throws RecognitionException {
		NoteListContext _localctx = new NoteListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_noteList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			note();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(92);
				match(T__18);
				setState(93);
				note();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ParserRuleContext {
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4293918720L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001&f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018\b\u0000"+
		"\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001%\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006G\b\u0006\n\u0006\f\u0006J\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007R\b\u0007\n\u0007\f\u0007U\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t_\b"+
		"\t\n\t\f\tb\t\t\u0001\n\u0001\n\u0001\n\u0000\u0000\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0002\u0001\u0000\u000f"+
		"\u0012\u0001\u0000\u0014\u001fc\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"$\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006*\u0001"+
		"\u0000\u0000\u0000\b1\u0001\u0000\u0000\u0000\n7\u0001\u0000\u0000\u0000"+
		"\f?\u0001\u0000\u0000\u0000\u000eN\u0001\u0000\u0000\u0000\u0010Y\u0001"+
		"\u0000\u0000\u0000\u0012[\u0001\u0000\u0000\u0000\u0014c\u0001\u0000\u0000"+
		"\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000"+
		"\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000"+
		"\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0000\u0000"+
		"\u0001\u001d\u0001\u0001\u0000\u0000\u0000\u001e%\u0003\u0004\u0002\u0000"+
		"\u001f%\u0003\u0006\u0003\u0000 %\u0003\b\u0004\u0000!%\u0003\n\u0005"+
		"\u0000\"%\u0003\f\u0006\u0000#%\u0003\u000e\u0007\u0000$\u001e\u0001\u0000"+
		"\u0000\u0000$\u001f\u0001\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000"+
		"$!\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000"+
		"\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005"+
		"!\u0000\u0000()\u0005\u0002\u0000\u0000)\u0005\u0001\u0000\u0000\u0000"+
		"*+\u0005\u0003\u0000\u0000+,\u0005\u0004\u0000\u0000,-\u0003\u0012\t\u0000"+
		"-.\u0005\u0005\u0000\u0000./\u0005\"\u0000\u0000/0\u0005\u0002\u0000\u0000"+
		"0\u0007\u0001\u0000\u0000\u000012\u0005\u0006\u0000\u000023\u0005\u0007"+
		"\u0000\u000034\u0005\"\u0000\u000045\u0005\b\u0000\u000056\u0005\u0002"+
		"\u0000\u00006\t\u0001\u0000\u0000\u000078\u0005\t\u0000\u000089\u0005"+
		"\u0007\u0000\u00009:\u0005\"\u0000\u0000:;\u0005\n\u0000\u0000;<\u0005"+
		"\"\u0000\u0000<=\u0005\b\u0000\u0000=>\u0005\u0002\u0000\u0000>\u000b"+
		"\u0001\u0000\u0000\u0000?@\u0005\u000b\u0000\u0000@A\u0005#\u0000\u0000"+
		"AB\u0005\u0007\u0000\u0000BC\u0003\u0010\b\u0000CD\u0005\b\u0000\u0000"+
		"DH\u0005\f\u0000\u0000EG\u0003\u0002\u0001\u0000FE\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\r\u0000"+
		"\u0000LM\u0005\u0002\u0000\u0000M\r\u0001\u0000\u0000\u0000NO\u0005\u000e"+
		"\u0000\u0000OS\u0005\f\u0000\u0000PR\u0003\f\u0006\u0000QP\u0001\u0000"+
		"\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VW\u0005\r\u0000\u0000WX\u0005\u0002\u0000\u0000X\u000f\u0001\u0000\u0000"+
		"\u0000YZ\u0007\u0000\u0000\u0000Z\u0011\u0001\u0000\u0000\u0000[`\u0003"+
		"\u0014\n\u0000\\]\u0005\u0013\u0000\u0000]_\u0003\u0014\n\u0000^\\\u0001"+
		"\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a\u0013\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000cd\u0007\u0001\u0000\u0000d\u0015\u0001\u0000\u0000\u0000"+
		"\u0005\u0019$HS`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}