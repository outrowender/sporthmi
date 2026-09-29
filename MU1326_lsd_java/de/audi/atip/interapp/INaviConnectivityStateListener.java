/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface INaviConnectivityStateListener {
    default public void onlineStateChanged() {
    }

    default public void onlineErrorShown() {
    }

    default public void updateOnlineConnectionState(boolean bl) {
    }
}

