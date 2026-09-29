/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$2
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$imgType;
    private final /* synthetic */ HistoryTuner this$0;

    HistoryTuner$2(HistoryTuner historyTuner, String string, int n) {
        this.this$0 = historyTuner;
        this.val$imgType = n;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.setPreferredImgType(this.val$imgType);
    }
}

