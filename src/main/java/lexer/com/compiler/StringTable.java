package lexer.com.compiler;

import java.util.HashMap;
import java.util.List;

import lexer.utils.LexerUtils;

/**
 * StringTable
 */
public class StringTable extends HashMap<Integer,String> {

	private static final long serialVersionUID = -4322311144038354562L;

	public StringTable() {
		super();
		List<Token> l = LexerUtils.keywordsTokens;
		for (int i = 0; i < l.size(); i++) 
			put(i, l.get(i).getName());
		
	}
}