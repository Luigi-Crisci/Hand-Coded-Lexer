package lexer;

import static org.junit.Assert.assertTrue;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.junit.Test;

import lexer.com.compiler.Lexer;
import lexer.com.compiler.Token;
import lexer.lexeme.IdentifierLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class LexerTest {

    private final String ERROR_ON_TOKEN_ATTRIBUTE = "";

    @Test
    public void LoaderTest() {
        ByteBuffer b = ByteBuffer.allocate(16);
        b.put("abcdef".getBytes());

        b.position(2);
        b = b.compact();
        b.position(0);

        byte[] bytes = new byte[16];
        b.get(bytes);
        System.out.println(new String(bytes));

    }



}
