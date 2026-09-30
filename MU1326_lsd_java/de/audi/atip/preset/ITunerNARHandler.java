/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.IPresetManager;
import de.audi.atip.preset.Preset;

public interface ITunerNARHandler {
    public void injectPresetManager(IPresetManager var1);

    public void presetSavedByPresetPopup(int var1, Preset var2);
}

