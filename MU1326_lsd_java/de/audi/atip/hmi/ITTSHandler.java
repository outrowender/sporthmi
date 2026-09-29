/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.interapp.tts.TTSSessionBasedService;

public interface ITTSHandler {
    public static final int TAG_NONE;
    public static final int TAG_SAY_AS;
    public static final int TAG_PHONEME;

    default public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
    }

    default public void speak(int n, String string, String string2, String string3, boolean bl, int n2) {
    }

    default public void speak(int n, String string, String string2, String string3, String string4, boolean bl, int n2) {
    }

    default public void startSession(int n) {
    }

    default public void stopSession(int n, boolean bl) {
    }

    default public void reset() {
    }
}

