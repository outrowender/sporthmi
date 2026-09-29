/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList$OptionsListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$OptionsListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$newAmFmView;
    private final /* synthetic */ HistoryStationList$OptionsListener this$1;

    HistoryStationList$OptionsListener$1(HistoryStationList$OptionsListener historyStationList$OptionsListener, String string, int n) {
        this.this$1 = historyStationList$OptionsListener;
        this.val$newAmFmView = n;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.amFmViewChanged(this.val$newAmFmView);
    }
}

