/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandlerText;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemHistory;

public class SwdlListHandlerHistory
extends AbstractSwdlListHandlerText {
    private ILoggingManager loggingManager = null;

    public SwdlListHandlerHistory(SwdlEnv swdlEnv, ILoggingManager iLoggingManager, ListModelApp listModelApp) {
        super(swdlEnv, listModelApp, listModelApp.getID(), 5);
        this.loggingManager = iLoggingManager;
    }

    final ILoggingManager getLoggingManager() {
        return this.loggingManager;
    }

    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[this.getNrCol()];
        listCellArray[0] = new IntegerListCell(-1, 99);
        listCellArray[1] = new TextListCell("");
        listCellArray[2] = new TextListCell("");
        listCellArray[3] = new IntegerListCell(-1, 99);
        listCellArray[4] = new TextListCell("");
        return listCellArray;
    }

    public void updateList(String[] stringArray, int[] nArray) {
        this.logList("History", stringArray);
        this.adjustListLength(stringArray.length);
        if (this.checkBase()) {
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemHistory[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2].substring(17);
                String string2 = stringArray[i2].substring(0, 16);
                iSwdlListItemArray[i2] = new SwdlListItemHistory(this.getLoggingManager(), this.getBase(), i2, string, string2, nArray[i2], this.getTextFactory());
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }
}

