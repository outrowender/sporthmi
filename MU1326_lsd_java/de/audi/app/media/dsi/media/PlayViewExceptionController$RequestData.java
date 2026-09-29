/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

class PlayViewExceptionController$RequestData {
    private static final int MAX_RETRY;
    private long entryID;
    private int index;
    private int count;
    private int clientID;
    private boolean valid;
    private int retries;

    PlayViewExceptionController$RequestData(long l, int n, int n2, int n3) {
        this.entryID = l;
        this.index = n;
        this.count = n2;
        this.clientID = n3;
        this.valid = true;
    }

    long getEntryID() {
        return this.entryID;
    }

    int getIndex() {
        return this.index;
    }

    int getCount() {
        return this.count;
    }

    int getClientID() {
        return this.clientID;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.clientID;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        PlayViewExceptionController$RequestData playViewExceptionController$RequestData = (PlayViewExceptionController$RequestData)object;
        return this.clientID == playViewExceptionController$RequestData.clientID;
    }

    boolean isValid() {
        return this.valid;
    }

    void invalidate() {
        this.valid = false;
    }

    public int getRetries() {
        return this.retries;
    }

    public boolean retry() {
        return ++this.retries <= 3;
    }

    public String toString() {
        return new StringBuffer().append("entry ID: ").append(this.entryID).append(", index: ").append(this.index).append(", count: ").append(this.count).append(", client ID: ").append(this.clientID).append(", valid: ").append(this.valid).append(", retries: ").append(this.retries).toString();
    }
}

