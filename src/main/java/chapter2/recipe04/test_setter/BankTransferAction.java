package chapter2.recipe04.test_setter;

import util.Money;

public class BankTransferAction {
    private String sourceAccountId, targetAccountId;
    private Money amount;

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public void setTargetAccountId(String targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public void execute() {
        execute(Bank.getInstance());
    }

    public void execute(Bank bank) {
        bank.transfer(sourceAccountId, targetAccountId, amount);
    }
}
