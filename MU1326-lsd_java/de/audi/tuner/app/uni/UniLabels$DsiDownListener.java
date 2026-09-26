/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniLabels;
import de.audi.tuner.app.uni.UniLabels$1;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniLabels$DsiDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ UniLabels this$0;

    private UniLabels$DsiDownListener(UniLabels uniLabels) {
        this.this$0 = uniLabels;
    }

    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        UniLabels.access$200(this.this$0, unifiedStationExt);
    }

    /* synthetic */ UniLabels$DsiDownListener(UniLabels uniLabels, UniLabels$1 uniLabels$1) {
        this(uniLabels);
    }
}

