/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.i18n.Language;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$LanguageChangeListener$1;

class HistoryStationList$LanguageChangeListener
implements LanguageManager$ILanguageChangeListener {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$LanguageChangeListener(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    @Override
    public void languageChanged(Language language) {
        if (!HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$LanguageChangeListener$1(this, "HistoryStationList.LanguageChangeListener.languageChanged", language));
            return;
        }
        boolean bl = HistoryStationList.access$2200(this.this$0).isDisplayStationNames();
        MemoryListHandler.adjustRowLayoutsIfNecessary(HistoryStationList.access$900(this.this$0), HistoryStationList.access$2300(this.this$0).getChoiceModel(1636368640), bl, HistoryStationList.access$2400(this.this$0).getAmfmView());
    }

    /* synthetic */ HistoryStationList$LanguageChangeListener(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }
}

