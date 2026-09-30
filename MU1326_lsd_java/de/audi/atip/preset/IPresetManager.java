/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.preset;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import java.io.Serializable;

public interface IPresetManager {
    public void responseDefine(DefinitionRequest var1, int var2, Serializable var3, PresetListRow var4, int var5);

    public void responseExecute(ExecuteRequest var1, int var2);

    public void favoriteDefinitionChanged(DefinitionRequest var1, int var2, Serializable var3, PresetListRow var4, int var5);
}

