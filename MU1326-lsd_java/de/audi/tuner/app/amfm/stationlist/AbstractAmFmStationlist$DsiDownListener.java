/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$1;

class AbstractAmFmStationlist$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ AbstractAmFmStationlist this$0;

    private AbstractAmFmStationlist$DsiDownListener(AbstractAmFmStationlist abstractAmFmStationlist) {
        this.this$0 = abstractAmFmStationlist;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        Object object = this.this$0.mutex;
        synchronized (object) {
            if (aMFMStation.waveband == 1 && AbstractAmFmStationlist.access$1200(this.this$0) == 1 || aMFMStation.waveband == 3 && AbstractAmFmStationlist.access$1200(this.this$0) != 1 && AbstractAmFmStationlist.access$1200(this.this$0) == this.this$0.models.getActiveTuner()) {
                this.this$0.highlight(aMFMStation);
            }
        }
    }

    /* synthetic */ AbstractAmFmStationlist$DsiDownListener(AbstractAmFmStationlist abstractAmFmStationlist, AbstractAmFmStationlist$1 abstractAmFmStationlist$1) {
        this(abstractAmFmStationlist);
    }
}

