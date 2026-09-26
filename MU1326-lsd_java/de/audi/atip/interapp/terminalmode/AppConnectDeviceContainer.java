/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

public class AppConnectDeviceContainer {
    public static final int UNKNOWN;
    public static final int CAR_PLAY;
    public static final int GAL;
    public static final int NOT_CONNECTED;
    private boolean audioFocus;
    private String deviceName;
    private int type;
    private final boolean available;

    public AppConnectDeviceContainer(boolean bl) {
        this.available = bl;
    }

    public boolean isAudioFocus() {
        return this.audioFocus;
    }

    public void setAudioFocus(boolean bl) {
        this.audioFocus = bl;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String string) {
        this.deviceName = string;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public boolean isAvailable() {
        return this.available;
    }
}

