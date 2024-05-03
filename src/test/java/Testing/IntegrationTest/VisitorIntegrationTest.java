package Testing.IntegrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;

import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Test;

import Interpreter.Nodes.ASTNode;
import Grammar.MusicLanguageLexer;
import Grammar.MusicLanguageParser;
import Interpreter.SymbolTable;
import Interpreter.Visitor;

public class VisitorIntegrationTest {

    @Test
    public void testVisitProgram() {
        // Define your input program
        String inputProgram = "let x = 5;\n"
                            + "let y = 10;\n"
                            + "play x;\n"
                            + "play y;\n";

        // Set up the lexer, parser, and input stream
        MusicLanguageLexer lexer = new MusicLanguageLexer(CharStreams.fromString(inputProgram));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicLanguageParser parser = new MusicLanguageParser(tokens);

        // Parse the input program
        MusicLanguageParser.ProgramContext programContext = parser.program();

        // Create an instance of your visitor
        Visitor visitor = new Visitor();

        // Visit the program context with your visitor
        ASTNode result = visitor.visitProgram(programContext);

        // Assert that the result is not null
        assertEquals(result, );
    }
}