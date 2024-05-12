package Testing.UnitTesting;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import Interpreter.Nodes.*;
import Util.TimingHandler;
import Interpreter.SymbolTable;
import Interpreter.Visitor;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import Grammar.MusicLanguageLexer;
import Grammar.MusicLanguageParser;

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
    private MusicLanguageParser.ArithmeticOperationContext mockArithmeticOperationContext;

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
    private TerminalNode mockTerminalNode;

    @Mock
    private TimingHandler mockTimingHandler;

    @Mock
    private ASTNode astNode;

    @Mock
    private SymbolTable symbolTable;

    @InjectMocks
    Visitor visitor = new Visitor();

    @BeforeEach
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

    @Test
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
    public void testVisitArithmeticOperation() {
        // Arrange
        MusicLanguageParser.ArithmeticOperationContext mockArithmeticOperationContext = mock(
                MusicLanguageParser.ArithmeticOperationContext.class);
        when(mockArithmeticOperationContext.getText()).thenReturn("5+3");

        // Mock the symbol table to return an IntegerValueNode when retrieveSymbol is
        // called
        when(symbolTable.retrieveSymbol(toString())).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if (arg.matches("\\d+")) {
                return new IntegerValueNode(Integer.parseInt(arg));
            } else {
                return null;
            }
        });

        // Act
        ASTNode result = visitor.visitArithmeticOperation(mockArithmeticOperationContext);

        // Assert
        assertTrue(result instanceof IntegerValueNode);
        assertEquals(8, ((IntegerValueNode) result).getValue());
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

}
