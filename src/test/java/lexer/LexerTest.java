package lexer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import lexer.com.compiler.*;
import lexer.utils.LexerUtils;
import lexer.utils.Tokens;

public class LexerTest {

    @Test
    public void LexerUtils_isBufferEmpty_false(){
        char c = '1';
        assertFalse("1 is not a blank char", LexerUtils.isBufferEmpty(c));
    }

    @Test
    public void LexerUtils_isBufferEmpty_true(){
        char c = (byte)0;
        assertTrue("0 should be recognized as empty", LexerUtils.isBufferEmpty(c));
    }

}
