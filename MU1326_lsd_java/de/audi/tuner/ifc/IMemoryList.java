/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.TunerObjectContainer;

public interface IMemoryList {
    public TunerObjectContainer[] getList();

    public TunerObjectContainer[] getList(int var1);

    public TunerObjectContainer[] getList(int[] var1);

    public PresetIds getPresetIds(TunerObjectContainer var1);

    public boolean isEmpty();

    public boolean tuneByCombiID(int var1, int var2);
}

