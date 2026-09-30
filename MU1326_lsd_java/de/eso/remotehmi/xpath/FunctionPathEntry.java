/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class FunctionPathEntry
extends AbstractPathEntry {
    public FunctionPathEntry(String string) {
        super(string, null);
    }

    public void match(Map map, Node node, List list) {
        if (!this.name.equals("text()")) {
            throw new RuntimeException("Unknown function.");
        }
        String string = this.collectTextNodes(node);
        Text text = node.getOwnerDocument().createTextNode(string);
        list.add(text);
    }

    private String collectTextNodes(Node node) {
        if (node == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); ++i2) {
            Node node2 = node.getChildNodes().item(i2);
            if (!(node2 instanceof Text)) {
                throw new RuntimeException("Invalid child element found.");
            }
            stringWriter.write(node2.getNodeValue());
        }
        return stringWriter.toString();
    }
}

