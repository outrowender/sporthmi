/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.Preset;

public interface IOnlinePresetHandler
extends IAppPresetDefinitionHandler {
    public Preset updatePresetPreview(Preset var1);

    public boolean isDynmaicOnlineModel(int var1);
}

