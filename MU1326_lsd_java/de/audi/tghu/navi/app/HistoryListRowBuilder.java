/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory;

public interface HistoryListRowBuilder {
    public EvoListRow buildListRow(CityHistory.HistoryEntry var1, int var2);
}

