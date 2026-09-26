/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.ResourceLocator;

public interface IPlayerViewListener {
    public static final int FLAGS_NONE;
    public static final int FLAGS_NO_PLAYABLE_FILE_AVAILABLE;
    public static final int FLAGS_METADATA_UPDATE;
    public static final int FLAGS_COVERART_UPDATE;
    public static final int FLAG_SYNTHETIC_SUPPRESS_PROPAGATION;

    default public int getClientID() {
    }

    default public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
    }

    default public void listInvalidated() {
    }

    default public void listChanged(boolean bl, long l, int n, int n2) {
    }

    default public void listChangeOnSelection(boolean bl) {
    }

    default public void errorListRequestAborted() {
    }

    default public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
    }
}

