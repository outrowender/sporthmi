/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDefaultListener;
import de.audi.atip.log.LogChannel;

public class WLANResponseListener
extends WLANDefaultListener {
    public WLANResponseListener(LogChannel logChannel) {
        super(logChannel);
    }

    public void responseAbortSearch(int n) {
    }

    public void responseConnectNetwork(String string, String string2, int n) {
    }

    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    public void responseFactoryReset(int n) {
    }

    public void responseNetworkSearch(int n, int n2) {
    }

    public void responseSetProfile(int n) {
    }

    public void responseSetRFActive(int n) {
    }

    public void responseSetRole(int n) {
    }

    public void responseActivateWps(int n) {
    }
}

