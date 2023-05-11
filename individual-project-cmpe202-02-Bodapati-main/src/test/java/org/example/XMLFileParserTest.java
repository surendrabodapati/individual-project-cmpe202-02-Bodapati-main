package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class XMLFileParserTest extends TestCase {

    @Test
    public void testReadFile(){
        XMLFileParser xml = new XMLFileParser();
        xml.readFile("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/input_file.xml");
        assertEquals(null, null);
    }

    @Test
    public void testProcessFile(){
        XMLFileParser xml = new XMLFileParser();
        xml.processEachCardNumber();
        assertEquals(null,null);
    }

    @Test
    public void testOutputFile(){
        XMLFileParser xml = new XMLFileParser();
        xml.writeOutputFile("/Users/surendrabodapati/Documents/Files/TestCases/Inputs/output_file.xml");
    }
}