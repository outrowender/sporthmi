/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractPlayerSelectionRequest
implements IPlayerSelectionRequest {
    private final int browserID;
    private final long entryID;
    private final boolean seamless;
    private final boolean waitingForPlayposition;

    public AbstractPlayerSelectionRequest(int n, long l, boolean bl, boolean bl2) {
        this.browserID = n;
        this.entryID = l;
        this.seamless = bl;
        this.waitingForPlayposition = bl2;
    }

    @Override
    public int getBrowserID() {
        return this.browserID;
    }

    @Override
    public long getEntryID() {
        return this.entryID;
    }

    @Override
    public boolean isSeamless() {
        return this.seamless;
    }

    @Override
    public boolean waitForPlayposition() {
        return this.waitingForPlayposition;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("browserID='").append(this.browserID).append("',entryID='").append(this.entryID).append("',seamless='").append(this.seamless).append("'");
        return buffer.toString();
    }
}

