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

    public int getType() {
        return -1;
    }

    public String getName() {
        return "";
    }

    public void start() {
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
    }

    public void abort(boolean bl) {
    }

    public void discardPlayViewRequests() {
    }

    public void errorListRequestAborted() {
    }
}

