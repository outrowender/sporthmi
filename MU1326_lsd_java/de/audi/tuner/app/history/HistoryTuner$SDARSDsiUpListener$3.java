/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;
import org.dsi.ifc.sdars.ServiceStatus3;

class HistoryTuner$SDARSDsiUpListener$3
extends AbstractNamedRunnable {
    private final /* synthetic */ ServiceStatus3 val$serviceStatus3;
    private final /* synthetic */ HistoryTuner$SDARSDsiUpListener this$1;

    HistoryTuner$SDARSDsiUpListener$3(HistoryTuner$SDARSDsiUpListener historyTuner$SDARSDsiUpListener, String string, ServiceStatus3 serviceStatus3) {
        this.this$1 = historyTuner$SDARSDsiUpListener;
        this.val$serviceStatus3 = serviceStatus3;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateServiceStatus3(this.val$serviceStatus3);
    }
}

