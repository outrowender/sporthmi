/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$3
extends AbstractNamedRunnable {
    private final /* synthetic */ boolean val$on;
    private final /* synthetic */ HistoryTuner this$0;

    HistoryTuner$3(HistoryTuner historyTuner, String string, boolean bl) {
        this.this$0 = historyTuner;
        this.val$on = bl;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.setNamesOnOff(this.val$on);
    }
}

