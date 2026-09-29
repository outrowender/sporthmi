/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelSDSHandler;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.SDSService;

class TelSDSHandler$SDSServiceTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelSDSHandler this$0;

    public TelSDSHandler$SDSServiceTracker(TelSDSHandler telSDSHandler, ITelApplication iTelApplication) {
        this.this$0 = telSDSHandler;
        super(iTelApplication, "App.Phone.Audio", TelSDSHandler.class$de$audi$atip$interapp$SDSService == null ? (TelSDSHandler.class$de$audi$atip$interapp$SDSService = TelSDSHandler.class$("de.audi.atip.interapp.SDSService")) : TelSDSHandler.class$de$audi$atip$interapp$SDSService);
    }

    @Override
    protected void serviceAvailable(Object object) {
        TelSDSHandler.access$002(this.this$0, (SDSService)object);
    }

    @Override
    protected void serviceRemoved(Object object) {
        TelSDSHandler.access$002(this.this$0, null);
    }
}

