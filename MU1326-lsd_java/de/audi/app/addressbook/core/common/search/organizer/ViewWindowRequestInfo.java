/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer;

public class ViewWindowRequestInfo {
    private int requestId;
    private int movement = 6;
    private long refEntryId;
    private int viewType;
    private int spellerHandle = -1;
    private int windowSize = 20;
    private int totalEntries;
    private boolean clearListOnUpdate = false;
    private boolean resetCursorOnUpdate = false;

    public ViewWindowRequestInfo(int n, int n2, int n3, int n4, int n5) {
        this.requestId = n;
        this.refEntryId = n2;
        this.viewType = n3;
        this.spellerHandle = n4;
        this.windowSize = n5;
    }

    public ViewWindowRequestInfo(int n, int n2, int n3, boolean bl, boolean bl2) {
        this.requestId = -1;
        this.refEntryId = n;
        this.viewType = n2;
        this.spellerHandle = n3;
        this.clearListOnUpdate = bl;
        this.resetCursorOnUpdate = bl2;
    }

    public ViewWindowRequestInfo(long l, int n, int n2, boolean bl) {
        this.requestId = -1;
        this.refEntryId = l;
        this.movement = 3;
        this.viewType = n;
        this.spellerHandle = n2;
        this.clearListOnUpdate = bl;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setMovement(int n) {
        this.movement = n;
    }

    public int getMovement() {
        return this.movement;
    }

    public long getRefEntryId() {
        return this.refEntryId;
    }

    public int getViewType() {
        return this.viewType;
    }

    public int getSpellerHandle() {
        return this.spellerHandle;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    public void setTotalEntries(int n) {
        this.totalEntries = n;
    }

    public int getTotalEntries() {
        return this.totalEntries;
    }

    public boolean isClearListOnUpdate() {
        return this.clearListOnUpdate;
    }

    public boolean isResetCursorOnUpdate() {
        return this.resetCursorOnUpdate;
    }
}

