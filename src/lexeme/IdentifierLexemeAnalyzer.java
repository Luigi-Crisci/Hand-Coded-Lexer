package lexeme;

import com.compiler.Token;
import utils.LexerUtils;
import utils.RecognizedToken;
import utils.Tokens;

import java.nio.ByteBuffer;

public class IdentifierLexemeAnalyzer extends AbstractLexemeAnalyzer {

    private String tokenName;

    public IdentifierLexemeAnalyzer() {
        this.tokenName = Tokens.ID.toString();
    }

    @Override
    public RecognizedToken check(ByteBuffer buffer) {
        while (true){
            switch (state){
                case 0:{
                    nextChar(buffer);
                    if (LexerUtils.isLetter(readChar)){
                        state = 1;
                        continue;
                    }
                    return ERROR_TOKEN;
                }
                case 1: {
                    nextChar(buffer);
                    if (LexerUtils.isWord(readChar))
                        continue;

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
