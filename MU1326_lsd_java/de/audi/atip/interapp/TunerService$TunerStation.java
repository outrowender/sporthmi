/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public class TunerService$TunerStation {
    public final long stationID;
    public final String stationName;

    public TunerService$TunerStation(long l, String string) {
        this.stationID = l;
        this.stationName = string;
    }

    public final String toString() {
        return new StringBuffer().append(this.stationName).append(" (").append(this.stationID).append(")").toString();
    }

    public long getStationId() {
        return this.stationID;
    }
}

