/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.esolutions.fw.util.commons.Buffer;

public final class GeoCoordinates {
    private final int longitude;
    private final int latitude;

    public static GeoCoordinates getInstance(int n, int n2) {
        return new GeoCoordinates(n, n2);
    }

    private GeoCoordinates(int n, int n2) {
        this.longitude = n;
        this.latitude = n2;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.latitude;
        n = 31 * n + this.longitude;
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
        GeoCoordinates geoCoordinates = (GeoCoordinates)object;
        if (this.latitude != geoCoordinates.latitude) {
            return false;
        }
        return this.longitude == geoCoordinates.longitude;
    }

    public String toString() {
        return new Buffer("GeoCoordinates [longitude=").append(this.longitude).append(", latitude=").append(this.latitude).append("]").toString();
    }
}

