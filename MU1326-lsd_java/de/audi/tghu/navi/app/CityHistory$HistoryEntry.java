/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class CityHistory$HistoryEntry {
    private final LIStateHistoryEntry stateEntry;
    private final LICityHistoryEntry cityEntry;
    private final LIStreetHistoryEntry streetEntry;

    public CityHistory$HistoryEntry(LIStateHistoryEntry lIStateHistoryEntry) {
        this.stateEntry = lIStateHistoryEntry;
        this.cityEntry = null;
        this.streetEntry = null;
    }

    public CityHistory$HistoryEntry(LICityHistoryEntry lICityHistoryEntry) {
        this.stateEntry = null;
        this.cityEntry = lICityHistoryEntry;
        this.streetEntry = null;
    }

    public CityHistory$HistoryEntry(LIStreetHistoryEntry lIStreetHistoryEntry) {
        this.stateEntry = null;
        this.cityEntry = null;
        this.streetEntry = lIStreetHistoryEntry;
    }

    public Object getEntry() {
        if (this.stateEntry != null) {
            return this.stateEntry;
        }
        if (this.cityEntry != null) {
            return this.cityEntry;
        }
        return this.streetEntry;
    }

    public String getEntryName() {
        if (this.stateEntry != null) {
            return this.stateEntry.getName();
        }
        if (this.cityEntry != null) {
            return this.cityEntry.getName();
        }
        return this.streetEntry.getName();
    }

    public long getId() {
        if (this.stateEntry != null) {
            return this.stateEntry.getId();
        }
        if (this.cityEntry != null) {
            return this.cityEntry.getId();
        }
        return this.streetEntry.getId();
    }
}

