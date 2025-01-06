package wordslist;

import java.io.*;
import java.util.*;

public class WordsReader {

    //function to read a txt file
    public List<String> readFile(String fileTxt){

        //create the array
        List<String> wordsList = new ArrayList<>();

        //read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileTxt))) {
            String line;

            //add each line of the txt file to the array
            while ((line = br.readLine()) != null) {
                wordsList.add(line);
            }
        //catch the exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return the array
        return wordsList;
    }
}
