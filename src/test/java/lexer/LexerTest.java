package lexer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import lexer.com.compiler.*;
import lexer.utils.Tokens;

public class LexerTest {

    private Path file = Paths.get("testfile");

    @Before
    public void initialize() {
        try {
            file = Files.createFile(file);
            Files.write(file,"<".getBytes());

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
    public void LexerTest_OP() {
        Lexer l = new Lexer();
        l.initialize(file.toString());

        Token t = new Token(Tokens.OP.name(), "<");
        try {
            Token whosthis= l.nextToken();
            assertTrue("Tokens are equals", t.equals(whosthis));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void clean(){
        try {
            Files.delete(Paths.get("testfile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
