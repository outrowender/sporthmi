/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.ifc.IPrevNext;

class SDARSStationListHandler$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ SDARSStationListHandler this$0;

    private SDARSStationListHandler$PrevNextHandler(SDARSStationListHandler sDARSStationListHandler) {
        this.this$0 = sDARSStationListHandler;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        StationInfoExt stationInfoExt = SDARSStationListHandler.access$1900(this.this$0, bl, true);
        if (stationInfoExt != null) {
            SDARSStationListHandler.access$1300(this.this$0).selectStation(stationInfoExt, 0);
            if (!SDARSStationListHandler.access$2000(this.this$0).isDrawerOpen()) {
                SDARSStationListHandler.access$2100(this.this$0).trigger(ModelTrigger.JOIN_CURSOR);
            }
        }
    }

    /* synthetic */ SDARSStationListHandler$PrevNextHandler(SDARSStationListHandler sDARSStationListHandler, SDARSStationListHandler$1 sDARSStationListHandler$1) {
        this(sDARSStationListHandler);
    }
}

