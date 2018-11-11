package dictionary;

import pattern.Pattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class WordChecker {

    private final Map<String, List<String>> dictionaryPatterns;

    public WordChecker() {
        dictionaryPatterns = new HashMap<>();

        try {
            Stream<String> stream = Files.lines(Paths.get("dictionary.txt"));
            stream.forEach(line -> {
                String patternedLine = Pattern.convert(line.toLowerCase().trim());

                List<String> patternValues = dictionaryPatterns.get(patternedLine);

                if (patternValues == null || patternValues.isEmpty()) {
                    List<String> newValues = new ArrayList<>();
                    newValues.add(line.toLowerCase());

                    dictionaryPatterns.put(patternedLine, newValues);
                } else {
                    patternValues.add(line.toLowerCase());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsMatchingPattern(String pattern) {
        return dictionaryPatterns.get(pattern);
    }
}
