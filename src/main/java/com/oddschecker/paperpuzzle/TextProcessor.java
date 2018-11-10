package com.oddschecker.paperpuzzle;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Facilitates the manipulation of text fragments
 */
public class TextProcessor {

    public String reassemble(String sampleText){
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

    //type of text
    //type of encoding - utf-8
    //System.out.println(new String(line.getBytes("UTF-8"))) ??;
    //


}
