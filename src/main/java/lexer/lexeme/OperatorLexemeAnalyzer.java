package lexer.lexeme;

import lexer.utils.*;
import java.nio.ByteBuffer;

public class OperatorLexemeAnalyzer extends AbstractLexemeAnalyzer {

    @Override
    public RecognizedToken check(ByteBuffer buffer) {

        reset();

        while (true) {
            switch (state) {
                case 0: {
                    nextChar(buffer);
                    if (LexerUtils.isBlank(readChar))
                        continue;
                    switch (readChar.charAt(0)) {
                        case '>': {
                            state = 1;
                            continue;
                        }
                        case '<': {
                            state = 2;
                            continue;
                        }
                        case '|': {
                            state = 4;
                            continue;
                        }
                        case '&': {
                            state = 5;
                            continue;
                        }
                        case '!': {
                            state = 6;
                            continue;
                        }
                        case '^':
                        case '+':
                        case '-':
                        case '/':
                        case '*':
                        case '=':
                        case '%': {
                            return constructToken(Tokens.OP);
                        }
                    }
                    return constructToken(Tokens.ERROR);
                }
                case 1: { // Read >
                    nextChar(buffer);
                    if (readChar.equals("=")) {
                        return constructToken(Tokens.OP);
                    }
                    retract();
                    return constructToken(Tokens.OP);
                }
                case 2: { // Read <
                    nextChar(buffer);
                    if (readChar.equals("="))
                        return constructToken(Tokens.OP);
                    if (readChar.equals("-")) {
                        state = 3;
                        continue;
                    }
                    retract();
                    return constructToken(Tokens.OP);
                }
                case 3: { // Read <-
                    nextChar(buffer);
                    if (readChar.equals("-"))
                        return constructToken(Tokens.OP);

                    retract(2);
                    return constructToken(Tokens.OP);
                }
                case 4: { // Read |
                    nextChar(buffer);
                    if (readChar.equals("|"))
                        return constructToken(Tokens.OP);
                    retract();
                    return constructToken(Tokens.OP);
                }
                case 5: { // &
                    nextChar(buffer);
                    if (readChar.equals("&"))
                        return constructToken(Tokens.OP);
                    retract();
                    return constructToken(Tokens.OP);
                }
                case 6: { // !
                    nextChar(buffer);
                    if (readChar.equals("="))
                        return constructToken(Tokens.OP);
                    retract();
                    return constructToken(Tokens.OP);
                }
            }
        }

    }

}
