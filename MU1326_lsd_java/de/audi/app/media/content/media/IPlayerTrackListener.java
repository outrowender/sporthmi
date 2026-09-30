/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.ResourceLocator;

public interface IPlayerTrackListener {
    public void trackChanged(boolean var1, boolean var2, PlayingTrack var3, PlayTime var4);

    public void detailInfoChanged(MediaDetailInfo var1);

    public void playbackFolderChanged(MediaListEntry[] var1);

    public void coverArtChanged(ResourceLocator var1);
}

