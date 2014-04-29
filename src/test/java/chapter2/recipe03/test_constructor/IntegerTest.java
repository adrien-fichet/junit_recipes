package chapter2.recipe03.test_constructor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerTest {

    @Test
    public void testInitialization() {
        Integer i = new Integer(12);
        assertEquals(12, i.intValue());
    }
}
