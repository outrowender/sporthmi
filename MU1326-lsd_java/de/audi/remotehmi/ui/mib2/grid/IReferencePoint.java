/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.GeoPosition;

public interface IReferencePoint {
    public static final String RRD_REFPOINT_TYPE_CITY;
    public static final String RRD_REFPOINT_TYPE_DESTINATION;
    public static final String RRD_REFPOINT_TYPE_DEFAULT;
    public static final String RRD_REFPOINT_TYPE_STOPOVER;
    public static final String RRD_REFPOINT_TYPE_VT_NEARBY;
    public static final String RRD_REFPOINT_TYPE_VT_ATDESTINATION;
    public static final String RRD_REFPOINT_TYPE_VT_ATSTOPOVER;
    public static final String RRD_REFPOINT_TYPE_VT_INCITY;

    default public GeoPosition getGeoLocation() {
    }

    default public String getType() {
    }
}

