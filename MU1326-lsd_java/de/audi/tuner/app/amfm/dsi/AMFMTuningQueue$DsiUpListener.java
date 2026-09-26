/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue$1;

class AMFMTuningQueue$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AMFMTuningQueue this$0;

    private AMFMTuningQueue$DsiUpListener(AMFMTuningQueue aMFMTuningQueue) {
        this.this$0 = aMFMTuningQueue;
    }

    @Override
    public void selectStationStatus(int n) {
        AMFMTuningQueue.access$900(this.this$0, n, 1);
    }

    @Override
    public void selectFrequencyStatus(int n) {
        AMFMTuningQueue.access$900(this.this$0, n, 1);
    }

    /* synthetic */ AMFMTuningQueue$DsiUpListener(AMFMTuningQueue aMFMTuningQueue, AMFMTuningQueue$1 aMFMTuningQueue$1) {
        this(aMFMTuningQueue);
    }
}

