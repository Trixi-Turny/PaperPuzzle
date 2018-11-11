package com.oddschecker.paperpuzzle;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TextProcessorTest {


    @Test
    public void reassembling_sample_text_results_in_correct_output(){
        String sampleText = "O draconia;conian devil! Oh la;h lame sa;saint!";
        String reAssembledText = new TextProcessor().reassemble(sampleText);
        assertEquals("O draconian devil! Oh lame saint!", reAssembledText);

    }

    @Test
    public void splits_line_to_correct_arrayList_of_words(){
        String sampletext = "O draconia;conian devil! Oh la;h lame sa;saint!";
        ArrayList<String> splitSample= new TextProcessor().splitToWords(sampletext);
        assertEquals(new ArrayList<String>(Arrays.asList("O", "draconia", "conian", "devil!", "Oh", "la", "h", "lame", "sa", "saint!")), splitSample);


    }

    @Test
    public void checkIfStringContainsAnotherStringFragment(){
        String a = "draconia";
        String b = "conia";

    }
    @Test
    public void test_if_we_can_correctly_eliminate_words_contained_entirely(){
        String sampletext = "O draconia;conian devil! Oh la;h h h lame sa;saint! sai sai sa";
        ArrayList<String> splitSample= new TextProcessor().splitToWords(sampletext);
        ArrayList<String> eliminatedWords = new TextProcessor().reAssemble(splitSample);
        assertEquals(Arrays.asList("draconia", "conian", "devil!", "Oh", "lame", "saint!"), eliminatedWords);

    }

    @Test
    public void checkIf_2_words_not_entirely_substrings_can_be_merged_correctly(){

        String s1 = "draconia";
        String s2 = "conian";
        String merged = new TextProcessor().mergeWords(s1, s2);
        assertEquals("draconian", merged);

    }


    @Test
    public void checkIf_2_words_not_entirely_substrings_can_be_merged_correctly_when_switched(){

        String s1 = "draconia";
        String s2 = "conian";
        //switch the order of params
        String merged = new TextProcessor().mergeWords(s2, s1);
        assertEquals("draconian", merged);

    }

    @Test
    public void checkIf_2_words_not_entirely_substrings_can_be_merged(){

        String s1 = "asta";
        String s2 = "stalavista";
        //switch the order of params
        String merged = new TextProcessor().mergeWords(s2, s1);
        assertEquals("astalavista", merged);

    }

    @Test
    public void checkIfFragmentsAreSeparatedCorrectly(){
        TextProcessor textProcessor = new TextProcessor();
        String sampletext = "O draconia;conian devil! Oh la;h lame sa;saint!";
        ArrayList<String> listOfFragments  =  textProcessor.splitToFragments(sampletext);
        assertEquals(Arrays.asList("O draconia","conian devil!", " Oh la", "h lame sa",  "saint!"), listOfFragments );
    }

    @Test
    public void checkIfSentencesAreSeparatedCorrectly(){
        TextProcessor textProcessor = new TextProcessor();
        String sampletext = "O draconia;conian devil! Oh la;h lame sa;saint!";
        ArrayList<String> listOfFragments = new ArrayList<String>();
        ArrayList<String> sentences  =  textProcessor.splitToFragments(sampletext);
        ArrayList<String> results = textProcessor.reAssemble(sentences);
        assertEquals("O draconian devil! Oh lame saint!", results);
    }

//    @Test
//    public void checkIfSentencesAreSeparatedCorrectlyWithLongerSequence(){
//        String sampletext = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al";
//        ArrayList<String> splitSample= new TextProcessor().splitToWords(sampletext);
//
//        ArrayList<String> eliminatedWords = new TextProcessor().reAssemble(splitSample);
//        assertEquals(Arrays.asList("draconian", "devil!", "Oh", "lame", "saint!"), eliminatedWords);
//    }

}
