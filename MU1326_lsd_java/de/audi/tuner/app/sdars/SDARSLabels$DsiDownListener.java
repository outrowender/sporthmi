/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSLabels;
import de.audi.tuner.app.sdars.SDARSLabels$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class SDARSLabels$DsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ SDARSLabels this$0;

    private SDARSLabels$DsiDownListener(SDARSLabels sDARSLabels) {
        this.this$0 = sDARSLabels;
    }

    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        SDARSLabels.access$502(this.this$0, stationInfoExt);
        SDARSLabels.access$400(this.this$0).getLabelModel(1015480576).setText("");
        SDARSLabels.access$300(this.this$0, true);
    }

    /* synthetic */ SDARSLabels$DsiDownListener(SDARSLabels sDARSLabels, SDARSLabels$1 sDARSLabels$1) {
        this(sDARSLabels);
    }
}

