/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSService;

public interface TTSSDSService
extends TTSService {
    default public void playTone(int n) {
    }

    default public void speakRemoteHMI(String string) {
    }
}

