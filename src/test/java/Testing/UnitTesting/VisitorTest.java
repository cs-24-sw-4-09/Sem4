package Testing.UnitTesting;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.List;

import Interpreter.Nodes.*;
import Util.TimingHandler;
import Interpreter.SymbolTable;
import Interpreter.Visitor;
import org.antlr.v4.runtime.Token;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import Grammar.MusicLanguageParser;
import Grammar.MusicLanguageParser.LetStatementContext;

@RunWith(MockitoJUnitRunner.class)
public class VisitorTest {
    @Mock
    private MusicLanguageParser.BpmStatementContext mockContext;

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
    MusicLanguageParser.ExpressionContext mockExpressionContext = mock(MusicLanguageParser.ExpressionContext.class);
    ASTNode mockValue = mock(ASTNode.class);
    when(visitor.visit(mockExpressionContext)).thenReturn(mockValue);

    LetStatementContext mockContext = mock(LetStatementContext.class);
    when(mockTerminalNode.getText()).thenReturn("variable");
    when(mockContext.expression()).thenReturn(mockExpressionContext);

    // Act
    ASTNode result = visitor.visitLetStatement(mockContext);

    // Assert
    assertTrue(result instanceof LetStatement);
    assertEquals("variable", ((LetStatement) result).getLet());
    assertEquals(mockValue, ((LetStatement) result).getExpression());
}
}
