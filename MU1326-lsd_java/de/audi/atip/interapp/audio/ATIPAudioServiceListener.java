/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

import de.audi.atip.interapp.audio.IAudioSdisListener;

public interface ATIPAudioServiceListener {
    default public void updateActiveConnection(int n, int n2) {
    }

    default public void updateActiveEntertainmentConnection(int n, int n2) {
    }

    default public void incVolume(int n) {
    }

    default public void decVolume(int n) {
    }

    default public void addAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
    }

    default public void removeAudioSdisListener(IAudioSdisListener iAudioSdisListener) {
    }
}

