/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class AMFMTuner$MemoryListener
extends DefaultUpdateListener
implements IUpdateListener {
    private final IMemoryList memory;
    private final /* synthetic */ AMFMTuner this$0;

    public AMFMTuner$MemoryListener(AMFMTuner aMFMTuner, IMemoryList iMemoryList) {
        this.this$0 = aMFMTuner;
        this.memory = iMemoryList;
    }

    @Override
    public void updatedMemoryList() {
        TunerObjectContainer[] tunerObjectContainerArray = this.memory.getList(new int[]{1, 4});
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            AMFMStation aMFMStation = tunerObjectContainerArray[i2].getAMFMService();
            if (n == 0 && RadioComparators.equals(AMFMTuner.access$1000(this.this$0), aMFMStation)) {
                n = aMFMStation.getPresetPos();
            }
            if (n2 == 0 && RadioComparators.equals(AMFMTuner.access$1100(this.this$0), aMFMStation)) {
                n2 = aMFMStation.getPresetPos();
            }
            if (n3 != 0 || !RadioComparators.equals(AMFMTuner.access$1200(this.this$0), aMFMStation)) continue;
            n3 = aMFMStation.getPresetPos();
        }
        AMFMTuner.access$1000(this.this$0).setPresetPos(n);
        AMFMTuner.access$1100(this.this$0).setPresetPos(n2);
        AMFMTuner.access$1200(this.this$0).setPresetPos(n3);
    }
}

