/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.app.phone.core.state.GlobalTelephoneStateModelHandler;
import de.audi.atip.i18n.Language;

class GlobalTelephoneStateModelHandler$GlobalTelephoneStateModelHandlerLanguageUpdateListener
extends AbstractTelLangaugeUpdateListener {
    private final /* synthetic */ GlobalTelephoneStateModelHandler this$0;

    public GlobalTelephoneStateModelHandler$GlobalTelephoneStateModelHandlerLanguageUpdateListener(GlobalTelephoneStateModelHandler globalTelephoneStateModelHandler, ITelApplication iTelApplication) {
        this.this$0 = globalTelephoneStateModelHandler;
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void setLanguage(Language language) {
        this.log.log(1078071040, "[GlobalTelephoneStateModelHandler.GlobalTelephoneStateModelHandlerLanguageUpdateListener#setLanguage] refreshing primary phone models.");
        GlobalTelephoneStateModelHandler.access$000(this.this$0);
    }
}

