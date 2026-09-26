/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.interapp.radio.IHistoryListService;
import de.audi.atip.interapp.tv.TVStation;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$HistoryListService$1;

class HistoryTuner$HistoryListService
implements IHistoryListService {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$HistoryListService(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void updateAudibleTVStation(TVStation tVStation) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$HistoryListService$1(this, "HistroyTuner.HistoryListService.updateAudibleTVStation", tVStation));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryListService.updateAudibleTVStation] %1", (Object)tVStation);
        if (tVStation == null) {
            HistoryTuner.access$2602(this.this$0, TunerObjectContainer.EMPTY_CONTAINER);
            HistoryTuner.access$2702(this.this$0, false);
        } else {
            HistoryTuner.access$2602(this.this$0, new TunerObjectContainer(tVStation));
            HistoryTuner.access$2702(this.this$0, true);
            HistoryTuner.access$1700(this.this$0);
            if (HistoryTuner.access$1800(this.this$0).highlight(HistoryTuner.access$2600(this.this$0)) == 0) {
                HistoryTuner.access$1900(this.this$0).cancel();
            }
        }
    }

    /* synthetic */ HistoryTuner$HistoryListService(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

