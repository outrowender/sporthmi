/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

public interface IAudioListener {
    default public void onMuGotTvAudioFocus(boolean bl) {
    }

    default public void onMuLostTvAudioFocus() {
    }

    default public void onSdisGotTvAudioFocus() {
    }

    default public void onSdisLostTvAudioFocus() {
    }

    default public void onMuteChange(boolean bl) {
    }
}

