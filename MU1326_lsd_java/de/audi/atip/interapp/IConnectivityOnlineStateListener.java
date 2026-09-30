/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IConnectivityOnlineStateListener {
    public void onlineAppEntered();

    public void onlineAppLeft();

    public void enableOnlineDataConfiguration();

    public void disableOnlineDataConfiguration();

    public void connectivityDataOnlineCheckEntered();

    public void connectivityDataOnlineCheckLeft();
}

