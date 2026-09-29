/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiUpListener$1;

class HistoryTuner$AMFMDsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$AMFMDsiUpListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$AMFMDsiUpListener$1(this, "HistroyTuner.AMFMDsiUpListener.updateSelectedStation", aMFMStation));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.updateSelectedStation] AM/FM station: %1", (Object)aMFMStation);
        HistoryTuner.access$1502(this.this$0, new TunerObjectContainer(aMFMStation));
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && (n == 1 || n == 4 || n == 10)) {
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$1500(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    /* synthetic */ HistoryTuner$AMFMDsiUpListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

