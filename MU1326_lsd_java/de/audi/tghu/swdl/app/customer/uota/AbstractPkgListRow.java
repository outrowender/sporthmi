/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;

abstract class AbstractPkgListRow
extends EvoListRow {
    PkgNode node;
    static final int ENABLED = 1;
    static final int DISABLED = 0;

    AbstractPkgListRow(PkgNode pkgNode, int n) {
        super(pkgNode.getRowId(), n);
        this.node = pkgNode;
        this.setValues();
    }

    boolean isSelectable() {
        return this.node.isSelectable();
    }

    boolean isPkgGroup() {
        return !this.node.isLeaf();
    }

    int getPkgIndex() {
        return this.node.getIndex();
    }

    PkgNode getNode() {
        return this.node;
    }

    abstract void setValues();
}

