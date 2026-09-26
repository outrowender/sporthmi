/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$DABDsiDownListener$1;

class HistoryTuner$DABDsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$DABDsiDownListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$DABDsiDownListener$1(this, "HistroyTuner.DABDsiDownListener.preTuneAction", dabStation, dabReceptionStatus, n));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.preTuneAction] DAB station: %1", (Object)dabStation);
        HistoryTuner.access$2002(this.this$0, new TunerObjectContainer(dabStation));
        HistoryTuner.access$2000(this.this$0).setReceptionStatus(dabReceptionStatus.getReception());
        int n2 = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && n2 == 5) {
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2000(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    /* synthetic */ HistoryTuner$DABDsiDownListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

