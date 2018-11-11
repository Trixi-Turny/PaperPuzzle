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

    public ArrayList<String> splitToFragments(String sampleText){
        if(sampleText!= null){
            ArrayList<String> fragments  = new ArrayList<String>();
            fragments.addAll(Arrays.asList(sampleText.split(";|(?<=!)|(?<=\\?)|(?<=\\.)")));
            return fragments;
        }
        return null;

    }


    public String buildSentence(ArrayList<String> fragments){
        if(fragments!=null) {
            StringBuilder builder = new StringBuilder();
            for (String sentence : fragments) {
                builder.append(sentence);
            }
            return builder.toString();
        }
        return null;

    }

    public ArrayList<String> reAssemble(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int k = 0; k < words.size(); k++) {
                if(i==words.size()){
                    return words;
                }
                String word1 = words.get(i);
                String word2 = words.get(k);



                if (word1.equals(word2)) {
                    continue;
                }

                String mergedWord = this.mergeWords(word1, word2);
                if (mergedWord != null && !mergedWord.equals("")) {
                    words.add(mergedWord);
                    words.remove(word1);
                    words.remove(word2);
                }

//                } else {
//                    if (word1.contains(word2)) {
//                        words.remove(word1);
//                    } else if (word1.contains(word2)) {
//                        words.remove(word2);
//                    }
//                }
            }
        }
        return words;
    }

    public String mergeWords(String s1, String s2) {
        String s = "";
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



