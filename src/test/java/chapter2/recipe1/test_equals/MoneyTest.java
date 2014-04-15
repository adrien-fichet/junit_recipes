package chapter2.recipe1.test_equals;

import org.junit.Before;
import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test equals: RST
 * Reflexivity: a == a
 * Symmetry: if a == b, then b == a
 * Transitivity: if a == b and b == c, then a == c
 */
public class MoneyTest {
    private Money a;
    private Money b;
    private Money c;

    @Before
    public void setUp() {
        a = new Money(100, 0);
        b = new Money(100, 0);
        c = new Money(50, 0);
    }

    @Test
    public void testReflexive() {
        assertEquals(a, a);
        assertEquals(b, b);
        assertEquals(c, c);
    }

    @Test
    public void testSymmetric() {
        assertEquals(a, b);
        assertEquals(b, a);
        assertFalse(a.equals(c));
        assertFalse(c.equals(a));
    }

    @Test
    public void testConsistent() {
        for (int i = 0; i < 1000; i++) {
            assertEquals(a, b);
            assertFalse(a.equals(c));
        }
    }

    @Test
    public void testNotNull() {
        assertFalse(a.equals(null));
        assertFalse(c.equals(null));
    }
}
