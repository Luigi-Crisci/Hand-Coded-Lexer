package lexer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import org.junit.Test;

import lexer.com.compiler.Token;
import lexer.lexeme.OperatorLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

/**
 * Unit test for simple App.
 */
public class OperatorLexemeAnalyzerTest {
    /**
     * Rigorous Test :-)
     */

    private final String ERROR_ON_TOKEN_ATTRIBUTE = "No match on token attribute";
    private final String ERROR_ON_TOKEN_NAME = "Token is wrong";

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void OperatorLexemeAnalyzerTest_GEQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put(">=aaa");
        buffer.rewind();

        OperatorLexemeAnalyzer a = new OperatorLexemeAnalyzer();
        RecognizedToken t = a.check(buffer.asReadOnlyBuffer());
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, t.token.getAttribute().equals(">="));
        assertTrue(ERROR_ON_TOKEN_NAME, t.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_GT() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("> qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), ">"); 
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_GT_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put(">= qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), ">"); 
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_LT() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<qwf");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("<"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_LEQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<=;f");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("<="));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_EQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("=;=f");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("="));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AS() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<--WSW");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("<--"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIF() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("!=@SW");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("!="));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }


    @Test
    public void OperatorLexemeAnalyzerTest_PLUS() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("+12W");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("+"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_SUB() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("- #12");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("-"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MUL() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("*AS4");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("*"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIV() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("/#12");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("/"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MOD() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("%_13");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("%"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_POW() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("^=");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("^"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AND() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("&&/");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("&&"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_OR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("|| ! ");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("||"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_NOT() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("!\"");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.getAttribute().equals("!"));
        assertTrue(ERROR_ON_TOKEN_NAME, rt.token.getName().equals(Tokens.OP.toString()));
    }
}
