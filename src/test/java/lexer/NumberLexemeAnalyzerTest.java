package lexer;

import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import org.junit.Test;

import lexer.com.compiler.Token;
import lexer.lexeme.NumberLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class NumberLexemeAnalyzerTest {
    
    private final String ERROR_ON_TOKEN_ATTRIBUTE = "No match on token attribute";

    @Test
    public void NumerLexemeAnalyzerTest_INT(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("         2002");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.INT.toString(), "2002");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }
    
}
