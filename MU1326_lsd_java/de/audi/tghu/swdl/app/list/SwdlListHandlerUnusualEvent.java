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
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandler;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemUnusualEvent;

public class SwdlListHandlerUnusualEvent
extends AbstractSwdlListHandler {
    private ILoggingManager loggingManager = null;

    public SwdlListHandlerUnusualEvent(SwdlEnv swdlEnv, ILoggingManager iLoggingManager, ListModelApp listModelApp) {
        super(swdlEnv, listModelApp, listModelApp.getID(), 3);
        this.loggingManager = iLoggingManager;
    }

    final ILoggingManager getLoggingManager() {
        return this.loggingManager;
    }

    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[]{new IntegerListCell(-1, 99), new TextListCell(""), new TextListCell("")};
        return listCellArray;
    }

    public void updateList(String[] stringArray, String[] stringArray2) {
        this.logList("UnusualEvent", stringArray);
        this.adjustListLength(stringArray.length);
        if (this.checkBase()) {
            ISwdlListItem[] iSwdlListItemArray = new SwdlListItemUnusualEvent[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                iSwdlListItemArray[i2] = new SwdlListItemUnusualEvent(this.getLoggingManager(), this.getBase(), i2, stringArray[i2], stringArray2[i2]);
            }
            this.setEntries(iSwdlListItemArray);
            this.updateList();
        }
    }
}

