package chapter4.recipe09.test_suite_xml;

import chapter4.recipe08.data_driven_test_suite.AllocateMoneyTest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.dom4j.Dom4jXPath;
import util.Money;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AllocateMoneyTestBuilder {
    private String testFileName;

    public AllocateMoneyTestBuilder(String testFileName) {
        this.testFileName = testFileName;
    }

    public static List makeTests(String testFileName) throws Exception {
        return new AllocateMoneyTestBuilder(testFileName).makeTests();
    }

    @SuppressWarnings("unchecked")
    public List makeTests() throws Exception {
        List tests = new ArrayList();
        Document document = new SAXReader().read(AllocateMoneyTestBuilder.class.getResourceAsStream(testFileName));
        List<Element> testNodes = new Dom4jXPath("/tests/test").selectNodes(document);

        for (Element testNode : testNodes) {
            tests.add(makeAllocateMoneyTest(testNode));
        }

        return tests;
    }

    private AllocateMoneyTest makeAllocateMoneyTest(Element testNode) throws JaxenException, ParseException {
        Money amountToSplit = parseAsMoney(testNode, "input/amount-to-split");
        int nWays = parseAsInt(testNode, "input/number-of-ways");
        List<Element> expectedCutNodes = new Dom4jXPath("expected-result/cut").selectNodes(testNode);
        Map expectedCuts = parseExpectedCuts(expectedCutNodes);
        AllocateMoneyTest eachAllocateMoneyTest = new AllocateMoneyTest(amountToSplit, nWays, expectedCuts);
        return eachAllocateMoneyTest;
    }

    private Map parseExpectedCuts(List<Element> expectedCutNodes) throws JaxenException, ParseException {
        Map expectedCuts = new HashMap();

        for (Element cutNode : expectedCutNodes) {
            Money cutAmount = parseAsMoney(cutNode, "amount");
            int numberOfCuts = parseAsInt(cutNode, "number");
            expectedCuts.put(cutAmount.valueInCents(), numberOfCuts);
        }

        return expectedCuts;
    }

    private static int parseAsInt(Element fromNode, String xpathToInt) throws JaxenException {
        String intAsString = getNodeText(fromNode, xpathToInt);
        return Integer.parseInt(intAsString);
    }

    private static String getNodeText(Element fromNode, String xpath) throws JaxenException {
        return String.valueOf(new Dom4jXPath(xpath).selectSingleNode(fromNode));
    }

    private static Money parseAsMoney(Element fromNode, String xpathToMoneyObject) throws JaxenException,
            ParseException {
        String moneyAsString = getNodeText(fromNode, xpathToMoneyObject);
        return new Money(moneyAsString);
    }
}