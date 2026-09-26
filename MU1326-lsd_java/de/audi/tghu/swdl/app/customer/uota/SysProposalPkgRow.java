/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.ByteSizeProvider;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.esolutions.fw.util.commons.Buffer;

public class SysProposalPkgRow
extends AbstractPkgListRow {
    protected static final int COLUMNS;
    protected static final int IDX_ROW_ID;
    protected static final int IDX_ENABLED;
    protected static final int IDX_COMPONENT_NAME;
    protected static final int IDX_COMPONENT_SIZE;
    protected static final int IDX_COMPONENT_SELECTED;
    protected static final int IDX_GROUP_ROW;
    protected static final int IDX_ADD_INFOS;
    protected static final int IDX_LAYOUT;
    static final int LAYOUT_NORMAL_WITH_SIZE_AND_CHECKBOX;
    static final int LAYOUT_UPTODATE_WITHOUT_CHECKBOX;
    static final int LAYOUT_NORMAL_WIHOUT_SIZE_WITH_CHECKBOX;

    public SysProposalPkgRow(PkgNode pkgNode) {
        super(pkgNode, 8);
    }

    @Override
    void setValues() {
        super.setLong(0, this.node.getRowId());
        super.setText(2, this.node.getDisplayName());
        super.setText(3, ByteSizeProvider.getByteSize(this.node.getSize()).format());
        super.setText(6, this.node.getAdditionalInfos());
        this.setLayout();
    }

    protected void setLayout() {
        int n = -1;
        boolean bl = true;
        boolean bl2 = this.node.isSelected();
        if (this.node.hidePackageSize()) {
            n = 2;
            if (this.node.isSelectable()) {
                if (!this.node.isAllowedForSelection()) {
                    bl = false;
                    super.setText(6, this.getInfoTextUpdateUnavailable());
                } else {
                    bl = true;
                }
            } else {
                bl2 = true;
                bl = false;
                super.setText(6, this.getInfoTextAlreadyInstalled());
            }
        } else if (this.node.isSelectable()) {
            n = 0;
            bl = true;
        } else {
            n = 1;
            bl = false;
            bl2 = false;
        }
        super.setInteger(7, n);
        super.setInteger(4, bl2 ? 1 : 0);
        super.setInteger(1, bl ? 1 : 0);
    }

    protected String getInfoTextUpdateUnavailable() {
        if (null != this.node.getUotaController() && null != this.node.getUotaController().getSwdlEnv()) {
            return this.node.getUotaController().getSwdlEnv().getTextFactory().getTextConstantCustUotaUpdateUnavailable();
        }
        return "";
    }

    protected String getInfoTextAlreadyInstalled() {
        if (null != this.node.getUotaController() && null != this.node.getUotaController().getSwdlEnv()) {
            return this.node.getUotaController().getSwdlEnv().getTextFactory().getTextConstantCustUotaAlreadyInstalled();
        }
        return "";
    }

    private void dumpState() {
        Buffer buffer = new Buffer();
        buffer.append(super.getText(2));
        buffer.append(",node=").append(this.node.hashCode());
        buffer.append(",hideSize=").append(this.node.hidePackageSize());
        buffer.append(",class=").append(super.getClass().getName().substring(super.getClass().getName().lastIndexOf(46) + 1));
        buffer.append(",layout=").append(super.getInteger(7));
        buffer.append(",enabled=").append(super.getInteger(1));
        buffer.append(",selectable=").append(this.node.isSelectable());
        buffer.append(",selected=").append(super.getInteger(4));
        buffer.append(",infotext=").append(super.getText(6));
        System.out.println(buffer);
    }

    @Override
    public EvoListRow copy() {
        return new SysProposalPkgRow(this.node);
    }
}

