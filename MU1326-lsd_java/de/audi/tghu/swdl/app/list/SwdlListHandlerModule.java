/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerDeviceInfo;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemModule;

public class SwdlListHandlerModule
extends AbstractSwdlListHandlerDeviceInfo {
    static final int ITEM_CELL_COUNT;

    public SwdlListHandlerModule(SwdlEnv swdlEnv, IDeviceInfoManager iDeviceInfoManager, ListModelApp listModelApp) {
        super(iDeviceInfoManager, swdlEnv, listModelApp, listModelApp.getID(), 6);
    }

    @Override
    public ListCell[] getNewRow() {
        ListCell[] listCellArray = super.getNewRow();
        listCellArray[4] = new TextListCell("");
        listCellArray[5] = new IntegerListCell(-1, 0);
        return listCellArray;
    }

    public void updateList(String[] stringArray, int[] nArray, short[] sArray) {
        this.logList("Module", stringArray);
        this.adjustListLength(stringArray.length);
        if (this.checkBase()) {
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemModule[stringArray.length];
            int n = this.getLayout();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                iSwdlListItemArray[i2] = new SwdlListItemModule(this.getDeviceInfoManager(), this.getBase(), i2, stringArray[i2], nArray[i2], sArray[i2], this.getTextFactory(), n);
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }
}

