package chapter3.recipe04.factor_out_test_fixture;

import org.junit.Before;
import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;

public class MoneyTest {
    private Money money;
    
    @Before
    public void setUp() {
        money = new Money(12, 50);
    }
    
    @Test
    public void testAdd() throws Exception {
        Money augend = new Money(12, 50);
        Money sum = money.add(augend);
        assertEquals(2500, sum.valueInCents());
    }

    @Test
    public void testNegate() throws Exception {
        Money opposite = money.negate();
        assertEquals(-1250, opposite.valueInCents());
    }

    @Test
    public void testRoundedDown() throws Exception {
        Money round = money.roundToNearestDollar();
        assertEquals(1300, round.valueInCents());
    }

    @Test
    public void testRoundedUp() throws Exception {
        money.setDecimals(0);
        Money round = money.roundToNearestDollar();
        assertEquals(1200, money.valueInCents());
    }

}
