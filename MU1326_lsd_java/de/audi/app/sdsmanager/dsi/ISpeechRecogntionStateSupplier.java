/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.dsi.ISpeechRecognitionStateListener;

public interface ISpeechRecogntionStateSupplier {
    public boolean registerSpeechRecognitionStateListener(ISpeechRecognitionStateListener var1);

    public boolean unregisterSpeechRecognitionStateListener(ISpeechRecognitionStateListener var1);
}

