package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class MasterCardTest extends TestCase {

    @Test
    public void testMasterCard() {
        MasterCard mc = new MasterCard("5567894523129080");
        String result = mc.validateCreditCard("5567894523129080");
        assertEquals("MasterCard",result);

    }

    @Test
    public void testMore19Digits() {
        MasterCard mc = new MasterCard("5.90123E+22");
        String result = mc.validateCreditCard("5.90123E+22");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNotPossible() {
        MasterCard mc = new MasterCard("3601110000000000");
        String result = mc.validateCreditCard("3601110000000000");
        assertEquals("Invalid: Not a possible card number",result);

    }

    @Test
    public void testNonNumeric() {
        MasterCard mc = new MasterCard("6011*890HJrt6789");
        String result = mc.validateCreditCard("6011*890HJrt6789");
        assertEquals("Invalid",result);

    }

    @Test
    public void testNull() {
        MasterCard mc = new MasterCard("");
        String result = mc.validateCreditCard("");
        assertEquals("Invalid: empty/null card number",result);

    }
}