/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.SDARSTuner$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.StationDescription;

class SDARSTuner$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSTuner this$0;

    private SDARSTuner$DsiUpListener(SDARSTuner sDARSTuner) {
        this.this$0 = sDARSTuner;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        this.this$0.updateSelectedStation(stationInfoExt);
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        this.this$0.updateStationList(stationInfoExtArray);
    }

    @Override
    public void updateElectronicSerialCode(String string) {
        SDARSTuner.access$200(this.this$0).getLabelModel(222).setText(string);
        SDARSTuner.access$200(this.this$0).getLabelModel(125).setText(string);
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        SDARSTuner.access$400(this.this$0).updateServiceStatus(serviceStatus3);
    }

    @Override
    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        this.this$0.updateCategoryList(categoryInfoExtArray);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.this$0.updateDetectedDevice(n);
    }

    @Override
    public void updateAvailability(int n) {
        this.this$0.updateAvailability(n);
    }

    @Override
    public void selectStationStatus(int n) {
        this.this$0.selectStationStatus(n);
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        SDARSTuner.access$500(this.this$0).updateStationDescriptions(stationDescriptionArray);
    }

    /* synthetic */ SDARSTuner$DsiUpListener(SDARSTuner sDARSTuner, SDARSTuner$1 sDARSTuner$1) {
        this(sDARSTuner);
    }
}

