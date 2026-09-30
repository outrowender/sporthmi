/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;

public interface IMediaFileSessionPlayer
extends IMediaSessionPlayer {
    public void play(String var1, boolean var2);

    public void setVideoScaling(int var1, int var2, int var3, int var4);
}

