/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IConnectivityNaviStateListener {
    default public void onlineMapEntered() {
    }

    default public void onlineMapLeft() {
    }

    default public void enableOnlineDataConfiguration() {
    }

    default public void disableOnlineDataConfiguration() {
    }

    default public void connectivityDataOnlineCheckEntered() {
    }

    default public void connectivityDataOnlineCheckLeft() {
    }
}

