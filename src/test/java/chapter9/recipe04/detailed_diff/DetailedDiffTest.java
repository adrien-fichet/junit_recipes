package chapter9.recipe04.detailed_diff;

import chapter9.recipe01.xml_verify_order.ArticleBuilder;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DetailedDiffTest extends XMLTestCase {

    @Before
    public void setUp() {
        XMLUnit.setIgnoreWhitespace(true);
    }

    @After
    public void tearDown() {
        XMLUnit.setIgnoreWhitespace(false);
    }

    @Test
    public void testMultipleParagraphs() throws Exception {
        ArticleBuilder builder = new ArticleBuilder("Testing and XML");
        builder.addAuthorName("J.B. Rainsberger");
        builder.addHeading("A heading");
        builder.addParagraph("A paragraph.");

        String expected = "<?xml version=\"1.0\" ?>" +
                "<article>" +
                "<title>Testing and XML</title>" +
                "<author>J.B. Rainsberger</author>" +
                "<h1>A heading</h1>" +
                "<p>A paragraph.</p>" +
                "</article>";

        String actual = builder.toXml();
        assertXMLExactlyIdentical(expected, actual);
    }

    public void assertXMLExactlyIdentical(String expected, String actual) throws IOException, SAXException {
        Diff diff = new Diff(expected, actual);
        assertTrue(new DetailedDiff(diff).toString(), diff.identical());
    }
}
