package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class DiscoverTest extends TestCase {
    @Test
    public void testMasterCard() {
        Discover d = new Discover("6011110000000000");
        String result = d.validateCreditCard("6011110000000000");
        assertEquals("Discover",result);

    }

    @Test
    public void testMore19Digits() {
        Discover d = new Discover("5.90123E+22");
        String result = d.validateCreditCard("5.90123E+22");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNotPossible() {
        Discover d = new Discover("3601110000000000");
        String result = d.validateCreditCard("3601110000000000");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNonNumeric() {
        Discover d = new Discover("6011*890HJrt6789");
        String result = d.validateCreditCard("6011*890HJrt6789");
        assertEquals("Invalid",result);

    }

    @Test
    public void testNull() {
        Discover d = new Discover("");
        String result = d.validateCreditCard("");
        assertEquals("Invalid: empty/null card number",result);

    }


}