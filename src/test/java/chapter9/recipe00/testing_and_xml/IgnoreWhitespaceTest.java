package chapter9.recipe00.testing_and_xml;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import util.Person;

public class IgnoreWhitespaceTest extends XMLTestCase {

    @Test
    public void testIgnoreWhitespace() throws Exception {
        Person person = new Person("J.B.", "Rainsberger");
        XMLUnit.setIgnoreWhitespace(false);
        String personXmlWithWhitespace = person.toXmlWithWhitespace();
        assertFalse(personXmlWithWhitespace.equals(person.toXml()));
        assertXMLNotEqual(personXmlWithWhitespace, person.toXml());
        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(personXmlWithWhitespace, person.toXml());
        XMLUnit.setIgnoreWhitespace(false);
    }
}
