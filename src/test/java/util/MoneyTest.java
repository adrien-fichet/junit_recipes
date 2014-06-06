package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("[1,0]", new Money(1, 0).toString());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new Money(1, 0).equals(new Money(0, 100)));
        assertTrue(new Money("$100").equals(new Money(100, 0)));
        assertFalse(new Money(1, 0).equals(new Double(1.0d)));
    }
}
