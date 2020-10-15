package lexer.lexeme;

import java.nio.ByteBuffer;

import lexer.utils.LexerUtils;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

/**
 * StringLexemeAnalyzer
 */
public class StringLexemeAnalyzer extends AbstractLexemeAnalyzer {

	@Override
	public RecognizedToken check(ByteBuffer buffer) {
		
		reset();

		while(true){
			switch(state){
				case 0:{
					nextChar(buffer);
					if(LexerUtils.isBlank(readChar))
						continue;
					if(readChar.equals("\"")){
						state = 1;
						continue;
					}
					return constructToken(Tokens.ERROR);
				}
				case 1:{
					nextChar(buffer);
					if(readChar.equals("\""))
						return constructToken(Tokens.STRING);
					if(LexerUtils.isBufferEmpty(readChar.charAt(0))){
						retract();
						return constructToken(Tokens.ERROR);
					}
				}
			}
		}
	}

	
}