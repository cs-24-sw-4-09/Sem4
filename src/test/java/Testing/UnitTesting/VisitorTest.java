package Testing.UnitTesting;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.beans.Expression;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import Interpreter.Nodes.*;
import Util.Note;
import Util.TimingHandler;
import Interpreter.SymbolTable;
import Interpreter.Visitor;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import Grammar.MusicLanguageParser;
import Grammar.MusicLanguageParser.ExpressionStatementContext;
import Grammar.MusicLanguageParser.LetStatementContext;
import org.antlr.v4.runtime.CommonToken;

@RunWith(MockitoJUnitRunner.class)
public class VisitorTest {
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
        visitor.setTimingHandler(mockTimingHandler);
    }


    @Test
    public void testVisitBpmStatement() {
        //Arrange
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
        String variableName = "x";
        when(mockLetStatementContext.variable).thenReturn(mockTerminalNode);
        when(mockTerminalNode.getText()).thenReturn(variableName);
        when(mockLetStatementContext.expression()).thenReturn(mockExpressionContext);
        when(visitor.visit(mockExpressionContext)).thenReturn(astNode);

        // Act
        ASTNode result = visitor.visitLetStatement(mockLetStatementContext);

        // Assert
        assertTrue(result instanceof LetStatement);
        assertEquals(variableName, ((LetStatement) result).getLet());
        verify(symbolTable, times(1)).enterSymbol(variableName, astNode);
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
    public void testVisitNote(){
        // Arrange
        String expectedNote = "C";
        when(mockNoteContext.getText()).thenReturn(expectedNote);

        // Act
        ASTNode result = visitor.visitNote(mockNoteContext);

        // Assert
        assertEquals(NoteStatement.class, result.getClass());
    }

    @Test
    public void testVisitChord(){
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
    public void testVisitSampleStatement(){
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

}
