/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

import de.audi.atip.interapp.audio.IAudioSdisListener;

public interface ATIPAudioServiceListener {
    public void updateActiveConnection(int var1, int var2);

    public void updateActiveEntertainmentConnection(int var1, int var2);

    public void incVolume(int var1);

    public void decVolume(int var1);

    public void addAudioSdisListener(IAudioSdisListener var1);

    public void removeAudioSdisListener(IAudioSdisListener var1);
}

