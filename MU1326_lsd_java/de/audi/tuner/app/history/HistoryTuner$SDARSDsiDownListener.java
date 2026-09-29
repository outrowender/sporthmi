/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$SDARSDsiDownListener$1;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;

class HistoryTuner$SDARSDsiDownListener
extends SDARSDsiDownInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$SDARSDsiDownListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void preTuneAction(StationInfoExt stationInfoExt) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$SDARSDsiDownListener$1(this, "HistroyTuner.SDARSDsiDownListener.preTuneAction", stationInfoExt));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.preTuneAction] SDARS station: %1", (Object)stationInfoExt);
        HistoryTuner.access$2202(this.this$0, new TunerObjectContainer(stationInfoExt));
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && n == 7) {
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2200(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    /* synthetic */ HistoryTuner$SDARSDsiDownListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

