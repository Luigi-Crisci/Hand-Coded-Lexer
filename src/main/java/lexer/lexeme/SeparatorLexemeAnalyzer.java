package lexer.lexeme;

import java.nio.ByteBuffer;

import lexer.utils.RecognizedToken;
import lexer.utils.Tokens;
import lexer.com.compiler.*;

public class SeparatorLexemeAnalyzer extends AbstractLexemeAnalyzer {

	private String tokenName;


	public SeparatorLexemeAnalyzer(){
		super();
		tokenName = "";
	}

	@Override
	public RecognizedToken check(ByteBuffer buffer) {
		while (true) {
			switch (state) {
				case 0:{
					nextChar(buffer);
					if(readChar.equals("("))
						tokenName = Tokens.L_PAR.toString();
					if(readChar.equals(")"))
						tokenName = Tokens.R_PAR.toString();
					if(readChar.equals("{"))
						tokenName = Tokens.L_CURLY.toString();
					if(readChar.equals("}"))
						tokenName = Tokens.R_CURLY.toString();
					if(readChar.equals(","))
						tokenName = Tokens.COLON.toString();
					if(readChar.equals(";"))
						tokenName = Tokens.S_COLON.toString();
					return constructToken();
				}
			}
		}
	}

	@Override
	protected RecognizedToken constructToken() {
		Token t = new Token(tokenName,stringBuffer.toString());
        return new RecognizedToken(t,numCharRead);
	}

	
}
