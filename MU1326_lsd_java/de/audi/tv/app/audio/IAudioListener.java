/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

public interface IAudioListener {
    public void onMuGotTvAudioFocus(boolean var1);

    public void onMuLostTvAudioFocus();

    public void onSdisGotTvAudioFocus();

    public void onSdisLostTvAudioFocus();

    public void onMuteChange(boolean var1);
}

