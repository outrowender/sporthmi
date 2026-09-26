/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;
import org.dsi.ifc.global.ResourceLocator;

public interface IMediaOnlineSessionPlayer
extends IMediaSessionPlayer {
    public static final int PLAYBACK_FROM_BEGINNING;

    default public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
    }

    default public void seekToTime(int n) {
    }

    default public void setRepeatTitle(boolean bl) {
    }

    default public void setShuffle(boolean bl) {
    }

    default public void updateOnlineCoverart(ResourceLocator resourceLocator) {
    }
}

