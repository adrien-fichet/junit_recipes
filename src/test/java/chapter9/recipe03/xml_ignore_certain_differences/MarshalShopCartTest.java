package chapter9.recipe03.xml_ignore_certain_differences;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Money;

import java.util.Arrays;

public class MarshalShopCartTest extends XMLTestCase {
    private CoffeeCatalog catalog;

    @Before
    public void setUp() {
        XMLUnit.setIgnoreWhitespace(true);
        catalog = new CoffeeCatalog() {
            public String getProductId(String coffeeName) {
                return "001";
            }

            public Money getUnitPrice(String coffeeName) {
                return Money.ZERO;
            }
        };
    }

    @After
    public void tearDown() {
        XMLUnit.setIgnoreWhitespace(false);
    }
    
    @Test
    public void testOneItemIgnoreCatalogDetails() throws Exception {
        String expectedXml =
                "<?xml version='1.0' ?>"
                + "<shopcart>"
                + "<item id=\"762\">"
                + "<name>Sumatra</name>"
                + "<quantity>2</quantity>"
                + "<unit-price>$7.50</unit-price>"
                + "<total-price>$15.00</total-price>"
                + "</item>"
                + "<subtotal>$15.00</subtotal>"
                + "</shopcart>";
        ShopcartModel shopcart = new ShopcartModel();
        shopcart.addCoffeeQuantities(Arrays.asList(new CoffeeQuantity(2, "Sumatra")));
        String shopcartAsXml = ShopcartBean.create(shopcart, catalog).asXml();
        Diff diff = new Diff(expectedXml, shopcartAsXml);
        diff.overrideDifferenceListener(new IgnoreCatalogDetailsDifferenceListener());
        assertTrue(diff.toString(), diff.similar());
    }

}
