/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.stationlist.FmStationList;
import de.audi.tuner.app.amfm.stationlist.FmStationList$1;

class FmStationList$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FmStationList this$0;

    private FmStationList$DsiUpListener(FmStationList fmStationList) {
        this.this$0 = fmStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationListFM(AMFMStation[] aMFMStationArray) {
        Object object = this.this$0.mutex;
        synchronized (object) {
            this.this$0.lastList = aMFMStationArray;
            this.this$0.doListUpdate(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        Object object = this.this$0.mutex;
        synchronized (object) {
            if (aMFMStation.waveband == 1) {
                this.this$0.highlight(aMFMStation);
            }
        }
    }

    /* synthetic */ FmStationList$DsiUpListener(FmStationList fmStationList, FmStationList$1 fmStationList$1) {
        this(fmStationList);
    }
}

