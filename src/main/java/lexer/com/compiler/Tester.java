package lexer.com.compiler;

import lexer.utils.LexerUtils;

public class Tester {

	public static void main(String[] args) {
		
		if(args.length < 1)
			throw new IllegalAccessError("You must pass a valid filename");

		System.out.printf("Processing file at path %s",args[0]);

		Lexer lexer = new Lexer();
		Token currentToken;
		lexer.initialize(args[0]);

		//Process tokens
        try {
        	System.out.println("\nTokens:");
            while( !LexerUtils.isEmpty( currentToken = lexer.nextToken() ) ){
                System.out.println(currentToken.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
		}
		//Print String Table
		System.out.println("\nString Table:");
		lexer.getStringTable().forEach((k,v) -> {
			System.out.printf("| %d --- %s |%n", k,v);
		});

		
	}
}
