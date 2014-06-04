package chapter6.recipe06.ignore_a_test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class IgnoreTest {

    @Ignore
    @Test
    public void testIgnore() throws Exception {
        assertFalse(true);
    }

    public void DISABLED_test() throws Exception {
        assertFalse(true);
    }
}
