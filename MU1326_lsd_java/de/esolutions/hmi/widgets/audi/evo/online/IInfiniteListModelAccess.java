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
    public static final int REQUEST_ID_REMOTEHMI = Integer.MIN_VALUE;

    public boolean isVisibleAreaOverlappingForbiddenArea();

    public void updateInfiniteListData(IInfiniteListData var1, GridListRow[] var2);

    public long getFirstVisibleRowId();

    public long getLastVisibleRowId();

    public void changeAllRowsToArtificialOrOriginal();

    public void insertRowsAfter(int var1, List var2);

    public ListController getListController();

    public void setListController(ListController var1);

    public IInfiniteListListener getInfiniteListListener();

    public BaseListModelListener getBaseListListener();

    public boolean isResolvingRows();

    public boolean isResetting();

    public void checkDelayedTasks();
}

