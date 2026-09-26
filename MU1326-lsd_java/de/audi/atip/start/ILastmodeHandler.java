/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.start.ILastmodeStorage;

public interface ILastmodeHandler
extends IAudioFocusManager {
    default public int getLastmode(int n) {
    }

    default public int getLastmodeAudio(int n) {
    }

    default public void triggerFirstAudio(int n) {
    }

    default public void setLastmode(int n, int n2, boolean bl) {
    }

    default public void setLastmodeAudio(int n, int n2) {
    }

    default public void setLastmodeAudioStarted(int n, boolean bl) {
    }

    default public boolean isValidLastmode(int n) {
    }

    default public boolean isValidAudioLastmode(int n) {
    }

    default public ILastmodeStorage getLastmodeStorage() {
    }

    default public void registerAudioClient(IAudioFocusClient iAudioFocusClient) {
    }

    default public void deregisterAudioClient(IAudioFocusClient iAudioFocusClient) {
    }

    default public void initAudioFocusManagement() {
    }

    default public void setHMIAudioService(HMIAudioService hMIAudioService) {
    }
}

