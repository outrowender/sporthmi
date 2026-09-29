/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl;
import de.audi.app.phone.core.interapp.TelServiceConnectivityListenerWrapper;
import de.audi.atip.phone.ITelServiceConnectivityListener;

class TelServiceConnectivityImpl$1
extends AbstractTelInterappEvent {
    private final /* synthetic */ ITelServiceConnectivityListener val$listener;
    private final /* synthetic */ int val$nadMode;
    private final /* synthetic */ TelServiceConnectivityImpl this$0;

    TelServiceConnectivityImpl$1(TelServiceConnectivityImpl telServiceConnectivityImpl, String string, ITelServiceConnectivityListener iTelServiceConnectivityListener, int n) {
        this.this$0 = telServiceConnectivityImpl;
        this.val$listener = iTelServiceConnectivityListener;
        this.val$nadMode = n;
        super(string);
    }

    @Override
    public void run() {
        TelServiceConnectivityImpl.access$000(this.this$0).log(1078071040, "[TelServiceConnectivityImpl#setNadMode] nadMode%2, listener=%1", (Object)this.val$listener, (long)this.val$nadMode);
        TelServiceConnectivityImpl.access$100(this.this$0).getTelephoneDSIAccess().requestSetNadMode(this.val$nadMode, 0, true, this.val$listener != null ? new TelServiceConnectivityListenerWrapper(this.val$listener) : null);
    }
}

