package Testing.IntegrationTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import Util.PlaybackHandler;
import Interpreter.SymbolTable;
import Interpreter.Visitor;
import Interpreter.Nodes.SampleStatement;
import Grammar.MusicLanguageParser;
import Grammar.MusicLanguageLexer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class VisitorIntegrationTest {
    @Mock
    private PlaybackHandler playbackHandlerMock = mock(PlaybackHandler.class);


    private SymbolTable symbolTable = new SymbolTable();
    private Visitor visitor = new Visitor();


    @BeforeEach
    public void setUp() throws Exception {
        //playbackHandlerMock = mock(PlaybackHandler.class);
        //Visitor visitor = new Visitor();
        //visitor.setPlaybackHandler(playbackHandlerMock);

        
    }


    public class TreeFromString {
        public static MusicLanguageParser.ProgramContext getExprTreeFromString(String input) {
            var lexer = new MusicLanguageLexer(CharStreams.fromString(input));
            var parser = new MusicLanguageParser(new CommonTokenStream(lexer));
            return parser.program();
        }
    }

    @Test 
    public void testBpmStatementPlaybackHandlerBpm() {
    String testString = "bpm (113);";
    
    // Parse the input string and visit it with the visitor
    MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
    visitor.visit(ctx);
    playbackHandlerMock = visitor.getPlaybackHandler();
    // Assuming the visitBpmStatement method correctly sets the BPM in the PlaybackHandler
    // and getBpm reflects this state accurately.
    assertEquals(113, playbackHandlerMock.getBpm()); // Adjusted to match the expected BPM
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
        System.out.println(visitor.visit(ctx).toString());
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
    public void expressionPlaybackHandler() {
        String testString = "bpm(113);\n" + "let a = 4A3;\n" + "a;";
        MusicLanguageParser.ProgramContext ctx = TreeFromString.getExprTreeFromString(testString);
        visitor.visit(ctx);
        playbackHandlerMock = visitor.getPlaybackHandler();
        

/*
        Util.notation.Note expectedNote = new Util.notation.Note(noteToMidi("4A3"));
        assertTrue(playbackHandlerMock.getNotation("default", expectedNote));

        //verify(visitor.getPlaybackHandler()).addNotation(eq("default"), eq(any(Util.notation.Note.class)));
    */
    }


}
    
    
/*
    @Test //Testing if the program execution starts playback: Workings
    public void testProgramExecutionStartsPlayback() {
    MusicLanguageParser.ProgramContext programContext = mock(MusicLanguageParser.ProgramContext.class); // Assume this is obtained from parsing
    visitor.visitProgram(programContext);
    verify(playbackHandlerMock, times(1)).startPlayback();
}
*/



//Test expression henter fra symbol
//Test alt i programmet som arbejder sammen med symboltable og playbackhandler