/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UniStationList$1;
import de.audi.tuner.app.uni.UnifiedStationExt;
import java.util.List;

class UniStationList$UniUpListener
extends UniDsiUpInfo {
    boolean lowReception = false;
    private final /* synthetic */ UniStationList this$0;

    private UniStationList$UniUpListener(UniStationList uniStationList) {
        this.this$0 = uniStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        boolean bl;
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            if (UniStationList.access$1000(this.this$0) != null && UniStationList.access$1000(this.this$0).hasPrimaryService() && !unifiedStationExt.hasPrimaryService() && UnifiedStationExt.equals(UniStationList.access$1000(this.this$0), unifiedStationExt)) {
                unifiedStationExt.setPrimaryService(UniStationList.access$1000(this.this$0).getPrimaryService());
            }
            UniStationList.access$900(this.this$0);
            UniStationList.access$800(this.this$0, unifiedStationExt);
        }
        boolean bl2 = bl = unifiedStationExt.getAudioStatus() == 3;
        if (this.lowReception != bl) {
            this.lowReception = bl;
            this.this$0.propagateUpdatedMuteStatus(11, this.lowReception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationList(UnifiedStationExt[] unifiedStationExtArray, UnifiedStationExt unifiedStationExt) {
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            UniStationList.access$1102(this.this$0, unifiedStationExtArray);
            UniStationList.access$900(this.this$0);
            if (unifiedStationExt != null) {
                UniStationList.access$1002(this.this$0, unifiedStationExt);
            }
            UniStationList.access$1200(this.this$0);
        }
    }

    /* synthetic */ UniStationList$UniUpListener(UniStationList uniStationList, UniStationList$1 uniStationList$1) {
        this(uniStationList);
    }
}

