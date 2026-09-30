/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.esolutions.fw.util.commons.Buffer;

public class ParkingPopupIdentifier {
    public static final int POPUP_TYPE_FULLSCREEN = 0;
    public static final int POPUP_TYPE_PARTIAL = 1;
    private int popupType;
    private int hmiPopupID;

    public ParkingPopupIdentifier(int n, int n2) {
        this.popupType = n;
        this.hmiPopupID = n2;
    }

    public int getPopupType() {
        return this.popupType;
    }

    public int getHmiPopupID() {
        return this.hmiPopupID;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ParkingPopupIdentifier)) {
            return false;
        }
        ParkingPopupIdentifier parkingPopupIdentifier = (ParkingPopupIdentifier)object;
        return this.popupType == parkingPopupIdentifier.popupType && this.hmiPopupID == parkingPopupIdentifier.hmiPopupID;
    }

    public int hashCode() {
        int n = 11;
        int n2 = 29;
        n = n * n2 + this.popupType;
        n = n * n2 + this.hmiPopupID;
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ParkingPopupIdentifier{popupType=");
        buffer.append(this.popupType == 0 ? "FULLSCREEN" : "PARTIAL");
        buffer.append(", hmiPopupID=");
        buffer.append(this.hmiPopupID);
        return buffer.toString();
    }
}

