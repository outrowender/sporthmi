/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.online.ModelDescription;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.util.RangeCounter;

public class GridHelper {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void updateListModelTransaction(ListModelApp listModelApp, IGridList iGridList, Object object, int n, int n2, LogChannel logChannel) {
        String string = ModelDescription.getList(listModelApp.getID());
        logChannel.log(1000000, "GridHelper#updateListModelTransaction: triggered grid list repaint. grid list range start = %1. List model = '%2'. Listener = %3", (Object)new Integer(iGridList.getIdRangeStart()), (Object)string, object);
        if (n == 0) {
            logChannel.log(1000000, "GridHelper#updateListModelTransaction: skipping update mode %1 (nothing to do)", (long)n);
            return;
        }
        IGridList iGridList2 = iGridList;
        synchronized (iGridList2) {
            iGridList.setListener(object);
            int n3 = iGridList.addUpdateMode(n);
            int n4 = iGridList.getUpdateMode();
            if (n3 != 0 && n3 != n4) {
                logChannel.log(1000000, "GridHelper#updateListModelTransaction: old pending update mode %1 overridden with mode %2", (long)n3, (long)n4);
            }
            iGridList.setUpdateSource(n2);
        }
        try {
            listModelApp.beginTransaction();
            GridHelper.updateListModel(listModelApp, iGridList);
        }
        finally {
            listModelApp.endTransaction();
        }
    }

    private static void updateListModel(ListModelApp listModelApp, IGridList iGridList) {
        if (iGridList == null) {
            throw new IllegalArgumentException("need gridList!");
        }
        listModelApp.clear();
        listModelApp.setMaxColumns(1);
        listModelApp.setMaxRows(1);
        ListCell[] listCellArray = new ListCell[]{new ObjectListCell(iGridList)};
        listModelApp.addRow(listCellArray);
    }

    public static void setNewIdRange(IGridList iGridList, RangeCounter rangeCounter, int n, LogChannel logChannel) {
        try {
            iGridList.setNewIdRange(rangeCounter, n);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            logChannel.log(10000, "GridHelper#setNewIdRange: model ID range too small for grid list, selected item cannot be identified properly and may lead to wrong actions. Details: %1.", (Object)illegalArgumentException.toString());
        }
    }

    public static void setNewIdRange(IGridList iGridList, RangeCounter rangeCounter, LogChannel logChannel) {
        GridHelper.setNewIdRange(iGridList, rangeCounter, iGridList.size(), logChannel);
    }
}

