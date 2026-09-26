/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

public interface ISpeechRequestHandler {
    default public void prewarm() {
    }

    default public void cancelPrewarm() {
    }

    default public void startSpeechSession() {
    }

    default public void abortActiveSpeechSession() {
    }

    default public void pttReleasedAfterLongPress() {
    }
}

