/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.HistoryListRowBuilder;
import java.util.ArrayList;
import java.util.List;

public class CityHistory$HistoryForCurrentInput {
    public static final CityHistory$HistoryForCurrentInput NO_HISTORY = new CityHistory$HistoryForCurrentInput(new ArrayList());
    private final List matchingHistoryEntries;

    public CityHistory$HistoryForCurrentInput(List list) {
        this.matchingHistoryEntries = list;
    }

    public CityHistory$HistoryEntry getBestMatchingEntry() {
        if (this.matchingHistoryEntries != null && !this.matchingHistoryEntries.isEmpty()) {
            return (CityHistory$HistoryEntry)this.matchingHistoryEntries.get(0);
        }
        return null;
    }

    public EvoListRow[] getEntriesForList(LogChannel logChannel, HistoryListRowBuilder historyListRowBuilder) {
        logChannel.log(-2137614336, "CityHistory#HistoryForCurrentInput#getEntriesForList");
        if (this.matchingHistoryEntries == null) {
            return null;
        }
        EvoListRow[] evoListRowArray = new EvoListRow[this.matchingHistoryEntries.size()];
        for (int i2 = 0; i2 < this.matchingHistoryEntries.size(); ++i2) {
            evoListRowArray[i2] = historyListRowBuilder.buildListRow((CityHistory$HistoryEntry)this.matchingHistoryEntries.get(i2), 1078071040 + i2);
        }
        return evoListRowArray;
    }
}

