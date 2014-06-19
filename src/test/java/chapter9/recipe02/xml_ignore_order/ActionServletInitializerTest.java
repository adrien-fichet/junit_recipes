package chapter9.recipe02.xml_ignore_order;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.dom4j.Dom4jXPath;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ActionServletInitializerTest {
    private final String webXml = "/chapter9/recipe02/xml_ignore_order/web.xml";

    @Test
    public void testActionServletInitializationParameters() throws Exception {
        Document document = new SAXReader().read(getClass().getResourceAsStream(webXml));
        Map expectedParameters = getExpectedParameters();
        Map<String, String> actualParameters = getInitParams(document);
        assertEquals(expectedParameters, actualParameters);
    }

    private Map<String, String> getInitParams(Document document) throws JaxenException {
        Map<String, String> result = new HashMap<String, String>();
        List<Element> nodes = new Dom4jXPath("/web-app/servlet[servlet-name='action']/init-param").selectNodes(document);
        assertFalse("Found no nodes. Something wrong with XPath statement", nodes.size() == 0);
        appendInitParams(nodes, result);
        return result;
    }

    private void appendInitParams(List<Element> nodes, Map<String, String> result) {
        for (Element element : nodes) {
            String name = null;
            String value = null;
            List<Element> childNodes = element.elements();

            for (Element child : childNodes) {
                if ("param-name".equals(child.getName())) {
                    name = child.getTextTrim();
                } else if ("param-value".equals(child.getName())) {
                    value = child.getTextTrim();
                }
            }

            result.put(name, value);
        }
    }

    private Map<String, String> getExpectedParameters() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("debug", "2");
        result.put("application", "org.apache.struts.webapp.exercise.ApplicationResources");
        result.put("detail", "2");
        result.put("config", "/WEB-INF/struts-config.xml");
        return result;
    }
}
