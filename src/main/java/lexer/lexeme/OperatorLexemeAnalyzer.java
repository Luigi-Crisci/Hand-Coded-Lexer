package lexer.lexeme;

import lexer.com.compiler.*;
import lexer.utils.*;
import java.nio.ByteBuffer;

public class OperatorLexemeAnalyzer extends AbstractLexemeAnalyzer{

    private final String tokenName;

    public OperatorLexemeAnalyzer() {
        super();
        tokenName = Tokens.OP.toString();
    }

    @Override
    public RecognizedToken check(ByteBuffer buffer) {

        while(true){
            switch (state){
                case 0:{
                    nextChar(buffer);
                    switch (readChar.charAt(0)){
                        case '>':{
                            state = 1;
                            continue;
                        }
                        case '<':{
                            state = 2;
                            continue;
                        }
                        case '|':{
                            state = 4;
                            continue;
                        }
                        case '&':{
                            state = 5;
                            continue;
                        }
                        case '!':{
                            state = 6;
                            continue;
                        }
                        case '^':
                        case '+':
                        case '-':
                        case '/':
                        case '*':
                        case '%': {
                            return constructToken();
                        }
                    }
                    return ERROR_TOKEN;
                }
                case 1:{ // Read >
                    nextChar(buffer);
                    if (readChar.equals("=")){
                        return constructToken();
                    }
                    retract();
                    return constructToken();
                }
                case 2: { // Read <
                    nextChar(buffer);
                    if (readChar.equals("="))
                        return constructToken();
                    if (readChar.equals("-")){
                        state = 3;
                        continue;
                    }
                    retract();
                    return constructToken();
                }
                case 3:{ // Read <-
                    nextChar(buffer);
                    if (readChar.equals("-"))
                        return constructToken();
                    return ERROR_TOKEN;
                }
                case 4:{ // Read |
                    nextChar(buffer);
                    if (readChar.equals("|"))
                        return constructToken();
                    return ERROR_TOKEN;
                }
                case 5:{ // &
                    nextChar(buffer);
                    if (readChar.equals("&"))
                        return constructToken();
                    return ERROR_TOKEN;
                }
                case 6:{ // !
                    nextChar(buffer);
                    if (readChar.equals("="))
                        return constructToken();

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
