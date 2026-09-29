/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.IPresetManager;
import de.audi.atip.preset.Preset;

public interface ITunerNARHandler {
    default public void injectPresetManager(IPresetManager iPresetManager) {
    }

    default public void presetSavedByPresetPopup(int n, Preset preset) {
    }
}

