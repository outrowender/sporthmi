/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl;
import de.audi.app.phone.core.interapp.TelServiceConnectivityListenerWrapper;
import de.audi.atip.phone.ITelServiceConnectivityListener;

class TelServiceConnectivityImpl$2
extends AbstractTelInterappEvent {
    private final /* synthetic */ boolean val$stateOn;
    private final /* synthetic */ ITelServiceConnectivityListener val$listener;
    private final /* synthetic */ TelServiceConnectivityImpl this$0;

    TelServiceConnectivityImpl$2(TelServiceConnectivityImpl telServiceConnectivityImpl, String string, boolean bl, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.this$0 = telServiceConnectivityImpl;
        this.val$stateOn = bl;
        this.val$listener = iTelServiceConnectivityListener;
        super(string);
    }

    @Override
    public void run() {
        TelServiceConnectivityImpl.access$200(this.this$0).log(1078071040, "[TelServiceConnectivityImpl#changePhoneModulePowerState] stateOn=%1, listener=%2", (Object)String.valueOf(this.val$stateOn), (Object)this.val$listener);
        int n = this.val$stateOn ? 1 : 0;
        TelServiceConnectivityImpl.access$300(this.this$0).getTelephoneDSIAccess().requestTelPower(n, 0, true, this.val$listener != null ? new TelServiceConnectivityListenerWrapper(this.val$listener) : null);
    }
}

