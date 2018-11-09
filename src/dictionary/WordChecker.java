package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class WordChecker {

    private final HashSet<String> dictionary;

    public WordChecker() {
        dictionary = new HashSet<>();

        try {
            Stream<String> stream = Files.lines(Paths.get("dictionary.txt"));
            stream.forEach(line -> dictionary.add(line.toLowerCase().trim()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet <String> getWordsContainingPattern(String pattern,int wordLength){
        HashSet<String> dictionaryWords = new HashSet<>();
        for (String word : dictionary) {
            if(word.contains(pattern) && word.length() == wordLength){
                dictionaryWords.add(word);
            }
        }

        return dictionaryWords;
    }

    public boolean check(String word) {
        return dictionary.contains(word.toLowerCase().trim());
    }
}
