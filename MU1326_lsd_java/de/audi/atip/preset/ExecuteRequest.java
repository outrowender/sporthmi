/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.IPresetManager;
import de.audi.atip.preset.Preset;

public class ExecuteRequest {
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR = 1;
    private final IPresetManager manager;
    private final Preset preset;

    public ExecuteRequest(IPresetManager iPresetManager, Preset preset) {
        this.preset = preset;
        this.manager = iPresetManager;
    }

    public Preset getPreset() {
        return this.preset;
    }

    public void responseExecute(int n) {
        this.manager.responseExecute(this, n);
    }
}

