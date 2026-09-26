/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;

class RowInfo {
    public static RowInfo ILLEGAL = new RowInfo(-1, -1, null, null);
    private final int index;
    private final int subindex;
    private final GridListRow row;
    private final GridListRow parent;

    public RowInfo(int n, int n2, GridListRow gridListRow, GridListRow gridListRow2) {
        this.index = n;
        this.subindex = n2;
        this.parent = gridListRow;
        this.row = gridListRow2;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSubindex() {
        return this.subindex;
    }

    public GridListRow getRow() {
        return this.row;
    }

    public GridListRow getParent() {
        return this.parent;
    }

    public String toString() {
        return new StringBuffer().append("RowInfo [index=").append(this.index).append(", subindex=").append(this.subindex).append(", row=").append(this.row).append(", parent=").append(this.parent).append("]").toString();
    }

    public boolean isBefore(RowInfo rowInfo) {
        int n = rowInfo.getIndex();
        return this.index < n || this.index == n && this.subindex < rowInfo.getSubindex();
    }

    public boolean isAfter(RowInfo rowInfo) {
        int n = rowInfo.getIndex();
        return this.index > n || this.index == n && this.subindex > rowInfo.getSubindex();
    }
}

