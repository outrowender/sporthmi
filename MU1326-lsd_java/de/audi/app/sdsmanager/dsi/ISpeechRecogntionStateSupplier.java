/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;

public interface ISpeechRecogntionStateSupplier {
    default public boolean registerSpeechRecognitionStateListener(ISpeechRecognitionStateListener iSpeechRecognitionStateListener) {
    }

    default public boolean unregisterSpeechRecognitionStateListener(ISpeechRecognitionStateListener iSpeechRecognitionStateListener) {
    }
}

