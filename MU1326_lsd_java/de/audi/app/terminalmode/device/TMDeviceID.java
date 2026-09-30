/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.atip.utils.Preconditions;

public final class TMDeviceID {
    public static final TMDeviceID INVALID = new TMDeviceID("INVALID", SmartphoneManager.SmartphoneType.UNKNOWN);
    public final String address;
    public final SmartphoneManager.SmartphoneType smartphoneType;

    public TMDeviceID(String string, SmartphoneManager.SmartphoneType smartphoneType) {
        this.address = Preconditions.checkNotNull(string);
        this.smartphoneType = Preconditions.checkNotNull(smartphoneType);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.address == null ? 0 : this.address.hashCode());
        n = 31 * n + (this.smartphoneType == null ? 0 : this.smartphoneType.hashCode());
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
        TMDeviceID tMDeviceID = (TMDeviceID)object;
        if (this.address == null ? tMDeviceID.address != null : !this.address.equals(tMDeviceID.address)) {
            return false;
        }
        return !(this.smartphoneType == null ? tMDeviceID.smartphoneType != null : !this.smartphoneType.equals(tMDeviceID.smartphoneType));
    }

    public String toString() {
        return "TMDeviceID [address=" + this.address + ", smartphoneType=" + this.smartphoneType + "]";
    }
}

