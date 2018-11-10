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
        assertEquals(reAssembledText, "O draconian devil! Oh lame saint!");

    }

    @Test
    public void splits_line_to_correct_arrayList_of_words(){
        String sampletext = "O draconia;conian devil! Oh la;h lame sa;saint!";
        ArrayList<String> splitSample= new TextProcessor().splitToWords(sampletext);
        assertEquals(splitSample, new ArrayList<String> (Arrays.asList("O", "drakonia", "conian", "devil!", "Oh", "la", "h", "lame", "sa", "saint")));


    }


}
