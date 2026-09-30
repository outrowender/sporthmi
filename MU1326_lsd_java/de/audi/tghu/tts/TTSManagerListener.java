/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

public interface TTSManagerListener {
    public void sessionStarted();

    public void sessionStopped();

    public void speakingFinished();

    public void speakingAborted();

    public void sessionPaused();

    public void sessionResumed();

    public void speakingFailed();

    public void audioAvailable(boolean var1);
}

