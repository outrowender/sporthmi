/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.esolutions.fw.util.commons.Buffer;

public class GeoPosition {
    public static final double UNDEFINED_COORDINATE = Double.MAX_VALUE;
    public static final int UNDEFINED_COORDINATE_WGS = Integer.MIN_VALUE;
    public static final GeoPosition UNDEFINED_POSITION = new GeoPosition(Double.MAX_VALUE, Double.MAX_VALUE);
    private final int MAX_LENGTH_FOR_DOUBLE_AS_STRING;
    private final double latitude;
    private final double longitude;
    private String debugInfo;

    public static GeoPosition createPosition(double d2, double d3) {
        if (d2 == Double.MAX_VALUE || d3 == Double.MAX_VALUE) {
            return UNDEFINED_POSITION;
        }
        return new GeoPosition(d2, d3);
    }

    private GeoPosition(double d2, double d3) {
        this.MAX_LENGTH_FOR_DOUBLE_AS_STRING = 24;
        this.latitude = d2;
        this.longitude = d3;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double[] asDoubleArray() {
        double[] dArray = new double[]{this.latitude, this.longitude};
        return dArray;
    }

    public static GeoPosition fromDoubleArray(double[] dArray) {
        return dArray == null || dArray.length < 2 ? UNDEFINED_POSITION : GeoPosition.createPosition(dArray[0], dArray[1]);
    }

    public int hashCode() {
        int n = 1;
        long l = Double.doubleToLongBits(this.latitude);
        n = 31 * n + (int)(l ^ l >>> 32);
        l = Double.doubleToLongBits(this.longitude);
        n = 31 * n + (int)(l ^ l >>> 32);
        return n;
    }

    public boolean equals(Object object) {
        if (!(object instanceof GeoPosition)) {
            return false;
        }
        GeoPosition geoPosition = (GeoPosition)object;
        return this.latitude == geoPosition.latitude && this.longitude == geoPosition.longitude;
    }

    public static boolean equals(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        if (object2 == null) {
            return false;
        }
        return object.equals(object2);
    }

    public String toString() {
        return this.toString('x');
    }

    public String toString(char c2) {
        if (this.debugInfo != null) {
            return this.debugInfo;
        }
        Buffer buffer = new Buffer(49);
        buffer.append(Double.toString(this.latitude)).append(c2).append(Double.toString(this.longitude));
        this.debugInfo = buffer.toString();
        return this.debugInfo;
    }

    public static void main(String[] stringArray) {
        GeoPosition geoPosition = new GeoPosition(1.0, 2.0);
        GeoPosition geoPosition2 = new GeoPosition(3.0, 4.0);
        GeoPosition.equals(geoPosition, geoPosition2);
    }
}

