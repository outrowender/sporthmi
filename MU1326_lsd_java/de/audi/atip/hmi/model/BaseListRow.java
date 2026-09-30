/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.esolutions.fw.util.commons.Buffer;

public class BaseListRow {
    protected ListCell[] cells;

    BaseListRow() {
        this(new ListCell[0]);
    }

    public BaseListRow(ListCell[] listCellArray) {
        this.setCells(listCellArray);
    }

    public ListCell[] getCells() {
        return this.cells;
    }

    public int getColumnCount() {
        return this.cells.length;
    }

    public void setCells(ListCell[] listCellArray) {
        this.cells = listCellArray != null ? listCellArray : new ListCell[]{};
    }

    public void setCell(int n, ListCell listCell) {
        try {
            this.cells[n] = listCell;
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("Invalid col:" + n + " - #col:" + this.cells.length);
        }
    }

    public void setInteger(int n, int n2) {
        this.setCell(n, IntegerListCell.create(n2));
    }

    public void setText(int n, String string) {
        this.setCell(n, new TextListCell(string));
    }

    public ListCell getCell(int n) {
        try {
            return this.cells[n];
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("Invalid col:" + n + " - #col:" + this.cells.length);
        }
    }

    public int getInteger(int n) {
        return ((IntegerListCell)this.getCell(n)).getValue();
    }

    public long getLong(int n) {
        return ((LongListCell)this.getCell(n)).getValue();
    }

    public String getText(int n) {
        return ((TextListCell)this.getCell(n)).getText();
    }

    public String toString() {
        if (this.cells == null) {
            return super.toString();
        }
        Buffer buffer = new Buffer(super.toString());
        buffer.append(':');
        for (int i2 = 0; i2 < this.cells.length; ++i2) {
            ListCell listCell = this.cells[i2];
            buffer.append(" [").append(i2).append(']');
            buffer.append(listCell != null ? listCell.toString() : "null");
        }
        return buffer.toString();
    }
}

