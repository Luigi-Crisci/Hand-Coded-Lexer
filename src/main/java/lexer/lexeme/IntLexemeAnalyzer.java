package lexer.lexeme;

import lexer.com.compiler.*;
import lexer.utils.*;

import java.nio.ByteBuffer;

public class IntLexemeAnalyzer extends AbstractLexemeAnalyzer {

    private String tokenName;


    public IntLexemeAnalyzer() {
        super();
        tokenName = Tokens.INT.toString();
    }

    @Override
    public RecognizedToken check(ByteBuffer buffer) {

        while(true) {
            switch (state) {
                case 0: { //Initial state
                    nextChar(buffer);
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
                    nextChar(buffer);
                    if (readChar.equals(".")){
                        state = 3;
                        tokenName = Tokens.FLOAT.toString();
                        break;
                    }
                    if (!LexerUtils.isBlank(readChar))
                        return ERROR_TOKEN;
                    retract();
                    return constructToken();
                }

                case 2: { //Read "1-9" as first char
                    nextChar(buffer);
                    if (!LexerUtils.isDigit(readChar)){
                        if(LexerUtils.isBlank(readChar)){
                            retract();
                            return constructToken();
                        }
                        if (readChar.equals(".")){
                            state = 3;
                            tokenName = Tokens.FLOAT.toString();
                            break;
                        }
                        return ERROR_TOKEN;
                    }
                    break;
                }

                case 3: { //Read a . or a 0, expecting at least a non-zero digit
                    nextChar(buffer);
                    if(readChar.equals("0"))
                        continue;
                    if(LexerUtils.isNonzeroDigit(readChar)){
                        state = 4;
                        continue;
                    }
                    return ERROR_TOKEN;
                }

                case 4: { // Check for float suffix - must not end with 0
                    nextChar(buffer);
                    if (LexerUtils.isNonzeroDigit(readChar))
                        continue;
                    if (readChar.equals("0")){
                        state = 3;
                        continue;
                    }

                    retract();
                    return constructToken();
                }
            }
        }
    }

    @Override
    protected RecognizedToken constructToken() {
        Token t = new Token(tokenName,stringBuffer.toString());
        return new RecognizedToken(t,numCharRead);
    }


}
