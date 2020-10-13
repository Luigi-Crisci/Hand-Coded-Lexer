package lexer;

import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import org.junit.Test;

import lexer.com.compiler.Token;
import lexer.lexeme.IdentifierLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class IdentifierLexemeAnalyzerTest {

    private final String ERROR_ON_TOKEN_ATTRIBUTE = "";

    @Test
    public void LexemeAnalyzerTest() {

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("var_1av2c <-- 10");
        buffer.rewind();

        IdentifierLexemeAnalyzer ila = new IdentifierLexemeAnalyzer();
        RecognizedToken rt = ila.check(buffer);
        Token expectedToken = new Token(Tokens.ID.toString(), "var_1av2c");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void LexemeAnalyzerTest_SimpleVar(){
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("var<-- 10");
        buffer.rewind();

        IdentifierLexemeAnalyzer ila = new IdentifierLexemeAnalyzer();
        RecognizedToken rt = ila.check(buffer);
        Token expectedToken = new Token(Tokens.ID.toString(), "var");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }


}
