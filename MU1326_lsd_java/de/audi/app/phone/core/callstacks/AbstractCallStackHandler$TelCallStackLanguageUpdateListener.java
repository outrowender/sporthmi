/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.atip.i18n.Language;

class AbstractCallStackHandler$TelCallStackLanguageUpdateListener
extends AbstractTelLangaugeUpdateListener {
    private final /* synthetic */ AbstractCallStackHandler this$0;

    public AbstractCallStackHandler$TelCallStackLanguageUpdateListener(AbstractCallStackHandler abstractCallStackHandler, ITelApplication iTelApplication) {
        this.this$0 = abstractCallStackHandler;
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void setLanguage(Language language) {
        this.log.log(1078071040, "[AbstractCallStackHandler.TelCallStackLanguageUpdateListener#setLanguage] refreshing call stack list.");
        this.this$0.updateCallStackEntries();
    }
}

