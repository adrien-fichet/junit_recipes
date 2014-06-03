package chapter6.recipe02.display_test_names;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DisplayTestNamesTest extends TestCase {

    @Before
    public void setUp() {
        System.out.println(getName());
    }

    @Test
    public void testOne() throws Exception {
        assertTrue(true);
    }

    @Test
    public void testTwo() throws Exception {
        assertFalse(false);
    }
}
