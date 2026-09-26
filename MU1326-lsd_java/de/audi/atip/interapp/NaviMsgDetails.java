/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.metrics.GeoMetric;
import de.esolutions.fw.util.commons.Buffer;

public class NaviMsgDetails {
    public static int MSG_TYPE_LOCATION = 0;
    public static int MSG_TYPE_DESTINATION = 1;
    public int msgTypeID = MSG_TYPE_LOCATION;
    public String formattedCurrentPosition;
    public String longitudeCurrentPosition;
    public String latitudeCurrentPosition;
    public String formattedDestination;
    public String longitudeDestination;
    public String latitudeDestination;
    public int distance;
    public long eta;

    public NaviMsgDetails(String string, int n, int n2, String string2, int n3, int n4, int n5, long l) {
        this(string, n, n2);
        this.msgTypeID = MSG_TYPE_DESTINATION;
        this.formattedDestination = string2;
        GeoMetric geoMetric = new GeoMetric(n3, n4);
        this.longitudeDestination = geoMetric.formatLongitude();
        this.latitudeDestination = geoMetric.formatLatitude();
        this.distance = n5;
        this.eta = l;
    }

    public NaviMsgDetails(String string, int n, int n2) {
        this.formattedCurrentPosition = string;
        GeoMetric geoMetric = new GeoMetric(n, n2);
        this.longitudeDestination = geoMetric.formatLongitude();
        this.latitudeDestination = geoMetric.formatLatitude();
    }

    public String toString() {
        Buffer buffer = new Buffer("(msgTypeID=");
        buffer.append(this.msgTypeID).append(", formattedCurrentPosition=").append(this.formattedCurrentPosition).append(", longitudeCurrentPosition=").append(this.longitudeCurrentPosition).append(", latitudeCurrentPosition=").append(this.latitudeCurrentPosition);
        if (this.msgTypeID == MSG_TYPE_DESTINATION) {
            buffer.append(", formattedDestination=").append(this.formattedDestination).append(", longitudeDestination=").append(this.longitudeDestination).append(", latitudeDestination=").append(this.latitudeDestination).append(", distance=").append(this.distance).append(", eta=").append(this.eta);
        }
        return buffer.toString();
    }
}

