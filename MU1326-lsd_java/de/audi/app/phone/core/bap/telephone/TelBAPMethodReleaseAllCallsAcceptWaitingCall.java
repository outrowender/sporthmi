/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseAllCallsAcceptWaitingCall$1;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodReleaseAllCallsAcceptWaitingCall
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodReleaseAllCallsAcceptWaitingCall(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void releaseAllCallsAcceptWaitingCall() {
        this.enqueueResultNotification(new TelBAPMethodReleaseAllCallsAcceptWaitingCall$1(this));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodReleaseAllCallsAcceptWaitingCall telBAPMethodReleaseAllCallsAcceptWaitingCall) {
        return telBAPMethodReleaseAllCallsAcceptWaitingCall.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodReleaseAllCallsAcceptWaitingCall telBAPMethodReleaseAllCallsAcceptWaitingCall) {
        return telBAPMethodReleaseAllCallsAcceptWaitingCall.log;
    }
}

