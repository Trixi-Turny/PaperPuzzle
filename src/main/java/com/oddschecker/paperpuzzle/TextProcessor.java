package com.oddschecker.paperpuzzle;


import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> splitToFragments(String sampleText) {
        if (sampleText != null) {
            ArrayList<String> fragments = new ArrayList<String>();
            String cleanedSample = sampleText.replaceAll(",", ",");
            cleanedSample = sampleText.replaceAll("\\.", "\\.");
            cleanedSample = sampleText.replaceAll("!", "!");


            fragments.addAll(Arrays.asList(sampleText.split(";|(?<=!)|(?<=\\?)|(?<=\\. )")));
            return fragments;
        }
        return null;

    }


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

    public ArrayList<String> reAssemble(ArrayList<String> listOfFragments) {

        int highIndex1 = 0;
        int highIndex2 = 0;
        int common = 0;
        int highestCommon = 0;
        for (int i = 0; i < listOfFragments.size(); i++) {
            highestCommon = 0;
            for (int k = 0; k < listOfFragments.size(); k++) {
                if (i == k)  {
                    continue;
                }

                common = getNoOfCommonChars(listOfFragments.get(i), listOfFragments.get(k));
                if (common > highestCommon) {
                    highestCommon = common;
                    highIndex1 = i;
                    highIndex2 = k;
                }

            }
            if(highestCommon > 0) {
                System.out.println("highestCommon " + highestCommon);
//                System.out.println(listOfFragments.get(highIndex1) + " and " + listOfFragments.get(highIndex2));
                String mergedWord = this.mergeWords(listOfFragments.get(highIndex1), listOfFragments.get(highIndex2));


                if (mergedWord != null && !mergedWord.equals("")) {
                    listOfFragments.add(mergedWord);
//                    System.out.println("merging: \n" + listOfFragments.get(highIndex1) + " and \n" + listOfFragments.get(highIndex2));
                    System.out.println("mergedWord " + mergedWord);
                    System.out.println("adding mergedWord " + mergedWord + listOfFragments.size());

                    listOfFragments.remove(highIndex2);
                    listOfFragments.remove(highIndex1);
                    System.out.println("list "+listOfFragments.toString());
                    return this.reAssemble(listOfFragments);
                }

            }
            if (i == listOfFragments.size() ) {
                return listOfFragments;

            }

        }


        return listOfFragments;
    }

    public int getNoOfCommonChars(String s1, String s2) {
        String s = "";
        String common = "";

        int lengthOfS2 = s2.length();
        int lengthOfS1 = s1.length();
        while (lengthOfS2 > 0) {
            if (s1.endsWith(s2.substring(0, lengthOfS2))) {
                common = s2.substring(0, lengthOfS2);
                s = s1 + s2.substring(common.length());
                System.out.println("common " + common.length());
                break;
            }
            lengthOfS2--;

            if (s2.endsWith(s1.substring(0, lengthOfS1))) {
                common = s1.substring(0, lengthOfS1);
                s = s2 + s1.substring(common.length());
                System.out.println("common " + common.length());
                break;
            }

            lengthOfS1--;
        }
        return common.length();
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



