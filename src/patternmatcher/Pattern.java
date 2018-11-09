package patternmatcher;

import java.util.HashMap;
import java.util.Map;

public class Pattern {

    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String convert(String input) {

        char[] chars = input.toCharArray();

        char[] converted = new char[chars.length];

        int alphabetIndex = 0;

        Map<Character, Character> patternMap = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {

            char next = chars[i];
            Character nextPatternChar = patternMap.get(next);

            if (nextPatternChar != null) {
                converted[i] = nextPatternChar;
            }
            else {
                nextPatternChar = alphabet[alphabetIndex];
                patternMap.put(next, nextPatternChar);
                converted[i] = nextPatternChar;
                alphabetIndex++;
            }

        }

        return new String(converted);
    }


}
