package com.oddschecker.paperpuzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;

/**
 *Main program
 *
 */
public class App {
    public static void main(String[] args) {

//        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
//            String fragmentProblem;
//            while ((fragmentProblem = in.readLine()) != null) {
//                System.out.println(new TextProcessor().reassemble(fragmentProblem));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String sampletext = "O draconia;conian devil! Oh la;h h h lame sa;saint! sai sai sa";
        ArrayList<String> splitSample= new TextProcessor().splitToWords(sampletext);
        ArrayList<String> eliminatedWords = new TextProcessor().eliminateCompleteSubstrings(splitSample);

        System.out.println(eliminatedWords.toString());
//
    }


}
