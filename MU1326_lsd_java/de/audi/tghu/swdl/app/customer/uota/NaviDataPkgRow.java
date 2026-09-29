/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.SysProposalPkgRow;

class NaviDataPkgRow
extends SysProposalPkgRow {
    public NaviDataPkgRow(PkgNode pkgNode) {
        super(pkgNode);
    }

    @Override
    void setValues() {
        super.setValues();
        super.setInteger(5, this.node.isLeaf() ? 0 : 1);
    }

    @Override
    public EvoListRow copy() {
        return new NaviDataPkgRow(this.node);
    }
}

