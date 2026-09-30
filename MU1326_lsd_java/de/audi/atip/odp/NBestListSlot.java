/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public class NBestListSlot {
    private final long slotResultID;
    private final String slotResultString;
    private final String slotObjStringID;

    public NBestListSlot(long l, String string, String string2) {
        this.slotResultID = l;
        this.slotResultString = string;
        this.slotObjStringID = string2;
    }

    public long getSlotResultID() {
        return this.slotResultID;
    }

    public String getSlotResultString() {
        return this.slotResultString;
    }

    public String getSlotObjectStringID() {
        return this.slotObjStringID;
    }

    public String toString() {
        return "NBestListSlot(" + this.slotResultID + ", " + this.slotResultString + ", " + this.slotObjStringID + ")";
    }
}

