/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaListEntry;

public interface IMediaBrowserListListener {
    default public int getClientID() {
    }

    default public void responseList(MediaListEntry[] mediaListEntryArray, int n) {
    }

    default public void responsePickList(MediaListEntry[] mediaListEntryArray) {
    }

    default public void errorListRequestAborted() {
    }

    default public void errorPickListRequestAborted() {
    }
}

