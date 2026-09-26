/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniLabels;
import de.audi.tuner.app.uni.UniLabels$1;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniLabels$DsiUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ UniLabels this$0;

    private UniLabels$DsiUpListener(UniLabels uniLabels) {
        this.this$0 = uniLabels;
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        UniLabels.access$200(this.this$0, unifiedStationExt);
    }

    /* synthetic */ UniLabels$DsiUpListener(UniLabels uniLabels, UniLabels$1 uniLabels$1) {
        this(uniLabels);
    }
}

