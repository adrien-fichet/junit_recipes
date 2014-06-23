package chapter9.recipe03.xml_ignore_certain_differences;

import util.Money;

public class CoffeeCatalogItem {
    public String productId = "";
    public String coffeeName = "";
    public Money unitPrice = Money.ZERO;

    public CoffeeCatalogItem(String productId, String coffeeName, Money unitPrice) {
        this.productId = productId;
        this.coffeeName = coffeeName;
        this.unitPrice = unitPrice;
    }
}
