/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;
import org.dsi.ifc.global.ResourceLocator;

public interface IMediaOnlineSessionPlayer
extends IMediaSessionPlayer {
    public static final int PLAYBACK_FROM_BEGINNING = -1;

    public void updatePlayingTrack(long var1, String var3, String var4, String var5, ResourceLocator var6);

    public void seekToTime(int var1);

    public void setRepeatTitle(boolean var1);

    public void setShuffle(boolean var1);

    public void updateOnlineCoverart(ResourceLocator var1);
}

