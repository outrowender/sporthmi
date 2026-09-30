/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.esolutions.fw.util.commons.Buffer;

public class TerminalModeAppState {
    public static final int APP_UNKNOWN = 0;
    public static final int APP_NAVIGATION = 1;
    public static final int APP_PHONE = 2;
    public static final int APP_SPEECH = 3;
    private final int appId;
    private final boolean runningOnDevice;

    public TerminalModeAppState(int n, boolean bl) {
        this.appId = n;
        this.runningOnDevice = bl;
    }

    public int getAppId() {
        return this.appId;
    }

    public boolean isRunningOnDevice() {
        return this.runningOnDevice;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.appId;
        n = 31 * n + (this.runningOnDevice ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        TerminalModeAppState terminalModeAppState = (TerminalModeAppState)object;
        if (this.appId != terminalModeAppState.appId) {
            return false;
        }
        return this.runningOnDevice == terminalModeAppState.runningOnDevice;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("appID=").append(this.appId).append(" (");
        switch (this.appId) {
            case 0: {
                buffer.append("UNKNOWN");
                break;
            }
            case 1: {
                buffer.append("NAVIGATION");
                break;
            }
            case 2: {
                buffer.append("PHONE");
                break;
            }
            case 3: {
                buffer.append("SPEECH");
                break;
            }
            default: {
                buffer.append("TYPE_MISSING");
            }
        }
        buffer.append("), runningOnDevice=").append(this.runningOnDevice);
        return buffer.toString();
    }
}

