/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.atip.i18n.Language;

class TelIntellicallHandler$IntellicallMainLanguageUpdateListener
extends AbstractTelLangaugeUpdateListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    public TelIntellicallHandler$IntellicallMainLanguageUpdateListener(TelIntellicallHandler telIntellicallHandler, ITelApplication iTelApplication) {
        this.this$0 = telIntellicallHandler;
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void setLanguage(Language language) {
        this.log.log(1078071040, "[TelIntellicallHandler.IntellicallMainLanguageUpdateListener#setLanguage] refreshing primary device name");
        TelIntellicallHandler.access$1400(this.this$0);
    }
}

