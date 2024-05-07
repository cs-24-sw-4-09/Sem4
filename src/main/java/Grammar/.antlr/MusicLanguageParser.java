// Generated from c:/Users/makse/OneDrive - Aalborg Universitet/4th semester/Sem4/src/main/java/Grammar/MusicLanguage.g4 by ANTLR 4.13.1
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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, INSTRUMENT=30, NOTE=31, 
		PAUSE=32, CHORD=33, INT=34, BOOL=35, STRING=36, INDENT=37, DEDENT=38, 
		WS=39, ENDLINE=40;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_bpmStatement = 2, RULE_sampleStatement = 3, 
		RULE_playStatement = 4, RULE_repeatStatement = 5, RULE_letStatement = 6, 
		RULE_ifStatement = 7, RULE_whileStatement = 8, RULE_assignementStatement = 9, 
		RULE_expressionStatement = 10, RULE_soundStatement = 11, RULE_expression = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "bpmStatement", "sampleStatement", "playStatement", 
			"repeatStatement", "letStatement", "ifStatement", "whileStatement", "assignementStatement", 
			"expressionStatement", "soundStatement", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bpm'", "'('", "')'", "'sample'", "'{'", "'}'", "'play'", "'repeat'", 
			"'let'", "'='", "'if'", "'else'", "'while'", "'sound'", "'()'", "'&'", 
			"'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'<='", "'>='", "'>'", 
			"'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "INSTRUMENT", "NOTE", "PAUSE", "CHORD", 
			"INT", "BOOL", "STRING", "INDENT", "DEDENT", "WS", "ENDLINE"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
		public BpmStatementContext bpmStatement() {
			return getRuleContext(BpmStatementContext.class,0);
		}
		public SampleStatementContext sampleStatement() {
			return getRuleContext(SampleStatementContext.class,0);
		}
		public PlayStatementContext playStatement() {
			return getRuleContext(PlayStatementContext.class,0);
		}
		public LetStatementContext letStatement() {
			return getRuleContext(LetStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public AssignementStatementContext assignementStatement() {
			return getRuleContext(AssignementStatementContext.class,0);
		}
		public SoundStatementContext soundStatement() {
			return getRuleContext(SoundStatementContext.class,0);
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
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				bpmStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				sampleStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				playStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				letStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(40);
				repeatStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(41);
				expressionStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(42);
				assignementStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(43);
				soundStatement();
				}
				break;
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
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public BpmStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpmStatement; }
	}

	public final BpmStatementContext bpmStatement() throws RecognitionException {
		BpmStatementContext _localctx = new BpmStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bpmStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			match(T__1);
			setState(48);
			match(INT);
			setState(49);
			match(T__2);
			setState(50);
			match(ENDLINE);
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
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public TerminalNode INSTRUMENT() { return getToken(MusicLanguageParser.INSTRUMENT, 0); }
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
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
	}

	public final SampleStatementContext sampleStatement() throws RecognitionException {
		SampleStatementContext _localctx = new SampleStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sampleStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__3);
			setState(53);
			match(STRING);
			setState(54);
			match(T__1);
			setState(55);
			match(INSTRUMENT);
			setState(56);
			match(T__2);
			setState(57);
			match(T__4);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
				{
				{
				setState(58);
				statement();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(T__5);
			setState(65);
			match(ENDLINE);
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
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PlayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playStatement; }
	}

	public final PlayStatementContext playStatement() throws RecognitionException {
		PlayStatementContext _localctx = new PlayStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_playStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(T__4);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
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
			match(T__5);
			setState(76);
			match(ENDLINE);
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
	public static class RepeatStatementContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_repeatStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__7);
			setState(79);
			match(T__1);
			setState(80);
			match(INT);
			setState(81);
			match(T__2);
			setState(82);
			match(T__4);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
				{
				{
				setState(83);
				statement();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__5);
			setState(90);
			match(ENDLINE);
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
	public static class LetStatementContext extends ParserRuleContext {
		public Token variable;
		public ExpressionContext value;
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letStatement; }
	}

	public final LetStatementContext letStatement() throws RecognitionException {
		LetStatementContext _localctx = new LetStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_letStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__8);
			setState(93);
			((LetStatementContext)_localctx).variable = match(STRING);
			setState(94);
			match(T__9);
			setState(95);
			((LetStatementContext)_localctx).value = expression(0);
			setState(96);
			match(ENDLINE);
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
	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__10);
			setState(99);
			match(T__1);
			setState(100);
			expression(0);
			setState(101);
			match(T__2);
			setState(102);
			match(T__4);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
				{
				{
				setState(103);
				statement();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__5);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(110);
				match(T__11);
				setState(111);
				match(T__4);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
					{
					{
					setState(112);
					statement();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(T__5);
				}
			}

			setState(121);
			match(ENDLINE);
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
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__12);
			setState(124);
			match(T__1);
			setState(125);
			expression(0);
			setState(126);
			match(T__2);
			setState(127);
			match(T__4);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 135828368278L) != 0)) {
				{
				{
				setState(128);
				statement();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(T__5);
			setState(135);
			match(ENDLINE);
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
	public static class AssignementStatementContext extends ParserRuleContext {
		public Token variable;
		public ExpressionContext value;
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignementStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignementStatement; }
	}

	public final AssignementStatementContext assignementStatement() throws RecognitionException {
		AssignementStatementContext _localctx = new AssignementStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignementStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((AssignementStatementContext)_localctx).variable = match(STRING);
			setState(138);
			match(T__9);
			setState(139);
			((AssignementStatementContext)_localctx).value = expression(0);
			setState(140);
			match(ENDLINE);
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			expression(0);
			setState(143);
			match(ENDLINE);
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
	public static class SoundStatementContext extends ParserRuleContext {
		public Token variable;
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public SoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_soundStatement; }
	}

	public final SoundStatementContext soundStatement() throws RecognitionException {
		SoundStatementContext _localctx = new SoundStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_soundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__13);
			setState(146);
			match(T__1);
			setState(147);
			((SoundStatementContext)_localctx).variable = match(STRING);
			setState(148);
			match(T__2);
			setState(149);
			match(ENDLINE);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOperationContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PauseContext extends ExpressionContext {
		public TerminalNode PAUSE() { return getToken(MusicLanguageParser.PAUSE, 0); }
		public PauseContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ExpressionContext {
		public TerminalNode NOTE() { return getToken(MusicLanguageParser.NOTE, 0); }
		public NoteContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SampleCallContext extends ExpressionContext {
		public List<TerminalNode> STRING() { return getTokens(MusicLanguageParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MusicLanguageParser.STRING, i);
		}
		public SampleCallContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(MusicLanguageParser.BOOL, 0); }
		public BooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticOperationContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArithmeticOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChordContext extends ExpressionContext {
		public TerminalNode CHORD() { return getToken(MusicLanguageParser.CHORD, 0); }
		public ChordContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new SampleCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(152);
				match(STRING);
				setState(153);
				match(T__14);
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(154);
						match(T__15);
						setState(155);
						match(STRING);
						setState(156);
						match(T__14);
						}
						} 
					}
					setState(161);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				break;
			case 2:
				{
				_localctx = new NotOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(T__28);
				setState(163);
				expression(8);
				}
				break;
			case 3:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(T__1);
				setState(165);
				expression(0);
				setState(166);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new ChordContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(CHORD);
				}
				break;
			case 5:
				{
				_localctx = new NoteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(NOTE);
				}
				break;
			case 6:
				{
				_localctx = new PauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(PAUSE);
				}
				break;
			case 7:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(STRING);
				}
				break;
			case 9:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(185);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(177);
						((ArithmeticOperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
							((ArithmeticOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(180);
						((ComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
							((ComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new LogicalOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(183);
						((LogicalOperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((LogicalOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(184);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00bf\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003<\b\u0003\n\u0003"+
		"\f\u0003?\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004G\b\u0004\n\u0004\f\u0004J\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005U\b\u0005\n\u0005\f\u0005X\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007i\b\u0007\n\u0007"+
		"\f\u0007l\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007r\b\u0007\n\u0007\f\u0007u\t\u0007\u0001\u0007\u0003\u0007x\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u0082\b\b\n\b\f\b\u0085\t\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u009e\b\f\n\f\f\f\u00a1\t\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00af\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ba\b\f\n\f\f\f\u00bd\t\f"+
		"\u0001\f\u0000\u0001\u0018\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u0000\u0003\u0001\u0000\u0011\u0014\u0001\u0000"+
		"\u0015\u001a\u0001\u0000\u001b\u001c\u00ce\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0002,\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006"+
		"4\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000"+
		"\u0000\f\\\u0001\u0000\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010"+
		"{\u0001\u0000\u0000\u0000\u0012\u0089\u0001\u0000\u0000\u0000\u0014\u008e"+
		"\u0001\u0000\u0000\u0000\u0016\u0091\u0001\u0000\u0000\u0000\u0018\u00ae"+
		"\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a"+
		"\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0005\u0000\u0000"+
		"\u0001!\u0001\u0001\u0000\u0000\u0000\"-\u0003\u0004\u0002\u0000#-\u0003"+
		"\u0006\u0003\u0000$-\u0003\b\u0004\u0000%-\u0003\f\u0006\u0000&-\u0003"+
		"\u000e\u0007\u0000\'-\u0003\u0010\b\u0000(-\u0003\n\u0005\u0000)-\u0003"+
		"\u0014\n\u0000*-\u0003\u0012\t\u0000+-\u0003\u0016\u000b\u0000,\"\u0001"+
		"\u0000\u0000\u0000,#\u0001\u0000\u0000\u0000,$\u0001\u0000\u0000\u0000"+
		",%\u0001\u0000\u0000\u0000,&\u0001\u0000\u0000\u0000,\'\u0001\u0000\u0000"+
		"\u0000,(\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0003\u0001\u0000\u0000\u0000"+
		"./\u0005\u0001\u0000\u0000/0\u0005\u0002\u0000\u000001\u0005\"\u0000\u0000"+
		"12\u0005\u0003\u0000\u000023\u0005(\u0000\u00003\u0005\u0001\u0000\u0000"+
		"\u000045\u0005\u0004\u0000\u000056\u0005$\u0000\u000067\u0005\u0002\u0000"+
		"\u000078\u0005\u001e\u0000\u000089\u0005\u0003\u0000\u00009=\u0005\u0005"+
		"\u0000\u0000:<\u0003\u0002\u0001\u0000;:\u0001\u0000\u0000\u0000<?\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0006\u0000"+
		"\u0000AB\u0005(\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005\u0007"+
		"\u0000\u0000DH\u0005\u0005\u0000\u0000EG\u0003\u0002\u0001\u0000FE\u0001"+
		"\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000KL\u0005\u0006\u0000\u0000LM\u0005(\u0000\u0000M\t\u0001\u0000\u0000"+
		"\u0000NO\u0005\b\u0000\u0000OP\u0005\u0002\u0000\u0000PQ\u0005\"\u0000"+
		"\u0000QR\u0005\u0003\u0000\u0000RV\u0005\u0005\u0000\u0000SU\u0003\u0002"+
		"\u0001\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000YZ\u0005\u0006\u0000\u0000Z[\u0005(\u0000\u0000"+
		"[\u000b\u0001\u0000\u0000\u0000\\]\u0005\t\u0000\u0000]^\u0005$\u0000"+
		"\u0000^_\u0005\n\u0000\u0000_`\u0003\u0018\f\u0000`a\u0005(\u0000\u0000"+
		"a\r\u0001\u0000\u0000\u0000bc\u0005\u000b\u0000\u0000cd\u0005\u0002\u0000"+
		"\u0000de\u0003\u0018\f\u0000ef\u0005\u0003\u0000\u0000fj\u0005\u0005\u0000"+
		"\u0000gi\u0003\u0002\u0001\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mw\u0005\u0006\u0000\u0000"+
		"no\u0005\f\u0000\u0000os\u0005\u0005\u0000\u0000pr\u0003\u0002\u0001\u0000"+
		"qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vx\u0005\u0006\u0000\u0000wn\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005(\u0000\u0000z\u000f"+
		"\u0001\u0000\u0000\u0000{|\u0005\r\u0000\u0000|}\u0005\u0002\u0000\u0000"+
		"}~\u0003\u0018\f\u0000~\u007f\u0005\u0003\u0000\u0000\u007f\u0083\u0005"+
		"\u0005\u0000\u0000\u0080\u0082\u0003\u0002\u0001\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087\u0005"+
		"\u0006\u0000\u0000\u0087\u0088\u0005(\u0000\u0000\u0088\u0011\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005$\u0000\u0000\u008a\u008b\u0005\n\u0000"+
		"\u0000\u008b\u008c\u0003\u0018\f\u0000\u008c\u008d\u0005(\u0000\u0000"+
		"\u008d\u0013\u0001\u0000\u0000\u0000\u008e\u008f\u0003\u0018\f\u0000\u008f"+
		"\u0090\u0005(\u0000\u0000\u0090\u0015\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u000e\u0000\u0000\u0092\u0093\u0005\u0002\u0000\u0000\u0093\u0094"+
		"\u0005$\u0000\u0000\u0094\u0095\u0005\u0003\u0000\u0000\u0095\u0096\u0005"+
		"(\u0000\u0000\u0096\u0017\u0001\u0000\u0000\u0000\u0097\u0098\u0006\f"+
		"\uffff\uffff\u0000\u0098\u0099\u0005$\u0000\u0000\u0099\u009f\u0005\u000f"+
		"\u0000\u0000\u009a\u009b\u0005\u0010\u0000\u0000\u009b\u009c\u0005$\u0000"+
		"\u0000\u009c\u009e\u0005\u000f\u0000\u0000\u009d\u009a\u0001\u0000\u0000"+
		"\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00af\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u001d\u0000"+
		"\u0000\u00a3\u00af\u0003\u0018\f\b\u00a4\u00a5\u0005\u0002\u0000\u0000"+
		"\u00a5\u00a6\u0003\u0018\f\u0000\u00a6\u00a7\u0005\u0003\u0000\u0000\u00a7"+
		"\u00af\u0001\u0000\u0000\u0000\u00a8\u00af\u0005!\u0000\u0000\u00a9\u00af"+
		"\u0005\u001f\u0000\u0000\u00aa\u00af\u0005 \u0000\u0000\u00ab\u00af\u0005"+
		"#\u0000\u0000\u00ac\u00af\u0005$\u0000\u0000\u00ad\u00af\u0005\"\u0000"+
		"\u0000\u00ae\u0097\u0001\u0000\u0000\u0000\u00ae\u00a2\u0001\u0000\u0000"+
		"\u0000\u00ae\u00a4\u0001\u0000\u0000\u0000\u00ae\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ae\u00a9\u0001\u0000\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ab\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\n\u000b\u0000\u0000\u00b1\u00b2\u0007\u0000\u0000\u0000"+
		"\u00b2\u00ba\u0003\u0018\f\f\u00b3\u00b4\n\n\u0000\u0000\u00b4\u00b5\u0007"+
		"\u0001\u0000\u0000\u00b5\u00ba\u0003\u0018\f\u000b\u00b6\u00b7\n\t\u0000"+
		"\u0000\u00b7\u00b8\u0007\u0002\u0000\u0000\u00b8\u00ba\u0003\u0018\f\n"+
		"\u00b9\u00b0\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b6\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u0019\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\r\u001d,=HVjsw\u0083\u009f\u00ae\u00b9\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}