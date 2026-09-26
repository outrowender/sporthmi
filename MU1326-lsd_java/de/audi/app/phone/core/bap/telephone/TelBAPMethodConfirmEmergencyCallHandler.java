/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.app.phone.core.bap.telephone.TelBAPMethodConfirmEmergencyCallHandler$1;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodConfirmEmergencyCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodConfirmEmergencyCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void confirmEmergencyCall(boolean bl) {
        this.enqueueResultNotification(new TelBAPMethodConfirmEmergencyCallHandler$1(this));
    }

    static /* synthetic */ LogChannel access$000(TelBAPMethodConfirmEmergencyCallHandler telBAPMethodConfirmEmergencyCallHandler) {
        return telBAPMethodConfirmEmergencyCallHandler.log;
    }

    static /* synthetic */ LogChannel access$100(TelBAPMethodConfirmEmergencyCallHandler telBAPMethodConfirmEmergencyCallHandler) {
        return telBAPMethodConfirmEmergencyCallHandler.log;
    }
}

