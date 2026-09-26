/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.sds.TunerServiceHandler;

class TunerServiceHandler$1
implements IMemoryList {
    private final /* synthetic */ TunerServiceHandler this$0;

    TunerServiceHandler$1(TunerServiceHandler tunerServiceHandler) {
        this.this$0 = tunerServiceHandler;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public PresetIds getPresetIds(TunerObjectContainer tunerObjectContainer) {
        return new PresetIds(0, 0);
    }

    @Override
    public TunerObjectContainer[] getList(int[] nArray) {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer[] getList(int n) {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer[] getList() {
        return new TunerObjectContainer[0];
    }

    @Override
    public boolean tuneByCombiID(int n, int n2) {
        return false;
    }
}

