/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

public class sPosition {
    public int timeStamp;
    public long utcTimestamp;
    public double latitude;
    public double longitude;
    public double mercatorX;
    public double mercatorY;
    public short heading;
    public short bearing;

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(int n) {
        this.timeStamp = n;
    }

    public long getUtcTimestamp() {
        return this.utcTimestamp;
    }

    public void setUtcTimestamp(long l) {
        this.utcTimestamp = l;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getMercatorX() {
        return this.mercatorX;
    }

    public void setMercatorX(double d2) {
        this.mercatorX = d2;
    }

    public double getMercatorY() {
        return this.mercatorY;
    }

    public void setMercatorY(double d2) {
        this.mercatorY = d2;
    }

    public short getHeading() {
        return this.heading;
    }

    public void setHeading(short s) {
        this.heading = s;
    }

    public short getBearing() {
        return this.bearing;
    }

    public void setBearing(short s) {
        this.bearing = s;
    }

    public sPosition() {
    }

    public sPosition(int n, long l, double d2, double d3, double d4, double d5, short s, short s2) {
        this.timeStamp = n;
        this.utcTimestamp = l;
        this.latitude = d2;
        this.longitude = d3;
        this.mercatorX = d4;
        this.mercatorY = d5;
        this.heading = s;
        this.bearing = s2;
    }

    public String toString() {
        return "sPosition{" + "timeStamp=" + this.timeStamp + ", utcTimestamp=" + this.utcTimestamp + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", mercatorX=" + this.mercatorX + ", mercatorY=" + this.mercatorY + ", heading=" + this.heading + ", bearing=" + this.bearing + "}";
    }
}

