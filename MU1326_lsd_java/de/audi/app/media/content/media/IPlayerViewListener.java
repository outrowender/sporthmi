/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.ResourceLocator;

public interface IPlayerViewListener {
    public static final int FLAGS_NONE = 0;
    public static final int FLAGS_NO_PLAYABLE_FILE_AVAILABLE = 1;
    public static final int FLAGS_METADATA_UPDATE = 2;
    public static final int FLAGS_COVERART_UPDATE = 4;
    public static final int FLAG_SYNTHETIC_SUPPRESS_PROPAGATION = 4096;

    public int getClientID();

    public void responsePlayView(int var1, MediaListEntry[] var2, int var3);

    public void listInvalidated();

    public void listChanged(boolean var1, long var2, int var4, int var5);

    public void listChangeOnSelection(boolean var1);

    public void errorListRequestAborted();

    public void notifySameTrackSelected(MediaDetailInfo var1, ResourceLocator var2);
}

