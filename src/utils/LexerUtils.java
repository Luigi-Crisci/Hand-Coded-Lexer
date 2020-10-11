package utils;

import java.util.regex.Pattern;

public class LexerUtils {

    public static boolean isBlank(CharSequence c){
        return Pattern.matches("\\s",c);
    }

    public static boolean isDigit(CharSequence c){
        return Pattern.matches(LexemePatterns.DIGIT,c);
    }

    public static CharSequence charToCharSequence(char c){
        return "" + c;
    }
}
