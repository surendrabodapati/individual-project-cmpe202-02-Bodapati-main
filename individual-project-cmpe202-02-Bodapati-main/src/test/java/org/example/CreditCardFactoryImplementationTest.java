package org.example;

import junit.framework.TestCase;

public class CreditCardFactoryImplementationTest extends TestCase {

    public void testMasterCard(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        ccfi.getCreditCard("5567890000000000");
        assertEquals(null,null);
    }

    public void testVisa(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        ccfi.getCreditCard("4123460000000");
        assertEquals(null,null);
    }

    public void testAmericanExpress(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        ccfi.getCreditCard("347856000000000");
        assertEquals(null,null);
    }

    public void testDiscover(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        ccfi.getCreditCard("6011110000000000");
        assertEquals(null,null);
    }
    public void testNull(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        assertEquals(null,ccfi.getCreditCard(""));
    }
    public void test19Digits(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        assertEquals(null,ccfi.getCreditCard("5.90123E+22"));
    }
    public void testNonNumeric(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        assertEquals(null,ccfi.getCreditCard("6011*890HJrt6789"));
    }
    public void testNotPossibleCard(){
        CreditCardFactoryImplementation ccfi = new CreditCardFactoryImplementation();
        assertEquals(null,ccfi.getCreditCard("3601110000000000"));
    }

}