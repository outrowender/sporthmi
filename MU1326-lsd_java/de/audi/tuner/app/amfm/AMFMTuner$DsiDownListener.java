/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AMFMTuner$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class AMFMTuner$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ AMFMTuner this$0;

    private AMFMTuner$DsiDownListener(AMFMTuner aMFMTuner) {
        this.this$0 = aMFMTuner;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        AMFMTuner.access$400(this.this$0, aMFMStation);
    }

    @Override
    public void postTuneAction(AMFMStation aMFMStation, int n) {
        AMFMTuner.access$600(this.this$0, aMFMStation, AMFMTuner.access$500(this.this$0).getActiveTuner());
    }

    @Override
    public void setNotificationForSelectedStation() {
        this.this$0.setNotification(new int[]{1, 20});
    }

    /* synthetic */ AMFMTuner$DsiDownListener(AMFMTuner aMFMTuner, AMFMTuner$1 aMFMTuner$1) {
        this(aMFMTuner);
    }
}

