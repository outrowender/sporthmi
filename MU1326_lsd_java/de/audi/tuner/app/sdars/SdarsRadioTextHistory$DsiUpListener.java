/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SdarsRadioTextHistory;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;

class SdarsRadioTextHistory$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SdarsRadioTextHistory this$0;

    private SdarsRadioTextHistory$DsiUpListener(SdarsRadioTextHistory sdarsRadioTextHistory) {
        this.this$0 = sdarsRadioTextHistory;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        SdarsRadioTextHistory.access$300(this.this$0, stationInfoExt.sID);
    }

    /* synthetic */ SdarsRadioTextHistory$DsiUpListener(SdarsRadioTextHistory sdarsRadioTextHistory, SdarsRadioTextHistory$1 sdarsRadioTextHistory$1) {
        this(sdarsRadioTextHistory);
    }
}

