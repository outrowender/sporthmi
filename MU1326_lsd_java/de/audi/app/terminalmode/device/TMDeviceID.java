/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.atip.utils.Preconditions;

public final class TMDeviceID {
    public static final TMDeviceID INVALID = new TMDeviceID("INVALID", SmartphoneManager$SmartphoneType.UNKNOWN);
    public final String address;
    public final SmartphoneManager$SmartphoneType smartphoneType;

    public TMDeviceID(String string, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType) {
        this.address = (String)Preconditions.checkNotNull((Object)string);
        this.smartphoneType = (SmartphoneManager$SmartphoneType)Preconditions.checkNotNull((Object)smartphoneManager$SmartphoneType);
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
        if (super.getClass() != object.getClass()) {
            return false;
        }
        TMDeviceID tMDeviceID = (TMDeviceID)object;
        if (this.address == null ? tMDeviceID.address != null : !this.address.equals(tMDeviceID.address)) {
            return false;
        }
        return !(this.smartphoneType == null ? tMDeviceID.smartphoneType != null : !this.smartphoneType.equals(tMDeviceID.smartphoneType));
    }

    public String toString() {
        return new StringBuffer().append("TMDeviceID [address=").append(this.address).append(", smartphoneType=").append(this.smartphoneType).append("]").toString();
    }
}

