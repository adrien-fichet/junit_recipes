package chapter9.recipe03.xml_ignore_certain_differences;

import util.Money;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class CoffeeCatalog {
    private Set<CoffeeCatalogItem> items = new HashSet<CoffeeCatalogItem>();

    public String getProductId(String coffeeName) {
        for (CoffeeCatalogItem item : items) {
            if (item.coffeeName.equals(coffeeName))
                return item.productId;
        }

        throw new NoSuchElementException("Coffee name " + coffeeName);
    }

    public Money getUnitPrice(String coffeeName) {
        for (CoffeeCatalogItem item : items) {
            if (item.coffeeName.equals(coffeeName))
                return item.unitPrice;
        }

        throw new NoSuchElementException("Coffee name " + coffeeName);
    }
}
