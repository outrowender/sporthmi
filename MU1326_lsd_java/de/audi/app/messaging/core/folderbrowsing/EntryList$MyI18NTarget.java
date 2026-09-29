/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;

class EntryList$MyI18NTarget
implements I18NTarget {
    private final /* synthetic */ EntryList this$0;

    private EntryList$MyI18NTarget(EntryList entryList) {
        this.this$0 = entryList;
    }

    @Override
    public void setLanguage(Language language) {
        if (EntryList.access$4500(this.this$0).isInfo()) {
            EntryList.access$4600(this.this$0).log(1078071040, "[EntryList#setLanguage] language = %1", (Object)String.valueOf(language));
        }
        EntryList.access$4400(this.this$0);
    }

    /* synthetic */ EntryList$MyI18NTarget(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

