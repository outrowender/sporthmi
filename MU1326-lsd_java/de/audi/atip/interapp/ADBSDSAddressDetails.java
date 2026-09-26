/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.organizer.AdbEntry;

public class ADBSDSAddressDetails {
    public static final int BUSINESS;
    public static final int PRIVATE;
    private AdbEntry adbEntry;
    private int addressType;

    public ADBSDSAddressDetails(AdbEntry adbEntry, int n) {
        this.adbEntry = adbEntry;
        this.addressType = n;
    }

    public AdbEntry getAdbEntry() {
        return this.adbEntry;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public int getAddressIndex() {
        if (this.addressType == 2 || this.addressType == 0 || this.addressType == 4) {
            return 0;
        }
        return 1;
    }

    public byte[] getNavLocation() {
        if (this.addressType == 2) {
            return this.adbEntry.addressData[0].navLocation;
        }
        if (this.addressType == 3) {
            return this.adbEntry.addressData[1].navLocation;
        }
        return new byte[0];
    }

    public String getGeoPos() {
        if (this.addressType == 4) {
            return this.adbEntry.addressData[0].geoPosition;
        }
        if (this.addressType == 5) {
            return this.adbEntry.addressData[1].geoPosition;
        }
        return "";
    }
}

