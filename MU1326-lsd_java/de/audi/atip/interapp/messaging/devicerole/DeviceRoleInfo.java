/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.devicerole;

import de.esolutions.fw.util.commons.Buffer;

public final class DeviceRoleInfo {
    private final boolean isSimDevice;
    private final String simCardId;
    private final String btDeviceAddress;

    public DeviceRoleInfo(boolean bl, String string, String string2) {
        this.isSimDevice = bl;
        this.simCardId = string;
        this.btDeviceAddress = string2;
    }

    public boolean isSimDevice() {
        return this.isSimDevice;
    }

    public String getSimCardId() {
        return this.simCardId;
    }

    public String getBtDeviceAddress() {
        return this.btDeviceAddress;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.btDeviceAddress == null ? 0 : this.btDeviceAddress.hashCode());
        n = 31 * n + (this.isSimDevice ? 1231 : 1237);
        n = 31 * n + (this.simCardId == null ? 0 : this.simCardId.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof DeviceRoleInfo) {
            DeviceRoleInfo deviceRoleInfo = (DeviceRoleInfo)object;
            boolean bl = true;
            if (this.isSimDevice != deviceRoleInfo.isSimDevice() || !this.getSimCardId().equalsIgnoreCase(deviceRoleInfo.getSimCardId()) || !this.getBtDeviceAddress().equalsIgnoreCase(deviceRoleInfo.getBtDeviceAddress())) {
                bl = false;
            }
            return bl;
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DeviceRoleInfo {isSimDevice = ");
        buffer.append(this.isSimDevice());
        buffer.append(", simCardId = ");
        buffer.append(this.getSimCardId());
        buffer.append(", btDeviceAddress = ");
        buffer.append(this.getBtDeviceAddress());
        buffer.append('}');
        return buffer.toString();
    }
}

