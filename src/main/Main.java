package main;

import dictionary.WordChecker;
import dictionary.WordFrequency;
import dictionary.inDictionary;
import patternmatcher.Pattern;

import java.util.*;

public class Main {

    private static final WordChecker wordChecker = new WordChecker();

    public static void main(String[] args) {

        String input = "ptjc r htpprot qk zkpt vbqn qnt vkzc vbyrzc rjc xksz qtrh jrht qk otq qnt jtwq agst";

        String[] inputWords = input.split(" ");
        String[] inputPatterns = new String[inputWords.length];

        for (int i = 0; i < inputWords.length; i++) {
            inputPatterns[i] = Pattern.convert(inputWords[i]);
        }


            patternMatch("htpprot");
     

//        System.out.println(areKeysCompatible(makeKey("ptjc", "send"), makeKey("t", "s"))); //tests if arekeyscompatible works


        System.out.println(new WordChecker().check(input));

        Map<Character, Double> letterFrequency = initializeLetterFrequency();
        Map<Character,Character> cypherAlphabet = initializeCypherAlphabet();
        findLetterFrequency(letterFrequency, input);

        System.out.println(letterFrequency);


        decipherTest(input);

        new WordFrequency("hello");

    }

    //TODO: Need to be able to lock exact letters for pattern match when we have values we are certain of/want to test.
    private static boolean patternMatch(String word) {

        String wordPattern = Pattern.convert(word);
        List<String> wordsMatchingPattern = wordChecker.getWordsMatchingPattern(wordPattern); // gets all words of same size and with same letter pattern as word.
        System.out.println("Found " + wordsMatchingPattern.size() + " words matching the pattern: " +wordPattern);
        for(String matchingWord : wordsMatchingPattern){
            if(new inDictionary().isWord(matchingWord)){
                System.out.println("possible match: " +matchingWord);
            }
            //System.out.println("possible match: " +matchingWord);
        }
        //TODO: Something something do something idk what haha
        return true;
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
            System.out.println(char1 + " : " + char2);

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



    private static void decipherTest(String input) {
        Map<Character,Character> keyMap = new HashMap<>();
        keyMap.put('a', 'c');
        keyMap.put('b', 'i');
        keyMap.put('c', 'd');
        keyMap.put('d', null);
        keyMap.put('e', null);
        keyMap.put('f', null);
        keyMap.put('g', 'l');
        keyMap.put('h', 'm');
        keyMap.put('i', null);
        keyMap.put('j', 'n');
        keyMap.put('k', 'o');
        keyMap.put('l', null);
        keyMap.put('m', null);
        keyMap.put('n', 'h');
        keyMap.put('o', 'g');
        keyMap.put('p', 's');
        keyMap.put('q', 't');
        keyMap.put('r', 'a');
        keyMap.put('s', 'u');
        keyMap.put('t', 'e');
        keyMap.put('u', null);
        keyMap.put('v', 'w');
        keyMap.put('w', 'x');
        keyMap.put('x', 'y');
        keyMap.put('y', 'z');
        keyMap.put('z', 'r');
        keyMap.put(' ', ' ');

        System.out.println(Decryptor.decrypt(input, keyMap));
    }

    private static Map<Character, Character> initializeCypherAlphabet() {
        Map<Character, Character> cypherAlphabet = new HashMap<>();
        cypherAlphabet.put('a', 'a');
        cypherAlphabet.put('b', 'b');
        cypherAlphabet.put('c', 'c');
        cypherAlphabet.put('d', 'd');
        cypherAlphabet.put('e', 'e');
        cypherAlphabet.put('f', 'f');
        cypherAlphabet.put('g', 'g');
        cypherAlphabet.put('h', 'h');
        cypherAlphabet.put('i', 'i');
        cypherAlphabet.put('j', 'j');
        cypherAlphabet.put('k', 'k');
        cypherAlphabet.put('l', 'l');
        cypherAlphabet.put('m', 'm');
        cypherAlphabet.put('n', 'n');
        cypherAlphabet.put('o', 'o');
        cypherAlphabet.put('p', 'p');
        cypherAlphabet.put('q', 'q');
        cypherAlphabet.put('r', 'r');
        cypherAlphabet.put('s', 's');
        cypherAlphabet.put('t', 't');
        cypherAlphabet.put('u', 'u');
        cypherAlphabet.put('v', 'v');
        cypherAlphabet.put('w', 'w');
        cypherAlphabet.put('x', 'x');
        cypherAlphabet.put('y', 'y');
        cypherAlphabet.put('z', 'z');
        return cypherAlphabet;
    }

    private static void findLetterFrequency(Map<Character, Double> frequencyMap, String string) {
        double length = string.length();

        for (Character character : frequencyMap.keySet()) {
            double count = string.length() - string.replace(character.toString(), "").length();

            if (count != length) {
                frequencyMap.put(character, count/length);
            }
        }
    }

    private static Map<Character, Double> initializeEnglishFrequency() {
        Map<Character, Double> englishFrequencyMap = new HashMap<>();
        englishFrequencyMap.put('a', 0.08167);
        englishFrequencyMap.put('b', 0.01492);
        englishFrequencyMap.put('c', 0.02782);
        englishFrequencyMap.put('d', 0.04253);
        englishFrequencyMap.put('e', 0.12702);
        englishFrequencyMap.put('f', 0.02228);
        englishFrequencyMap.put('g', 0.02015);
        englishFrequencyMap.put('h', 0.06094);
        englishFrequencyMap.put('i', 0.06966);
        englishFrequencyMap.put('j', 0.00153);
        englishFrequencyMap.put('k', 0.00772);
        englishFrequencyMap.put('l', 0.04025);
        englishFrequencyMap.put('m', 0.02406);
        englishFrequencyMap.put('n', 0.06749);
        englishFrequencyMap.put('o', 0.07507);
        englishFrequencyMap.put('p', 0.01929);
        englishFrequencyMap.put('q', 0.00095);
        englishFrequencyMap.put('r', 0.05987);
        englishFrequencyMap.put('s', 0.06327);
        englishFrequencyMap.put('t', 0.09056);
        englishFrequencyMap.put('u', 0.02758);
        englishFrequencyMap.put('v', 0.00978);
        englishFrequencyMap.put('w', 0.02360);
        englishFrequencyMap.put('x', 0.00150);
        englishFrequencyMap.put('y', 0.00074);
        return englishFrequencyMap;
    }

    private static Map<Character, Double> initializeLetterFrequency() {
        Map<Character, Double> wordFrequencyMap = new HashMap<>();
        wordFrequencyMap.put('a', 0.0);
        wordFrequencyMap.put('b', 0.0);
        wordFrequencyMap.put('c', 0.0);
        wordFrequencyMap.put('d', 0.0);
        wordFrequencyMap.put('e', 0.0);
        wordFrequencyMap.put('f', 0.0);
        wordFrequencyMap.put('g', 0.0);
        wordFrequencyMap.put('h', 0.0);
        wordFrequencyMap.put('i', 0.0);
        wordFrequencyMap.put('j', 0.0);
        wordFrequencyMap.put('k', 0.0);
        wordFrequencyMap.put('l', 0.0);
        wordFrequencyMap.put('m', 0.0);
        wordFrequencyMap.put('n', 0.0);
        wordFrequencyMap.put('o', 0.0);
        wordFrequencyMap.put('p', 0.0);
        wordFrequencyMap.put('q', 0.0);
        wordFrequencyMap.put('r', 0.0);
        wordFrequencyMap.put('s', 0.0);
        wordFrequencyMap.put('t', 0.0);
        wordFrequencyMap.put('u', 0.0);
        wordFrequencyMap.put('v', 0.0);
        wordFrequencyMap.put('w', 0.0);
        wordFrequencyMap.put('x', 0.0);
        wordFrequencyMap.put('y', 0.0);
        return wordFrequencyMap;
    }
}
