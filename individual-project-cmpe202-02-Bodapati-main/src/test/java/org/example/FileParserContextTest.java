package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileParserContextTest extends TestCase {


    @Test
    public void testExecuteFileParserTestJson() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Inputs/input_file.json", "/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Outputs/output_file.json");

//        assertEquals(null, null);
    }



    @Test
    public void testExecuteFileParserTestCSV() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Inputs/input_file.csv", "/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Outputs/output_file.csv");

        assertEquals(null, null);
    }

    @Test
    public void testExecuteFileParserTestXML() {

        FileParserContext fpc = new FileParserContext();
        fpc.executeFileParser("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Inputs/input_file.xml", "/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Outputs/output_file.xml");

        assertEquals(null, null);
    }
}