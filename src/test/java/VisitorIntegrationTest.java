import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.Tree;

import Grammar.MusicLanguageParser;
import Grammar.MusicLanguageLexer;
import Interpreter.SymbolTable;
import Interpreter.Visitor;
import Interpreter.Nodes.BooleanValueNode;
import Util.PlaybackHandler;

@RunWith(MockitoJUnitRunner.class)
public class VisitorIntegrationTest {
    @Mock
    private PlaybackHandler playbackHandlerMock;

    private SymbolTable symbolTable;
    private Visitor visitor;
    private PlaybackHandler playbackHandler;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        visitor = new Visitor();
        playbackHandler = new PlaybackHandler(120);
        visitor.setPlaybackHandler(playbackHandler);
    }

    public static class TreeFromString {
        public static MusicLanguageParser.ProgramContext getExprTreeFromString(String input) {
            var lexer = new MusicLanguageLexer(CharStreams.fromString(input));
            var parser = new MusicLanguageParser(new CommonTokenStream(lexer));
            return parser.program();
        }
    }

    @Test 
    public void testBpmStatementPlaybackHandlerBpm() {
        String testString = "bpm (113);";
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        playbackHandlerMock = visitor.getPlaybackHandler();
        assertEquals(113, playbackHandlerMock.getBpm());
    }

    @Test
    public void testLetStatementSymbolTable() {
        String testString = "bpm(113);\n" + "let a = 5;"; 
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        symbolTable = visitor.getSymbolTable();
        assertEquals("5", symbolTable.retrieveSymbol("a").toString());
    }

    @Test
    public void visitExpressionSymbolTable() {
        String testString = "bpm(113);\n" + "let a = 5;\n" + "let b = 10;\n" + "a = b;";
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        symbolTable = visitor.getSymbolTable();
        assertEquals("10", symbolTable.retrieveSymbol("a").toString());
    }

    @Test
    public void sampleTestSymbolTable(){
        String testString = "sample test(Piano){\n" + "let a = 5;\n" + "} \n" + "test();";
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        symbolTable = visitor.getSymbolTable();
        System.out.println(symbolTable.retrieveSymbol("test"));
    }

    @Test
    public void testIfStatement() {
        String testString = "bpm(113);\n" + "let a = 5;\n" + "let b = 10;\n" + "if (a == b) {\n" + "bpm(120);\n" + "}";
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        playbackHandlerMock = visitor.getPlaybackHandler();
        assertEquals(113, playbackHandlerMock.getBpm());
    }

}
