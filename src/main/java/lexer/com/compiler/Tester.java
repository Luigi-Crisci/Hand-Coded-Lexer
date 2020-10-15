package lexer.com.compiler;

import lexer.utils.LexerUtils;

public class Tester {

	public static void main(String[] args) {
		
		if(args.length < 2)
			throw new IllegalAccessError("You must pass a valid filename");
		
		Lexer lexer = new Lexer();
		Token currentToken;
		lexer.initialize(args[1]);

		//Process tokens
        try {
            while( !LexerUtils.isEmpty( currentToken = lexer.nextToken() ) ){
                System.out.println(currentToken.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
		}
		//Print String Table
		lexer.getStringTable().forEach((k,v) -> {
			System.out.println(String.format("| %d --- %s |", k,v));
		});

		
	}
}
