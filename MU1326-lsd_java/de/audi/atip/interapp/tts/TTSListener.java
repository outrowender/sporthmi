/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

public interface TTSListener {
    default public void sessionStarted() {
    }

    default public void sessionStopped() {
    }

    default public void speakingFinished() {
    }

    default public void speakingAborted() {
    }

    default public void sessionPaused() {
    }

    default public void sessionResumed() {
    }

    default public void speakingFailed() {
    }

    default public void audioAvailable(boolean bl) {
    }

    default public void speakingStarted() {
    }

    default public void speakingPaused() {
    }
}

