package chapter9.recipe03.xml_ignore_certain_differences;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

public class IgnoreCatalogDetailsDifferenceListener implements DifferenceListener {
    private static final Set<String> tagNamesToIgnore = new HashSet<String>() {
        {
            add("unit-price");
            add("total-price");
            add("subtotal");
        }
    };

    @Override
    public int differenceFound(Difference difference) {
        int response = RETURN_ACCEPT_DIFFERENCE;
        int differenceId = difference.getId();

        if (differenceId == DifferenceConstants.TEXT_VALUE_ID) {
            String currentTagName = getTagName(difference.getControlNodeDetail().getNode());

            if (tagNamesToIgnore.contains(currentTagName)) {
                response = RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
            }
        } else if (differenceId == DifferenceConstants.ATTR_VALUE_ID) {
            Attr attribute = (Attr) difference.getControlNodeDetail().getNode();

            if (attribute.getName().equals("id") && attribute.getOwnerElement().getNodeName().equals("item")) {
                response = RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
            }
        }

        return response;
    }

    private String getTagName(Node node) {
        if (node instanceof Text) {
            return node.getParentNode().getNodeName();
        } else {
            return node.getNodeName();
        }
    }

    @Override
    public void skippedComparison(Node node, Node node2) {
        // Unused
    }
}
