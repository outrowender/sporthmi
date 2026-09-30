/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.ByteSizeProvider;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;

class GenericPkgRow
extends AbstractPkgListRow {
    protected static final int COLUMNS = 9;
    protected static final int IDX_ROW_ID = 0;
    protected static final int IDX_COMPONENT_NAME = 1;
    protected static final int IDX_COMPONENT_SIZE = 2;
    protected static final int IDX_COMPONENT_SELECTED = 3;
    protected static final int IDX_COMPONENT_VERSION = 4;
    protected static final int IDX_COMPONENT_SELECTED_SUBCOMPONENTS = 5;
    protected static final int IDX_COMPONENT_MAX_SUBCOMPONENTS = 6;
    protected static final int IDX_GROUP_ROW = 7;
    protected static final int IDX_ENABLED = 8;
    private final boolean isSystemPackage;

    GenericPkgRow(PkgNode pkgNode) {
        super(pkgNode, 9);
        this.isSystemPackage = pkgNode.isSystemPackage();
    }

    void setValues() {
        super.setLong(0, this.node.getRowId());
        super.setText(1, this.node.getDisplayName());
        super.setText(2, ByteSizeProvider.getByteSize(this.node.getSize()).format());
        super.setInteger(3, this.node.isSelected() || this.node.hasSelectedChildren() || this.node.isPPOI() && !this.node.isSelectable() ? 1 : 0);
        super.setText(4, this.node.getVersion());
        super.setText(5, Integer.toString(this.node.getSelectedCount()));
        if (this.node.getSelectedCount() == 0 && this.node.getMaxBusinessCount() == 0) {
            super.setText(6, "0");
        } else {
            super.setText(6, Integer.toString(this.node.getMaxCount()));
        }
        super.setInteger(7, this.node.isLeaf() ? 0 : 1);
        super.setInteger(8, this.node.isSelectable() ? 1 : 0);
    }

    boolean isSystemPackage() {
        return this.isSystemPackage;
    }

    void setSelectable(boolean bl) {
        super.setInteger(8, this.isSelectable() ? 1 : 0);
    }

    public EvoListRow copy() {
        return new GenericPkgRow(this.node);
    }
}

