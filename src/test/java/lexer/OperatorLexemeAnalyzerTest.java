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

    private final String ERROR_ON_TOKEN_ATTRIBUTE = "No match on token attribute";

    @Test
    public void OperatorLexemeAnalyzerTest_GEQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put(">=aaa");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), ">=");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_GEQ_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put(" >>= qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), ">=");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
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
        buffer.asCharBuffer().put(" >= qs");
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
        Token expectedToken = new Token(Tokens.OP.toString(), "<");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_LT_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<-- qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_LEQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<=;f");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<=");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_LEQ_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("< = qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<=");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_EQ() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("=;=f");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "=");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_EQ_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("-= qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "=");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AS() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<--WSW");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<--");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AS_ERROR_RET1() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("< - - qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<--");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AS_ERROR_RET2() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("<- - qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "<");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIF() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("!=@SW");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "!=");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIF_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("! = qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "!=");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_PLUS() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("+12W");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "+");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_PLUS_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("-+ qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "+");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_SUB() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("- #12");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "-");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_SUB_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("!- qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "-");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MUL() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("*AS4");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "*");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MUL_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("/*");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "*");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIV() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("/#12");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "/");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_DIV_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("&&/ sd");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "/");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MOD() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("%_13");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "%");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_MOD_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("&&%");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "%");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_POW() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("^=");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "^");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_POW_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("%^^");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "^");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_AND() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("&&/");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "&&");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test //TODO: fix
    public void OperatorLexemeAnalyzerTest_AND_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("& & qs");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "&&");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_OR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("|| ! ");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "||");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test //TODO: fix
    public void OperatorLexemeAnalyzerTest_OR_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("| | s");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "||");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_NOT() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("!\"");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "!");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void OperatorLexemeAnalyzerTest_NOT_ERROR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put("-!fqw");
        buffer.rewind();

        OperatorLexemeAnalyzer ola = new OperatorLexemeAnalyzer();
        RecognizedToken rt = ola.check(buffer);
        Token expectedToken = new Token(Tokens.OP.toString(), "!");
        assertFalse(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

}