package main;

import dictionary.WordChecker;
import pattern.Pattern;

import java.util.*;

public class Solver {

    private static final WordChecker wordChecker = new WordChecker();
    private static final List<String> potentialMatches = new ArrayList<>();

    public static void main(String[] args) {

        String input = "ptjc r htpprot qk zkpt vbqn qnt vkzc vbyrzc rjc xksz qtrh jrht qk otq qnt jtwq agst";

        List<String> inputWords = Arrays.asList(input.split(" "));

        solve(new ArrayList<>(), inputWords, new HashMap<>());

        potentialMatches.forEach(System.out::println);
    }

    private static void solve(List<String> current, List<String> next, Map<Character, Character> previousKey) {

        if (potentialMatches.size() < 10) {     // Cap at 10 or it keeps going until it tries all words in the dictionary

            if (next.isEmpty()) {
                // We have a match
                potentialMatches.add(String.join(" ", current));
            } else {
                // No match yet
                String first = next.get(0);
                String wordPattern = Pattern.convert(first);
                List<String> wordsMatchingPattern = wordChecker.getWordsMatchingPattern(wordPattern);

                for (String word : wordsMatchingPattern) {

                    Map<Character, Character> key = makeKey(first, word);

                    if (areKeysCompatible(previousKey, key)) {

                        List<String> newCurrent = new ArrayList<>(current);
                        newCurrent.add(word);

                        List<String> newNext = new ArrayList<>(next);
                        newNext.remove(0);

                        Map<Character, Character> newPreviousKey = combineKeys(previousKey, key);

                        solve(newCurrent, newNext, newPreviousKey);
                    }
                }
            }
        }
    }


    private static Map<Character, Character> makeKey(String keys, String values) {

        char[] keyChars = keys.toCharArray();
        char[] valueChars = values.toCharArray();

        Map<Character, Character> keyMap = new HashMap<>();

        for (int i = 0; i < keyChars.length; i++) {
            keyMap.put(keyChars[i], valueChars[i]);
        }

        return keyMap;
    }

    private static boolean areKeysCompatible(Map<Character, Character> key1, Map<Character, Character> key2) {

        Set<Character> keyset = new HashSet<>();
        keyset.addAll(key1.keySet());
        keyset.addAll(key2.keySet());

        Set<Character> valuesSet = new HashSet<>();

        for (Character character : keyset) {
            Character char1 = key1.get(character);
            Character char2 = key2.get(character);

            if (char1 != null && char2 != null && !char1.equals(char2)) {
                return false;
            }

            if (valuesSet.contains(char1) || valuesSet.contains(char2)) {
                return false;
            }

            if (char1 != null) {
                valuesSet.add(char1);
            }

            if (char2 != null) {
                valuesSet.add(char2);
            }
        }

        return true;
    }

    private static Map<Character, Character> combineKeys(Map<Character, Character> key1, Map<Character, Character> key2) {

        Map<Character, Character> combinedKey = new HashMap<>();

        combinedKey.putAll(key1);
        combinedKey.putAll(key2);

        return combinedKey;
    }
}
