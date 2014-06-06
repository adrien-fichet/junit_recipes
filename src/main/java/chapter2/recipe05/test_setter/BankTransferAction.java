package chapter2.recipe05.test_setter;

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

    public boolean execute() {
        return execute(Bank.getInstance());
    }

    public boolean execute(Bank bank) {
        return bank.transfer(sourceAccountId, targetAccountId, amount);
    }
}
