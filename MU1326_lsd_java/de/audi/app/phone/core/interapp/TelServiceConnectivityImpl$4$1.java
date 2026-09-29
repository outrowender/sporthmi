/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$4;

class TelServiceConnectivityImpl$4$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelServiceConnectivityImpl$4 this$1;

    TelServiceConnectivityImpl$4$1(TelServiceConnectivityImpl$4 telServiceConnectivityImpl$4) {
        this.this$1 = telServiceConnectivityImpl$4;
    }

    @Override
    public void responseChangeTopology(int n, int n2) {
        if (TelServiceConnectivityImpl$4.access$800(this.this$1) != null) {
            TelServiceConnectivityImpl$4.access$800(this.this$1).responseSetNadRole(n);
        }
    }
}

