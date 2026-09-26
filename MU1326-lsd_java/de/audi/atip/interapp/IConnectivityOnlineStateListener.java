/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IConnectivityOnlineStateListener {
    default public void onlineAppEntered() {
    }

    default public void onlineAppLeft() {
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

