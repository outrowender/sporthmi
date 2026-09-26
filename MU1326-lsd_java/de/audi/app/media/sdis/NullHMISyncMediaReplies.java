/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.atip.sdis.IHMISyncMediaReplies;
import de.audi.atip.sdis.IHMISyncMediaRequests$ListEntry;
import de.audi.atip.sdis.IHMISyncMediaRequests$Source;

public class NullHMISyncMediaReplies
implements IHMISyncMediaReplies {
    @Override
    public void updatePlaybackState(int n) {
    }

    @Override
    public void updateSourceList(IHMISyncMediaRequests$Source[] iHMISyncMediaRequests$SourceArray) {
    }

    @Override
    public void updateActiveSource(IHMISyncMediaRequests$Source iHMISyncMediaRequests$Source) {
    }

    @Override
    public void updatePlayingPosition(long l, String string, String string2, int n) {
    }

    @Override
    public void updatePlayingTrack(IHMISyncMediaRequests$ListEntry iHMISyncMediaRequests$ListEntry) {
    }

    @Override
    public void updatePlayList(IHMISyncMediaRequests$ListEntry[] iHMISyncMediaRequests$ListEntryArray) {
    }
}

