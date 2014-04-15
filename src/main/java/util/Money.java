package util;

public class Money {
    private int units;
    private int decimals;

    public Money(int units, int decimals) {
        this.units = units;
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
}
