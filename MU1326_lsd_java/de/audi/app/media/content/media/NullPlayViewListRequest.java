/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.PlayViewListRequest;
import de.audi.app.media.dsi.media.MediaListEntry;

public class NullPlayViewListRequest
extends PlayViewListRequest {
    public NullPlayViewListRequest() {
        super(null, null, null, 1L);
    }

    @Override
    public int getType() {
        return -1;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void start() {
    }

    @Override
    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
    }

    @Override
    public void abort(boolean bl) {
    }

    public void discardPlayViewRequests() {
    }

    @Override
    public void errorListRequestAborted() {
    }
}

