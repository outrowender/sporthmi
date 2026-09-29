/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$DABDsiUpListener$1;

class HistoryTuner$DABDsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$DABDsiUpListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$DABDsiUpListener$1(this, "HistroyTuner.DABDsiUpListener.updateCurrentStation", dabStation, dabReceptionStatus));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.updateCurrentStation] DAB station: %1", (Object)dabStation);
        HistoryTuner.access$2002(this.this$0, new TunerObjectContainer(dabStation));
        HistoryTuner.access$2000(this.this$0).setReceptionStatus(dabReceptionStatus.getReception());
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && n == 5) {
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2000(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    /* synthetic */ HistoryTuner$DABDsiUpListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

