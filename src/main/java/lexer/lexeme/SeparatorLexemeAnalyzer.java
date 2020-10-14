package lexer.lexeme;

import java.nio.ByteBuffer;

import lexer.utils.LexerUtils;
import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;

public class SeparatorLexemeAnalyzer extends AbstractLexemeAnalyzer {

	@Override
	public RecognizedToken check(ByteBuffer buffer) {
		while (true) {
			switch (state) {
				case 0:{
					nextChar(buffer);
					if (LexerUtils.isBlank(readChar))
					continue;
					if(readChar.equals("("))
						return constructToken(Tokens.L_PAR);
					if(readChar.equals(")"))
						return constructToken(Tokens.R_PAR);
					if(readChar.equals("{"))
						return constructToken(Tokens.L_CURLY);
					if(readChar.equals("}"))
						return constructToken(Tokens.R_CURLY);
					if(readChar.equals(","))
						return constructToken(Tokens.COLON);
					if(readChar.equals(";"))
						return constructToken(Tokens.S_COLON);
				}
			}
		}
	}

	
}
