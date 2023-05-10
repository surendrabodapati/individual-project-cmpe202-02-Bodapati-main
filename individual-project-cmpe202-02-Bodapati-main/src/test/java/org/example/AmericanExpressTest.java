package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class AmericanExpressTest extends TestCase {

    @Test
    public void testMasterCard() {
        AmericanExpress ae = new AmericanExpress("347856000000000");
        String result = ae.validateCreditCard("347856000000000");
        assertEquals("AmericanExpress",result);

    }

    @Test
    public void testMore19Digits() {
        AmericanExpress ae = new AmericanExpress("5.90123E+22");
        String result = ae.validateCreditCard("5.90123E+22");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNotPossible() {
        AmericanExpress ae = new AmericanExpress("3601110000000000");
        String result = ae.validateCreditCard("3601110000000000");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNonNumeric() {
        AmericanExpress ae = new AmericanExpress("6011*890HJrt6789");
        String result = ae.validateCreditCard("6011*890HJrt6789");
        assertEquals("Invalid",result);

    }

    @Test
    public void testNull() {
        AmericanExpress ae = new AmericanExpress("");
        String result = ae.validateCreditCard("");
        assertEquals("Invalid: empty/null card number",result);

    }

}