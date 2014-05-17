package chapter4.recipe08.data_driven_test_suite;

import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void testValueInCents() throws Exception {
        assertEquals(50010, new Money(500, 10).valueInCents());
        assertEquals(16667, new Money(166, 67).valueInCents());
    }
}
