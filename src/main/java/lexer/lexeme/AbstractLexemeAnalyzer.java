package lexer.lexeme;

import java.nio.ByteBuffer;
import lexer.com.compiler.*;
import lexer.utils.LexerUtils;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public abstract class AbstractLexemeAnalyzer {

    protected int state = 0;
    protected int numCharRead = 0;
    protected StringBuffer stringBuffer;
    protected CharSequence readChar;

    public AbstractLexemeAnalyzer() {
        stringBuffer = new StringBuffer();
    }

    public abstract RecognizedToken check(ByteBuffer buffer);
    
    protected RecognizedToken constructToken(Tokens tokenName) {
        Token t = new Token(tokenName.toString(), stringBuffer.toString());
        return new RecognizedToken(t, numCharRead);
    }

    protected void retract(){
        retract(1);
    }

    protected void retract(int n){
        if ( n <= 0)
            return;
        numCharRead -= n;
        stringBuffer.delete(stringBuffer.length() - n, stringBuffer.length() - 1);
    }
    
    protected void nextChar(ByteBuffer buffer) {
        char c = buffer.getChar();
        stringBuffer.append(c);
        numCharRead++;
        readChar = LexerUtils.charToCharSequence(c);
        
    }

}
