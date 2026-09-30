/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

public class DisplayManagerState {
    private static final int INVALID_ID = -1;
    private final int displayableId;

    public DisplayManagerState(int n) {
        this.displayableId = n;
    }

    public DisplayManagerState() {
        this(-1);
    }

    public boolean isValid() {
        return -1 != this.displayableId;
    }

    public int getDisplayableId() {
        return this.displayableId;
    }
}

