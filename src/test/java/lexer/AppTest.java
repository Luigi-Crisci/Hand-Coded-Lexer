package lexer;

import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import org.junit.Test;

import lexer.lexeme.OperatorLexemeAnalyzer;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void OperatorLexemeAnalyzerTest(){
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.asCharBuffer().put(">=aaa");
        buffer.rewind();        

        OperatorLexemeAnalyzer a = new OperatorLexemeAnalyzer();
        RecognizedToken t = a.check(buffer.asReadOnlyBuffer());
        assertTrue("I token non combaciano",t.token.getAttribute().equals(">="));
        assertTrue("Il token non è corretto", t.token.getName().equals(Tokens.OP.toString()));
    }
}
