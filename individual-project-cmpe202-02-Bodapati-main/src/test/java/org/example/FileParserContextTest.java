package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileParserContextTest extends TestCase {


    @Test
    public void testExecuteFileParserTestJson() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/input_file.json", "/Users/surendrabodapati/Documents/Files/TestCases/Inputs/output_file.json");

//        assertEquals(null, null);
    }



    @Test
    public void testExecuteFileParserTestCSV() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/input_file-1.csv", "/Users/surendrabodapati/Documents/Files/TestCases/Inputs/output_file-1.csv");

        assertEquals(null, null);
    }

    @Test
    public void testExecuteFileParserTestXML() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/input_file.xml", "/Users/surendrabodapati/Documents/Files/TestCases/Inputs/output_file.xml");

        assertEquals(null, null);
    }
}