/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.hierarchiclist;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;

public abstract class AbstractHierarchyListRow
extends ListRow {
    private boolean entryPassed = false;
    private boolean border = false;

    protected AbstractHierarchyListRow() {
    }

    public AbstractHierarchyListRow(ListCell[] listCellArray) {
        super(listCellArray);
    }

    public int hashCode() {
        return (int)(this.getUid() ^ this.getUid() >>> 32);
    }

    public boolean equals(Object object) {
        try {
            AbstractHierarchyListRow abstractHierarchyListRow = (AbstractHierarchyListRow)object;
            return this.getUid() == abstractHierarchyListRow.getUid();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public boolean isEntryPassed() {
        return this.entryPassed;
    }

    protected void setEntryPassed(boolean bl) {
        this.entryPassed = bl;
    }

    public boolean isBorder() {
        return this.border;
    }

    public void setBorder(boolean bl) {
        this.border = bl;
    }

    public abstract long getUid();

    public abstract boolean isHasChildren();

    public abstract boolean isHasDetails();

    public abstract void queryDetails();
}

