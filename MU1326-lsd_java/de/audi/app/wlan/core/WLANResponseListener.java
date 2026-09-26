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

    @Override
    public void responseAbortSearch(int n) {
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseFactoryReset(int n) {
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
    }

    @Override
    public void responseSetProfile(int n) {
    }

    @Override
    public void responseSetRFActive(int n) {
    }

    @Override
    public void responseSetRole(int n) {
    }

    @Override
    public void responseActivateWps(int n) {
    }
}

