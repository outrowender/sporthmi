/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

public class AppConnectDeviceContainer {
    public static final int UNKNOWN = 0;
    public static final int CAR_PLAY = 1;
    public static final int GAL = 2;
    public static final int NOT_CONNECTED = 3;
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

