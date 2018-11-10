package com.oddschecker.paperpuzzle;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *Main program
 *
 */
public class App {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            String fragmentProblem;
            while ((fragmentProblem = in.readLine()) != null) {
                System.out.println(new TextProcessor().reassemble(fragmentProblem));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
