/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodResetMissedCallsIndicator
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodResetMissedCallsIndicator(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void resetMissedCallsIndicator() {
        this.log.log(1078071040, "[TelBAPMethodResetMissedCallsIndicator#resetMissedCallsIndicator]");
        this.getApplication().getTelephoneDSIAccess().resetMissedCallIndicator(1);
    }
}

