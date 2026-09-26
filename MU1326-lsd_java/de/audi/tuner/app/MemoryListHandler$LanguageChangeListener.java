/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.i18n.Language;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;

class MemoryListHandler$LanguageChangeListener
implements LanguageManager$ILanguageChangeListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$LanguageChangeListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void languageChanged(Language language) {
        Object object = MemoryListHandler.access$5200(this.this$0);
        synchronized (object) {
            boolean bl = MemoryListHandler.access$5300(this.this$0).isDisplayStationNames();
            MemoryListHandler.adjustRowLayoutsIfNecessary(MemoryListHandler.access$1700(this.this$0), MemoryListHandler.access$2800(this.this$0).getChoiceModel(1636368640), bl, MemoryListHandler.access$5400(this.this$0).getAmfmView());
        }
    }

    /* synthetic */ MemoryListHandler$LanguageChangeListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

