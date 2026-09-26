/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue$1;

class SDARSTuningQueue$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSTuningQueue this$0;

    private SDARSTuningQueue$DsiUpListener(SDARSTuningQueue sDARSTuningQueue) {
        this.this$0 = sDARSTuningQueue;
    }

    @Override
    public void selectStationStatus(int n) {
        this.this$0.selectStationStatus(n);
    }

    /* synthetic */ SDARSTuningQueue$DsiUpListener(SDARSTuningQueue sDARSTuningQueue, SDARSTuningQueue$1 sDARSTuningQueue$1) {
        this(sDARSTuningQueue);
    }
}

