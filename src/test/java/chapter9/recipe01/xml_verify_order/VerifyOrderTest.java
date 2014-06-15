package chapter9.recipe01.xml_verify_order;

import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Test;
import util.Person;

public class VerifyOrderTest extends XMLTestCase {

    @Test
    public void testXmlOrder() throws Exception {
        Person person1 = new Person("abc", "def");
        Person person2 = new Person("ghi", "jkl");
        String xml1 = "<persons>" + person1.toXml() + person2.toXml() + "</persons>";
        String xml2 = "<persons>" + person2.toXml() + person1.toXml() + "</persons>";
        assertXMLNotEqual(xml1, xml2);
    }
}
