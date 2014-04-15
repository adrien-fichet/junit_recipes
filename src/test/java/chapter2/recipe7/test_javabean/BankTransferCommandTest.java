package chapter2.recipe7.test_javabean;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Money;

public class BankTransferCommandTest {

	@Test
	public void testBankTransferCommandIsValid() {
		BankTransferCommand command = new BankTransferCommand();
		command.setSourceAccountId("source");
		command.setTargetAccountId("target");
		command.setAmount(new Money(1000, 0));
		assertTrue(command.isReadyToExecute());
	}
	
	@Test
	public void testBankTransferCommandAmountNotSet() {
		BankTransferCommand command = new BankTransferCommand();
		command.setSourceAccountId("source");
		command.setTargetAccountId("target");
		// Do not set amount
		assertFalse(command.isReadyToExecute());
	}
	
	@Test
	public void testBankTransferCommandSourceNotSet() {
		BankTransferCommand command = new BankTransferCommand();
		// Do not set source
		command.setTargetAccountId("target");
		command.setAmount(new Money(1000, 0));
		assertFalse(command.isReadyToExecute());
	}
	
	@Test
	public void testBankTransferCommandTargetNotSet() {
		BankTransferCommand command = new BankTransferCommand();
		command.setSourceAccountId("source");
		// Do not set target
		command.setAmount(new Money(1000, 0));
		assertFalse(command.isReadyToExecute());
	}
}
