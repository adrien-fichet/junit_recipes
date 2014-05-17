package chapter4.recipe08.data_driven_test_suite;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.Money;

import java.util.*;

public class AllocateMoneyTest extends TestCase {
    private Money amountToSplit;
    private int nWays;
    private Map expectedCuts;

    public AllocateMoneyTest(Money amountToSplit, int nWays, Map expectedCuts) {
        super("testAllocate");
        this.amountToSplit = amountToSplit;
        this.nWays = nWays;
        this.expectedCuts = expectedCuts;
    }

    public static Test suite() throws Exception {
        TestSuite suite = new TestSuite();

        Map oneGSixWays = new HashMap();
        oneGSixWays.put(new Money(166, 66).valueInCents(), 2);
        oneGSixWays.put(new Money(166, 67).valueInCents(), 4);
        suite.addTest(new AllocateMoneyTest(new Money(1000, 0), 6, oneGSixWays));

        Map oneGTwoWays = Collections.singletonMap(new Money(500, 0).valueInCents(), 2);
        suite.addTest(new AllocateMoneyTest(new Money(1000, 0), 2, oneGTwoWays));

        return suite;
    }

    public void testAllocate() {
        List allocatedAmounts = amountToSplit.split(nWays);
        Map actualCuts = organizeIntoBag(allocatedAmounts);
        assertEquals(expectedCuts, actualCuts);
    }

    private Map organizeIntoBag(List allocatedAmounts) {
        Map bagOfCuts = new HashMap();

        for (Object allocatedAmount : allocatedAmounts) {
            Money eachAmount = (Money) allocatedAmount;
            incrementCountForCutAmount(bagOfCuts, eachAmount);
        }

        return bagOfCuts;
    }

    private void incrementCountForCutAmount(Map bagOfCuts, Money eachAmount) {
        Object cutsForAmountAsObject = bagOfCuts.get(eachAmount.valueInCents());
        int cutsForAmount;

        if (cutsForAmountAsObject == null) {
            cutsForAmount = 0;
        } else {
            cutsForAmount = (Integer) cutsForAmountAsObject;
        }

        bagOfCuts.put(eachAmount.valueInCents(), cutsForAmount + 1);
    }
}
