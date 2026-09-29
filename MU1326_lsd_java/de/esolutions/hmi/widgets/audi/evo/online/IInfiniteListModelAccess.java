/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListData;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListListener;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.List;

public interface IInfiniteListModelAccess
extends IListWidgetDataAccess {
    public static final int REQUEST_ID_REMOTEHMI;

    default public boolean isVisibleAreaOverlappingForbiddenArea() {
    }

    default public void updateInfiniteListData(IInfiniteListData iInfiniteListData, GridListRow[] gridListRowArray) {
    }

    default public long getFirstVisibleRowId() {
    }

    default public long getLastVisibleRowId() {
    }

    default public void changeAllRowsToArtificialOrOriginal() {
    }

    default public void insertRowsAfter(int n, List list) {
    }

    default public ListController getListController() {
    }

    default public void setListController(ListController listController) {
    }

    default public IInfiniteListListener getInfiniteListListener() {
    }

    default public BaseListModelListener getBaseListListener() {
    }

    default public boolean isResolvingRows() {
    }

    default public boolean isResetting() {
    }

    default public void checkDelayedTasks() {
    }
}

