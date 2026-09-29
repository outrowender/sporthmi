/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$1;

class AbstractAmFmStationlistNar$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ AbstractAmFmStationlistNar this$0;

    private AbstractAmFmStationlistNar$DsiDownListener(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        this.this$0 = abstractAmFmStationlistNar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        Object object = this.this$0.mutex;
        synchronized (object) {
            AbstractAmFmStationlistNar.access$1002(this.this$0, true);
            if (aMFMStation.waveband == 1 && AbstractAmFmStationlistNar.access$1100(this.this$0) == 1 || aMFMStation.waveband == 3 && AbstractAmFmStationlistNar.access$1100(this.this$0) != 1 && AbstractAmFmStationlistNar.access$1100(this.this$0) == AbstractAmFmStationlistNar.access$1200(this.this$0).getActiveTuner()) {
                this.this$0.highlight(aMFMStation);
            }
        }
    }

    /* synthetic */ AbstractAmFmStationlistNar$DsiDownListener(AbstractAmFmStationlistNar abstractAmFmStationlistNar, AbstractAmFmStationlistNar$1 abstractAmFmStationlistNar$1) {
        this(abstractAmFmStationlistNar);
    }
}

