/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.i18n.Language;
import de.audi.tuner.app.history.HistoryStationList$LanguageChangeListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$LanguageChangeListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ Language val$newLanguage;
    private final /* synthetic */ HistoryStationList$LanguageChangeListener this$1;

    HistoryStationList$LanguageChangeListener$1(HistoryStationList$LanguageChangeListener historyStationList$LanguageChangeListener, String string, Language language) {
        this.this$1 = historyStationList$LanguageChangeListener;
        this.val$newLanguage = language;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.languageChanged(this.val$newLanguage);
    }
}

