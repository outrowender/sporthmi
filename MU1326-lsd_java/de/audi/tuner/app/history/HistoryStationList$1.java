/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1$1;
import de.audi.tuner.app.sdars.PdtListener;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.ifc.IListResourceProvider;

class HistoryStationList$1
extends PdtListener {
    private final /* synthetic */ TunerBasics val$basics;
    private final /* synthetic */ HistoryStationList this$0;

    HistoryStationList$1(HistoryStationList historyStationList, IListResourceProvider iListResourceProvider, BaseListModelApp baseListModelApp, Object object, int n, TunerBasics tunerBasics) {
        this.this$0 = historyStationList;
        this.val$basics = tunerBasics;
        super(iListResourceProvider, baseListModelApp, object, n);
    }

    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        if (!this.val$basics.tunerJobQueue.isJobQueueDispatchThread()) {
            this.val$basics.tunerJobQueue.enqueue(new HistoryStationList$1$1(this, "HistoryStationList.PdtListener.updatePdt", n, sdarsRadioText));
            return;
        }
        super.updatePdt(n, sdarsRadioText);
    }

    static /* synthetic */ HistoryStationList access$700(HistoryStationList$1 historyStationList$1) {
        return historyStationList$1.this$0;
    }
}

