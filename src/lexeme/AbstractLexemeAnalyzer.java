package lexeme;

import com.compiler.Token;
import utils.LexerUtils;
import utils.RecognizedToken;

import java.nio.ByteBuffer;

public abstract class AbstractLexemeAnalyzer {

    public static final RecognizedToken ERROR_TOKEN = new RecognizedToken();

    protected int state = 0;
    protected int numCharRead = 0;
    protected StringBuffer stringBuffer;

    public abstract RecognizedToken check(ByteBuffer buffer);
    protected abstract RecognizedToken constructToken();

    protected void retract(){
        numCharRead--;
    }

    protected CharSequence nextChar(ByteBuffer buffer) {
        char c = buffer.getChar();
        numCharRead++;
        return LexerUtils.charToCharSequence(c);
    }

}
