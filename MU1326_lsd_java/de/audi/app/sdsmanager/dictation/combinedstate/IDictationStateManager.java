/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;

public interface IDictationStateManager {
    public static final int DICTATION_STATE_INACTIVE = 0;
    public static final int DICTATION_STATE_ACTIVATED = 1;
    public static final int DICTATION_STATE_STARTED = 2;
    public static final int DICTATION_STATE_RECORDING = 3;
    public static final int DICTATION_STATE_PROCESSING = 4;

    public void addObserver(IDictationStateObserver var1);

    public void removeObserver(IDictationStateObserver var1);
}

