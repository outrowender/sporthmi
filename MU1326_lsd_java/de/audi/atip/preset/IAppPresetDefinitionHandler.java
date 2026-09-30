/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.DefinitionRequest;

public interface IAppPresetDefinitionHandler {
    public int getType();

    public int[] getModelIds();

    public void requestDefinition(DefinitionRequest var1);
}

