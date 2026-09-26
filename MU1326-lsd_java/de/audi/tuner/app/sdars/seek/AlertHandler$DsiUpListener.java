/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;

class AlertHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ AlertHandler this$0;

    AlertHandler$DsiUpListener(AlertHandler alertHandler) {
        this.this$0 = alertHandler;
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        AlertHandler.access$400(this.this$0, seekEntryArray);
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert) {
        AlertHandler.access$500(this.this$0, seekAlert);
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        AlertHandler.access$600(this.this$0, stationInfoExtArray);
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        AlertHandler.access$700(this.this$0, stationInfoExt);
    }

    @Override
    public void updateSignalStatus(boolean bl) {
        AlertHandler.access$800(this.this$0, bl);
    }
}

