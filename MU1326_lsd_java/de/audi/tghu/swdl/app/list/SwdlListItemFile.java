/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemFile
extends AbstractSwdlListItemDeviceInfo {
    private static final int CHECKED = 1;
    private static final int UNCHECKED = 0;
    private int checked = 0;
    private int additionalInfo;
    private long currentVersion;
    private long targetVersion;
    private boolean enabled;
    private boolean isSelection;

    public SwdlListItemFile(IDeviceInfoManager iDeviceInfoManager, ISwdlListItem iSwdlListItem, int n, String string, AbstractSwdlTextFactory abstractSwdlTextFactory, int n2, boolean bl) {
        super(iDeviceInfoManager, iSwdlListItem, n, string, abstractSwdlTextFactory, ((AbstractSwdlListItemDeviceInfo)iSwdlListItem).isAvailable());
        this.setLayout(n2);
        this.enabled = bl && this.isAvailable();
        this.isSelection = iDeviceInfoManager.checkAccessType(1) && n2 == 0;
    }

    public long getVersion() {
        return this.currentVersion;
    }

    public void setVersion(long l) {
        this.currentVersion = l;
    }

    public long getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(long l) {
        this.targetVersion = l;
    }

    public void setAdditionalInfo(int n) {
        this.additionalInfo = n;
        this.checked = this.isAvailable() && (n == 1 || n == 6) ? 1 : 0;
    }

    public boolean isChecked() {
        return this.checked == 1;
    }

    public void select(int n) {
        this.getDeviceInfoManager().doSelectFile(n);
    }

    static ListCell getNewListCell(int n) {
        return new IntegerListCell(-1, 99);
    }

    private boolean isEnabled() {
        return this.enabled && (this.getVersion() != 0L || this.getTargetVersion() != 0L) && this.additionalInfo != 3 && this.additionalInfo != 4;
    }

    public void updateListRow(BaseListRow baseListRow) {
        super.updateListRow(baseListRow);
        baseListRow.setInteger(2, !this.isSelection || this.isEnabled() ? 1 : 0);
        baseListRow.setInteger(4, 1);
        baseListRow.setText(5, SwdlEnv.formatVersion(this.getVersion()));
        baseListRow.setText(6, SwdlEnv.formatVersion(this.getTargetVersion()));
        baseListRow.setInteger(7, this.checked);
        baseListRow.setInteger(8, this.additionalInfo);
    }

    public String getSwdlClassName() {
        return "[SwdlFile]";
    }
}

