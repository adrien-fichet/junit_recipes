package chapter2.recipe5.test_setter;

import static org.junit.Assert.*;
import org.junit.Test;

import util.Money;
import chapter2.recipe4.test_setter.Bank;
import chapter2.recipe4.test_setter.BankTransferAction;

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
