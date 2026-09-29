/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelOnlinePhoneStateUpdater;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.online.IPhoneStateService;

class TelOnlinePhoneStateUpdater$OnlineServiceRegistrationListener
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelOnlinePhoneStateUpdater this$0;

    public TelOnlinePhoneStateUpdater$OnlineServiceRegistrationListener(TelOnlinePhoneStateUpdater telOnlinePhoneStateUpdater, ITelApplication iTelApplication) {
        this.this$0 = telOnlinePhoneStateUpdater;
        super(iTelApplication, "App.Phone.Main", TelOnlinePhoneStateUpdater.class$de$audi$atip$interapp$online$IPhoneStateService == null ? (TelOnlinePhoneStateUpdater.class$de$audi$atip$interapp$online$IPhoneStateService = TelOnlinePhoneStateUpdater.class$("de.audi.atip.interapp.online.IPhoneStateService")) : TelOnlinePhoneStateUpdater.class$de$audi$atip$interapp$online$IPhoneStateService);
    }

    @Override
    protected void serviceAvailable(Object object) {
        TelOnlinePhoneStateUpdater.access$002(this.this$0, (IPhoneStateService)object);
        this.log.log(1078071040, "[TelOnlinePhoneStateUpdater.OnlineServiceRegistrationListener#serviceAvailable] phoneReady=%1", TelOnlinePhoneStateUpdater.access$100(this.this$0));
        TelOnlinePhoneStateUpdater.access$000(this.this$0).updatePhoneStatus(TelOnlinePhoneStateUpdater.access$100(this.this$0));
    }

    @Override
    protected void serviceRemoved(Object object) {
        TelOnlinePhoneStateUpdater.access$002(this.this$0, null);
    }
}

