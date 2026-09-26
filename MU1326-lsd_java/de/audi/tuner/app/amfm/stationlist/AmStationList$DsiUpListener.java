/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.stationlist.AmStationList;
import de.audi.tuner.app.amfm.stationlist.AmStationList$1;

class AmStationList$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AmStationList this$0;

    private AmStationList$DsiUpListener(AmStationList amStationList) {
        this.this$0 = amStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationListAM(AMFMStation[] aMFMStationArray) {
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
            if (aMFMStation.waveband == 3 && this.this$0.models.getActiveTuner() == 4) {
                this.this$0.highlight(aMFMStation);
            }
        }
    }

    /* synthetic */ AmStationList$DsiUpListener(AmStationList amStationList, AmStationList$1 amStationList$1) {
        this(amStationList);
    }
}

