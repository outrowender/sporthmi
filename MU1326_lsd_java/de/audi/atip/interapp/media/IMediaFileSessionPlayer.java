/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.IMediaSessionPlayer;

public interface IMediaFileSessionPlayer
extends IMediaSessionPlayer {
    default public void play(String string, boolean bl) {
    }

    default public void setVideoScaling(int n, int n2, int n3, int n4) {
    }
}

