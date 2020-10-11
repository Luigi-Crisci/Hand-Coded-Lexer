package utils;

import com.compiler.Token;

public class RecognizedToken {

    public Token token;
    public int character_read;

    public RecognizedToken(){
        token = null;
        character_read = 0;
    }

    public RecognizedToken(Token t, int character_read) {
        this.character_read = character_read;
        this.token = t;
    }
}
