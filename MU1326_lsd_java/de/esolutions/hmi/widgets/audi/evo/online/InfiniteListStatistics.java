/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.online.GridListModel;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.InfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;

public class InfiniteListStatistics {
    protected static final LogChannel log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI.Grid");
    public static final int ROW_NON_DELETED_FIRST = 0;
    public static final int ROW_NON_DELETED_LAST = 1;
    public static final int ROW_BEGIN_PROXY_LAST = 2;
    public static final int ROW_END_PROXY_FIRST = 3;
    public static final int ROW_PREVIOUS_REQUEST_END_PROXY_FIRST = 4;
    public static final int ROW_PREVIOUS_REQUEST_OVERLAP_LAST = 5;
    public static final int ROW_NEXT_REQUEST_OVERLAP_FIRST = 6;
    public static final int ROW_NEXT_REQUEST_BEGIN_PROXY_LAST = 7;
    public static final int ROW_COUNT = 8;
    private RowData[] dataArray = new RowData[8];
    private boolean isDirty;

    public InfiniteListStatistics() {
        this.dataArray[0] = new RowData("first row in list which is not marked as deleted", Integer.MAX_VALUE);
        this.dataArray[1] = new RowData("last row in list which is not marked as deleted", Integer.MAX_VALUE);
        this.dataArray[2] = new RowData("last row of beginning proxy area", Integer.MAX_VALUE);
        this.dataArray[3] = new RowData("first row of end proxy area", Integer.MAX_VALUE);
        this.dataArray[4] = new RowData("first row of end proxy area when running a previous request", 5);
        this.dataArray[5] = new RowData("last row of overlap area when running a previous request", 5);
        this.dataArray[7] = new RowData("last row of beginning proxy area when running a next request", 3);
        this.dataArray[6] = new RowData("first row of overlap area when running a next request", 3);
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    public void setDirty(boolean bl) {
        this.isDirty = bl;
    }

    private void warnIfDirty() {
        if (this.isDirty) {
            log.log(100000, "InfiniteListStatistics#warnIfDirty: Underlying model was changed. Statistic is unreliable and should only be queried after indices are updated");
        }
    }

    public String getRowDataName(int n) {
        return this.dataArray[n].name;
    }

    public RowInfo getRowInfo(int n) {
        this.warnIfDirty();
        RowData rowData = this.dataArray[n];
        RowInfo rowInfo = rowData.info;
        if (rowInfo == null) {
            log.log(100000, "InfiniteListStatistics#getRowInfo: requested row info does not exist. Name='%1', uniqueId=%2.", (Object)rowData.name, rowData.uniqueId);
        }
        return rowInfo;
    }

    public GridListRow getRow(int n) {
        GridListRow gridListRow;
        RowInfo rowInfo = this.getRowInfo(n);
        GridListRow gridListRow2 = gridListRow = rowInfo == null ? null : rowInfo.getRow();
        if (gridListRow == null) {
            RowData rowData = this.dataArray[n];
            log.log(100000, "InfiniteListStatistics#getRow: requested row does not exist. Name='%1', uniqueId=%2.", (Object)rowData.name, rowData.uniqueId);
        }
        return gridListRow;
    }

    public int getModelIndex(int n) {
        int n2;
        this.warnIfDirty();
        RowInfo rowInfo = this.getRowInfo(n);
        int n3 = n2 = rowInfo == null ? -1 : rowInfo.getIndex();
        if (n2 == -1) {
            RowData rowData = this.dataArray[n];
            log.log(100000, "InfiniteListStatistics#getModelIndex: requested model index does not exist. Name='%1', uniqueId=%2.", (Object)rowData.name, rowData.uniqueId);
        }
        return n2;
    }

    public long getUniqueId(int n) {
        return this.dataArray[n].uniqueId;
    }

    private void setUniqueId(int n, long l) {
        this.dataArray[n].uniqueId = l;
    }

    public void updateInfo(long l, RowInfo rowInfo) {
        for (int i2 = 0; i2 < 8; ++i2) {
            RowData rowData = this.dataArray[i2];
            if (l != rowData.uniqueId) continue;
            rowData.info = rowInfo;
        }
    }

    public void update(GridListModel gridListModel, int n) {
        this.clearRowInfo();
        GridListModel.RowSubrowIterator rowSubrowIterator = gridListModel.rowSubrowIterator();
        while (rowSubrowIterator.hasNext()) {
            GridListRow gridListRow = (GridListRow)rowSubrowIterator.next();
            if (gridListRow.isDeletableIfOffscreen()) continue;
            this.updateInfo(gridListRow.getUniqueID(), rowSubrowIterator.previousRowInfo());
        }
        this.checkForUnsetValues(n);
        this.isDirty = false;
    }

    private void clearRowInfo() {
        for (int i2 = 0; i2 < 8; ++i2) {
            this.dataArray[i2].info = null;
        }
    }

    private void checkForUnsetValues(int n) {
        for (int i2 = 0; i2 < 8; ++i2) {
            boolean bl;
            RowData rowData = this.dataArray[i2];
            boolean bl2 = bl = (rowData.checkFor & n) == n;
            if (!bl || rowData.info != null) continue;
            InfiniteListModelAccess.log.log(100000, "InfiniteListStatistics#checkForUnsetValues: value was not updated. Name='%1', uniqueId=%2, requestType=%3(bit1=next, bit2=previous).", (Object)rowData.name, rowData.uniqueId, (long)n);
        }
    }

    public void correctForDeletedBoundaries(int n) {
        if (n == 2) {
            this.copyVariableValuesFromTo(7, 2);
            this.copyVariableValuesFromTo(6, 0);
        } else if (n == 4) {
            this.copyVariableValuesFromTo(4, 3);
            this.copyVariableValuesFromTo(5, 1);
        }
    }

    private void copyVariableValuesFromTo(int n, int n2) {
        this.dataArray[n2].info = this.dataArray[n].info;
        this.dataArray[n2].uniqueId = this.dataArray[n].uniqueId;
    }

    public void updateIdByNewList(GridListRow[] gridListRowArray, int n, int n2) {
        int n3 = gridListRowArray.length;
        if (n3 < n2) {
            log.log(100000, "InfiniteListStatistics#updateIdByNewList: illegal arrayLength, it must be greater or equal than overlapSize. arrayLength=%1, overlapSize=%2.", (long)n3, (long)n2);
        }
        if (n2 <= 2 * n) {
            log.log(100000, "InfiniteListStatistics#updateIdByNewList: illegal overlapSize, it must be bigger than 2 * proxyRange. overlapSize=%1, proxyRange=%2.", (long)n2, (long)n);
        }
        this.setUniqueId(0, gridListRowArray[0].getUniqueID());
        this.setUniqueId(1, gridListRowArray[n3 - 1].getUniqueID());
        this.setUniqueId(2, gridListRowArray[n - 1].getUniqueID());
        this.setUniqueId(3, gridListRowArray[n3 - n].getUniqueID());
        this.setUniqueId(5, gridListRowArray[n2 - 1].getUniqueID());
        this.setUniqueId(6, gridListRowArray[n3 - n2].getUniqueID());
        this.setUniqueId(7, gridListRowArray[n3 - n2 + n - 1].getUniqueID());
        this.setUniqueId(4, gridListRowArray[n2 - n].getUniqueID());
    }

    private static class RowData {
        public String name;
        public long uniqueId;
        public RowInfo info;
        public int checkFor;

        public RowData(String string, int n) {
            this.name = string;
            this.checkFor = n;
            this.uniqueId = -1L;
            this.info = null;
        }
    }
}

