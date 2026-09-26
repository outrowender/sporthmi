/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

public interface IDictationStateObserver {
    default public void updateDictationState(int n) {
    }

    default public void updateDictationMaxDuration(long l) {
    }

    default public void indicateRecordingStarted() {
    }

    default public void indicateRecordingStopped() {
    }
}

