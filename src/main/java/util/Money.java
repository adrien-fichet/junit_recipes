package util;

public class Money {
    private int units;
    private int decimals;

    public Money(int units, int decimals) {
        this.units = units;
        this.decimals = decimals;
    }

    public int getUnits() {
        return units;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public boolean equals(Object b) {
        if (b == null) {
            return false;
        }

        Money m = (Money) b;
        return (units == m.units && decimals == m.decimals);
    }

    public int valueInCents() {
        return units * 100 + decimals;
    }

    public Money add(Money augend) {
        return new Money(units + augend.getUnits(), decimals + augend.getDecimals());
    }

    public Money negate() {
        return new Money(-units, -decimals);
    }

    public Money roundToNearestDollar() {
        if (decimals < 50) {
            return new Money(units, 0);
        } else {
            return new Money(units + 1, 0);
        }
    }
}
