/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerState;

public interface IFilePlayer {
    default public IFilePlayerState getState() {
    }

    default public IAudioManager getAudioManager() {
    }

    default public void setPlaybackURL(String string) {
    }

    default public void resume() {
    }

    default public void pause() {
    }

    default public void seek(boolean bl) {
    }

    default public void skip(int n) {
    }

    default public void stop() {
    }

    default public void setPlaybackMode(int n) {
    }

    default public void setVideoScaling(int n, int n2, int n3, int n4) {
    }
}

