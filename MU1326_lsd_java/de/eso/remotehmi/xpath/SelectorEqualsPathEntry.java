/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import de.eso.remotehmi.xpath.AbstractPathEntry;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

public class SelectorEqualsPathEntry
extends AbstractPathEntry {
    public final String left;
    public final String right;

    public SelectorEqualsPathEntry(String string, String string2) {
        super(null, null);
        this.left = string;
        this.right = string2;
    }

    @Override
    public void match(Map map, Node node, List list) {
        if (node.getAttributes().getNamedItem(this.left) == null) {
            return;
        }
        String string = node.getAttributes().getNamedItem(this.left).getNodeValue();
        if (string != null && this.right != null && string.equals(this.right)) {
            list.add(node);
        }
    }
}

