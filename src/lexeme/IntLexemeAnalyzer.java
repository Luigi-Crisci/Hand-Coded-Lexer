package lexeme;

import com.compiler.Token;
import utils.LexerUtils;
import utils.RecognizedToken;
import java.nio.ByteBuffer;

public class IntLexemeAnalyzer extends AbstractLexemeAnalyzer {

    private final String TOKEN_NAME = "INT";

    @Override
    public RecognizedToken check(ByteBuffer buffer) {
        stringBuffer = new StringBuffer();
        CharSequence readChar;

        while(true) {
            switch (state) {
                case 0: { //Initial state
                    readChar = nextChar(buffer);
                    stringBuffer.append(readChar);
                    if (LexerUtils.isDigit(readChar)) {
                        if (readChar.equals("0"))
                            state = 1;
                        else
                            state = 2;
                        break;
                    }
                    return ERROR_TOKEN;
                }

                case 1: { //Read "0"
                    readChar = nextChar(buffer);
                    if (!LexerUtils.isBlank(readChar))
                        return ERROR_TOKEN;
                    retract();
                    return constructToken();
                }

                case 2: { //Read "1-9" as first char
                    readChar = nextChar(buffer);
                    if (!LexerUtils.isDigit(readChar)){
                        if(LexerUtils.isBlank(readChar)){
                            retract();
                            return constructToken();
                        }
                        return ERROR_TOKEN;
                    }
                    stringBuffer.append(readChar);
                }
            }
        }
    }

    @Override
    protected RecognizedToken constructToken() {
        Token t = new Token(TOKEN_NAME,stringBuffer.toString());
        return new RecognizedToken(t,numCharRead);
    }


}
