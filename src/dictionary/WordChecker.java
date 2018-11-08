package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
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

    public boolean check(String word) {
        return dictionary.contains(word.toLowerCase().trim());
    }
}
