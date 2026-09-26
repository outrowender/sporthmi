/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniVolumeLockHandler;
import de.audi.tuner.app.uni.UniVolumeLockHandler$1;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniVolumeLockHandler$DsiUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ UniVolumeLockHandler this$0;

    private UniVolumeLockHandler$DsiUpListener(UniVolumeLockHandler uniVolumeLockHandler) {
        this.this$0 = uniVolumeLockHandler;
    }

    @Override
    public void updateAudioStatus(int n) {
        UniVolumeLockHandler.access$102(this.this$0, n);
        UniVolumeLockHandler.access$200(this.this$0);
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        UniVolumeLockHandler.access$102(this.this$0, unifiedStationExt.getAudioStatus());
        UniVolumeLockHandler.access$200(this.this$0);
    }

    @Override
    public void selectionIsRunning(boolean bl) {
        UniVolumeLockHandler.access$302(this.this$0, bl);
        UniVolumeLockHandler.access$200(this.this$0);
    }

    @Override
    public void updateDetectedDevice(int n) {
        UniVolumeLockHandler.access$402(this.this$0, n);
        UniVolumeLockHandler.access$200(this.this$0);
    }

    /* synthetic */ UniVolumeLockHandler$DsiUpListener(UniVolumeLockHandler uniVolumeLockHandler, UniVolumeLockHandler$1 uniVolumeLockHandler$1) {
        this(uniVolumeLockHandler);
    }
}

