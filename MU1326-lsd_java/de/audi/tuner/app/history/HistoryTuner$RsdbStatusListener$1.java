/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$RsdbStatusListener;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$RsdbStatusListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ ILogoDatabase val$logoDb;
    private final /* synthetic */ HistoryTuner$RsdbStatusListener this$1;

    HistoryTuner$RsdbStatusListener$1(HistoryTuner$RsdbStatusListener historyTuner$RsdbStatusListener, String string, ILogoDatabase iLogoDatabase) {
        this.this$1 = historyTuner$RsdbStatusListener;
        this.val$logoDb = iLogoDatabase;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.databaseReady(this.val$logoDb);
    }
}

