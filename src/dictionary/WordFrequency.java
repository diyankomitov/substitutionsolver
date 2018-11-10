package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class WordFrequency {

    ArrayList<String> frequencyEnglish = new ArrayList<>();

    public WordFrequency(String WORD){


        try {
            Stream<String> stream = Files.lines(Paths.get("wordFrequency.txt"));
            stream.forEach(line -> frequencyEnglish.add(line.toLowerCase().trim()));

        } catch (IOException e) {
            e.printStackTrace();
        }
//            if (frequencyEnglish.contains(WORD)) {
//                System.out.println(WORD + " was found at : " + frequencyEnglish.indexOf(WORD));
//            }
    }

    public int getLine (String WORD) {
        return frequencyEnglish.indexOf(WORD);
    }
    public String getWORD(int line){
        return frequencyEnglish.get(line);
    }

    public boolean isWord(String WORD) {

        if (frequencyEnglish.contains(WORD)){
            return true;
        }
        else{
            return false;
        }

    }




}

