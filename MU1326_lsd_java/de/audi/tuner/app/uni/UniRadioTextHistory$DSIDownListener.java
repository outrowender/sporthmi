/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniRadioTextHistory;
import de.audi.tuner.app.uni.UniRadioTextHistory$1;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniRadioTextHistory$DSIDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ UniRadioTextHistory this$0;

    private UniRadioTextHistory$DSIDownListener(UniRadioTextHistory uniRadioTextHistory) {
        this.this$0 = uniRadioTextHistory;
    }

    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        UniRadioTextHistory.access$300(this.this$0, UniRadioTextHistory.access$200(unifiedStationExt));
        UniRadioTextHistory.access$402(this.this$0, unifiedStationExt);
    }

    /* synthetic */ UniRadioTextHistory$DSIDownListener(UniRadioTextHistory uniRadioTextHistory, UniRadioTextHistory$1 uniRadioTextHistory$1) {
        this(uniRadioTextHistory);
    }
}

