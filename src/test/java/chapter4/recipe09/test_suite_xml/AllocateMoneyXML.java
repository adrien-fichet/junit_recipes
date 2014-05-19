package chapter4.recipe09.test_suite_xml;

import chapter4.recipe08.data_driven_test_suite.AllocateMoneyTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.Money;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllocateMoneyXML extends TestCase {
    private Money amountToSplit;
    private int nWays;
    private Map expectedCuts;
    private Map actualCuts;

    public AllocateMoneyXML(Money amountToSplit, int nWays, Map expectedCuts) {
        super("testAllocate");
        this.amountToSplit = amountToSplit;
        this.nWays = nWays;
        this.expectedCuts = expectedCuts;
    }

    public static Test suite() throws Exception {
        TestSuite suite = new TestSuite();
        String testFileName = "/suite.xml";
        List tests = AllocateMoneyTestBuilder.makeTests(testFileName);

        for (Object test : tests) {
            AllocateMoneyTest eachTest = (AllocateMoneyTest) test;
            suite.addTest(eachTest);
        }

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
