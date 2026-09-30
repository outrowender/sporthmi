/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSService;

public interface TTSSessionBasedService
extends TTSService {
    public void startSession();

    public void stopSession();

    public void pause();

    public void resume();

    public void playTone(int var1);
}

