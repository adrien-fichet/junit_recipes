package chapter9.recipe05.testing_static_webpage_content;

import org.apache.xerces.parsers.DOMParser;
import org.custommonkey.xmlunit.XMLTestCase;
import org.cyberneko.html.HTMLConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class WelcomePageNekoTest extends XMLTestCase {
    private Document welcomePageDom;
    private final String webpage = "/chapter9/recipe05/testing_static_webpage_content/webpage.html";

    @Before
    public void setUp() throws Exception {
        DOMParser nekoParser = new DOMParser(new HTMLConfiguration());
        nekoParser.setFeature("http://cyberneko.org/html/features/augmentations", true);
        nekoParser.setProperty("http://cyberneko.org/html/properties/names/elems", "lower");
        nekoParser.setProperty("http://cyberneko.org/html/properties/names/attrs", "lower");
        nekoParser.setFeature("http://cyberneko.org/html/features/report-errors", true);
        nekoParser.parse(new InputSource(getClass().getResourceAsStream(webpage)));
        welcomePageDom = nekoParser.getDocument();
        assertNotNull("Could not load DOM", welcomePageDom);
    }

    @Test
    public void testCanNavigateToCatalog() throws Exception {
        assertXpathExists("//form[@action='coffee']//input[@type='submit' and @name='browseCatalog']", welcomePageDom);
    }

    @Test
    public void testCanNavigateToCatalogMoreVerbose() throws Exception {
        assertXpathExists("//form", welcomePageDom);
        assertXpathEvaluatesTo("coffee", "//form/@action", welcomePageDom);
        assertXpathExists("//form[@action='coffee']//input[@type='submit']", welcomePageDom);
        assertXpathEvaluatesTo("browseCatalog", "//form[@action='coffee']//input[@type='submit']/@name", welcomePageDom);
    }
}
