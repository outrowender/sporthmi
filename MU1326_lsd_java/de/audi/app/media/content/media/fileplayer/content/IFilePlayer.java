/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerState;

public interface IFilePlayer {
    public IFilePlayerState getState();

    public IAudioManager getAudioManager();

    public void setPlaybackURL(String var1);

    public void resume();

    public void pause();

    public void seek(boolean var1);

    public void skip(int var1);

    public void stop();

    public void setPlaybackMode(int var1);

    public void setVideoScaling(int var1, int var2, int var3, int var4);
}

