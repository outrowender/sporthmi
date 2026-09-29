/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.online.GridListModel$RowSubrowIterator;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.IInfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;
import java.util.List;

public class GridListModel
extends BaseListModel {
    protected static final LogChannel log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI.Grid");
    private int updateCounter;
    private IInfiniteListModelAccess modelAccess;
    private long oldUniqueID = -1L;
    private int oldCol = -1;
    private int oldTerminal = -1;

    public GridListModel(int n) {
        super(n, null);
    }

    public GridListModel(int n, MenuModel menuModel) {
        super(n, menuModel, "GridListModel");
    }

    public BaseListModelListener getListener() {
        return this.listener;
    }

    public GridListModel$RowSubrowIterator rowSubrowIterator() {
        return new GridListModel$RowSubrowIterator(this, -1, -1);
    }

    public GridListModel$RowSubrowIterator rowSubrowIterator(int n, int n2) {
        return new GridListModel$RowSubrowIterator(this, n, n2);
    }

    public GridListModel$RowSubrowIterator rowSubrowIterator(RowInfo rowInfo) {
        return new GridListModel$RowSubrowIterator(this, rowInfo.getIndex(), rowInfo.getSubindex());
    }

    public GridListRow getRowAt(int n, int n2) {
        if (n < 0 || n >= this.getLength()) {
            return null;
        }
        GridListRow gridListRow = (GridListRow)this.getGuiRow(n);
        if (n2 == -1) {
            return gridListRow;
        }
        List list = gridListRow.getRowsToInsertIfOffscreen();
        if (n2 < 0 || n2 >= list.size()) {
            return null;
        }
        return (GridListRow)list.get(n2);
    }

    public RowInfo getRowInfo(int n, int n2) {
        GridListRow gridListRow;
        if (n < 0) {
            return RowInfo.ILLEGAL;
        }
        GridListRow gridListRow2 = this.getRowAt(n, -1);
        GridListRow gridListRow3 = gridListRow = n2 == -1 ? gridListRow2 : this.getRowAt(n, n2);
        if (gridListRow == null || gridListRow2 == null) {
            String string = new StringBuffer().append("GridListModel.getRowInfo: null row detected, list structure corrupt: index=").append(n).append(", subindex=").append(n2).append(", row=").append(gridListRow).append(", parent=").append(gridListRow2).toString();
            throw new IllegalStateException(string);
        }
        return new RowInfo(n, n2, gridListRow2, gridListRow);
    }

    public RowInfo getRowInfoAfter(int n, int n2) {
        int n3 = n2 + 1;
        GridListRow gridListRow = this.getRowAt(n, n3);
        if (gridListRow != null) {
            return this.getRowInfo(n, n3);
        }
        int n4 = n + 1;
        if (n4 >= this.getLength()) {
            return RowInfo.ILLEGAL;
        }
        n3 = -1;
        return this.getRowInfo(n4, n3);
    }

    public RowInfo getRowInfoBefore(int n, int n2) {
        int n3 = n2 - 1;
        if (n3 >= -1) {
            return this.getRowInfo(n, n3);
        }
        n3 = -1;
        int n4 = n - 1;
        GridListRow gridListRow = this.getRowAt(n4, -1);
        if (gridListRow == null) {
            return RowInfo.ILLEGAL;
        }
        int n5 = gridListRow.getRowsToInsertIfOffscreen().size();
        n3 = n5 == 0 ? -1 : n5 - 1;
        return this.getRowInfo(n4, n3);
    }

    public RowInfo getLastRowInfo() {
        int n = this.getLength() - 1;
        if (n == -1) {
            return RowInfo.ILLEGAL;
        }
        GridListRow gridListRow = (GridListRow)this.getGuiRow(n);
        int n2 = gridListRow.getRowsToInsertIfOffscreen().size();
        int n3 = n2 == 0 ? -1 : n2 - 1;
        return this.getRowInfo(n, n3);
    }

    public int getUpdate() {
        return this.updateCounter;
    }

    public int nextUpdate() {
        ++this.updateCounter;
        return this.updateCounter;
    }

    public int findUniqueIdAmongDisplayedRows(int n, int n2) {
        int n3 = n + n2;
        int n4 = this.getID();
        int n5 = this.getIndexForUniqueID(n4 * (this.updateCounter + 1) + n3);
        if (n5 != -1) {
            return n5;
        }
        int n6 = this.getLength();
        for (int i2 = 0; i2 < n6; ++i2) {
            GridListRow gridListRow = (GridListRow)this.getGuiRow(i2);
            n5 = (int)gridListRow.getUniqueID();
            if (n5 % n4 != n3) continue;
            return n5;
        }
        return -1;
    }

    public RowInfo getFirstRowInfo() {
        if (this.getLength() <= 0) {
            return RowInfo.ILLEGAL;
        }
        return this.getRowInfo(0, -1);
    }

    public int getAbsoluteIndexOfRow(GridListRow gridListRow) {
        int n = this.getID();
        return (int)(gridListRow.getUniqueID() % (long)n);
    }

    public void setModelAccess(IInfiniteListModelAccess iInfiniteListModelAccess) {
        this.modelAccess = iInfiniteListModelAccess;
    }

    @Override
    public void itemFocused(long l, int n, int n2) {
        if (this.modelAccess != null && (this.modelAccess.isResolvingRows() || this.modelAccess.isResetting())) {
            this.oldUniqueID = l;
            this.oldCol = n;
            this.oldTerminal = n2;
            return;
        }
        super.itemFocused(l, n, n2);
        if (this.modelAccess != null) {
            this.modelAccess.checkDelayedTasks();
        }
    }

    public void notifyResolvingRowsAndResettingFinished() {
        if (this.oldUniqueID != -1L) {
            log.log(1078071040, "GridListModel#notifyResolvingRowsAndResettingFinished: setting focused item to cached unique ID %1. (absolute index=%2)", this.oldUniqueID, this.oldUniqueID % (long)this.getID());
            super.itemFocused(this.oldUniqueID, this.oldCol, this.oldTerminal);
            this.clearCacheForFocusedItem();
            this.modelAccess.checkDelayedTasks();
        }
    }

    public void clearCacheForFocusedItem() {
        this.oldUniqueID = -1L;
    }
}

