/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

public class AbstractDisplayConfigurationComponent$DCElementSelectionEntry {
    private final String uniqueKey;
    private final int displayID;
    private final int contentNameID;
    private boolean selection;
    private boolean available;

    public AbstractDisplayConfigurationComponent$DCElementSelectionEntry(String string, int n, int n2) {
        this.uniqueKey = string;
        this.displayID = n;
        this.contentNameID = n2;
    }

    public String getUniqueKey() {
        return this.uniqueKey;
    }

    public int getDisplayID() {
        return this.displayID;
    }

    public int getContentNameID() {
        return this.contentNameID;
    }

    public boolean isSelection() {
        return this.selection;
    }

    public void setSelection(boolean bl) {
        this.selection = bl;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean bl) {
        this.available = bl;
    }
}

