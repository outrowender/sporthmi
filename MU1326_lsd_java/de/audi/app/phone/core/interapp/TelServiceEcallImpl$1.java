/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceEcallImpl;
import de.audi.app.phone.core.interapp.TelServiceEcallImpl$1$1;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;

class TelServiceEcallImpl$1
extends AbstractTelInterappEvent {
    private final /* synthetic */ ITelServiceEcallListener val$responseListener;
    private final /* synthetic */ TelServiceEcallImpl this$0;

    TelServiceEcallImpl$1(TelServiceEcallImpl telServiceEcallImpl, String string, ITelServiceEcallListener iTelServiceEcallListener) {
        this.this$0 = telServiceEcallImpl;
        this.val$responseListener = iTelServiceEcallListener;
        super(string);
    }

    @Override
    public void run() {
        TelServiceEcallImpl.access$000(this.this$0).log(-2137614336, "TelServiceEcallImpl#hangupAllCalls(): called.");
        TelServiceEcallImpl.access$200(this.this$0).getTelephoneDSIAccess().hangupCall(255, 0, false, new TelServiceEcallImpl$1$1(this));
    }

    static /* synthetic */ ITelServiceEcallListener access$100(TelServiceEcallImpl$1 telServiceEcallImpl$1) {
        return telServiceEcallImpl$1.val$responseListener;
    }
}

