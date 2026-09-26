/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandler;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemRelease;

public class SwdlListHandlerRelease
extends AbstractSwdlListHandler {
    private ISelectionManager selectionManager = null;
    private Object syncObj = new Object();

    public SwdlListHandlerRelease(SwdlEnv swdlEnv, ISelectionManager iSelectionManager, ListModelApp listModelApp) {
        super(swdlEnv, listModelApp, listModelApp.getID(), 2);
        this.selectionManager = iSelectionManager;
    }

    final ISelectionManager getSelectionlManager() {
        return this.selectionManager;
    }

    @Override
    public ListCell[] getNewRow() {
        ListCell[] listCellArray = new ListCell[]{new IntegerListCell(-1, 99), new TextListCell("")};
        return listCellArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateList(String[] stringArray) {
        Object object = this.syncObj;
        synchronized (object) {
            if (stringArray == null) {
                return;
            }
            this.logList("Release", stringArray);
            this.adjustListLength(stringArray.length);
            if (this.checkBase()) {
                ISwdlListItem[] iSwdlListItemArray = new SwdlListItemRelease[stringArray.length];
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    iSwdlListItemArray[i2] = new SwdlListItemRelease(this.getSelectionlManager(), this.getBase(), i2, stringArray[i2]);
                }
                this.setEntries(iSwdlListItemArray);
                this.updateList();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ISwdlListItem getEntry(int n) {
        Object object = this.syncObj;
        synchronized (object) {
            return super.getEntry(n);
        }
    }
}

