package chapter2.recipe7.test_javabean;

import util.Money;

public class BankTransferCommand {
    private String sourceAccountId;
    private String targetAccountId;
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

    public boolean isReadyToExecute() {
        return sourceAccountId != null && targetAccountId != null &&
                amount != null;
    }

}
