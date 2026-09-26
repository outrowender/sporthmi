/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSService;

public interface TTSSessionBasedService
extends TTSService {
    default public void startSession() {
    }

    default public void stopSession() {
    }

    default public void pause() {
    }

    default public void resume() {
    }

    default public void playTone(int n) {
    }
}

