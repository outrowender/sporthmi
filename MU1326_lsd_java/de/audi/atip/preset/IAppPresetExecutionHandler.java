/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.preset.ExecuteRequest;

public interface IAppPresetExecutionHandler {
    public int getExecutionType();

    public void requestExecute(ExecuteRequest var1);
}

