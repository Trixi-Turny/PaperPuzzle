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
                } else if (words.get(i).contains(words.get(k))) {
                    words.removeAll(Collections.singleton(words.get(k)));
                } else {
                    if (i == words.size()) {
                        return words;
                    }
                }
            }
        }
        System.out.println(words.toString());
        return words;

    }

    public String mergeWords(String s1, String s2) {
        String s = s1;
        int lengthOfS2 = s2.length();
        int lengthOfS1 = s1.length();
            while (lengthOfS2 > 0) {
                String common = s2.substring(0, lengthOfS2);
                if (s1.endsWith(common)) {
                    s = s1 + s2.substring(common.length());
                    break;
                }
                lengthOfS2--;
            }
            while (lengthOfS1 > 0) {
                String common = s1.substring(0, lengthOfS1);
                if (s2.endsWith(common)) {
                    s = s2 + s1.substring(common.length());
                    break;
                }
                lengthOfS1--;
            }
        return s;
    }


}

//type of text
//type of encoding - utf-8
//System.out.println(new String(line.getBytes("UTF-8"))) ??;
//



