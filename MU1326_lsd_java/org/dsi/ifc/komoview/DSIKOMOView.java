/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.komoview.RouteInfoElement;

public interface DSIKOMOView
extends DSIBase {
    public static final String VERSION = "2.11.15";
    public static final int ROUTEINFOELEMENTTYPE_RIE_NONE = 0;
    public static final int ROUTEINFOELEMENTTYPE_RIE_POI = 1;
    public static final int ROUTEINFOELEMENTTYPE_RIE_TMC = 2;
    public static final int ROUTEINFOELEMENTTYPE_RIE_MANEUVER = 3;
    public static final int ROUTEINFOELEMENTTYPE_RIE_CALC = 4;
    public static final int KOMOVIEWSTYLE_VARIANT1 = 1;
    public static final int KOMOVIEWSTYLE_VARIANT2 = 2;
    public static final int KOMOVIEWSTYLE_VARIANT3 = 3;
    public static final int KOMOVIEWSTYLE_VARIANT4 = 4;
    public static final int KOMOVIEWSTYLE_VARIANT5 = 5;
    public static final int KOMOVIEWSTYLE_VARIANT6 = 6;
    public static final int KOMOVIEWSTYLE_VARIANT7 = 7;
    public static final int KOMOVIEWSTYLE_NOKOMOVIEW = 255;
    public static final int KOMOVIEWRESULT_OK = 0;
    public static final int KOMOVIEWRESULT_NOT_OPERABLE = 1;
    public static final int KOMOVIEWRESULT_ERROR = 2;
    public static final int KOMOVIEWRESULT_UNSUPPORTED = 3;
    public static final int KOMOVIEWTYPE_UNDEFINED = 0;
    public static final int KOMOVIEWTYPE_MANEUVERVIEW = 1;
    public static final int KOMOVIEWTYPE_ROUTEINFO = 2;
    public static final int ATTR_KOMOVIEWENABLED = 1;
    public static final int ATTR_VISIBILITY = 2;
    public static final int ATTR_CURRENTKOMOVIEWTYPE = 3;
    public static final int RT_ENABLEKOMOVIEW = 1000;
    public static final int RT_NOTIFYVISIBILITY = 1001;
    public static final int RT_SETROUTEINFOELEMENT = 1002;
    public static final int RT_SETKOMOVIEWSTYLE = 1003;
    public static final int RT_SETROUTEINFO = 1004;
    public static final int RP_KOMOVIEWRESULT = 2000;

    public void enableKomoView(boolean var1);

    public void notifyVisibility(boolean var1);

    public void setRouteInfoElement(RouteInfoElement var1);

    public void setRouteInfo(RouteInfoElement[] var1);

    public void setKomoViewStyle(int var1);
}

