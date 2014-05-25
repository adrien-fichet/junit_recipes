package chapter5.recipe04.properties_file;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InterestCalculatorTest {
    private String propertiesFile = "/chapter5/recipe04/properties_file/InterestCalculatorTest.properties";
    private double interestRate, loanAmount;
    private int loanDuration;

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(propertiesFile);
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.list(System.out);

        interestRate = Double.parseDouble(properties.getProperty("interest.rate"));
        loanAmount = Double.parseDouble(properties.getProperty("loan.amount"));
        loanDuration = Integer.parseInt(properties.getProperty("loan.duration.years"));
    }
    
    @Test
    public void testInterestCalculation() throws Exception {
        // fake interest calculation
    }

}
