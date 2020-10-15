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

    private Path file = Paths.get("testfile");

    @Before
    public void initialize() {
        try {
            file = Files.createFile(file);
            Files.write(file,"if (i = 0)\n\ni = 0".getBytes());
        } catch (IOException e) {  
            e.printStackTrace();
        }
    }

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


    @Test
    public void Tester() {
        String[] s = {"aaaaa","testfile"};
        Tester.main( s);
    }

    @After
    public void clean(){
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
