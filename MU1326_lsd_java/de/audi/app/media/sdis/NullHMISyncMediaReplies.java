/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.atip.sdis.IHMISyncMediaReplies;
import de.audi.atip.sdis.IHMISyncMediaRequests;

public class NullHMISyncMediaReplies
implements IHMISyncMediaReplies {
    public void updatePlaybackState(int n) {
    }

    public void updateSourceList(IHMISyncMediaRequests.Source[] sourceArray) {
    }

    public void updateActiveSource(IHMISyncMediaRequests.Source source) {
    }

    public void updatePlayingPosition(long l, String string, String string2, int n) {
    }

    public void updatePlayingTrack(IHMISyncMediaRequests.ListEntry listEntry) {
    }

    public void updatePlayList(IHMISyncMediaRequests.ListEntry[] listEntryArray) {
    }
}

