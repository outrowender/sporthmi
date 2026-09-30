/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

public interface IDictationStateObserver {
    public void updateDictationState(int var1);

    public void updateDictationMaxDuration(long var1);

    public void indicateRecordingStarted();

    public void indicateRecordingStopped();
}

