/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.BufferedFolderListModel;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ModelException;
import de.audi.atip.hmi.modelaccess.BufferedFolderListModelApp;
import de.audi.atip.hmi.modelaccess.FolderListContentModelApp;
import de.audi.atip.log.LogChannel;

public class BufferedFolderListContentModel
extends BufferedListModel
implements FolderListContentModelApp {
    public static final int INDEX_ROW_ID;
    public static final int INDEX_FOLDER_ID;
    public static final int INDEX_IS_FOLDER;
    public static final int INDEX_LD_OPEN;
    public static final int INDEX_LD_CLOSED;
    public static final int INDEX_RS;
    private final BufferedFolderListModel viewModel;
    private final LogChannel lc;

    public BufferedFolderListContentModel(LogChannel logChannel, BufferedFolderListModelApp bufferedFolderListModelApp) {
        super(-1);
        this.lc = logChannel;
        this.viewModel = (BufferedFolderListModel)bufferedFolderListModelApp;
        this.viewModel.setContentModel(this);
    }

    @Override
    public void addRow(ListCell listCell) {
        throw new ModelException((HMIModel)this, "Single column rows are not supported!");
    }

    @Override
    public void addRow(BaseListRow baseListRow) {
        super.addRow(baseListRow);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.addRow] Ignored because transaction is running.");
            return;
        }
        this.setViewFolderState(baseListRow);
        this.viewModel.addRow(baseListRow);
    }

    private void setViewFolderState(BaseListRow baseListRow) {
        if (BufferedFolderListContentModel.isFolder(baseListRow)) {
            int n;
            int n2;
            int n3 = baseListRow.getInteger(1);
            if (this.viewModel.isOpen(n3)) {
                n2 = 1;
                n = 3;
            } else {
                n2 = 2;
                n = 4;
            }
            baseListRow.setInteger(2, n2);
            baseListRow.setInteger(5, n);
        }
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        this.viewModel.contentChanged();
    }

    @Override
    public void insertRow(int n, ListCell listCell) {
        throw new ModelException((HMIModel)this, "Single column rows are not supported!");
    }

    @Override
    public void insertRow(int n, BaseListRow baseListRow) {
        super.insertRow(n, baseListRow);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.insertRow] Ignored because transaction is running.");
            return;
        }
        this.setViewFolderState(baseListRow);
        this.viewModel.insertRow(n, baseListRow);
    }

    @Override
    public void removeRow(int n) {
        int n2 = this.getRowIdByIndex(n);
        super.removeRow(n);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.removeRow] Ignored because transaction is running.");
            return;
        }
        if (this.viewModel.isVisible(n2)) {
            int n3 = this.viewModel.getIndexForRowID(n2);
            this.viewModel.removeRow(n3);
        }
    }

    @Override
    public void setMaxColumns(int n) {
        super.setMaxColumns(n);
        this.viewModel.setMaxColumns(n);
    }

    @Override
    public void setMaxRows(int n) {
        super.setMaxRows(n);
        this.viewModel.setMaxRows(n);
    }

    @Override
    public void setCell(int n, int n2, ListCell listCell) {
        super.setCell(n, n2, listCell);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.setCell] Ignored because transaction is running.");
            return;
        }
        int n3 = this.getRowIdByIndex(n);
        if (this.viewModel.isVisible(n3)) {
            int n4 = this.viewModel.getIndexForRowID(n3);
            this.viewModel.setCell(n4, n2, listCell);
        }
    }

    @Override
    public void setRow(int n, BaseListRow baseListRow) {
        super.setRow(n, baseListRow);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.setRow] Ignored because transaction is running.");
            return;
        }
        this.setViewFolderState(baseListRow);
        int n2 = this.getRowIdByIndex(n);
        int n3 = this.viewModel.getIndexForRowID(n2);
        this.viewModel.setRow(n3, baseListRow);
    }

    @Override
    public void addHint(int n) {
        super.addHint(n);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.addHint] Ignored because transaction is running.");
            return;
        }
        this.viewModel.addHint(n);
    }

    @Override
    public void removeHint(int n) {
        super.removeHint(n);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.removeHint] Ignored because transaction is running.");
            return;
        }
        this.viewModel.removeHint(n);
    }

    @Override
    public void resetHints() {
        super.resetHints();
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.resetHints] Ignored because transaction is running.");
            return;
        }
        this.viewModel.resetHints();
    }

    @Override
    public void publishHints() {
        super.publishHints();
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.publishHints] Ignored because transaction is running.");
            return;
        }
        this.viewModel.publishHints();
    }

    @Override
    public void setSelected(int n) {
        super.setSelected(n);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.setSelected] Ignored because transaction is running.");
            return;
        }
        int n2 = n != -1 ? this.getRowIdByIndex(n) : -1;
        this.viewModel.setSelected(n2);
    }

    public int getRowIdByIndex(int n) {
        if (n >= this.getLength() || n < 0) {
            return -1;
        }
        return this.getRow(n).getInteger(0);
    }

    public ListCell getCellByRowId(int n, int n2) {
        int n3 = this.getLength();
        for (int i2 = 0; i2 < n3; ++i2) {
            if (n != this.getRowIdByIndex(i2)) continue;
            return this.getCell(i2, n2);
        }
        throw new ModelException((HMIModel)this, new StringBuffer().append("Row ID ").append(n).append(" not found!").toString());
    }

    int getFolderIdByIndex(int n) {
        if (n >= this.getLength() || n < 0) {
            return -1;
        }
        return this.getRow(n).getInteger(1);
    }

    @Override
    public int getFolderIndex(int n) {
        int n2 = this.getLength();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (n != this.getFolderIdByIndex(i2)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public void setStatus(int n) {
        super.setStatus(n);
        if (this.isTransactionRunning()) {
            this.lc.log(1078071040, "[BFLContentModel.setStatus] Ignored because transaction is running.");
            return;
        }
        this.viewModel.setStatus(n);
    }

    static boolean isFolder(BaseListRow baseListRow) {
        return baseListRow.getInteger(2) != 0;
    }
}

