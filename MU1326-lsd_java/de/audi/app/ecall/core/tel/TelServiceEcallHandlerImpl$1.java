/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.app.ecall.core.tel.TelServiceEcallHandlerImpl;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;

class TelServiceEcallHandlerImpl$1
implements ITelServiceEcallListener {
    private final /* synthetic */ TelServiceEcallHandlerImpl this$0;

    TelServiceEcallHandlerImpl$1(TelServiceEcallHandlerImpl telServiceEcallHandlerImpl) {
        this.this$0 = telServiceEcallHandlerImpl;
    }

    @Override
    public void responseHangupAllCalls(int n) {
        TelServiceEcallHandlerImpl.access$000(this.this$0).log(1078071040, "TelServiceEcallHandlerImpl.hangupAllCalls().new ITelServiceEcallListener() {...}#responseHangupAllCalls(): result: %1", (long)n);
    }
}

