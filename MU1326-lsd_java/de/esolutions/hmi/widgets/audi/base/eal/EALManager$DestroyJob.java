/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode;

class EALManager$DestroyJob {
    private INode node;
    private boolean recursive;

    public EALManager$DestroyJob(INode iNode, boolean bl) {
        this.node = iNode;
        this.recursive = bl;
    }

    public INode getNode() {
        return this.node;
    }

    public boolean isRecursive() {
        return this.recursive;
    }
}

