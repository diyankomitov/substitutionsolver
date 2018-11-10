package dictionary;

import patternmatcher.Pattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class WordChecker {

    private final Map<String, List<String>> dictionaryPatterns;
    private final List<String> dictionaryValues;

    public WordChecker() {
        dictionaryPatterns = new HashMap<>();
        dictionaryValues = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(Paths.get("Dictionary100k.txt"));
            stream.forEach(line -> {
                String patternedLine = Pattern.convert(line.toLowerCase().trim());

                List<String> patternValues = dictionaryPatterns.get(patternedLine);

                if (patternValues == null || patternValues.isEmpty()) {

                    List<String> newValues = new ArrayList<>();
                    newValues.add(line.toLowerCase());

                    dictionaryPatterns.put(patternedLine, newValues);
                }
                else {
                    patternValues.add(line.toLowerCase());
                }

                dictionaryValues.add(line.toLowerCase());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsMatchingPattern(String pattern){
        return dictionaryPatterns.get(pattern);
    }

    public boolean check(String word) {
        return dictionaryValues.contains(word.toLowerCase().trim());
    }
}
