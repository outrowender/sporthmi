/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$4$1;
import de.audi.atip.phone.ITelServiceConnectivityListener;

class TelServiceConnectivityImpl$4
extends AbstractTelInterappEvent {
    private final /* synthetic */ ITelServiceConnectivityListener val$listener;
    private final /* synthetic */ int val$nadRole;
    private final /* synthetic */ TelServiceConnectivityImpl this$0;

    TelServiceConnectivityImpl$4(TelServiceConnectivityImpl telServiceConnectivityImpl, String string, ITelServiceConnectivityListener iTelServiceConnectivityListener, int n) {
        this.this$0 = telServiceConnectivityImpl;
        this.val$listener = iTelServiceConnectivityListener;
        this.val$nadRole = n;
        super(string);
    }

    @Override
    public void run() {
        TelServiceConnectivityImpl.access$700(this.this$0).log(1078071040, "[TelServiceConnectivityImpl#setNadRole] nadRole=%2, listener=%1", (Object)this.val$listener, (long)this.val$nadRole);
        TelServiceConnectivityImpl.access$900(this.this$0).getTelephoneDSIAccess().requestSetNadRole(0, this.val$nadRole, new TelServiceConnectivityImpl$4$1(this));
    }

    static /* synthetic */ ITelServiceConnectivityListener access$800(TelServiceConnectivityImpl$4 telServiceConnectivityImpl$4) {
        return telServiceConnectivityImpl$4.val$listener;
    }
}

