/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

import org.apache.commons.id.uuid.state.Node;

public interface NodeManager {
    public Node currentNode();

    public Node nextAvailableNode();

    public void lockNode(Node var1);

    public void releaseNode(Node var1);
}

