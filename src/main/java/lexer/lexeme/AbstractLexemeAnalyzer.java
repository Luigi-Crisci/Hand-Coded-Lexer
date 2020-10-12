package lexer.lexeme;

import java.nio.ByteBuffer;
import lexer.utils.LexerUtils;
import lexer.utils.RecognizedToken;

public abstract class AbstractLexemeAnalyzer {

    public static final RecognizedToken ERROR_TOKEN = new RecognizedToken();

    protected int state = 0;
    protected int numCharRead = 0;
    protected StringBuffer stringBuffer;
    protected CharSequence readChar;

    public AbstractLexemeAnalyzer() {
        stringBuffer = new StringBuffer();
    }

    public abstract RecognizedToken check(ByteBuffer buffer);
    protected abstract RecognizedToken constructToken();

    protected void retract(){
        numCharRead--;
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }

    protected void nextChar(ByteBuffer buffer) {
        char c = buffer.getChar();
        stringBuffer.append(c);
        numCharRead++;
        readChar = LexerUtils.charToCharSequence(c);
        
    }

}