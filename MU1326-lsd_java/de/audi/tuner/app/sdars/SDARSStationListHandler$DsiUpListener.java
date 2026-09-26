/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.SeekPossibility;

class SDARSStationListHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSStationListHandler this$0;

    private SDARSStationListHandler$DsiUpListener(SDARSStationListHandler sDARSStationListHandler) {
        this.this$0 = sDARSStationListHandler;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        SDARSStationListHandler.access$300(this.this$0, stationInfoExt);
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        SDARSStationListHandler.access$400((SDARSStationListHandler)this.this$0).dsiUpInfo.updateStationList(stationInfoExtArray);
        SDARSStationListHandler.access$502(this.this$0, stationInfoExtArray);
        SDARSStationListHandler.access$600(this.this$0);
    }

    @Override
    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        SDARSStationListHandler.access$400((SDARSStationListHandler)this.this$0).dsiUpInfo.updateCategoryList(categoryInfoExtArray);
        SDARSStationListHandler.access$700(this.this$0, categoryInfoExtArray);
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility) {
        SDARSStationListHandler.access$800(this.this$0, seekPossibility);
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        SDARSStationListHandler.access$900(this.this$0, bl);
    }

    /* synthetic */ SDARSStationListHandler$DsiUpListener(SDARSStationListHandler sDARSStationListHandler, SDARSStationListHandler$1 sDARSStationListHandler$1) {
        this(sDARSStationListHandler);
    }
}

