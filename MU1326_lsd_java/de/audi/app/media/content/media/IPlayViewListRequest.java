/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IPlayViewListRequest {
    public static final long INVALID_ID = -1L;

    public int getClientID();

    public int getIndex();

    public long getId();

    public int getSize();

    public void responsePlayList(boolean var1, int var2, MediaListEntry[] var3);
}

