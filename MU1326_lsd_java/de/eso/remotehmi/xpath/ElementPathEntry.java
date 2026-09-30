/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

class ElementPathEntry
extends AbstractPathEntry {
    public ElementPathEntry(String string, String string2) {
        super(string, string2);
    }

    public void match(Map map, Node node, List list) {
        String string = this.ns;
        if (this.ns != null && this.ns.length() > 0 && map != null) {
            string = (String)map.get(this.ns);
        }
        if (string == null) {
            string = "";
        }
        if (node == null) {
            return;
        }
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); ++i2) {
            Node node2 = node.getChildNodes().item(i2);
            if (node2 == null) continue;
            if (string.length() == 0) {
                if (this.name == null || !this.name.equals(node2.getLocalName())) continue;
                list.add(node2);
                continue;
            }
            if (this.name == null || !this.name.equals(node2.getLocalName()) || !string.equals(node2.getNamespaceURI())) continue;
            list.add(node2);
        }
    }
}

