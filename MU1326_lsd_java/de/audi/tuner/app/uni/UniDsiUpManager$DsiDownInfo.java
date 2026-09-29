/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpManager;
import de.audi.tuner.app.uni.UniDsiUpManager$1;
import de.audi.tuner.app.uni.UnifiedStationExt;

class UniDsiUpManager$DsiDownInfo
extends UniDsiDownInfo {
    private final /* synthetic */ UniDsiUpManager this$0;

    private UniDsiUpManager$DsiDownInfo(UniDsiUpManager uniDsiUpManager) {
        this.this$0 = uniDsiUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void blockUpdates() {
        Object object = UniDsiUpManager.access$300(this.this$0);
        synchronized (object) {
            UniDsiUpManager.access$1102(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        Object object = UniDsiUpManager.access$300(this.this$0);
        synchronized (object) {
            UniDsiUpManager.access$602(this.this$0, true);
            UniDsiUpManager.access$1200(this.this$0).clear();
            UniDsiUpManager.access$1300(this.this$0).reset();
            UniDsiUpManager.access$1400(this.this$0).clear();
            UniDsiUpManager.access$1102(this.this$0, true);
            UniDsiUpManager.access$200(this.this$0).restart();
            if (unifiedStationExt.hasPrimaryService()) {
                UniDsiUpManager.access$1502(this.this$0, unifiedStationExt);
            } else {
                UniDsiUpManager.access$1502(this.this$0, null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void postTuneCommand(UnifiedStationExt unifiedStationExt, int n) {
        if (n == 0) {
            Object object = UniDsiUpManager.access$300(this.this$0);
            synchronized (object) {
                UniDsiUpManager.access$200(this.this$0).cancel();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unBlockUpdates() {
        Object object = UniDsiUpManager.access$300(this.this$0);
        synchronized (object) {
            UniDsiUpManager.access$602(this.this$0, false);
            UniDsiUpManager.access$1102(this.this$0, false);
            UniDsiUpManager.access$200(this.this$0).cancel();
        }
    }

    /* synthetic */ UniDsiUpManager$DsiDownInfo(UniDsiUpManager uniDsiUpManager, UniDsiUpManager$1 uniDsiUpManager$1) {
        this(uniDsiUpManager);
    }
}

