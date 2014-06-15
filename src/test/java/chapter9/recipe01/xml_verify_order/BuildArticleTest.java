package chapter9.recipe01.xml_verify_order;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;

public class BuildArticleTest extends XMLTestCase {

    @Test
    public void testMultipleParagraphs() throws Exception {
        XMLUnit.setIgnoreWhitespace(true);
        ArticleBuilder builder = new ArticleBuilder("Testing and XML");
        builder.addAuthorName("J.B. Rainsberger");
        builder.addHeading("A heading");
        builder.addParagraph("This is a paragraph.");

        String expected = "<?xml version=\"1.0\" ?>" +
                "<article>" +
                "<title>Testing and XML</title>" +
                "<author>J.B. Rainsberger</author>" +
                "<p>This is a paragraph.</p>" +
                "<h1>A heading</h1>" + // Wrong order
                "</article>";

        assertXMLEqual(expected, builder.toXml()); // Order not checked
        XMLUnit.setIgnoreWhitespace(false);
    }
    
    @Test
    public void testMultipleParagraphsWithDiffWrongOrder() throws Exception {
        XMLUnit.setIgnoreWhitespace(true);
        ArticleBuilder builder = new ArticleBuilder("Testing and XML");
        builder.addAuthorName("J.B. Rainsberger");
        builder.addHeading("A heading");
        builder.addParagraph("This is a paragraph.");

        String expected = "<?xml version=\"1.0\" ?>" +
                "<article>" +
                "<title>Testing and XML</title>" +
                "<author>J.B. Rainsberger</author>" +
                "<p>This is a paragraph.</p>" +
                "<h1>A heading</h1>" +
                "</article>";

        Diff diff = new Diff(expected, builder.toXml());
        assertFalse(diff.identical());
        XMLUnit.setIgnoreWhitespace(false);
    }

    @Test
    public void testMultipleParagraphsWithDiffRightOrder() throws Exception {
        XMLUnit.setIgnoreWhitespace(true);
        ArticleBuilder builder = new ArticleBuilder("Testing and XML");
        builder.addAuthorName("J.B. Rainsberger");
        builder.addHeading("A heading");
        builder.addParagraph("This is a paragraph.");

        String expected = "<?xml version=\"1.0\" ?>" +
                "<article>" +
                "<title>Testing and XML</title>" +
                "<author>J.B. Rainsberger</author>" +
                "<h1>A heading</h1>" +
                "<p>This is a paragraph.</p>" +
                "</article>";

        Diff diff = new Diff(expected, builder.toXml());
        assertTrue(diff.identical());
        XMLUnit.setIgnoreWhitespace(false);
    }
}
