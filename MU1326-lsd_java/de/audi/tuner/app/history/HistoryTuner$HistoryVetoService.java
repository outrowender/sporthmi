/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.interapp.radio.IHistoryVetoService;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$HistoryVetoService$1;

class HistoryTuner$HistoryVetoService
implements IHistoryVetoService {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$HistoryVetoService(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void updateVeto(int n, boolean bl) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$HistoryVetoService$1(this, "HistroyTuner.HistoryVetoService.updateVeto", n, bl));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryVetoService.updateVeto] app %2, veto %1", bl, (long)n);
        if (n < 0 || n >= 2) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(10000, "[HistoryVetoService.updateVeto] veto ignored! %1 is a illegal app identifier", (long)n);
        } else {
            boolean bl2 = Utilities.checkIfAtLeastOneBooleanIsTrue(HistoryTuner.access$2800(this.this$0));
            HistoryTuner.access$2800((HistoryTuner)this.this$0)[n] = bl;
            if (!HistoryTuner.access$1900(this.this$0).isRunning()) {
                boolean bl3 = Utilities.checkIfAtLeastOneBooleanIsTrue(HistoryTuner.access$2800(this.this$0));
                if (bl2 && !bl3) {
                    HistoryTuner.access$1900(this.this$0).restart();
                }
            }
        }
    }

    /* synthetic */ HistoryTuner$HistoryVetoService(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

