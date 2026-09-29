/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IPlayViewListRequest {
    public static final long INVALID_ID;

    default public int getClientID() {
    }

    default public int getIndex() {
    }

    default public long getId() {
    }

    default public int getSize() {
    }

    default public void responsePlayList(boolean bl, int n, MediaListEntry[] mediaListEntryArray) {
    }
}

