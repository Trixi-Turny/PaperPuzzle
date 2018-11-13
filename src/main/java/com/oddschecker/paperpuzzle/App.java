package com.oddschecker.paperpuzzle;

import java.io.*;
import java.util.ArrayList;

/**
 * Main program
 */
public class App {


    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        
        int expectedNoOfArgs = 1;
        Validator validator = Validator.getInstance();
        try {
            if (validator.isValidArgs(args, expectedNoOfArgs)) {
                String filePath = args[0];
                app.readFile(filePath);
            }
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Processing file with provided filepath
     * @param filePath
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readFile(String filePath) throws FileNotFoundException, IOException {

        TextProcessor textProcessor = new TextProcessor();
        BufferedReader in = null;
        try {
            File file = new File(filePath);

            in = new BufferedReader(new FileReader(file));
            String fragmentProblem;
            while ((fragmentProblem = in.readLine()) != null) {
                ArrayList<String> fragments = textProcessor.splitToFragments(fragmentProblem);
                ArrayList<String> orderedFragments = textProcessor.reAssemble(fragments);
                System.out.println(textProcessor.buildSentence(orderedFragments));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Invalid path. File not found with path provided.");
        } catch (IOException e) {
            throw new IllegalArgumentException("There was a problem reading the file.");

        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown error occurred");
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }

}
