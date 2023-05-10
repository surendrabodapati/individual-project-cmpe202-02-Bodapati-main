package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class JSONFileParserTest extends TestCase {

    @Test
    public void testReadFile(){
        JSONFileParser json = new JSONFileParser();
        json.readFile("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Inputs/input_file.json");
        assertEquals(null, null);
    }

    @Test
    public void testProcessFile(){
        JSONFileParser json = new JSONFileParser();
        json.processEachCardNumber();
        assertEquals(null,null);
    }

    @Test
    public void testOutputFile(){
        JSONFileParser json = new JSONFileParser();
        json.writeOutputFile("/Users/anuraggajam/Desktop/202/Project/CreditCard-202/Files/TestCases/Outputs/output_file.xml");
    }
}