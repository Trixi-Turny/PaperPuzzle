package com.oddschecker.paperpuzzle;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Facilitates the manipulation of text fragments
 */
public class TextProcessor {

    public String reassemble(String sampleText) {
        //split to words
        //recurively iterate until possible
        return "";
    }


    public ArrayList<String> splitToWords(String sampleText) {
        String cleanedSample = sampleText.replaceAll(";", " ");
        ArrayList<String> words = new ArrayList<String>();

        String[] fragments = cleanedSample.split(" ");
        words.addAll(Arrays.asList(fragments));
        return words;

    }


    public ArrayList<String> eliminateCompleteSubstrings(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int k = 0; k < words.size(); k++) {
                if (words.get(i).equals(words.get(k))) {
                    continue;
                }
                    if (words.get(k).contains(words.get(i))) {
                        words.removeAll(Collections.singleton(words.get(i)));
                    }
                   else if (words.get(i).contains(words.get(k))) {
                        words.removeAll(Collections.singleton(words.get(k)));
                    }
                else{
                    if (i == words.size() ) {
                        return words;
                    }
                }
            }
        }
        System.out.println(words.toString());
        return words;

    }


    //type of text
    //type of encoding - utf-8
    //System.out.println(new String(line.getBytes("UTF-8"))) ??;
    //


}
