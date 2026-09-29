/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.esolutions.fw.util.commons.Buffer;

public class TerminalModeDevice {
    public static final int CONN_METHOD_UNKNOWN;
    public static final int CONN_METHOD_CARPLAY;
    public static final int CONN_METHOD_ANDROIDAUTO;
    public static final int CONN_METHOD_CARLIFE;
    private final String deviceName;
    private final int connectionMethod;
    private final boolean active;
    private final boolean isTerminalModeEnabled;
    private final Object token;
    private final boolean isAttached;

    public TerminalModeDevice(Object object, String string, int n, boolean bl, boolean bl2, boolean bl3) {
        this.deviceName = string;
        this.connectionMethod = n;
        this.active = bl;
        this.isTerminalModeEnabled = bl2;
        this.token = object;
        this.isAttached = bl3;
    }

    public TerminalModeDevice(int n, String string, int n2, boolean bl) {
        this(Integer.toString(n), string, n2, bl, true, true);
    }

    public Object getToken() {
        return this.token;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getConnectionMethod() {
        return this.connectionMethod;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isTerminalModeEnabled() {
        return this.isTerminalModeEnabled;
    }

    public boolean isAttached() {
        return this.isAttached;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.active ? 1231 : 1237);
        n = 31 * n + this.connectionMethod;
        n = 31 * n + (this.deviceName == null ? 0 : this.deviceName.hashCode());
        n = 31 * n + (this.isAttached ? 1231 : 1237);
        n = 31 * n + (this.isTerminalModeEnabled ? 1231 : 1237);
        n = 31 * n + (this.token == null ? 0 : this.token.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        TerminalModeDevice terminalModeDevice = (TerminalModeDevice)object;
        if (this.active != terminalModeDevice.active) {
            return false;
        }
        if (this.connectionMethod != terminalModeDevice.connectionMethod) {
            return false;
        }
        if (this.deviceName == null ? terminalModeDevice.deviceName != null : !this.deviceName.equals(terminalModeDevice.deviceName)) {
            return false;
        }
        if (this.isAttached != terminalModeDevice.isAttached) {
            return false;
        }
        if (this.isTerminalModeEnabled != terminalModeDevice.isTerminalModeEnabled) {
            return false;
        }
        return !(this.token == null ? terminalModeDevice.token != null : !this.token.equals(terminalModeDevice.token));
    }

    public String toString() {
        return new Buffer(100).append("Device[").append(this.active ? "[x]" : (this.isAttached ? "[ ]" : "[-]")).append(this.deviceName).append(", ").append(TerminalModeDevice.connectionMethodToString(this.connectionMethod)).append("]").toString();
    }

    private static String connectionMethodToString(int n) {
        switch (n) {
            case 2: {
                return "AA";
            }
            case 1: {
                return "CP";
            }
            case 3: {
                return "CL";
            }
        }
        return "--";
    }

    public String getDeviceUniqueId() {
        return this.token.toString();
    }
}

