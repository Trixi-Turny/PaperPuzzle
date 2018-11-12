package com.oddschecker.paperpuzzle;

import java.util.ArrayList;

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

        String sampletext = "O draconia;conian devil! Oh la;h lame sa;saint!";
        String sampletext2 = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al";
        ArrayList<String> splitSample= new TextProcessor().splitToFragments(sampletext2);

        ArrayList<String> eliminatedWords = new TextProcessor().reAssemble(splitSample);

    }


}
