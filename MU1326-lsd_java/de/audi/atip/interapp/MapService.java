/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface MapService {
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_DISABLED;
    public static final int SETUP_MAP_DESTINATION;
    public static final int SETUP_MAP_POSITION_2D;
    public static final int SETUP_MAP_POSITION_3D;
    public static final int SETUP_MAP_OVERVIEW;
    public static final int SETUP_COLOR_DAY;
    public static final int SETUP_COLOR_NIGHT;
    public static final int SETUP_COLOR_AUTO;
    public static final int SETUP_ORIENTATION_NORTH;
    public static final int SETUP_ORIENTATION_CAR;
    public static final int SETUP_ADDITIONAL_ROUTEINFO;
    public static final int SETUP_ADDITIONAL_ROUTEINFO_TURNBYTURN;
    public static final int SETUP_ADDITIONAL_OVERVIEW_MAP;
    public static final int SETUP_ADDITIONAL_OFF;
    public static final int SETUP_CROSSING_VIEW_ON;
    public static final int SETUP_CROSSING_VIEW_OFF;
    public static final int SETUP_ZOOM_ON;
    public static final int SETUP_ZOOM_CROSSING;
    public static final int SETUP_ZOOM_OFF;
    public static final int MAP_REPRESENTATION_STANDARD;
    public static final int MAP_REPRESENTATION_GOOGLEEARTH;
    public static final int MAP_REPRESENTATION_TRAFFIC;
    public static final int MAP_REPRESENTATION_RANGEMAP;
    public static final int SUPPLEMENTARY_MAP_VIEW_NO_SUPPLEMENTARY_MAP_VIEW;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM;
    public static final int SUPPLEMENTARY_MAP_VIEW_COMPASS;
    public static final int SUPPLEMENTARY_MAP_VIEW_31_BOX;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM_ON_MAP;
    public static final int MAP_DISPLAY_MU;
    public static final int MAP_DISPLAY_BOTH;
    public static final int MAP_DISPLAY_KOMBI;

    default public int setMapType(int n) {
    }

    default public void setMapColor(int n) {
    }

    default public void setMapOrientation(int n) {
    }

    default public void setAdditionalInfos(int n) {
    }

    default public void setCrossingView(int n) {
    }

    default public void setIncrementalZoom(int n) {
    }

    default public void setMapRepresentation(int n) {
    }

    default public boolean sdsSetMapRepresentation(int n) {
    }

    default public void setZoomLevel(float f2) {
    }

    default public void swapMaps() {
    }

    default public void setTrafficSettings(boolean bl, boolean bl2, boolean bl3, int n) {
    }
}

