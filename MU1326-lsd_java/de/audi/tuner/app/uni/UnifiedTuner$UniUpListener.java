/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.app.uni.UnifiedTuner$1;

class UnifiedTuner$UniUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ UnifiedTuner this$0;

    private UnifiedTuner$UniUpListener(UnifiedTuner unifiedTuner) {
        this.this$0 = unifiedTuner;
    }

    @Override
    public void reNotification(int n) {
        this.this$0.reNotification(n);
    }

    @Override
    public void updateDetectedDevice(int n) {
        if (n == 3) {
            UnifiedTuner.access$700(this.this$0).getChoiceModel(-779681536).setValue(1);
            UnifiedTuner.access$900(this.this$0).addToBandList(11);
        } else {
            UnifiedTuner.access$700(this.this$0).getChoiceModel(-779681536).setValue(0);
        }
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        UnifiedTuner.access$500(this.this$0, unifiedStationExt);
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n) {
        boolean bl = n == 1;
        UnifiedTuner.access$700(this.this$0).getChoiceModel(-1316486912).setValue(bl ? 1 : 0);
    }

    /* synthetic */ UnifiedTuner$UniUpListener(UnifiedTuner unifiedTuner, UnifiedTuner$1 unifiedTuner$1) {
        this(unifiedTuner);
    }
}

