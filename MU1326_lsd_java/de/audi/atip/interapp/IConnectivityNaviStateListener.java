/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IConnectivityNaviStateListener {
    public void onlineMapEntered();

    public void onlineMapLeft();

    public void enableOnlineDataConfiguration();

    public void disableOnlineDataConfiguration();

    public void connectivityDataOnlineCheckEntered();

    public void connectivityDataOnlineCheckLeft();
}

