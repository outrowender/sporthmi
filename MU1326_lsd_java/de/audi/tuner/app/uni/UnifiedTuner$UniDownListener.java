/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.app.uni.UnifiedTuner$1;

class UnifiedTuner$UniDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ UnifiedTuner this$0;

    private UnifiedTuner$UniDownListener(UnifiedTuner unifiedTuner) {
        this.this$0 = unifiedTuner;
    }

    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        UnifiedTuner.access$500(this.this$0, unifiedStationExt);
        UnifiedTuner.access$600(this.this$0).abortAnnouncement();
    }

    @Override
    public void postTuneCommand(UnifiedStationExt unifiedStationExt, int n) {
        if (n != 0 && UnifiedTuner.access$700(this.this$0).getActiveTuner() == 11) {
            UnifiedTuner.access$800(this.this$0).demute();
        }
    }

    /* synthetic */ UnifiedTuner$UniDownListener(UnifiedTuner unifiedTuner, UnifiedTuner$1 unifiedTuner$1) {
        this(unifiedTuner);
    }
}

