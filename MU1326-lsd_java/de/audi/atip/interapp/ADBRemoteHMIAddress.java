/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public class ADBRemoteHMIAddress {
    private byte[] navLocation;
    private String[] geoPos;

    public ADBRemoteHMIAddress(byte[] byArray) {
        this.navLocation = byArray;
    }

    public ADBRemoteHMIAddress(String string, String string2) {
        this.geoPos = new String[]{string, string2};
    }

    public boolean isNavLocation() {
        return this.navLocation != null;
    }

    public byte[] getNavLocation() {
        return this.navLocation;
    }

    public String[] getGeoPos() {
        return this.geoPos;
    }
}

