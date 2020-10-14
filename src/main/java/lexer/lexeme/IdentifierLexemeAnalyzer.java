package lexer.lexeme;

import lexer.utils.*;
import java.nio.ByteBuffer;

public class IdentifierLexemeAnalyzer extends AbstractLexemeAnalyzer {

    @Override
    public RecognizedToken check(ByteBuffer buffer) {
        while (true) {
            switch (state) {
                case 0: { // Read a letter
                    nextChar(buffer);
                    if (LexerUtils.isLetter(readChar)) {
                        state = 1;
                        continue;
                    }
                    return constructToken(Tokens.ERROR);
                }

                case 1: { // Read a word (See LexemePatterns class for more info)
                    nextChar(buffer);
                    if (LexerUtils.isWord(readChar))
                        continue;
                    retract();
                    return constructToken(Tokens.ID);
                }
            }
        }
    }

    @Override
    protected RecognizedToken constructToken(Tokens tokenName) {
        if(LexerUtils.isKeyword(stringBuffer.toString()))
            return super.constructToken(Tokens.valueOf(stringBuffer.toString()));
        else
            return super.constructToken(Tokens.ID);
    }

}
