/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.GeoPosition;

public interface IReferencePoint {
    public static final String RRD_REFPOINT_TYPE_CITY = "city";
    public static final String RRD_REFPOINT_TYPE_DESTINATION = "destination";
    public static final String RRD_REFPOINT_TYPE_DEFAULT = "rrd";
    public static final String RRD_REFPOINT_TYPE_STOPOVER = "stopover";
    public static final String RRD_REFPOINT_TYPE_VT_NEARBY = "Nearby";
    public static final String RRD_REFPOINT_TYPE_VT_ATDESTINATION = "AtDestination";
    public static final String RRD_REFPOINT_TYPE_VT_ATSTOPOVER = "AtStopover";
    public static final String RRD_REFPOINT_TYPE_VT_INCITY = "InCity";

    public GeoPosition getGeoLocation();

    public String getType();
}

