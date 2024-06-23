//package Testing.UnitTesting;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import Interpreter.Nodes.*;
import Util.PlaybackHandler;
import Interpreter.SymbolTable;
import Interpreter.Visitor;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;

import Grammar.MusicLanguageLexer;
import Grammar.MusicLanguageParser;
import Grammar.MusicLanguageParser.ExpressionStatementContext;

import java.lang.reflect.Field;
@RunWith(MockitoJUnitRunner.class)
public class VisitorUnitTest {
    @Mock
    private MusicLanguageParser.BpmStatementContext mockContext;

    @Mock
    private MusicLanguageParser.LetStatementContext mockLetStatementContext;

    @Mock
    private MusicLanguageParser.ExpressionContext mockExpressionContext;

    @Mock
    private MusicLanguageParser.ExpressionStatementContext mockExpressionStatementContext;

    @Mock
    private MusicLanguageParser.NumberContext mockNumberContext;

    @Mock
    private MusicLanguageParser.StringContext mockStringContext;

    @Mock
    private MusicLanguageParser.NoteContext mockNoteContext;

    @Mock
    private MusicLanguageParser.ChordContext mockChordContext;

    @Mock
    private MusicLanguageParser.BooleanContext mockBooleanContext;

    @Mock
    private MusicLanguageParser.SampleStatementContext mockSampleStatementContext;

    @Mock
    private MusicLanguageParser.WhileStatementContext mockWhileStatementContext;

    @Mock
    private MusicLanguageParser.IfStatementContext mockIfStatementContext;

    @Mock
    private MusicLanguageParser.RepeatStatementContext mockRepeatStatementContext;

    @Mock
    private MusicLanguageParser.ElseStatementContext mockElseStatementContext;

    @Mock
    private MusicLanguageParser.AddSubOperationContext mockAddSubOperationContext;

    @Mock
    private MusicLanguageParser.MultDivOperationContext mockMultDivOperationContext;

    @Mock
    private MusicLanguageParser.LogicalOperationContext mockLogicalOperationContext;

    @Mock
    private MusicLanguageParser.ParenthesisContext mockParenthesisContext;

    @Mock
    private MusicLanguageParser.NotOperationContext mockNotOperationContext;

    @Mock
    private MusicLanguageParser.ComparisonContext mockComparisonContext;

    @Mock
    private MusicLanguageParser.StatementContext mockStatementContext;

    @Mock
    private MusicLanguageParser.PauseContext mockPauseContext;

    @Mock
    private MusicLanguageParser.PlayStatementContext ctx;
    
    @Mock
    private MusicLanguageParser.StatementContext statement1;

    @Mock
    private MusicLanguageParser.StatementContext statement2;

    @Mock
    private Token mockToken;

    @Mock
    private TerminalNode mockTerminalNode;

    @Mock
    private PlaybackHandler mockTimingHandler;

    @Mock
    private ASTNode astNode;

    @Mock
    private SymbolTable symbolTable;

    @Mock
    private PlaybackHandler playbackHandler;

    @InjectMocks
    Visitor visitor = new Visitor();

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        visitor = new Visitor();
    }

    @Test
    public void testVisitBpmStatement() {
        // Arrange
        when(mockContext.INT()).thenReturn(mockTerminalNode);
        when(mockTerminalNode.getText()).thenReturn("120");

        // Act
        ASTNode result = visitor.visitBpmStatement(mockContext);

        // Assert
        assertTrue(result instanceof BpmStatement);
        assertEquals(120, ((BpmStatement) result).getBpm());
    }

    @Test
    public void testVisitLetStatement() {
        // Arrange
        String input = "let x = 5;\n";
        MusicLanguageLexer lexer = new MusicLanguageLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicLanguageParser parser = new MusicLanguageParser(tokens);
        MusicLanguageParser.LetStatementContext letStatementContext = parser.letStatement();

        // Act
        ASTNode result = visitor.visitLetStatement(letStatementContext);

        // Assert
        assertTrue(result instanceof LetStatement);
        LetStatement letStatement = (LetStatement) result;
        assertEquals("Statements", letStatement.getType());
    }

    @Test
    public void testVisitNumber() {
        // Arrange
        int expectedValue = 42;
        when(mockNumberContext.getText()).thenReturn(String.valueOf(expectedValue));

        // Act
        ASTNode result = visitor.visitNumber(mockNumberContext);

        // Assert
        assertEquals(IntegerValueNode.class, result.getClass());
        assertEquals(expectedValue, ((IntegerValueNode) result).getValue());
    }

    @Test
    public void testVisitString() {
        // Arrange
        String expectedString = "Hello, world!";
        when(mockStringContext.getText()).thenReturn(expectedString);

        // Act
        ASTNode result = visitor.visitString(mockStringContext);

        // Assert
        assertEquals(StringValueNode.class, result.getClass());
        assertEquals(expectedString, ((StringValueNode) result).getValue());
    }

    @Test
    public void testVisitNote() {
        // Arrange
        String expectedNote = "C";
        when(mockNoteContext.getText()).thenReturn(expectedNote);

        // Act
        ASTNode result = visitor.visitNote(mockNoteContext);

        // Assert
        assertEquals(NoteStatement.class, result.getClass());
    }

    @Test
    public void testVisitChord() {
        // Arrange
        String expectedChord = "C, D, E";
        when(mockChordContext.getText()).thenReturn(expectedChord);

        // Act
        ASTNode result = visitor.visitChord(mockChordContext);

        // Assert
        assertEquals(ChordStatement.class, result.getClass());
    }

    @Test
    public void testVisitBoolean() {
        // Arrange
        boolean expectedBoolean = true;
        when(mockBooleanContext.getText()).thenReturn(String.valueOf(expectedBoolean));

        // Act
        ASTNode result = visitor.visitBoolean(mockBooleanContext);

        // Assert
        assertEquals(BooleanValueNode.class, result.getClass());
    }

    @Test
    public void testVisitSampleStatement() {
        // Arrange
        String expectedSample = "sample";
        String expectedInstrument = "instrument";
        when(mockSampleStatementContext.STRING()).thenReturn(mockTerminalNode);
        when(mockTerminalNode.getText()).thenReturn(expectedSample);
        when(mockSampleStatementContext.INSTRUMENT()).thenReturn(mockTerminalNode);
        when(mockTerminalNode.getText()).thenReturn(expectedInstrument);

        // Act
        ASTNode result = visitor.visitSampleStatement(mockSampleStatementContext);

        // Assert
        assertEquals(SampleStatement.class, result.getClass());
    }

    @Test(timeout = 5000)
    public void testVisitWhileStatement() {
        // Arrange
        MusicLanguageParser.WhileStatementContext mockWhileStatementContext = mock(
                MusicLanguageParser.WhileStatementContext.class);
        MusicLanguageParser.ExpressionContext mockExpressionContext = mock(MusicLanguageParser.ExpressionContext.class);
        when(mockWhileStatementContext.expression()).thenReturn(mockExpressionContext);

        BooleanValueNode booleanValueNode = new BooleanValueNode(true);
        when(visitor.visit(mockExpressionContext)).thenReturn(booleanValueNode);

        // Act
        ASTNode result = visitor.visitWhileStatement(mockWhileStatementContext);

        // Assert
        assertTrue(result instanceof WhileStatement);
        WhileStatement whileStatement = (WhileStatement) result;
        assertEquals("Statements", whileStatement.getType());
    }

    @Test
    public void testVisitRepeatStatement() {
        // Arrange
        MusicLanguageParser.RepeatStatementContext mockRepeatStatementContext = mock(MusicLanguageParser.RepeatStatementContext.class);
        MusicLanguageParser.StatementContext mockStatementContext1 = mock(MusicLanguageParser.StatementContext.class);

        TerminalNode mockINTTerminalNode = mock(TerminalNode.class);
        when(mockRepeatStatementContext.INT()).thenReturn(mockINTTerminalNode);
        when(mockINTTerminalNode.getText()).thenReturn("2"); 

        when(mockRepeatStatementContext.statement()).thenReturn(Arrays.asList(mockStatementContext1, mockStatementContext));

        ASTNode mockResult1 = mock(ASTNode.class);
        ASTNode mockResult2 = mock(ASTNode.class);
        when(visitor.visit(mockStatementContext)).thenReturn(mockResult1);
        when(visitor.visit(mockStatementContext1)).thenReturn(mockResult2);

        // Act
        ASTNode result = visitor.visitRepeatStatement(mockRepeatStatementContext);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ASTNode); 
        }



    @Test
    public void testVisitIfStatement() {
        // Arrange
        when(mockIfStatementContext.expression()).thenReturn(mockExpressionContext);

        BooleanValueNode booleanValueNode = new BooleanValueNode(true);
        when(visitor.visit(mockExpressionContext)).thenReturn(booleanValueNode);

        when(mockIfStatementContext.statement()).thenReturn(Collections.singletonList(mockStatementContext));

        when(visitor.visit(mockStatementContext)).thenReturn(astNode);

        // Act
        ASTNode result = visitor.visitIfStatement(mockIfStatementContext);

        // Assert
        assertEquals(astNode, result);
    }

    @Test
    public void testVisitElseStatement() {
        // Arrange
        when(mockElseStatementContext.statement()).thenReturn(Collections.singletonList(mockStatementContext));

        when(visitor.visit(mockStatementContext)).thenReturn(astNode);

        // Act
        ASTNode result = visitor.visitElseStatement(mockElseStatementContext);

        // Assert
        assertEquals(astNode, result);
    }

    @Test
    public void testVisitAddSubOperation() {
        // Arrange
        when(mockAddSubOperationContext.getText()).thenReturn("3+5");

        when(symbolTable.retrieveSymbol(anyString())).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if (arg.matches("\\d+")) {
                return new IntegerValueNode(Integer.parseInt(arg));
            } else {
                return null;
            }
        });

        // Act
        ASTNode result = visitor.visitAddSubOperation(mockAddSubOperationContext);

        // Assert
        assertTrue(result instanceof IntegerValueNode);
        assertEquals(8, ((IntegerValueNode) result).getValue());
    }

    @Test
    public void testVisitMultDivOperation() {
        // Arrange
        when(mockMultDivOperationContext.getText()).thenReturn("3*5");

        when(symbolTable.retrieveSymbol(anyString())).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if (arg.matches("\\d+")) {
                return new IntegerValueNode(Integer.parseInt(arg));
            } else {
                return null;
            }
        });

        // Act
        ASTNode result = visitor.visitMultDivOperation(mockMultDivOperationContext);

        // Assert
        assertTrue(result instanceof IntegerValueNode);
        assertEquals(15, ((IntegerValueNode) result).getValue());
    }

    @Test
    public void testVisitLogicalOperation() {
        // Arrange
        when(mockLogicalOperationContext.getText()).thenReturn("true&&false");

        // Mock the symbol table to return a BooleanValueNode when retrieveSymbol is
        // called
        when(symbolTable.retrieveSymbol(anyString())).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if (arg.equals("true") || arg.equals("false")) {
                return new BooleanValueNode(Boolean.parseBoolean(arg));
            } else {
                return null;
            }
        });

        // Act
        ASTNode result = visitor.visitLogicalOperation(mockLogicalOperationContext);

        // Assert
        assertTrue(result instanceof BooleanValueNode);
        assertEquals(false, ((BooleanValueNode) result).getValue());
    }

    @Test
    public void testVisitParenthesis() {
        // Arrange
        when(mockParenthesisContext.expression()).thenReturn(mockExpressionContext);

        IntegerValueNode integerValueNode = new IntegerValueNode(5);
        when(visitor.visit(mockExpressionContext)).thenReturn(integerValueNode);

        // Act
        ASTNode result = visitor.visitParenthesis(mockParenthesisContext);

        // Assert
        assertEquals(IntegerValueNode.class, result.getClass());
        assertEquals(5, ((IntegerValueNode) result).getValue());
    }

    @Test
    public void testVisitNotOperation() {
        // Arrange
        when(mockNotOperationContext.expression()).thenReturn(mockExpressionContext);

        BooleanValueNode booleanValueNode = new BooleanValueNode(true);
        when(visitor.visit(mockExpressionContext)).thenReturn(booleanValueNode);

        // Act
        ASTNode result = visitor.visitNotOperation(mockNotOperationContext);

        // Assert
        assertEquals(BooleanValueNode.class, result.getClass());
    }

    @Test
    public void testVisitComparison() {
        // Arrange
        when(mockComparisonContext.getText()).thenReturn("3>=5");

        when(symbolTable.retrieveSymbol(anyString())).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if (arg.matches("\\d+")) {
                return new IntegerValueNode(Integer.parseInt(arg));
            } else {
                return null;
            }
        });

        // Act
        ASTNode result = visitor.visitComparison(mockComparisonContext);

        // Assert
        assertTrue(result instanceof BooleanValueNode);
        assertEquals(false, ((BooleanValueNode) result).getValue());
    }

    @Test
    public void testVisitExpressionStatement_NoteStatement() {
        // Arrange
        String variableName = "A";
        NoteStatement mockNoteStatement = mock(NoteStatement.class);
        IntegerValueNode mockNoteValue = new IntegerValueNode(42); // Adjust the mock node as needed

        when(mockExpressionStatementContext.expression()).thenReturn(mockExpressionContext);
        when(mockExpressionContext.getText()).thenReturn(variableName);
        when(mockExpressionStatementContext.getStart()).thenReturn(mockToken);
        when(mockToken.getLine()).thenReturn(1);
        when(symbolTable.retrieveSymbol(variableName)).thenReturn(mockNoteStatement);
        when(symbolTable.retrieveSymbolValue(variableName)).thenReturn(mockNoteValue);

        visitor.insidePlayBlock = true;

        // Act
        ASTNode result = visitor.visitExpressionStatement(mockExpressionStatementContext);

        // Assert
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result instanceof Statements);
    }




    @Test
    public void testGetValue() throws NoSuchFieldException, IllegalAccessException {
        Visitor visitor = new Visitor();

        // Use reflection to access the symbolTable field
        Field symbolTableField = Visitor.class.getDeclaredField("symbolTable");
        symbolTableField.setAccessible(true);
        SymbolTable symbolTable = (SymbolTable) symbolTableField.get(visitor);

        // Add a symbol to the symbolTable
        symbolTable.enterSymbol("testVar", new BooleanValueNode(true));
        
    
        // Test when variable is in symbolTable and is a BooleanValueNode
        assertEquals(new BooleanValueNode(true).toString() == visitor.getValue("testVar").toString(), true);

        // Test when variable is "true"
        assertEquals(true, visitor.getValue("true"));

        // Test when variable is "false"
        assertEquals(false, visitor.getValue("false"));

        // Test when variable is not in symbolTable and is not "true" or "false"
        assertNull(visitor.getValue("nonexistentVar"));
    }

    @Test
    public void testVisitPause() {
        // Arrange
        when(mockPauseContext.getText()).thenReturn("1-");

        Token mockToken = mock(Token.class);
        when(mockToken.getLine()).thenReturn(1);
        when(mockPauseContext.getStart()).thenReturn(mockToken);

        // Act
        ASTNode result = visitor.visitPause(mockPauseContext);

        // Assert
        assertTrue(result instanceof PauseStatement);
    }

    @Test
    public void testNoteToMidi() {
        Visitor visitor = new Visitor();
        String[] notes = {"C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4"};
        int[] midiValues = {60, 61, 62, 63, 64, 65, 66, 67, 56, 57, 58, 59};
    
        for (int i = 0; i < notes.length; i++) {
            int midiValue = visitor.noteToMidi(notes[i]);
            assertEquals(midiValues[i], midiValue);
        }
    }

    @Test
    public void testMidiToNote() {
        Visitor visitor = new Visitor();
        String[] notes = {"C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4"};
        int[] midiValues = {60, 61, 62, 63, 64, 65, 66, 67, 56, 57, 58, 59};

        for (int i = 0; i < notes.length; i++) {
            String note = visitor.midiToNote(midiValues[i]);
            assertEquals(notes[i], note);
        }


    }

    @Test
    public void testVisitPlayStatementEmptyBlock() {
        Visitor visitor = new Visitor();
        when(ctx.statement()).thenReturn(Collections.emptyList());
        when(ctx.getText()).thenReturn("play");

        ASTNode node = visitor.visitPlayStatement(ctx);

        // Assert PlayStatement creation with empty child list
        assertEquals(node instanceof PlayStatement, true);
        PlayStatement playStatement = (PlayStatement) node;
        assertEquals(playStatement.getChildren().size() == 0, true);
    }

    @Test
    public void testVisitPlayStatementSingleStatement() {
        Visitor visitor = new Visitor();
        // Mock visit for statement1
        ASTNode mockedNode1 = new ASTNode(null);
        when(visitor.visit(statement1)).thenReturn(mockedNode1);

        when(ctx.statement()).thenReturn(Arrays.asList(statement1));
        when(ctx.getText()).thenReturn("play");

        ASTNode node = visitor.visitPlayStatement(ctx);

        // Assert PlayStatement creation with expected child
        assertEquals(node instanceof PlayStatement, true);
        PlayStatement playStatement = (PlayStatement) node;
        assertEquals(playStatement.getChildren().size() == 1, true);
    }
    

}