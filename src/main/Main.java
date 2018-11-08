package main;

import dictionary.WordChecker;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String input = "hello";

        System.out.println(new WordChecker().check(input));

        Map<Character, Double> letterFrequency = initializeLetterFrequency();
        findLetterFrequency(letterFrequency, input);

        System.out.println(letterFrequency);
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
