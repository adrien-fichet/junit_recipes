package chapter2.recipe05.test_setter;

import chapter2.recipe04.test_setter.Bank;
import chapter2.recipe04.test_setter.BankTransferAction;
import org.junit.Test;
import util.Money;

import static org.junit.Assert.assertEquals;

public class BankTransferActionTest {

    @Test
    public void testSettingInputParameters() {
        BankTransferAction bta = new BankTransferAction();
        bta.setSourceAccountId("source");
        bta.setTargetAccountId("target");
        bta.setAmount(new Money(100, 0));

        bta.execute(new Bank() {
            public void transfer(String sourceAccountId, String targetAccountId, Money amount) {
                assertEquals("source", sourceAccountId);
                assertEquals("target", targetAccountId);
                assertEquals(10000, amount.valueInCents());
            }
        });
    }

}
