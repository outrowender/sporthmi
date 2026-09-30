/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.recognizer;

public interface IRecognizerStateObserver {
    public void indicateStartOfSpeech();

    public void indicateEndOfSpeech();
}

