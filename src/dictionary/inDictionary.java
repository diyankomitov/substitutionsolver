package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class inDictionary {

    ArrayList<String> DictionaryWord = new ArrayList<>();

    public inDictionary (String WORD){

        try {
            Stream<String> stream = Files.lines(Paths.get("dictionary.txt"));
            stream.forEach(line -> DictionaryWord.add(line.toLowerCase().trim()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (DictionaryWord.contains(WORD)) {
            System.out.println(WORD + " was found at : " + DictionaryWord.indexOf(WORD));
        }

    }

    public boolean isWord(String WORD) {

        if (DictionaryWord.contains(WORD)){
            return true;
        }
        else{
            return false;
        }

    }

}
