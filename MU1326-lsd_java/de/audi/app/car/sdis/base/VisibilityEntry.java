/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

public class VisibilityEntry {
    private int visibility;
    private short coding;

    public VisibilityEntry(int n, short s) {
        this.visibility = n;
        this.coding = s;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int n) {
        this.visibility = n;
    }

    public short getCoding() {
        return this.coding;
    }

    public void setCoding(short s) {
        this.coding = s;
    }
}

