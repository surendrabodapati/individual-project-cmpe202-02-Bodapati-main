package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisaTest extends TestCase {

    @Test
    public void testMasterCard() {
        Visa v = new Visa("4123460000000");
        String result = v.validateCreditCard("4123460000000");
        assertEquals("Visa",result);

    }

    @Test
    public void testMore19Digits() {
        Visa v = new Visa("5.90123E+22");
        String result = v.validateCreditCard("5.90123E+22");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNotPossible() {
        Visa v = new Visa("3601110000000000");
        String result = v.validateCreditCard("3601110000000000");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNonNumeric() {
        Visa v = new Visa("6011*890HJrt6789");
        String result = v.validateCreditCard("6011*890HJrt6789");
        assertEquals("Invalid",result);

    }

    @Test
    public void testNull() {
        Visa v = new Visa("");
        String result = v.validateCreditCard("");
        assertEquals("Invalid: empty/null card number",result);

    }

}