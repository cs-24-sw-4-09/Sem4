
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Grammar.*;
import Interpreter.*;

import java.io.*;


public class app {
    public static void main(String[] args) throws IOException {
        // Read the content of the text file
        String inputFile = "program.txt";
        String inputText = readFile(inputFile);

        // Create a CharStream from the input text
        CharStream input = CharStreams.fromString(inputText);

        // Create a lexer
        MusicLanguageLexer lexer = new MusicLanguageLexer(input);

        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser
        MusicLanguageParser parser = new MusicLanguageParser(tokens);
        // Parse the input and build the parse tree
        ParseTree tree = parser.program();

        Visitor astBuilder = new Visitor();

        // Build the AST from the parse tree
        ASTNode ast = astBuilder.visit(tree);
        MidiInterpreter interpreter = new MidiInterpreter(120);
        interpreter.interpretAST(ast);
        interpreter.setEOF(parser.isMatchedEOF());

        // Print the parse tree to the console
        System.out.println(tree.toStringTree(parser));
        System.out.println(ast.toString());
        System.out.println("Interpretation result:");
        System.out.println(interpreter.getInterpretationResult());
    }

    // Helper method to read the content of a file as a string
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
