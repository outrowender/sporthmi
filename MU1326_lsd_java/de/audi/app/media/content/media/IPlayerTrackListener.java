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
    default public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
    }

    default public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
    }

    default public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    default public void coverArtChanged(ResourceLocator resourceLocator) {
    }
}

