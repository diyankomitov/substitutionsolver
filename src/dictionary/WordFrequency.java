package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class WordFrequency {

    public WordFrequency(String WORD){
        ArrayList<String> frequencyEnglish = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(Paths.get("wordFrequency.txt"));
            stream.forEach(line -> frequencyEnglish.add(line.toLowerCase().trim()));

        } catch (IOException e) {
            e.printStackTrace();
        }
            if (frequencyEnglish.contains(WORD)) {
                System.out.println(WORD + " was found at : " + frequencyEnglish.indexOf(WORD));
            }






    }




}

