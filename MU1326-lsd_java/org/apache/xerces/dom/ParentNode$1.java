/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import org.apache.xerces.dom.ParentNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ParentNode$1
implements NodeList {
    private final /* synthetic */ ParentNode this$0;

    ParentNode$1(ParentNode parentNode) {
        this.this$0 = parentNode;
    }

    @Override
    public int getLength() {
        return ParentNode.access$000(this.this$0);
    }

    @Override
    public Node item(int n) {
        return ParentNode.access$100(this.this$0, n);
    }
}

