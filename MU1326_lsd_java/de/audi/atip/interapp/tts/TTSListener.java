/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

public interface TTSListener {
    public void sessionStarted();

    public void sessionStopped();

    public void speakingFinished();

    public void speakingAborted();

    public void sessionPaused();

    public void sessionResumed();

    public void speakingFailed();

    public void audioAvailable(boolean var1);

    public void speakingStarted();

    public void speakingPaused();
}

