import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;;


public class ErrorChecker extends BaseErrorListener {
    public static final ErrorChecker INSTANCE = new ErrorChecker();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
