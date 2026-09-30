/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.IEntryListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.messaging.ListEntry;

public final class EntryListRow
extends EvoListRow
implements IEntryListRow {
    private static volatile long nextRowId = 0L;
    private final AbstractEntryListRowData entryListRowData;

    public EntryListRow(AbstractEntryListRowData abstractEntryListRowData) {
        super(nextRowId++, abstractEntryListRowData.getColumnCount());
        this.entryListRowData = abstractEntryListRowData;
        abstractEntryListRowData.setColumns(this, abstractEntryListRowData, null);
    }

    private EntryListRow(long l, AbstractEntryListRowData abstractEntryListRowData) {
        super(l, abstractEntryListRowData.getColumnCount());
        this.entryListRowData = abstractEntryListRowData;
        abstractEntryListRowData.setColumns(this, abstractEntryListRowData, null);
    }

    public EvoListRow copy() {
        EntryListRow entryListRow = new EntryListRow(this.getUniqueID(), this.entryListRowData);
        this.entryListRowData.setColumns(entryListRow, this.entryListRowData, null);
        return entryListRow;
    }

    public ListEntry getListEntry() {
        return this.entryListRowData.getListEntry();
    }

    public int getItemOffset() {
        return this.entryListRowData.getItemOffset();
    }

    public int getIconId() {
        return this.entryListRowData.getIconId();
    }

    public void toggleRow(EvoListRow evoListRow, boolean bl) {
        this.entryListRowData.toggleRow(evoListRow, bl);
    }

    public int getCheckBoxValue(EvoListRow evoListRow) {
        return this.entryListRowData.getCheckBoxValue(evoListRow);
    }
}

