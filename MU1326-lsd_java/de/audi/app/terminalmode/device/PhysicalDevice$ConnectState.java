/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

class PhysicalDevice$ConnectState {
    private final Boolean connected;

    public PhysicalDevice$ConnectState() {
        this.connected = null;
    }

    public PhysicalDevice$ConnectState(Boolean bl) {
        this.connected = bl;
    }

    public boolean isConnectStateAvailable() {
        return null != this.connected;
    }

    public boolean isConnected() {
        return null == this.connected || this.connected != false;
    }
}

