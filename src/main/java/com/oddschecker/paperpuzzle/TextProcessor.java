package com.oddschecker.paperpuzzle;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Facilitates the manipulation of text fragments
 */
public class TextProcessor {

    /**
     * Splits the sampletext provided into fragments discarding semicolons but keeping punctuation.
     * @param sampleText - @ String - the text we need to separate
     * @return ArrayList of Strings where Strings are the fragments
     */
    public ArrayList<String> splitToFragments(String sampleText) {
        if (sampleText != null) {
            ArrayList<String> fragments = new ArrayList<String>();
            fragments.addAll(Arrays.asList(sampleText.split(";|(?<=!)|(?<=\\?)|(?<=\\. )")));
            return fragments;
        }
        return null;

    }


    /**
     * Build a sentence from the fragments in the provided list
     * @param fragments  - the list containing the fragments
     * @return String the resulted sentence build with a StringBuilder
     */
    public String buildSentence(ArrayList<String> fragments) {
        if (fragments != null) {
            StringBuilder builder = new StringBuilder();
            for (String sentence : fragments) {
                builder.append(sentence);
            }
            return builder.toString();
        }
        return null;

    }


    /**
     * Method recursively check next fragment pairs with the most overlapping characters then merging them and replacing/removing the original pair.
     * @param listOfFragments - ArrayList<String>  - the list containing sentence fragments to be assembled
     * @return listOfFragments - a list with merged sentences;
     */
    public ArrayList<String> reAssemble(ArrayList<String> listOfFragments) {
        Pair<Integer, Integer> pairWithMostCommonChars = null;
        pairWithMostCommonChars = this.getHighestCommonCharPair(listOfFragments);

        if(pairWithMostCommonChars==null){
            return listOfFragments;
        }
        System.out.println("LIST before ");
        int counter = 0;

        for (String s : listOfFragments) {

            System.out.println(counter + " " + s + "\n");
            counter++;
        }
        System.out.println("PAIR " + listOfFragments.get(pairWithMostCommonChars.getFirst()) + "(" + pairWithMostCommonChars.getFirst() + ") | " + listOfFragments.get(pairWithMostCommonChars.getSecond()) + "(" + pairWithMostCommonChars.getSecond() + ")");
        String mergedWord = this.mergeWords(listOfFragments.get(pairWithMostCommonChars.getFirst()), listOfFragments.get(pairWithMostCommonChars.getSecond()));


        if (mergedWord != null && !mergedWord.equals("")) {
            System.out.println("mergedWord " + mergedWord);
            listOfFragments.set(pairWithMostCommonChars.getFirst(), mergedWord);
            listOfFragments.remove(listOfFragments.get(pairWithMostCommonChars.getSecond()));
            System.out.println("updatedList after ");
            counter = 0;
            for (String s : listOfFragments) {

                System.out.println(counter + " " + s + "\n");
                counter++;
            }
            reAssemble(listOfFragments);


        }

        return listOfFragments;

    }


    /**
     * Provides the indexes of fragments from a list that have the highest number of overlapping characters
     * @param listOfFragments - contains the fragments to assemble the sentence from
     * @return {@link Pair<Integer, Integer>} - a Pair object containing the indexes of fragments that overlap the most
     */
    public Pair<Integer, Integer> getHighestCommonCharPair(ArrayList<String> listOfFragments) {
        int highestCommon = 0;
        int common = 0;
        int highestCommonIndexFirst;
        int highestCommonIndexSecond;
        Pair<Integer, Integer> pairWithMostCommonChars = null;
        for (int i = 0; i < listOfFragments.size(); i++) {


            for (int k = 0; k < listOfFragments.size(); k++) {

                if (i == k) {

                    continue;
                }
                System.out.println("Checking " + listOfFragments.get(i) + " against " + listOfFragments.get(k));
                common = this.getNoOfCommonChars(listOfFragments.get(i), listOfFragments.get(k));
                if (common >highestCommon) {
                    highestCommon = common;
                    highestCommonIndexFirst = i;
                    highestCommonIndexSecond = k;
                    pairWithMostCommonChars = new Pair(highestCommonIndexFirst, highestCommonIndexSecond);

                }
                System.out.println("highestCommon was " + highestCommon + "  vs common " + common);
            }
        }
        System.out.println("highestCommon was " + highestCommon + "  vs common " + common);
        return pairWithMostCommonChars;

    }

    /**
     * Provides the number of overlapping characters in two strings
     * @param s1 - String one
     * @param s2 - String two
     * @return - the length of the overlap
     */
    public int getNoOfCommonChars(String s1, String s2) {
        String s = "";
        String common = "";


        int lengthOfS2 = s2.length();
        int lengthOfS1 = s1.length();

        while (lengthOfS2 > 0) {
            if (s1.endsWith(s2.substring(0, lengthOfS2))) {
                String common1 = s2.substring(0, lengthOfS2);
                s = s1 + s2.substring(common1.length());
                return common1.length();
            }
            lengthOfS2--;
        }
        while (lengthOfS1 > 0) {
            if (s2.endsWith(s1.substring(0, lengthOfS1))) {
                String common2 = s1.substring(0, lengthOfS1);
                s = s2 + s1.substring(common2.length());
                return common2.length();
            }

            lengthOfS1--;
        }
                if(s1.contains(s2)){
            return s2.length();
        }
        if(s2.contains(s1)){
            return s1.length();
        }
        return common.length();

    }


    /**
     * Merges 2 words on their common characters
     * @param s1 - String 1
     * @param s2 - String 2
     * @return - String the merged word
     */
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
                if (s1.contains(s2)) {
            return s1;
        }
        if (s2.contains(s1)) {
            return s2;
        }
        return s;
    }


}

//type of text
//type of encoding - utf-8
//System.out.println(new String(line.getBytes("UTF-8"))) ??;
//



