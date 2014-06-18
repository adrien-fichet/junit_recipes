package chapter9.recipe02.xml_ignore_order;

import com.sun.org.apache.xpath.internal.XPathAPI;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ActionServletInitializerTest {
    private final String webXml = "/chapter9/recipe02/xml_ignore_order/web.xml";

    @Test
    public void testActionServletInitializationParameters() throws Exception {
        File webXmlFile = new File(getClass().getResource(webXml).getPath());
        Document document = XMLUnit.buildTestDocument(new InputSource(new FileInputStream(webXmlFile)));
        Map expectedParameters = getExpectedParameters();
        Map<String, String> actualParameters = getInitParams(document);
        assertEquals(expectedParameters, actualParameters);
    }

    private Map<String, String> getInitParams(Document document) throws TransformerException {
        Map<String, String> result = new HashMap<String, String>();
        NodeList initParamNodes = XPathAPI.selectNodeList(document.getDocumentElement(),
                "/web-app/servlet[servlet-name='action']/init-param");
        int matchingNodes = initParamNodes.getLength();
        assertFalse("Found no nodes. Something wrong with XPath statement", matchingNodes == 0);
        appendInitParams(initParamNodes, result);
        return result;
    }

    private void appendInitParams(NodeList initParamNodes, Map<String, String> result) {
        for (int i = 0; i < initParamNodes.getLength(); i++) {
            Node currentNode = initParamNodes.item(i);
            String name = null;
            String value = null;

            NodeList childNodes = currentNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node each = childNodes.item(j);
                if ("param-name".equals(each.getNodeName())) {
                    name = getText(each);
                } else if ("param-value".equals(each.getNodeName())) {
                    value = getText(each);
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

    private String getText(Node each) {
        String nodeText = each.getFirstChild().getNodeValue();
        return (nodeText == null) ? null : nodeText.trim();
    }
}
