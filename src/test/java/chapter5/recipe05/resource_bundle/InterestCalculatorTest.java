package chapter5.recipe05.resource_bundle;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ResourceBundle;

public class InterestCalculatorTest {
    private final String BASE_NAME = "chapter5.recipe05.resource_bundle.InterestCalculatorTest";
    private double interestRate, loanAmount;
    private int loanDuration;

    @Before
    public void setUp() throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);
        interestRate = Double.parseDouble(resourceBundle.getString("interest.rate"));
        loanAmount = Double.parseDouble(resourceBundle.getString("loan.amount"));
        loanDuration = Integer.parseInt(resourceBundle.getString("loan.duration.years"));
    }
    
    @Test
    public void testInterestCalculation() throws Exception {
        // fake interest calculation
    }

}
