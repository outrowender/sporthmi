/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$UniDsiDownListener$1;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;

class HistoryTuner$UniDsiDownListener
extends UniDsiDownInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$UniDsiDownListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$UniDsiDownListener$1(this, "HistroyTuner.UniDsiDownListener.preTuneCommand", unifiedStationExt));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.preTuneCommand] Unified station: %1", (Object)unifiedStationExt);
        HistoryTuner.access$2102(this.this$0, new TunerObjectContainer(unifiedStationExt));
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && n == 11) {
            HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2100(this.this$0));
        }
    }

    /* synthetic */ HistoryTuner$UniDsiDownListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

