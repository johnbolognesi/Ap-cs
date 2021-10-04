/**
 * RomanToDecimalTest tests a series of inputs to make sure the roman numerals would match with the expected output from the code.
 * @version 10/04/21
 * @author John Bolognesi
 */

import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    /**
     * Series of tests using code from RomanToDecimal.
     */
    public void romanToDecimal()    {
        assertEquals(RomanToDecimal.romanToDecimal("X"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("XII"), 12);
        assertEquals(RomanToDecimal.romanToDecimal("XIII"), 13);
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("XV"), 15);
        assertEquals(RomanToDecimal.romanToDecimal("XVI"), 16);
        assertEquals(RomanToDecimal.romanToDecimal("XVII"), 17);
        assertEquals(RomanToDecimal.romanToDecimal("XVIII"), 18);
        assertEquals(RomanToDecimal.romanToDecimal("XVIV"), 19);

        assertEquals(RomanToDecimal.romanToDecimal("IVIV"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("IVLIV"), 60);
        assertEquals(RomanToDecimal.romanToDecimal("CMLCM"), 2050);
        assertEquals(RomanToDecimal.romanToDecimal("XCXXC"), 210);

        assertEquals(RomanToDecimal.romanToDecimal("John"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Teddy"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MarksBrother"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Sean"), -1);


    }
}
