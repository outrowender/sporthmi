/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupServiceHandlerCall;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;

class TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelBAPMethodHangupServiceHandlerCall this$0;

    public TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker(TelBAPMethodHangupServiceHandlerCall telBAPMethodHangupServiceHandlerCall, ITelApplication iTelApplication) {
        this.this$0 = telBAPMethodHangupServiceHandlerCall;
        super(iTelApplication, "App.Phone.Main", TelBAPMethodHangupServiceHandlerCall.class$de$audi$atip$interapp$phone$ITelEcallService == null ? (TelBAPMethodHangupServiceHandlerCall.class$de$audi$atip$interapp$phone$ITelEcallService = TelBAPMethodHangupServiceHandlerCall.class$("de.audi.atip.interapp.phone.ITelEcallService")) : TelBAPMethodHangupServiceHandlerCall.class$de$audi$atip$interapp$phone$ITelEcallService);
    }

    @Override
    protected void serviceAvailable(Object object) {
        this.log.log(1078071040, "TelBAPMethodHangupServiceHandlerCall.TelServiceListenerTracker#serviceAvailable(): %1", object);
        TelBAPMethodHangupServiceHandlerCall.access$002(this.this$0, (ITelEcallService)object);
    }

    @Override
    protected void serviceRemoved(Object object) {
        this.log.log(1078071040, "TelBAPMethodHangupServiceHandlerCall.TelServiceListenerTracker#serviceRemoved(): %1", object);
        TelBAPMethodHangupServiceHandlerCall.access$002(this.this$0, new NullTelEcallService(this.log));
    }
}

