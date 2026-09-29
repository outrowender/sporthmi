/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.SDARSTuner$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class SDARSTuner$DsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ SDARSTuner this$0;

    private SDARSTuner$DsiDownListener(SDARSTuner sDARSTuner) {
        this.this$0 = sDARSTuner;
    }

    @Override
    public void postTuneAction(StationInfoExt stationInfoExt, int n, int n2) {
        if (n != 0 && SDARSTuner.access$200(this.this$0).getActiveTuner() == 7) {
            SDARSTuner.access$300(this.this$0).demute(n2);
        }
    }

    /* synthetic */ SDARSTuner$DsiDownListener(SDARSTuner sDARSTuner, SDARSTuner$1 sDARSTuner$1) {
        this(sDARSTuner);
    }
}

