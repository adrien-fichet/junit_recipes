package chapter5.recipe10.test_suite_setup;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ResourceBundle;

public class InterestCalculatorTestWithTestSetup extends TestCase {
    private static final String basename = "chapter5.recipe05.resource_bundle.InterestCalculatorTest";
    private static double interestRate, loanAmount;
    private static int loanDuration;

    public static Test suite() {
        TestSuite testSuite = new TestSuite(InterestCalculatorTestWithTestSetup.class);
        TestSetup wrapper = new TestSetup(testSuite) {
            public void setUp() {
                ResourceBundle rb = ResourceBundle.getBundle(basename);
                interestRate = Double.parseDouble(rb.getString("interest.rate"));
                loanAmount = Double.parseDouble(rb.getString("loan.amount"));
                loanDuration = Integer.parseInt(rb.getString("loan.duration.years"));
            }
        };
        return wrapper;
    }

    public void testInterestCalculation() throws Exception {
        assertEquals(5.5d, interestRate, 0.0d);
        assertEquals(150000.00d, loanAmount, 0.0d);
        assertEquals(15, loanDuration);
    }

}
