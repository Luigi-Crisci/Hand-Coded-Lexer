package lexer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import lexer.com.compiler.Token;
import lexer.lexeme.NumberLexemeAnalyzer;
import lexer.lexeme.StringLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class StringLexemeAnalyzerTest {
    
    private final String ERROR_ON_TOKEN_ATTRIBUTE = "No match on token attribute";

    @Test
    public void StringLexemeAnalyzerTest_true(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("\"++2002\"".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();
        
        StringLexemeAnalyzer nla = new StringLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.STRING.toString(), "\"++2002\"");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void StringLexemeAnalyzerTest_false(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("\"++2002".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();
        
        StringLexemeAnalyzer nla = new StringLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.ERROR.toString(), "\"++2002");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }
    
}
