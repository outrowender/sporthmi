/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.navi.app.CityHistory;
import org.dsi.ifc.navigation.LIValueListElement;

public class HistoryLiValueListElementWrapper {
    private final CityHistory.HistoryEntry bestMatchingHistoryEntry;
    private final LIValueListElement liValueListElement;

    public HistoryLiValueListElementWrapper(CityHistory.HistoryEntry historyEntry) {
        this.bestMatchingHistoryEntry = historyEntry;
        this.liValueListElement = null;
    }

    public HistoryLiValueListElementWrapper(LIValueListElement lIValueListElement) {
        this.liValueListElement = lIValueListElement;
        this.bestMatchingHistoryEntry = null;
    }

    public boolean isHistoryEntry() {
        return this.bestMatchingHistoryEntry != null;
    }

    public boolean isLiValueListElement() {
        return this.liValueListElement != null;
    }

    public LIValueListElement getLiValueListElement() {
        return this.liValueListElement;
    }

    public CityHistory.HistoryEntry getHistoryEntry() {
        return this.bestMatchingHistoryEntry;
    }
}

