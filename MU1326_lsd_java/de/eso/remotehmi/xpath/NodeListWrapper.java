/*
 * Decompiled with CFR 0.152.
 */
package de.eso.remotehmi.xpath;

import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListWrapper
implements NodeList {
    private final List list;

    public NodeListWrapper(List list) {
        this.list = list;
    }

    @Override
    public Node item(int n) {
        return (Node)this.list.get(n);
    }

    @Override
    public int getLength() {
        return this.list.size();
    }
}

