package chapter9.recipe00.testing_and_xml;

import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Test;
import util.Person;

public class MarshalPersonToXmlTest extends XMLTestCase {
    
    @Test
    public void testJBRainsberger() throws Exception {
        Person person = new Person("JB", "Rainsberger");
        String personXml = person.toXml();
        assertXpathExists("/person", personXml);
        assertXpathEvaluatesTo("JB", "/person/firstname", personXml);
        assertXpathEvaluatesTo("Rainsberger", "/person/lastname", personXml);
    }

}
