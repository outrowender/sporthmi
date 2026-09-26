/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.lang;

import de.audi.app.phone.core.event.AbstractTelLangUpdateEvent;
import de.audi.app.phone.core.lang.ILanguageUpdateListener;
import de.audi.app.phone.core.lang.LanguageUpdateDispatcher;
import de.audi.atip.i18n.Language;
import java.util.ArrayList;

class LanguageUpdateDispatcher$1
extends AbstractTelLangUpdateEvent {
    private final /* synthetic */ Language val$language;
    private final /* synthetic */ LanguageUpdateDispatcher this$0;

    LanguageUpdateDispatcher$1(LanguageUpdateDispatcher languageUpdateDispatcher, String string, Language language) {
        this.this$0 = languageUpdateDispatcher;
        this.val$language = language;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        ArrayList arrayList;
        LanguageUpdateDispatcher.access$000(this.this$0).log(1078071040, "[LanguageUpdateDispatcher#setLanguage] language='%1'", (Object)this.val$language);
        Object object = LanguageUpdateDispatcher.access$100(this.this$0);
        synchronized (object) {
            arrayList = (ArrayList)LanguageUpdateDispatcher.access$100(this.this$0).clone();
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((ILanguageUpdateListener)object.next()).setLanguage(this.val$language);
        }
    }
}

