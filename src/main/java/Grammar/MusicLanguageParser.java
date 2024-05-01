// Generated from MusicLanguage.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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

	public static class BpmStatementContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitRepeatStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterLetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitLetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitLetStatement(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__28) | (1L << NOTE) | (1L << PAUSE) | (1L << CHORD) | (1L << INT) | (1L << BOOL) | (1L << STRING))) != 0)) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterAssignementStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitAssignementStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitAssignementStatement(this);
			else return visitor.visitChildren(this);
		}
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
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

	public static class SoundStatementContext extends ParserRuleContext {
		public Token variable;
		public TerminalNode ENDLINE() { return getToken(MusicLanguageParser.ENDLINE, 0); }
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public SoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_soundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterSoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitSoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitSoundStatement(this);
			else return visitor.visitChildren(this);
		}
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
	public static class LogicalOperationContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterLogicalOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitLogicalOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitLogicalOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PauseContext extends ExpressionContext {
		public TerminalNode PAUSE() { return getToken(MusicLanguageParser.PAUSE, 0); }
		public PauseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterPause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitPause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitPause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(MusicLanguageParser.INT, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotOperationContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterNotOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitNotOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitNotOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NoteContext extends ExpressionContext {
		public TerminalNode NOTE() { return getToken(MusicLanguageParser.NOTE, 0); }
		public NoteContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class SampleCallContext extends ExpressionContext {
		public List<TerminalNode> STRING() { return getTokens(MusicLanguageParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MusicLanguageParser.STRING, i);
		}
		public SampleCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterSampleCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitSampleCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitSampleCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(MusicLanguageParser.STRING, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(MusicLanguageParser.BOOL, 0); }
		public BooleanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticOperationContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArithmeticOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterArithmeticOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitArithmeticOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitArithmeticOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChordContext extends ExpressionContext {
		public TerminalNode CHORD() { return getToken(MusicLanguageParser.CHORD, 0); }
		public ChordContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicLanguageListener ) ((MusicLanguageListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicLanguageVisitor ) return ((MusicLanguageVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
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
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00c1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\7\tk\n\t\f\t\16\tn\13\t\3\t\3\t\3\t\3\t\7\tt\n\t\f\t\16\t"+
		"w\13\t\3\t\5\tz\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0084\n\n\f\n"+
		"\16\n\u0087\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a0\n\16\f\16"+
		"\16\16\u00a3\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00b1\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00bc\n\16\f\16\16\16\u00bf\13\16\3\16\2\3\32\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\5\3\2\23\26\3\2\27\34\3\2\35\36\2\u00d0\2\37\3\2"+
		"\2\2\4.\3\2\2\2\6\60\3\2\2\2\b\66\3\2\2\2\nE\3\2\2\2\fP\3\2\2\2\16^\3"+
		"\2\2\2\20d\3\2\2\2\22}\3\2\2\2\24\u008b\3\2\2\2\26\u0090\3\2\2\2\30\u0093"+
		"\3\2\2\2\32\u00b0\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35"+
		"\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$/\5"+
		"\6\4\2%/\5\b\5\2&/\5\n\6\2\'/\5\16\b\2(/\5\20\t\2)/\5\22\n\2*/\5\f\7\2"+
		"+/\5\26\f\2,/\5\24\13\2-/\5\30\r\2.$\3\2\2\2.%\3\2\2\2.&\3\2\2\2.\'\3"+
		"\2\2\2.(\3\2\2\2.)\3\2\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\5"+
		"\3\2\2\2\60\61\7\3\2\2\61\62\7\4\2\2\62\63\7$\2\2\63\64\7\5\2\2\64\65"+
		"\7*\2\2\65\7\3\2\2\2\66\67\7\6\2\2\678\7&\2\289\7\4\2\29:\7 \2\2:;\7\5"+
		"\2\2;?\7\7\2\2<>\5\4\3\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2"+
		"\2\2A?\3\2\2\2BC\7\b\2\2CD\7*\2\2D\t\3\2\2\2EF\7\t\2\2FJ\7\7\2\2GI\5\4"+
		"\3\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\b"+
		"\2\2NO\7*\2\2O\13\3\2\2\2PQ\7\n\2\2QR\7\4\2\2RS\7$\2\2ST\7\5\2\2TX\7\7"+
		"\2\2UW\5\4\3\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2"+
		"\2\2[\\\7\b\2\2\\]\7*\2\2]\r\3\2\2\2^_\7\13\2\2_`\7&\2\2`a\7\f\2\2ab\5"+
		"\32\16\2bc\7*\2\2c\17\3\2\2\2de\7\r\2\2ef\7\4\2\2fg\5\32\16\2gh\7\5\2"+
		"\2hl\7\7\2\2ik\5\4\3\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2"+
		"\2nl\3\2\2\2oy\7\b\2\2pq\7\16\2\2qu\7\7\2\2rt\5\4\3\2sr\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xz\7\b\2\2yp\3\2\2\2yz\3\2"+
		"\2\2z{\3\2\2\2{|\7*\2\2|\21\3\2\2\2}~\7\17\2\2~\177\7\4\2\2\177\u0080"+
		"\5\32\16\2\u0080\u0081\7\5\2\2\u0081\u0085\7\7\2\2\u0082\u0084\5\4\3\2"+
		"\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\b\2\2\u0089"+
		"\u008a\7*\2\2\u008a\23\3\2\2\2\u008b\u008c\7&\2\2\u008c\u008d\7\f\2\2"+
		"\u008d\u008e\5\32\16\2\u008e\u008f\7*\2\2\u008f\25\3\2\2\2\u0090\u0091"+
		"\5\32\16\2\u0091\u0092\7*\2\2\u0092\27\3\2\2\2\u0093\u0094\7\20\2\2\u0094"+
		"\u0095\7\4\2\2\u0095\u0096\7&\2\2\u0096\u0097\7\5\2\2\u0097\u0098\7*\2"+
		"\2\u0098\31\3\2\2\2\u0099\u009a\b\16\1\2\u009a\u009b\7&\2\2\u009b\u00a1"+
		"\7\21\2\2\u009c\u009d\7\22\2\2\u009d\u009e\7&\2\2\u009e\u00a0\7\21\2\2"+
		"\u009f\u009c\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00b1\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\37\2\2"+
		"\u00a5\u00b1\5\32\16\n\u00a6\u00a7\7\4\2\2\u00a7\u00a8\5\32\16\2\u00a8"+
		"\u00a9\7\5\2\2\u00a9\u00b1\3\2\2\2\u00aa\u00b1\7#\2\2\u00ab\u00b1\7!\2"+
		"\2\u00ac\u00b1\7\"\2\2\u00ad\u00b1\7%\2\2\u00ae\u00b1\7&\2\2\u00af\u00b1"+
		"\7$\2\2\u00b0\u0099\3\2\2\2\u00b0\u00a4\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0"+
		"\u00aa\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2"+
		"\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00bd\3\2\2\2\u00b2"+
		"\u00b3\f\r\2\2\u00b3\u00b4\t\2\2\2\u00b4\u00bc\5\32\16\16\u00b5\u00b6"+
		"\f\f\2\2\u00b6\u00b7\t\3\2\2\u00b7\u00bc\5\32\16\r\u00b8\u00b9\f\13\2"+
		"\2\u00b9\u00ba\t\4\2\2\u00ba\u00bc\5\32\16\f\u00bb\u00b2\3\2\2\2\u00bb"+
		"\u00b5\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\33\3\2\2\2\u00bf\u00bd\3\2\2\2\17\37.?"+
		"JXluy\u0085\u00a1\u00b0\u00bb\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}