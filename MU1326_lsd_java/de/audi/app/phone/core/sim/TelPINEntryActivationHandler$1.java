/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.sim.TelPINEntryActivationHandler;

class TelPINEntryActivationHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelPINEntryActivationHandler this$0;

    TelPINEntryActivationHandler$1(TelPINEntryActivationHandler telPINEntryActivationHandler) {
        this.this$0 = telPINEntryActivationHandler;
    }

    @Override
    public void responseSIMPINRequired(int n, int n2) {
        TelPINEntryActivationHandler.access$000(this.this$0).log(1078071040, "[TelPINEntryActivationHandler.activatePINRequired(...).new TelDefaultDSIResponseListener() {...}#responseSIMPINRequired] result=%1", (long)n);
        this.this$0.simPinRequiredResponse(n);
    }
}

