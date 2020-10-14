package lexer;

import static org.junit.Assert.assertFalse;
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
    public void NumberLexemeAnalyzerTest_INT(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("         2002");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.INT.toString(), "2002");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void NumberLexemeAnalyzerTest_ERROR_ON_ZERO(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("01997");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.INT.toString(), "01997");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void NumberLexemeAnalyzerTest_INT_ERROR(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("         2002.0");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.INT.toString(), "2002");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void NumberLexemeAnalyzerTest_FLOAT(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("3.14;");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.FLOAT.toString(), "3.14");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void NumberLexemeAnalyzerTest_DOUBLE_DOT(){

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("3..14;");
        buffer.rewind();
        
        NumberLexemeAnalyzer nla = new NumberLexemeAnalyzer();
        RecognizedToken rt = nla.check(buffer);
        Token expectedToken = new Token(Tokens.INT.toString(), "3");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }
    
}
