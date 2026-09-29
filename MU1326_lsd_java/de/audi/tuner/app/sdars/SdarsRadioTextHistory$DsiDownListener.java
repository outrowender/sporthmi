/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsRadioTextHistory;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class SdarsRadioTextHistory$DsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ SdarsRadioTextHistory this$0;

    private SdarsRadioTextHistory$DsiDownListener(SdarsRadioTextHistory sdarsRadioTextHistory) {
        this.this$0 = sdarsRadioTextHistory;
    }

    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        SdarsRadioTextHistory.access$300(this.this$0, stationInfoExt.sID);
    }

    /* synthetic */ SdarsRadioTextHistory$DsiDownListener(SdarsRadioTextHistory sdarsRadioTextHistory, SdarsRadioTextHistory$1 sdarsRadioTextHistory$1) {
        this(sdarsRadioTextHistory);
    }
}

