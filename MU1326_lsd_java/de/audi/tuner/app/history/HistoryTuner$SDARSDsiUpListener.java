/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener$1;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener$2;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener$3;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.ServiceStatus3;

class HistoryTuner$SDARSDsiUpListener
extends SDARSDsiUpInfo {
    private ServiceStatus3 serviceStatus = new ServiceStatus3();
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$SDARSDsiUpListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$SDARSDsiUpListener$1(this, "HistroyTuner.SDARSDsiUpListener.updateSelectedStation", stationInfoExt));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.updateSelectedStation] SDARS station: %1", (Object)stationInfoExt);
        HistoryTuner.access$2202(this.this$0, new TunerObjectContainer(stationInfoExt));
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && n == 7) {
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2200(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$SDARSDsiUpListener$2(this, "HistroyTuner.SDARSDsiUpListener.updateStationList", stationInfoExtArray));
            return;
        }
        HistoryTuner.access$1800(this.this$0).updateSdarsList(stationInfoExtArray);
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$SDARSDsiUpListener$3(this, "HistroyTuner.SDARSDsiUpListener.updateServiceStatus3", serviceStatus3));
            return;
        }
        if (this.serviceStatus.antennaStatus != serviceStatus3.antennaStatus) {
            this.serviceStatus = serviceStatus3;
            if (this.serviceStatus.antennaStatus == 1) {
                HistoryTuner.access$1800(this.this$0).setSDARSState(6);
            } else {
                HistoryTuner.access$1800(this.this$0).setSDARSState(0);
            }
        }
    }

    /* synthetic */ HistoryTuner$SDARSDsiUpListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

