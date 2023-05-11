package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class CSVFileParserTest extends TestCase {

    @Test
    public void testReadFile(){
        CSVFileParser csv = new CSVFileParser();
        csv.readFile("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/input_file-1.csv");
        assertEquals(null, null);
    }

    @Test
    public void testProcessFile(){
        CSVFileParser csv = new CSVFileParser();
        csv.processEachCardNumber();
        assertEquals(null,null);
    }

    @Test
    public void testOutputFile(){
            CSVFileParser csv = new CSVFileParser();
            csv.writeOutputFile("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/output_file-1.csv");
    }


}