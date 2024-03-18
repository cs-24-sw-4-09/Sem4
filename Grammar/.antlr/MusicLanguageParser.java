// Generated from c:/Users/lucas/OneDrive/Documents/SW4 - Music/Sem4/Grammar/MusicLanguage.g4 by ANTLR 4.13.1
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NOTE=15, INT=16, WS=17;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_noteStatement = 2, RULE_chordStatement = 3, 
		RULE_tempoStatement = 4, RULE_durationStatement = 5, RULE_noteList = 6, 
		RULE_note = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "noteStatement", "chordStatement", "tempoStatement", 
			"durationStatement", "noteList", "note"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'note'", "'chord'", "'['", "']'", "'tempo'", "'duration'", "','", 
			"'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "NOTE", "INT", "WS"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 102L) != 0)) {
				{
				{
				setState(16);
				statement();
				}
				}
				setState(21);
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
	public static class StatementContext extends ParserRuleContext {
		public NoteStatementContext noteStatement() {
			return getRuleContext(NoteStatementContext.class,0);
		}
		public ChordStatementContext chordStatement() {
			return getRuleContext(ChordStatementContext.class,0);
		}
		public TempoStatementContext tempoStatement() {
			return getRuleContext(TempoStatementContext.class,0);
		}
		public DurationStatementContext durationStatement() {
			return getRuleContext(DurationStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				noteStatement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				chordStatement();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				tempoStatement();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				durationStatement();
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
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public NoteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteStatement; }
	}

	public final NoteStatementContext noteStatement() throws RecognitionException {
		NoteStatementContext _localctx = new NoteStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_noteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			note();
			setState(30);
			((NoteStatementContext)_localctx).octave = match(INT);
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
	}

	public final ChordStatementContext chordStatement() throws RecognitionException {
		ChordStatementContext _localctx = new ChordStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_chordStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__1);
			setState(33);
			match(T__2);
			setState(34);
			noteList();
			setState(35);
			match(T__3);
			setState(36);
			((ChordStatementContext)_localctx).octave = match(INT);
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
	public static class TempoStatementContext extends ParserRuleContext {
		public Token tempo;
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public TempoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempoStatement; }
	}

	public final TempoStatementContext tempoStatement() throws RecognitionException {
		TempoStatementContext _localctx = new TempoStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tempoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__4);
			setState(39);
			((TempoStatementContext)_localctx).tempo = match(INT);
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
	public static class DurationStatementContext extends ParserRuleContext {
		public Token duration;
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public DurationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_durationStatement; }
	}

	public final DurationStatementContext durationStatement() throws RecognitionException {
		DurationStatementContext _localctx = new DurationStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_durationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__5);
			setState(42);
			((DurationStatementContext)_localctx).duration = match(INT);
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
	}

	public final NoteListContext noteList() throws RecognitionException {
		NoteListContext _localctx = new NoteListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_noteList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			note();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(45);
				match(T__6);
				setState(46);
				note();
				}
				}
				setState(51);
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
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32512L) != 0)) ) {
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
		"\u0004\u0001\u00117\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u00060\b\u0006\n\u0006\f\u00063\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001"+
		"\u0001\u0000\b\u000e3\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u001a"+
		"\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006 \u0001"+
		"\u0000\u0000\u0000\b&\u0001\u0000\u0000\u0000\n)\u0001\u0000\u0000\u0000"+
		"\f,\u0001\u0000\u0000\u0000\u000e4\u0001\u0000\u0000\u0000\u0010\u0012"+
		"\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012\u0015"+
		"\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0013"+
		"\u0001\u0000\u0000\u0000\u0016\u001b\u0003\u0004\u0002\u0000\u0017\u001b"+
		"\u0003\u0006\u0003\u0000\u0018\u001b\u0003\b\u0004\u0000\u0019\u001b\u0003"+
		"\n\u0005\u0000\u001a\u0016\u0001\u0000\u0000\u0000\u001a\u0017\u0001\u0000"+
		"\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u0019\u0001\u0000"+
		"\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001"+
		"\u0000\u0000\u001d\u001e\u0003\u000e\u0007\u0000\u001e\u001f\u0005\u0010"+
		"\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000 !\u0005\u0002\u0000\u0000"+
		"!\"\u0005\u0003\u0000\u0000\"#\u0003\f\u0006\u0000#$\u0005\u0004\u0000"+
		"\u0000$%\u0005\u0010\u0000\u0000%\u0007\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0005\u0000\u0000\'(\u0005\u0010\u0000\u0000(\t\u0001\u0000\u0000\u0000"+
		")*\u0005\u0006\u0000\u0000*+\u0005\u0010\u0000\u0000+\u000b\u0001\u0000"+
		"\u0000\u0000,1\u0003\u000e\u0007\u0000-.\u0005\u0007\u0000\u0000.0\u0003"+
		"\u000e\u0007\u0000/-\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\r\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000045\u0007\u0000\u0000\u00005\u000f\u0001"+
		"\u0000\u0000\u0000\u0003\u0013\u001a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}