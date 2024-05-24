import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Grammar.*;
import Interpreter.Nodes.*;

import Interpreter.*;

import java.io.*;


public class app {
    public static void main(String[] args) throws IOException {
    try {
        
        String inputFile = "src/main/java/program.txt";
        String inputText = readFile(inputFile);


        
        CharStream input = CharStreams.fromString(inputText);

        
        MusicLanguageLexer lexer = new MusicLanguageLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorChecker.INSTANCE);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        MusicLanguageParser parser = new MusicLanguageParser(tokens);
        
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorChecker.INSTANCE);
        ParseTree tree = parser.program();
        Visitor astBuilder = new Visitor();

        
        ASTNode ast = astBuilder.visit(tree);
      
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    
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
