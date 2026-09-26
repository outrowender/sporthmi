/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

final class CoMaCategoryPreview {
    private String notConnected;
    private String notActive;
    private String deviceName;
    private boolean isDeviceConnected;

    CoMaCategoryPreview(String string, String string2) {
        this.notConnected = string;
        this.notActive = string2;
    }

    String getPreview() {
        return this.isDeviceConnected ? (this.deviceName != null ? this.deviceName : this.notActive) : this.notConnected;
    }

    void updateDeviceName(String string) {
        this.deviceName = string;
    }

    String updateConnected(boolean bl) {
        this.isDeviceConnected = bl;
        return this.getPreview();
    }

    void setTextConstants(String string, String string2) {
        this.notConnected = string;
        this.notActive = string2;
    }
}

