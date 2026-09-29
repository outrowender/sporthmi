/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public class AMFMStationInfo {
    public String stationName;
    public int frequency;

    public AMFMStationInfo() {
        this.stationName = null;
        this.frequency = 0;
    }

    public AMFMStationInfo(String string, int n) {
        this.stationName = string;
        this.frequency = n;
    }
}

