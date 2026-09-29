/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public final class NullSamplePlayer
implements ISamplePlayer,
TTSListener {
    private static final NullSamplePlayer INSTANCE = new NullSamplePlayer();

    public static NullSamplePlayer getInstance() {
        return INSTANCE;
    }

    private NullSamplePlayer() {
    }

    @Override
    public void play() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void registerService(Object object) {
    }

    @Override
    public void deregisterService(Object object) {
    }

    @Override
    public void sessionStarted() {
    }

    @Override
    public void sessionStopped() {
    }

    @Override
    public void speakingFinished() {
    }

    @Override
    public void speakingAborted() {
    }

    @Override
    public void sessionPaused() {
    }

    @Override
    public void sessionResumed() {
    }

    @Override
    public void speakingFailed() {
    }

    @Override
    public void audioAvailable(boolean bl) {
    }

    @Override
    public void speakingStarted() {
    }

    @Override
    public void speakingPaused() {
    }
}

