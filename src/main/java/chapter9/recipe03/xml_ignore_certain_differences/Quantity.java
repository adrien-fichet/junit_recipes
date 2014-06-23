package chapter9.recipe03.xml_ignore_certain_differences;

import java.math.BigDecimal;

public class Quantity {
    protected BigDecimal magnitude;
    protected Object unitOfMeasure;
    private static Object NULL_UNIT_OF_MEASURE = new Object();

    public Quantity(Integer magnitude, String unitOfMeasure) {
        this(new BigDecimal(magnitude), unitOfMeasure);
    }

    public Quantity(BigDecimal magnitude, Object unitOfMeasure) {
        if (unitOfMeasure == null) {
            this.unitOfMeasure = NULL_UNIT_OF_MEASURE;
        } else {
            this.unitOfMeasure = unitOfMeasure;
        }

        this.magnitude = magnitude;
    }

    @Override
    public Object clone() {
        return new Quantity(magnitude, unitOfMeasure);
    }

    public Quantity add(Quantity that) {
        if (!this.unitOfMeasure.equals(that.unitOfMeasure)) {
            throw new ClassCastException("Cannot add a [" + unitOfMeasure + "] and a [" + that.unitOfMeasure + "]");
        }

        Quantity sum = (Quantity) this.clone();
        sum.magnitude = sum.magnitude.add(that.magnitude);
        return sum;
    }
}
