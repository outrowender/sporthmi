/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface INaviConnectivityStateListener {
    public void onlineStateChanged();

    public void onlineErrorShown();

    public void updateOnlineConnectionState(boolean var1);
}

