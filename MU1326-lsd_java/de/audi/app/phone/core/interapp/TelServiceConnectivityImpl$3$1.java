/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.TelServiceConnectivityImpl$3;

class TelServiceConnectivityImpl$3$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelServiceConnectivityImpl$3 this$1;

    TelServiceConnectivityImpl$3$1(TelServiceConnectivityImpl$3 telServiceConnectivityImpl$3) {
        this.this$1 = telServiceConnectivityImpl$3;
    }

    @Override
    public void responseChangeTopology(int n, int n2) {
        if (TelServiceConnectivityImpl$3.access$500(this.this$1) != null) {
            TelServiceConnectivityImpl$3.access$500(this.this$1).responseTogglePhones(n);
        }
    }
}

