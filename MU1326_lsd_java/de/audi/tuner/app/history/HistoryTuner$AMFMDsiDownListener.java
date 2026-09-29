/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiDownListener$1;

class HistoryTuner$AMFMDsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$AMFMDsiDownListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$AMFMDsiDownListener$1(this, "HistroyTuner.AMFMDsiDownListener.preTuneAction", aMFMStation, bl));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.preTuneAction] AM/FM station: %1", (Object)aMFMStation);
        HistoryTuner.access$1502(this.this$0, new TunerObjectContainer(aMFMStation));
        int n = HistoryTuner.access$1400(this.this$0).getModels().getActiveTuner();
        if (HistoryTuner.access$1600(this.this$0) && (n == 1 || n == 4 || n == 10)) {
            HistoryTuner.access$1700(this.this$0);
            HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$1500(this.this$0));
        }
    }

    /* synthetic */ HistoryTuner$AMFMDsiDownListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

