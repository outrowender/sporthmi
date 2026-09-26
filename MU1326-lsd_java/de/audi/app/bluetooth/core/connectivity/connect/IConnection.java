/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

public interface IConnection {
    default public void connectService(String string, int n, String string2, boolean bl) {
    }

    default public void connectService(String string, int n, String string2, boolean bl, boolean bl2) {
    }

    default public void abortConnectService() {
    }

    default public void disconnectService(String string, int n) {
    }

    default public void responseConnectService(String string, int n, int n2, int n3) {
    }

    default public void connectionExitAction() {
    }

    default public void updateHfpSupport(boolean bl) {
    }
}

