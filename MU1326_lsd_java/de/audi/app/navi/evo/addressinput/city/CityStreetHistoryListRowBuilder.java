/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.city;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.HistoryListRowBuilder;

public class CityStreetHistoryListRowBuilder
implements HistoryListRowBuilder {
    @Override
    public EvoListRow buildListRow(CityHistory$HistoryEntry cityHistory$HistoryEntry, int n) {
        return new AddressInputHistoryElementListRow(cityHistory$HistoryEntry, (long)n);
    }
}

