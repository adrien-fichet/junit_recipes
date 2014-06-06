package chapter2.recipe05.test_setter;

import util.Money;

public class Bank {

    public static Bank getInstance() {
        return new Bank();
    }

    public boolean transfer(String sourceAccountId, String targetAccountId, Money amount) {
        return true;
    }

}
