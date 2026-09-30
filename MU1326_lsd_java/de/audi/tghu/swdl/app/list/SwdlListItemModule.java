/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListItemDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;

public class SwdlListItemModule
extends AbstractSwdlListItemDeviceInfo {
    boolean isNoExclusiveBoloUpdate;
    int additionalInfo;
    short hwIndex;

    public SwdlListItemModule(IDeviceInfoManager iDeviceInfoManager, ISwdlListItem iSwdlListItem, int n, String string, int n2, short s, AbstractSwdlTextFactory abstractSwdlTextFactory, int n3) {
        super(iDeviceInfoManager, iSwdlListItem, n, string, abstractSwdlTextFactory, ((AbstractSwdlListItemDeviceInfo)iSwdlListItem).isAvailable() && 4 != n2);
        this.additionalInfo = n2;
        this.setIsNoExclusiveBoloUpdate(false);
        this.hwIndex = s;
        this.setLayout(n3);
    }

    public final void setIsNoExclusiveBoloUpdate(boolean bl) {
        this.isNoExclusiveBoloUpdate = bl;
    }

    public void updateListRow(BaseListRow baseListRow) {
        super.updateListRow(baseListRow);
        baseListRow.setText(4, Integer.toString(this.hwIndex));
        baseListRow.setInteger(5, this.additionalInfo);
    }

    public void select(int n) {
        this.deviceInfoManager.doSelectModule(n);
    }

    public String getSwdlClassName() {
        return "[SwdlModule]";
    }
}

