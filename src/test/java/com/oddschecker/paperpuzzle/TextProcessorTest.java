package com.oddschecker.paperpuzzle;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextProcessorTest {


    @Test
    public void reassembling_sample_test_results_in_correct_output(){
        String sampleText = "O draconia;conian devil! Oh la;h lame sa;saint!";
        String reAssembledText = new TextProcessor().reassemble(sampleText);
        assertEquals(reAssembledText, "O draconian devil! Oh lame saint!");

    }

}
