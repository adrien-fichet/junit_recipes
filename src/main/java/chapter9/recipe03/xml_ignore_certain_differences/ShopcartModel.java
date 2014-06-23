package chapter9.recipe03.xml_ignore_certain_differences;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShopcartModel implements Serializable {
    private Map<String, Quantity> coffeeQuantities = new HashMap<String, Quantity>();

    public Iterator items() {
        return coffeeQuantities.values().iterator();
    }

    public void addCoffeeQuantities(List<CoffeeQuantity> requestedQuantities) {
        for (CoffeeQuantity each : requestedQuantities) {
            String coffeeName = each.getCoffeeName();
            CoffeeQuantity currentQuantity = getCoffeeQuantity(coffeeName);
            Quantity sum = each.add(currentQuantity);
            coffeeQuantities.put(coffeeName, sum);
        }
    }

    private CoffeeQuantity getCoffeeQuantity(String coffeeName) {
        CoffeeQuantity currentQuantity = (CoffeeQuantity) coffeeQuantities.get(coffeeName);
        return (currentQuantity == null) ? new CoffeeQuantity(0, coffeeName) : currentQuantity;
    }
}
