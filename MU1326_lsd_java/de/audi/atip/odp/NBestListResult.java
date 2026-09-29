/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.NBestListSlot;

public class NBestListResult {
    private final int confidence;
    private final String result;
    private final NBestListSlot[] nBestListSlots;
    private final long grammarID;

    public NBestListResult(long l, int n, String string, NBestListSlot[] nBestListSlotArray) {
        this.grammarID = l;
        this.confidence = n;
        this.result = string;
        this.nBestListSlots = nBestListSlotArray;
    }

    public long getGrammarID() {
        return this.grammarID;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public String getResult() {
        return this.result;
    }

    public NBestListSlot[] getNBestListSlots() {
        return this.nBestListSlots;
    }

    public String toString() {
        return new StringBuffer("NBestListResult(id=").append(this.grammarID).append(", confidence=").append(this.confidence).append(", result=").append(this.result).append(", nBestListSlots=").append(this.nBestListSlots).append(")").toString();
    }
}

