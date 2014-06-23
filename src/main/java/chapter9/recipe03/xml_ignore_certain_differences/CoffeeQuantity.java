package chapter9.recipe03.xml_ignore_certain_differences;

public class CoffeeQuantity extends Quantity {
    public CoffeeQuantity(int kilograms, String coffeeName) {
        super(kilograms, coffeeName);
    }

    public String getCoffeeName() {
        return (String) unitOfMeasure;
    }

    public int getAmountInKilograms() {
        return magnitude.intValue();
    }

    @Override
    public Object clone() {
        return new CoffeeQuantity(getAmountInKilograms(), getCoffeeName());
    }
}
