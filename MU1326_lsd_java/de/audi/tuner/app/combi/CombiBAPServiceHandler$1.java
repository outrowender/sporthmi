/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.ifc.IMemoryList;

class CombiBAPServiceHandler$1
implements IMemoryList {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    CombiBAPServiceHandler$1(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
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

