/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UniStationList$1;
import de.audi.tuner.app.uni.UnifiedStationExt;
import java.util.List;

class UniStationList$UniDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ UniStationList this$0;

    private UniStationList$UniDownListener(UniStationList uniStationList) {
        this.this$0 = uniStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            UniStationList.access$800(this.this$0, unifiedStationExt);
            UniStationList.access$900(this.this$0);
        }
    }

    /* synthetic */ UniStationList$UniDownListener(UniStationList uniStationList, UniStationList$1 uniStationList$1) {
        this(uniStationList);
    }
}

