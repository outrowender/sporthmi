/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.lang.AbstractTelLangaugeUpdateListener;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawaerClosedStatusLineHandler;
import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener$1;
import de.audi.atip.i18n.Language;

class EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener
extends AbstractTelLangaugeUpdateListener {
    private final /* synthetic */ EntertainmentDrawaerClosedStatusLineHandler this$0;

    public EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener(EntertainmentDrawaerClosedStatusLineHandler entertainmentDrawaerClosedStatusLineHandler, ITelApplication iTelApplication) {
        this.this$0 = entertainmentDrawaerClosedStatusLineHandler;
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
    }

    @Override
    public void setLanguage(Language language) {
        this.log.log(1078071040, "[EntertainmentDrawaerClosedStatusLineHandler.StatusLineHandlerLanguageUpdateListener#setLanguage] refreshing 'conference' text value.");
        this.getApplication().enqueueEvent(new EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener$1(this, "StatusLineHandlerLanguageUpdateListener", "refreshing 'conference' text value."));
    }

    static /* synthetic */ EntertainmentDrawaerClosedStatusLineHandler access$000(EntertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener entertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener) {
        return entertainmentDrawaerClosedStatusLineHandler$StatusLineHandlerLanguageUpdateListener.this$0;
    }
}

