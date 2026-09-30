/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface MapService {
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR = 1;
    public static final int RESULT_DISABLED = 2;
    public static final int SETUP_MAP_DESTINATION = 0;
    public static final int SETUP_MAP_POSITION_2D = 1;
    public static final int SETUP_MAP_POSITION_3D = 2;
    public static final int SETUP_MAP_OVERVIEW = 3;
    public static final int SETUP_COLOR_DAY = 0;
    public static final int SETUP_COLOR_NIGHT = 1;
    public static final int SETUP_COLOR_AUTO = 2;
    public static final int SETUP_ORIENTATION_NORTH = 0;
    public static final int SETUP_ORIENTATION_CAR = 1;
    public static final int SETUP_ADDITIONAL_ROUTEINFO = 0;
    public static final int SETUP_ADDITIONAL_ROUTEINFO_TURNBYTURN = 1;
    public static final int SETUP_ADDITIONAL_OVERVIEW_MAP = 2;
    public static final int SETUP_ADDITIONAL_OFF = 3;
    public static final int SETUP_CROSSING_VIEW_ON = 0;
    public static final int SETUP_CROSSING_VIEW_OFF = 1;
    public static final int SETUP_ZOOM_ON = 0;
    public static final int SETUP_ZOOM_CROSSING = 1;
    public static final int SETUP_ZOOM_OFF = 2;
    public static final int MAP_REPRESENTATION_STANDARD = 0;
    public static final int MAP_REPRESENTATION_GOOGLEEARTH = 1;
    public static final int MAP_REPRESENTATION_TRAFFIC = 2;
    public static final int MAP_REPRESENTATION_RANGEMAP = 3;
    public static final int SUPPLEMENTARY_MAP_VIEW_NO_SUPPLEMENTARY_MAP_VIEW = 0;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM = 1;
    public static final int SUPPLEMENTARY_MAP_VIEW_COMPASS = 2;
    public static final int SUPPLEMENTARY_MAP_VIEW_31_BOX = 3;
    public static final int SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM_ON_MAP = 4;
    public static final int MAP_DISPLAY_MU = 0;
    public static final int MAP_DISPLAY_BOTH = 1;
    public static final int MAP_DISPLAY_KOMBI = 2;

    public int setMapType(int var1);

    public void setMapColor(int var1);

    public void setMapOrientation(int var1);

    public void setAdditionalInfos(int var1);

    public void setCrossingView(int var1);

    public void setIncrementalZoom(int var1);

    public void setMapRepresentation(int var1);

    public boolean sdsSetMapRepresentation(int var1);

    public void setZoomLevel(float var1);

    public void swapMaps();

    public void setTrafficSettings(boolean var1, boolean var2, boolean var3, int var4);
}

