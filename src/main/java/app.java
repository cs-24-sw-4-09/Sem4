import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Grammar.*;
import Interpreter.Nodes.*;

import Interpreter.*;

import java.io.*;


public class app {
    public static void main(String[] args) throws IOException {
    try {
        // Read the content of the text file
        String inputFile = "src/main/java/program.txt";
        String inputText = readFile(inputFile);


        // Create a CharStream from the input text
        CharStream input = CharStreams.fromString(inputText);

        // Create a lexer
        MusicLanguageLexer lexer = new MusicLanguageLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorChecker.INSTANCE);
        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Create a parser
        MusicLanguageParser parser = new MusicLanguageParser(tokens);
        // Parse the input and build the parse tree
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorChecker.INSTANCE);
        ParseTree tree = parser.program();
        System.out.println(parser);
        Visitor astBuilder = new Visitor();

        // Build the AST from the parse tree
        ASTNode ast = astBuilder.visit(tree);
        System.out.println(ast);
       // MidiInterpreter interpreter = new MidiInterpreter();
       // interpreter.interpretAST(ast);

        // Print the parse tree to the console
        //System.out.println(tree.toStringTree(parser));
        //System.out.println(ast.toString());
        //System.out.println("Interpretation result:");
       // System.out.println(interpreter.getInterpretationResult());
        //System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

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
