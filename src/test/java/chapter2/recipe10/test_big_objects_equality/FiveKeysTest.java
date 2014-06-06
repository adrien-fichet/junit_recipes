package chapter2.recipe10.test_big_objects_equality;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FiveKeysTest {
    private FiveKeys fiveKeys;

    @Before
    public void setUp() {
        fiveKeys = new FiveKeys(1, 2, 3, 4, 5);
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(fiveKeys.equals(new FiveKeys(1, 2, 3, 4, 5)));
        assertFalse(fiveKeys.equals(new FiveKeys(1, 2, 3, 4, 6)));
        assertFalse(fiveKeys.equals(null));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("FiveKeys[12345]", fiveKeys.toString());
    }
}
