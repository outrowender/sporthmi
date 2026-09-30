/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemDevice;

public class SwdlListHandlerDevice
extends AbstractSwdlListHandlerDeviceInfo {
    private static final int ITEM_CELL_COUNT = 5;

    public SwdlListHandlerDevice(SwdlEnv swdlEnv, IDeviceInfoManager iDeviceInfoManager, ListModelApp listModelApp) {
        super(iDeviceInfoManager, swdlEnv, listModelApp, listModelApp.getID(), 5);
    }

    public ListCell[] getNewRow() {
        ListCell[] listCellArray = super.getNewRow();
        listCellArray[4] = new IntegerListCell(-1, 0);
        return listCellArray;
    }

    public void updateList(String[] stringArray, int[] nArray) {
        this.logList("Device", stringArray);
        this.adjustListLength(stringArray.length);
        if (this.checkBase()) {
            int n = this.getLayout();
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemDevice[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                iSwdlListItemArray[i2] = new SwdlListItemDevice(this.getDeviceInfoManager(), this.getBase(), i2, stringArray[i2], nArray[i2], this.getTextFactory(), n);
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }
}

