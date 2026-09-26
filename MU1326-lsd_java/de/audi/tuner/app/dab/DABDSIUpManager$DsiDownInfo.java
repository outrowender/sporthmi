/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.app.dab.DABDSIUpManager$1;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;

class DABDSIUpManager$DsiDownInfo
extends DABDsiDownInfo {
    private final /* synthetic */ DABDSIUpManager this$0;

    private DABDSIUpManager$DsiDownInfo(DABDSIUpManager dABDSIUpManager) {
        this.this$0 = dABDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        Object object = DABDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            DABDSIUpManager.access$302(this.this$0, 1);
            DABDSIUpManager.access$400(this.this$0).clear();
            DABDSIUpManager.access$500(this.this$0).clear();
            DABDSIUpManager.access$600(this.this$0).reset();
            DABDSIUpManager.access$702(this.this$0, true);
        }
    }

    @Override
    public void seekStarted() {
        DABDSIUpManager.access$802(this.this$0, 1);
        DABDSIUpManager.access$400(this.this$0).clear();
        DABDSIUpManager.access$500(this.this$0).clear();
        DABDSIUpManager.access$600(this.this$0).reset();
    }

    /* synthetic */ DABDSIUpManager$DsiDownInfo(DABDSIUpManager dABDSIUpManager, DABDSIUpManager$1 dABDSIUpManager$1) {
        this(dABDSIUpManager);
    }
}

