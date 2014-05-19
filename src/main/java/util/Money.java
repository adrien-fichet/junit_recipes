package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Money {
    private int units;
    private int decimals;

    public Money(int units, int decimals) {
        this.units = units;
        this.decimals = decimals;
    }

    public Money(String amount) throws ParseException {
        double amountInDollars = NumberFormat.getCurrencyInstance(Locale.US).parse(amount).doubleValue();
        this.units = 0;
        this.decimals = (int) (amountInDollars * 100);
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
    public boolean equals(Object other) {
        if (other != null && getClass() == other.getClass()) {
            Money that = (Money) other;
            return valueInCents() == that.valueInCents();
        }
        return false;
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

    public List split(int nWays) {
        List result = new ArrayList();
        int baseSplitInCents = valueInCents() / nWays;
        int centsLeftOver = valueInCents() - baseSplitInCents * nWays;

        for (int i = 0; i < nWays; i++) {
            int eachSplitInCents;
            if (i < centsLeftOver) {
                eachSplitInCents = baseSplitInCents + 1;
            } else {
                eachSplitInCents = baseSplitInCents;
            }

            result.add(new Money(0, eachSplitInCents));
        }

        return result;
    }

    @Override
    public String toString() {
        return "[" + units + "," + decimals + "]";
    }
}
