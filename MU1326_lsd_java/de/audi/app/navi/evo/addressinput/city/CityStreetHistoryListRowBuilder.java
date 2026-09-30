/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.city;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HistoryListRowBuilder;

public class CityStreetHistoryListRowBuilder
implements HistoryListRowBuilder {
    public EvoListRow buildListRow(CityHistory.HistoryEntry historyEntry, int n) {
        return new AddressInputHistoryElementListRow(historyEntry, (long)n);
    }
}

