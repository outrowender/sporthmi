/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ListModel;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class BufferedListModel
extends BufferedAbstractModel
implements ListModelGUI,
ListModelApp {
    private final ListModel mainModel;
    private ListModel activeModel = this.mainModel = (ListModel)super.getMainModel();
    private int statusFlags = 0;

    public BufferedListModel(int n) {
        super(new ListModel(n), new ListModel(n));
    }

    public BufferedListModel(int n, int n2) {
        super(new ListModel(n, n2), new ListModel(n, n2));
    }

    public String toString() {
        Buffer buffer = new Buffer(super.toString());
        buffer.append("\n\nHMI/Main-");
        buffer.append(this.mainAbstractModel);
        buffer.append("\n\nTMP-");
        buffer.append(this.tmpAbstractModel);
        return buffer.toString();
    }

    public void abortTransaction() {
        super.abortTransaction();
        this.activeModel = this.mainModel;
    }

    public void beginTransaction() throws IllegalStateException {
        super.beginTransaction();
        this.activeModel = (ListModel)this.tmpAbstractModel;
    }

    public void endTransaction() {
        super.endTransaction();
        this.activeModel = this.mainModel;
        ((ListModel)this.tmpAbstractModel).clear();
        this.mainModel.fireModelUpdateEvent(16, this.getStatusFlags());
        this.clearStatusFlags();
    }

    public void setCell(int n, int n2, ListCell listCell) {
        this.activeModel.setCell(n, n2, listCell);
        this.setStatusFlag(1);
    }

    public ListCell getCell(int n, int n2) {
        return this.mainModel.getCell(n, n2);
    }

    public Class getColumnType(int n) {
        return this.mainModel.getColumnType(n);
    }

    public int getLength() {
        return this.mainModel.getLength();
    }

    public int getLengthOnTransaction() {
        return this.activeModel.getLength();
    }

    public void setListListener(ListListener listListener) {
        this.activeModel.setListListener(listListener);
    }

    public void setMaxColumns(int n) {
        this.activeModel.setMaxColumns(n);
        this.setStatusFlag(8);
    }

    public int getMaxColumns() {
        return this.mainModel.getMaxColumns();
    }

    public void setMaxRows(int n) {
        this.activeModel.setMaxRows(n);
        this.setStatusFlag(4);
    }

    public int getMaxRows() {
        return this.mainModel.getMaxRows();
    }

    public void setRow(int n, BaseListRow baseListRow) {
        this.activeModel.setRow(n, baseListRow);
        this.setStatusFlag(1);
    }

    public void setRow(int n, ListCell listCell) {
        this.activeModel.setRow(n, listCell);
        this.setStatusFlag(1);
    }

    public void setRow(int n, ListCell[] listCellArray) {
        this.activeModel.setRow(n, listCellArray);
        this.setStatusFlag(1);
    }

    public boolean getRow(int n, ListCell[] listCellArray) {
        return this.mainModel.getRow(n, listCellArray);
    }

    public BaseListRow getRow(int n) {
        return this.mainModel.getRow(n);
    }

    public BaseListRow getRowOnTransaction(int n) {
        return this.activeModel.getRow(n);
    }

    public void setSelected(int n) {
        this.activeModel.setSelected(n);
        this.setStatusFlag(2);
    }

    public int getSelected() {
        return this.mainModel.getSelected();
    }

    public void addRow(BaseListRow baseListRow) {
        this.activeModel.addRow(baseListRow);
        this.setStatusFlag(1);
    }

    public void addRow(ListCell listCell) {
        this.activeModel.addRow(listCell);
        this.setStatusFlag(1);
    }

    public void addRow(ListCell[] listCellArray) {
        this.activeModel.addRow(listCellArray);
        this.setStatusFlag(1);
    }

    public void clear() {
        this.activeModel.clear();
        this.setStatusFlag(1);
    }

    public void insertRow(int n, BaseListRow baseListRow) {
        this.activeModel.insertRow(n, baseListRow);
        this.setStatusFlag(1);
    }

    public void insertRow(int n, ListCell listCell) {
        this.activeModel.insertRow(n, listCell);
        this.setStatusFlag(1);
    }

    public void insertRow(int n, ListCell[] listCellArray) {
        this.activeModel.insertRow(n, listCellArray);
        this.setStatusFlag(1);
    }

    public void itemFocused(int n, int n2, int n3) {
        this.mainModel.itemFocused(n, n2, n3);
    }

    public void itemSelected(int n, int n2, int n3) {
        this.mainModel.itemSelected(n, n2, n3);
    }

    public void itemReleased(int n, int n2, int n3) {
        this.mainModel.itemReleased(n, n2, n3);
    }

    public void removeRow(int n) {
        this.activeModel.removeRow(n);
        this.setStatusFlag(1);
    }

    private int getStatusFlags() {
        return this.statusFlags;
    }

    private void clearStatusFlags() {
        this.statusFlags = 0;
    }

    private void setStatusFlag(int n) {
        this.statusFlags |= n;
    }
}

