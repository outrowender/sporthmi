/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.atip.hmi.model.ListRow;

public class FocusedRow {
    private final ListRow row;
    private final int rowVisibleIndex;

    public FocusedRow(ListRow listRow, int n) {
        if (listRow == null) {
            throw new IllegalArgumentException("Row is null.");
        }
        this.row = listRow;
        this.rowVisibleIndex = n;
    }

    public ListRow getRow() {
        return this.row;
    }

    public int getVisibleIndex() {
        return this.rowVisibleIndex;
    }

    public boolean equals(Object object) {
        try {
            FocusedRow focusedRow = (FocusedRow)object;
            return this.getVisibleIndex() == focusedRow.getVisibleIndex() && this.getRow().equals(focusedRow.getRow());
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }
}

