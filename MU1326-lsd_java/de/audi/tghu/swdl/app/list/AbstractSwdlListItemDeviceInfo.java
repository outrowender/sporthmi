/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemText;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public abstract class AbstractSwdlListItemDeviceInfo
extends AbstractSwdlListItemText {
    protected final IDeviceInfoManager deviceInfoManager;
    protected final boolean isAvailable;

    public AbstractSwdlListItemDeviceInfo(IDeviceInfoManager iDeviceInfoManager, ISwdlListItem iSwdlListItem, int n, String string, AbstractSwdlTextFactory abstractSwdlTextFactory, boolean bl) {
        super(iSwdlListItem, n, string, abstractSwdlTextFactory);
        this.deviceInfoManager = iDeviceInfoManager;
        this.isAvailable = bl;
    }

    IDeviceInfoManager getDeviceInfoManager() {
        return this.deviceInfoManager;
    }

    @Override
    public void updateListRow(BaseListRow baseListRow) {
        baseListRow.setInteger(0, this.getId());
        baseListRow.setText(1, this.getName());
        baseListRow.setInteger(2, this.getSelectable() ? 1 : 0);
        baseListRow.setInteger(3, this.getLayout());
    }

    protected boolean isAvailable() {
        return this.isAvailable;
    }
}

