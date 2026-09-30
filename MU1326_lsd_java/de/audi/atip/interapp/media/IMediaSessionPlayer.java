/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

public interface IMediaSessionPlayer {
    public void resume();

    public void pause();

    public void stop();

    public void seek(boolean var1);

    public void skip(int var1);
}

