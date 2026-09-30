/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IMediaBrowserListListener {
    public int getClientID();

    public void responseList(MediaListEntry[] var1, int var2);

    public void responsePickList(MediaListEntry[] var1);

    public void errorListRequestAborted();

    public void errorPickListRequestAborted();
}

