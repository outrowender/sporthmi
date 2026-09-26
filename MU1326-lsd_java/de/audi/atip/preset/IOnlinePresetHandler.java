/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.Preset;

public interface IOnlinePresetHandler
extends IAppPresetDefinitionHandler {
    default public Preset updatePresetPreview(Preset preset) {
    }

    default public boolean isDynmaicOnlineModel(int n) {
    }
}

