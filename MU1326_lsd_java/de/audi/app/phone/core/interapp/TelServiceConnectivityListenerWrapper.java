/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.atip.phone.ITelServiceConnectivityListener;

public class TelServiceConnectivityListenerWrapper
extends TelDefaultDSIResponseListener {
    private final ITelServiceConnectivityListener listener;

    public TelServiceConnectivityListenerWrapper(ITelServiceConnectivityListener iTelServiceConnectivityListener) {
        this.listener = iTelServiceConnectivityListener;
    }

    public void responseSetNADMode(int n, int n2, int n3) {
        if (this.listener != null) {
            this.listener.responseSetNadMode(n2);
        }
    }

    public void responseTelPower(int n, int n2) {
        if (this.listener != null) {
            this.listener.responseChangePhoneModulePowerState(n);
        }
    }

    public void responseChangeTopology(int n, int n2) {
        if (this.listener != null) {
            this.listener.responseTogglePhones(n);
        }
    }
}

