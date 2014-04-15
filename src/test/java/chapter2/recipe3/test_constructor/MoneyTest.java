package chapter2.recipe3.test_constructor;

import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void testMoneyValue() {
        Money m = new Money(0, 50);
        assertEquals(50, m.valueInCents());
    }
}
