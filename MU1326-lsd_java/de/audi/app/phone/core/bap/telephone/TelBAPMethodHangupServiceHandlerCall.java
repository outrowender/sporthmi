/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.ITelEcallService;

public class TelBAPMethodHangupServiceHandlerCall {
    private volatile ITelEcallService telEcallService;
    private final TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker telEcallServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelEcallService;

    public TelBAPMethodHangupServiceHandlerCall(ITelApplication iTelApplication) {
        this.telEcallServiceTracker = new TelBAPMethodHangupServiceHandlerCall$TelEcallServiceTracker(this, iTelApplication);
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

    static /* synthetic */ ITelEcallService access$002(TelBAPMethodHangupServiceHandlerCall telBAPMethodHangupServiceHandlerCall, ITelEcallService iTelEcallService) {
        telBAPMethodHangupServiceHandlerCall.telEcallService = iTelEcallService;
        return telBAPMethodHangupServiceHandlerCall.telEcallService;
    }
}

