package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class WordFrequency {

    public WordFrequency(){
        ArrayList<String> frequencyEnglish = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(Paths.get("wordFrequency.txt"));
            stream.forEach(line -> frequencyEnglish.add(line.toLowerCase().trim()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String aFrequencyEnglish : frequencyEnglish) {
            System.out.println(aFrequencyEnglish);
        }


    }




}

