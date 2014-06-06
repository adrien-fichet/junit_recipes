package chapter2.recipe08.test_throw_exception;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FractionTest {

    @Test
    public void testGetResultDenominatorZero() throws Exception {
        try {
            new Fraction(1.0d, 0.0d).getResult();
            fail("Expected exception if denominator == 0");
        } catch (IllegalArgumentException e) {
            assertEquals("denominator == 0", e.getMessage());
        }
    }

    @Test
    public void testGetResultDenominatorNotZero() throws Exception {
        assertEquals(1.0d, new Fraction(1.0d, 1.0d).getResult(), 0.001);
    }
}
