/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;

public interface HistoryListRowBuilder {
    default public EvoListRow buildListRow(CityHistory$HistoryEntry cityHistory$HistoryEntry, int n) {
    }
}

