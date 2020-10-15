package lexer;

import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import lexer.com.compiler.Token;
import lexer.lexeme.SeparatorLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class SeparatorLexemeAnalyzerTest {

    private final String ERROR_ON_TOKEN_ATTRIBUTE = "No match on token attribute";

    @Test
    public void SeparatorLexemeAnalyzerTest_L_PAR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("(\"content\");".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.L_PAR.toString(), "(");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void SeparatorLexemeAnalyzerTest_R_PAR() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put(" );".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.R_PAR.toString(), ")");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void SeparatorLexemeAnalyzerTest_L_Curly() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("{ public;".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.L_CURLY.toString(), "{");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void SeparatorLexemeAnalyzerTest_R_Curly() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("} on".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.R_CURLY.toString(), "}");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void SeparatorLexemeAnalyzerTest_Colon() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put(",var2;".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.COLON.toString(), ",");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

    @Test
    public void SeparatorLexemeAnalyzerTest_S_Colon() {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put(";; asd;".getBytes(StandardCharsets.UTF_8));
        buffer.rewind();

        SeparatorLexemeAnalyzer sla = new SeparatorLexemeAnalyzer();
        RecognizedToken rt = sla.check(buffer);
        Token expectedToken = new Token(Tokens.S_COLON.toString(), ";");
        assertTrue(ERROR_ON_TOKEN_ATTRIBUTE, rt.token.equals(expectedToken));
    }

}
