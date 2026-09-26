/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.DefinitionRequest;

public interface IAppPresetDefinitionHandler {
    default public int getType() {
    }

    default public int[] getModelIds() {
    }

    default public void requestDefinition(DefinitionRequest definitionRequest) {
    }
}

