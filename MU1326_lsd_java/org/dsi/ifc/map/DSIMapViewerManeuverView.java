/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;

public interface DSIMapViewerManeuverView
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_MANOEUVREVIEWACTIVE = 1;
    public static final int ATTR_MANOEUVREVIEWSAVAILABLE = 2;
    public static final int ATTR_BAPEXITVIEWID = 3;
    public static final int MANOEUVRETYPE_MAP = 0;
    public static final int MANOEUVRETYPE_RGS = 1;
    public static final int MANOEUVRETYPE_INTERSECTION = 2;
    public static final int MANOEUVRETYPE_INTERSECTION_3D = 3;
    public static final int MANOEUVRETYPE_JUNCTION = 4;
    public static final int MANOEUVRETYPE_REALISTIC_PICTURE = 5;
    public static final int MANOEUVRETYPE_CANBAN = 6;
    public static final int MANOEUVRETYPE_FOLLOW = 7;
    public static final int MANOEUVRETYPE_PREPARE = 8;
    public static final int MANOEUVRETYPE_UTURN = 9;
    public static final int MANOEUVRETYPE_OFFROAD = 10;
    public static final int MANOEUVRETYPE_DESTINATION = 11;
    public static final int MANOEUVRETYPE_MISCELLANEOUS = 12;
    public static final int MANOEUVRETYPE_INVALID_MANOEUVRE = 255;
    public static final int RT_HIDEMANOEUVREVIEW = 1000;
    public static final int RT_SELECTMANOEUVREVIEW = 1001;
    public static final int RT_SETDISTANCESTRING = 1002;
    public static final int RT_DISABLEMANEUVERVIEWGENERATION = 1003;

    public void hideManoeuvreView();

    public void selectManoeuvreView(int var1, boolean var2);

    public void setDistanceString(String var1);

    public void disableManeuverViewGeneration(boolean var1);
}

