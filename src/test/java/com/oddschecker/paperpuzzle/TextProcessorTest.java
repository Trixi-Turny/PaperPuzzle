package com.oddschecker.paperpuzzle;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

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
        ArrayList<String> eliminatedWords = new TextProcessor().eliminateCompleteSubstrings(splitSample);
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

//    @Test
//    public checkIfSentencesAreSeparatedCorrectly(){
//
//    }

}
