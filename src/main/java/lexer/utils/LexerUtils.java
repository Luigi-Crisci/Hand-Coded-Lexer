package lexer.utils;

import java.util.regex.Pattern;

public class LexerUtils {

    public static boolean isBlank(CharSequence c){
        return Pattern.matches("\\s",c);
    }

    public static boolean isDigit(CharSequence c){
        return Pattern.matches(LexemePatterns.DIGIT,c);
    }

    public static boolean isNonzeroDigit(CharSequence c){
        return Pattern.matches(LexemePatterns.DIGIT_NONZERO,c);
    }
    public static boolean isLetter(CharSequence c){
            return Pattern.matches(LexemePatterns.LETTER,c);
    }
    public static boolean isWord(CharSequence c) { return Pattern.matches(LexemePatterns.WORD,c); }


    public static CharSequence charToCharSequence(char c){
        return "" + c;
    }
}
