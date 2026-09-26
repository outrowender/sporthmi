/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;

public class NullTTSSessionBasedService
extends NullService
implements TTSSessionBasedService {
    public NullTTSSessionBasedService(LogChannel logChannel) {
        super(logChannel, "TTSSessionBasedService");
    }

    @Override
    public void startSession() {
        this.log();
    }

    @Override
    public void speak(String string) {
        this.log();
    }

    @Override
    public void abortSpeaking() {
        this.log();
    }

    @Override
    public void stopSession() {
        this.log();
    }

    public void setTTSListener(TTSListener tTSListener) {
        this.log();
    }

    @Override
    public void playTone(int n) {
        this.log();
    }

    @Override
    public void pause() {
        this.log();
    }

    @Override
    public void resume() {
        this.log();
    }
}

