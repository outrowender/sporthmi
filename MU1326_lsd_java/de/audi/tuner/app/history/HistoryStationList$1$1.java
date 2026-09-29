/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$1$1
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$sId;
    private final /* synthetic */ SdarsRadioText val$pdt;
    private final /* synthetic */ HistoryStationList$1 this$1;

    HistoryStationList$1$1(HistoryStationList$1 historyStationList$1, String string, int n, SdarsRadioText sdarsRadioText) {
        this.this$1 = historyStationList$1;
        this.val$sId = n;
        this.val$pdt = sdarsRadioText;
        super(string);
    }

    @Override
    public void run() {
        HistoryStationList.access$800(HistoryStationList$1.access$700(this.this$1)).updatePdt(this.val$sId, this.val$pdt);
    }
}

