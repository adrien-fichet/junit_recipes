package chapter2.recipe05.test_setter;

import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankTransferActionTest {

    @Test
    public void testSettingInputParameters() {
        BankTransferAction bta = new BankTransferAction();
        bta.setSourceAccountId("source");
        bta.setTargetAccountId("target");
        bta.setAmount(new Money(100, 0));

        assertTrue(bta.execute(new Bank() {
            @Override
            public boolean transfer(String sourceAccountId, String targetAccountId, Money amount) {
                assertEquals("source", sourceAccountId);
                assertEquals("target", targetAccountId);
                assertEquals(10000, amount.valueInCents());
                return true;
            }
        }));

        assertTrue(bta.execute());
    }

}
