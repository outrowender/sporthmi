/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayViewListRequest;

public abstract class AbstractPlayViewListRequest
implements IPlayViewListRequest {
    private final int index;
    private final long entryID;
    private final int size;
    private final int clientID;

    public AbstractPlayViewListRequest(int n, int n2, long l, int n3) {
        this.clientID = n;
        this.index = n2;
        this.entryID = l;
        this.size = n3;
    }

    public int getClientID() {
        return this.clientID;
    }

    public int getIndex() {
        return this.index;
    }

    public long getId() {
        return this.entryID;
    }

    public int getSize() {
        return this.size;
    }
}

