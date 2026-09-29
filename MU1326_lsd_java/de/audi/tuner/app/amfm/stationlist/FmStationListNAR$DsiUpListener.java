/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.stationlist.FmStationListNAR;
import de.audi.tuner.app.amfm.stationlist.FmStationListNAR$1;

class FmStationListNAR$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FmStationListNAR this$0;

    private FmStationListNAR$DsiUpListener(FmStationListNAR fmStationListNAR) {
        this.this$0 = fmStationListNAR;
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

    /* synthetic */ FmStationListNAR$DsiUpListener(FmStationListNAR fmStationListNAR, FmStationListNAR$1 fmStationListNAR$1) {
        this(fmStationListNAR);
    }
}

