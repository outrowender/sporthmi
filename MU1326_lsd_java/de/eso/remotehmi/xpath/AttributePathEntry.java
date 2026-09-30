/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

public class AttributePathEntry
extends AbstractPathEntry {
    public AttributePathEntry(String string) {
        super(string, null);
    }

    public void match(Map map, Node node, List list) {
        if (node.getAttributes() != null && node.getAttributes().getNamedItem(this.name) != null) {
            list.add(node.getAttributes().getNamedItem(this.name));
        }
    }
}

