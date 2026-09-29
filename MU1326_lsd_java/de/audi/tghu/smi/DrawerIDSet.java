/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

public class DrawerIDSet {
    private final long selectionDrawerID;
    private final long optionsDrawerID;

    public DrawerIDSet(long l, long l2) {
        this.selectionDrawerID = l;
        this.optionsDrawerID = l2;
    }

    protected long getSelectionDrawerID() {
        return this.selectionDrawerID;
    }

    protected long getOptionsDrawerID() {
        return this.optionsDrawerID;
    }

    public String toString() {
        return new StringBuffer().append("selectionDrawerID=").append(this.selectionDrawerID).append(", optionsDrawerID=").append(this.optionsDrawerID).toString();
    }
}

