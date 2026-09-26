/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.ExecuteRequest;

public interface IAppPresetExecutionHandler {
    default public int getExecutionType() {
    }

    default public void requestExecute(ExecuteRequest executeRequest) {
    }
}

