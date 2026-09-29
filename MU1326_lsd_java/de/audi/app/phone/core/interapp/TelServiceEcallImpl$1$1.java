/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.TelServiceEcallImpl$1;

class TelServiceEcallImpl$1$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelServiceEcallImpl$1 this$1;

    TelServiceEcallImpl$1$1(TelServiceEcallImpl$1 telServiceEcallImpl$1) {
        this.this$1 = telServiceEcallImpl$1;
    }

    @Override
    public void responseHangupCall(int n, int n2) {
        TelServiceEcallImpl$1.access$100(this.this$1).responseHangupAllCalls(n);
    }
}

