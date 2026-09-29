/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncMediaRequests$ListEntry;
import de.audi.atip.sdis.IHMISyncMediaRequests$Source;

public interface IHMISyncMediaReplies {
    public static final int PLAYBACKSTATE_UNDEFINED;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEKING;

    default public void updatePlaybackState(int n) {
    }

    default public void updateSourceList(IHMISyncMediaRequests.Source[] sourceArray) {
    }

    default public void updateActiveSource(IHMISyncMediaRequests.Source source) {
    }

    default public void updatePlayingPosition(long l, String string, String string2, int n) {
    }

    default public void updatePlayingTrack(IHMISyncMediaRequests.ListEntry listEntry) {
    }

    default public void updatePlayList(IHMISyncMediaRequests.ListEntry[] listEntryArray) {
    }
}

