/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;

public interface IDictationStateManager {
    public static final int DICTATION_STATE_INACTIVE;
    public static final int DICTATION_STATE_ACTIVATED;
    public static final int DICTATION_STATE_STARTED;
    public static final int DICTATION_STATE_RECORDING;
    public static final int DICTATION_STATE_PROCESSING;

    default public void addObserver(IDictationStateObserver iDictationStateObserver) {
    }

    default public void removeObserver(IDictationStateObserver iDictationStateObserver) {
    }
}

