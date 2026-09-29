/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.TunerObjectContainer;

public interface IMemoryList {
    default public TunerObjectContainer[] getList() {
    }

    default public TunerObjectContainer[] getList(int n) {
    }

    default public TunerObjectContainer[] getList(int[] nArray) {
    }

    default public PresetIds getPresetIds(TunerObjectContainer tunerObjectContainer) {
    }

    default public boolean isEmpty() {
    }

    default public boolean tuneByCombiID(int n, int n2) {
    }
}

