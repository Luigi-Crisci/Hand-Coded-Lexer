package lexer.utils;

import lexer.com.compiler.Token;

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

    public int compareTo(RecognizedToken token1){
        if(character_read > token1.character_read)
            return 1;
        if(character_read < token1.character_read)
            return -1;
        return 0;
    }
}
