/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager$1;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class SDARSDSIUpManager$DsiDownInfo
extends SDARSDsiDownInfo {
    private final /* synthetic */ SDARSDSIUpManager this$0;

    private SDARSDSIUpManager$DsiDownInfo(SDARSDSIUpManager sDARSDSIUpManager) {
        this.this$0 = sDARSDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void blockUpdatesForNextTune() {
        Object object = SDARSDSIUpManager.access$100(this.this$0);
        synchronized (object) {
            SDARSDSIUpManager.access$202(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        Object object = SDARSDSIUpManager.access$100(this.this$0);
        synchronized (object) {
            SDARSDSIUpManager.access$202(this.this$0, true);
            SDARSDSIUpManager.access$302(this.this$0, stationInfoExt);
        }
    }

    /* synthetic */ SDARSDSIUpManager$DsiDownInfo(SDARSDSIUpManager sDARSDSIUpManager, SDARSDSIUpManager$1 sDARSDSIUpManager$1) {
        this(sDARSDSIUpManager);
    }
}

