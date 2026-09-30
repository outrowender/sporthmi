/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncMediaRequests;

public interface IHMISyncMediaReplies {
    public static final int PLAYBACKSTATE_UNDEFINED = 0;
    public static final int PLAYBACKSTATE_PLAYING = 1;
    public static final int PLAYBACKSTATE_PAUSED = 2;
    public static final int PLAYBACKSTATE_SEEKING = 3;

    public void updatePlaybackState(int var1);

    public void updateSourceList(IHMISyncMediaRequests.Source[] var1);

    public void updateActiveSource(IHMISyncMediaRequests.Source var1);

    public void updatePlayingPosition(long var1, String var3, String var4, int var5);

    public void updatePlayingTrack(IHMISyncMediaRequests.ListEntry var1);

    public void updatePlayList(IHMISyncMediaRequests.ListEntry[] var1);
}

