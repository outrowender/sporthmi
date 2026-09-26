/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.recognizer;

public interface IRecognizerStateObserver {
    default public void indicateStartOfSpeech() {
    }

    default public void indicateEndOfSpeech() {
    }
}

