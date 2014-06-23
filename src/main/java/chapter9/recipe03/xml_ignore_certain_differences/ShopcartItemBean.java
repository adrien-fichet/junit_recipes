package chapter9.recipe03.xml_ignore_certain_differences;

import util.Money;

public class ShopcartItemBean implements Comparable {
    public String coffeeName = "";
    public String productId = "";
    public int quantityInKilograms;
    public Money unitPrice = Money.ZERO;

    public ShopcartItemBean(String coffeeName, String productId, int quantityInKilograms, Money unitPrice) {
        this.coffeeName = coffeeName;
        this.productId = productId;
        this.quantityInKilograms = quantityInKilograms;
        this.unitPrice = unitPrice;
    }

    @Override
    public int compareTo(Object other) {
        ShopcartItemBean that = (ShopcartItemBean) other;
        return this.coffeeName.compareTo(that.coffeeName);
    }

    public Money getTotalPrice() {
        return unitPrice.multipliedBy(quantityInKilograms);
    }
}
