/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$HistoryVetoService;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$HistoryVetoService$1
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$from;
    private final /* synthetic */ boolean val$veto;
    private final /* synthetic */ HistoryTuner$HistoryVetoService this$1;

    HistoryTuner$HistoryVetoService$1(HistoryTuner$HistoryVetoService historyTuner$HistoryVetoService, String string, int n, boolean bl) {
        this.this$1 = historyTuner$HistoryVetoService;
        this.val$from = n;
        this.val$veto = bl;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateVeto(this.val$from, this.val$veto);
    }
}

