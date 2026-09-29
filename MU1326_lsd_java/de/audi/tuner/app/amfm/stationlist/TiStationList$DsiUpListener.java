/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.stationlist.TiStationList;
import de.audi.tuner.app.amfm.stationlist.TiStationList$1;

class TiStationList$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ TiStationList this$0;

    private TiStationList$DsiUpListener(TiStationList tiStationList) {
        this.this$0 = tiStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        Object object = this.this$0.mutex;
        synchronized (object) {
            if (aMFMStation.waveband == 3 && this.this$0.models.getActiveTuner() == 10) {
                this.this$0.highlight(aMFMStation);
            }
        }
    }

    /* synthetic */ TiStationList$DsiUpListener(TiStationList tiStationList, TiStationList$1 tiStationList$1) {
        this(tiStationList);
    }
}

