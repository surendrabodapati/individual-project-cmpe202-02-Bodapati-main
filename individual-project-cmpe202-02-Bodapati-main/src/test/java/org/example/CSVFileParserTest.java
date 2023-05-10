package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class CSVFileParserTest extends TestCase {

    @Test
    public void testReadFile(){
        CSVFileParser csv = new CSVFileParser();
        csv.readFile("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Inputs/input_file.csv");
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
            csv.writeOutputFile("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Outputs/output_file.csv");
    }


}