/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;

public abstract class AbstractAddressInputHistoryElementListRow
extends EvoListRow {
    public AbstractAddressInputHistoryElementListRow(AbstractAddressInputHistoryElementListRow abstractAddressInputHistoryElementListRow) {
        super(abstractAddressInputHistoryElementListRow);
    }

    public AbstractAddressInputHistoryElementListRow(long l, int n) {
        super(l, n);
    }

    public abstract CityHistory$HistoryEntry getHistoryEntry() {
    }
}

