package chapter2.recipe05.test_setter;

import org.junit.Before;
import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BankTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(Bank.getInstance());
    }

    @Test
    public void testTransfer() throws Exception {
        assertTrue(bank.transfer("source", "target", new Money(1, 0)));
    }
}
