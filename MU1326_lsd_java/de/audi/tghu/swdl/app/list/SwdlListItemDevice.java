/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemDevice
extends AbstractSwdlListItemDeviceInfo {
    private int additionalInfo;

    public SwdlListItemDevice(IDeviceInfoManager iDeviceInfoManager, ISwdlListItem iSwdlListItem, int n, String string, int n2, AbstractSwdlTextFactory abstractSwdlTextFactory, int n3) {
        super(iDeviceInfoManager, iSwdlListItem, n, string, abstractSwdlTextFactory, 4 != n2);
        this.additionalInfo = n2;
        this.setLayout(n3);
    }

    IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    public String getExpandedName() {
        return this.getName();
    }

    public void updateListRow(BaseListRow baseListRow) {
        super.updateListRow(baseListRow);
        baseListRow.setInteger(4, this.additionalInfo);
    }

    public void select(int n) {
        this.deviceInfoManager.doSelectDevice(n);
    }

    public String getSwdlClassName() {
        return "[SwdlDevice]";
    }
}

