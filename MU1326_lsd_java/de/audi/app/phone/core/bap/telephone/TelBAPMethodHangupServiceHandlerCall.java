/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.interapp.phone.NullTelEcallService;

public class TelBAPMethodHangupServiceHandlerCall {
    private volatile ITelEcallService telEcallService;
    private final TelEcallServiceTracker telEcallServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;

    public TelBAPMethodHangupServiceHandlerCall(ITelApplication iTelApplication) {
        this.telEcallServiceTracker = new TelEcallServiceTracker(iTelApplication);
    }

    void hangupServiceCall() {
        this.telEcallService.hangupServiceCall();
    }

    void hangupLowPrioritySOSCall() {
        this.telEcallService.hangupLowPrioritySOSCall();
    }

    public void onCombiServiceChanged(CombiBAPServicePhone combiBAPServicePhone) {
        if (combiBAPServicePhone == null) {
            this.telEcallServiceTracker.deinit();
        } else {
            this.telEcallServiceTracker.init();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelEcallServiceTracker
    extends AbstractTelServiceTracker {
        public TelEcallServiceTracker(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", class$de$audi$atip$interapp$phone$ITelEcallService == null ? (class$de$audi$atip$interapp$phone$ITelEcallService = TelBAPMethodHangupServiceHandlerCall.class$("de.audi.atip.interapp.phone.ITelEcallService")) : class$de$audi$atip$interapp$phone$ITelEcallService);
        }

        protected void serviceAvailable(Object object) {
            this.log.log(1000000, "TelBAPMethodHangupServiceHandlerCall.TelServiceListenerTracker#serviceAvailable(): %1", object);
            TelBAPMethodHangupServiceHandlerCall.this.telEcallService = (ITelEcallService)object;
        }

        protected void serviceRemoved(Object object) {
            this.log.log(1000000, "TelBAPMethodHangupServiceHandlerCall.TelServiceListenerTracker#serviceRemoved(): %1", object);
            TelBAPMethodHangupServiceHandlerCall.this.telEcallService = new NullTelEcallService(this.log);
        }
    }
}

