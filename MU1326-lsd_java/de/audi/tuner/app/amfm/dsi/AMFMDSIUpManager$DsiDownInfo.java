/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.ifc.ISimpleTuner;

class AMFMDSIUpManager$DsiDownInfo
extends AMFMDsiDownInfo {
    private final /* synthetic */ AMFMDSIUpManager this$0;

    private AMFMDSIUpManager$DsiDownInfo(AMFMDSIUpManager aMFMDSIUpManager) {
        this.this$0 = aMFMDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            AMFMDSIUpManager.access$302(this.this$0, true);
            AMFMDSIUpManager.access$402(this.this$0, aMFMStation);
            AMFMDSIUpManager.access$500(this.this$0).reset();
            AMFMDSIUpManager.access$600(this.this$0).clear();
            AMFMDSIUpManager.access$702(this.this$0, ISimpleTuner.EMPTY_HDSTATIONINFO);
            if (aMFMStation.waveband == 1 && !AMFMDSIUpManager.access$800(this.this$0).isFmHdModeOn() || aMFMStation.waveband == 3 && !AMFMDSIUpManager.access$800(this.this$0).isAmHdModeOn()) {
                AMFMDSIUpManager.access$902(this.this$0, 1);
            }
            if (bl || Utilities.isNARBuild()) {
                AMFMDSIUpManager.access$1000(this.this$0).cancel();
            } else {
                AMFMDSIUpManager.access$1000(this.this$0).restart();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void blockUpdates() {
        AMFMDSIUpManager.access$1100(this.this$0).setValue(1);
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            AMFMDSIUpManager.access$302(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unBlockUpdates() {
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            AMFMDSIUpManager.access$302(this.this$0, false);
            AMFMDSIUpManager.access$1000(this.this$0).cancel();
        }
    }

    /* synthetic */ AMFMDSIUpManager$DsiDownInfo(AMFMDSIUpManager aMFMDSIUpManager, AMFMDSIUpManager$1 aMFMDSIUpManager$1) {
        this(aMFMDSIUpManager);
    }
}

