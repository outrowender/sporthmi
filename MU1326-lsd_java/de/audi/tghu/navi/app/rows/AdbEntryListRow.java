/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rows;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.organizer.AdbEntry;

public class AdbEntryListRow
extends EvoListRow {
    private final AdbEntry adbEntry;
    private final int adbType;

    protected AdbEntryListRow(AdbEntryListRow adbEntryListRow) {
        super(adbEntryListRow);
        this.adbEntry = adbEntryListRow.adbEntry;
        this.adbType = adbEntryListRow.adbType;
    }

    public AdbEntryListRow(long l, int n, AdbEntry adbEntry, int n2) {
        super(l, n);
        this.adbEntry = adbEntry;
        this.adbType = n2;
    }

    public AdbEntry getAdbEntry() {
        return this.adbEntry;
    }

    public int getAdbType() {
        return this.adbType;
    }
}

