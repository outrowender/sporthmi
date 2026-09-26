/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$3$1;
import de.audi.atip.phone.ITelServiceConnectivityListener;

class TelServiceConnectivityImpl$3
extends AbstractTelInterappEvent {
    private final /* synthetic */ ITelServiceConnectivityListener val$listener;
    private final /* synthetic */ TelServiceConnectivityImpl this$0;

    TelServiceConnectivityImpl$3(TelServiceConnectivityImpl telServiceConnectivityImpl, String string, ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.this$0 = telServiceConnectivityImpl;
        this.val$listener = iTelServiceConnectivityListener;
        super(string);
    }

    @Override
    public void run() {
        TelServiceConnectivityImpl.access$400(this.this$0).log(1078071040, "[TelServiceConnectivityImpl#togglePhones] listener=%1", (Object)this.val$listener);
        TelServiceConnectivityImpl.access$600(this.this$0).getTelephoneDSIAccess().togglePhones(0, true, new TelServiceConnectivityImpl$3$1(this));
    }

    static /* synthetic */ ITelServiceConnectivityListener access$500(TelServiceConnectivityImpl$3 telServiceConnectivityImpl$3) {
        return telServiceConnectivityImpl$3.val$listener;
    }
}

