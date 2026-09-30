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

    public void play() {
    }

    public void stop() {
    }

    public void registerService(Object object) {
    }

    public void deregisterService(Object object) {
    }

    public void sessionStarted() {
    }

    public void sessionStopped() {
    }

    public void speakingFinished() {
    }

    public void speakingAborted() {
    }

    public void sessionPaused() {
    }

    public void sessionResumed() {
    }

    public void speakingFailed() {
    }

    public void audioAvailable(boolean bl) {
    }

    public void speakingStarted() {
    }

    public void speakingPaused() {
    }
}

