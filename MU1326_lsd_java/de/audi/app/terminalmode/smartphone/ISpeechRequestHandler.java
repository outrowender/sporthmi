/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

public interface ISpeechRequestHandler {
    public void prewarm();

    public void cancelPrewarm();

    public void startSpeechSession();

    public void abortActiveSpeechSession();

    public void pttReleasedAfterLongPress();
}

