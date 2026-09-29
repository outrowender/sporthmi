/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class SDARSStationListHandler$DsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ SDARSStationListHandler this$0;

    private SDARSStationListHandler$DsiDownListener(SDARSStationListHandler sDARSStationListHandler) {
        this.this$0 = sDARSStationListHandler;
    }

    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        SDARSStationListHandler.access$300(this.this$0, stationInfoExt);
    }

    /* synthetic */ SDARSStationListHandler$DsiDownListener(SDARSStationListHandler sDARSStationListHandler, SDARSStationListHandler$1 sDARSStationListHandler$1) {
        this(sDARSStationListHandler);
    }
}

