/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;

public interface DSICombinedRouteList
extends DSIBase {
    public static final String VERSION = "2.11.71";
    public static final int COMBINEDROUTELISTELEMENTTYPE_LIST_END = -2;
    public static final int COMBINEDROUTELISTELEMENTTYPE_LIST_START = -1;
    public static final int COMBINEDROUTELISTELEMENTTYPE_ROAD_SEGMENT = 0;
    public static final int COMBINEDROUTELISTELEMENTTYPE_POINT = 1;
    public static final int COMBINEDROUTELISTELEMENTTYPE_MANEUVER = 2;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TRAFFIC_EVENT = 3;
    public static final int COMBINEDROUTELISTELEMENTTYPE_POI = 4;
    public static final int COMBINEDROUTELISTELEMENTTYPE_STOPOVER = 5;
    public static final int COMBINEDROUTELISTELEMENTTYPE_JUNCTION = 6;
    public static final int COMBINEDROUTELISTELEMENTTYPE_FERRYSEGMENT = 7;
    public static final int COMBINEDROUTELISTELEMENTTYPE_SLOPESEGMENT = 8;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TUNNELSEGMENT = 9;
    public static final int COMBINEDROUTELISTELEMENTTYPE_COUNTRYCHANGE = 10;
    public static final int COMBINEDROUTELISTELEMENTTYPE_STATECHANGE = 11;
    public static final int COMBINEDROUTELISTELEMENTTYPE_PROVINCECHANGE = 12;
    public static final int COMBINEDROUTELISTELEMENTTYPE_OFFROAD_SEGMENT = 13;
    public static final int COMBINEDROUTELISTELEMENTTYPE_OFFROAD = 14;
    public static final int COMBINEDROUTELISTELEMENTTYPE_HOVLANE = 15;
    public static final int COMBINEDROUTELISTELEMENTTYPE_TOLLSTATION = 16;
    public static final int COMBINEDROUTELISTELEMENTTYPE_CARTRAIN = 17;
    public static final int CHANGEINDICATOR_WINDOWCHANGED = 0;
    public static final int CHANGEINDICATOR_RGSTOPPED = 1;
    public static final int CHANGEINDICATOR_RGSTARTED = 2;
    public static final int LISTCONTENT_TOPLEVELNODES = -1;
    public static final int LISTCONTENT_LEAFNODES = -2;
    public static final int LISTCONTENT_ALLNODES = -3;
    public static final int RT_REQUESTCOMBINEDROUTELISTWINDOW = 1000;
    public static final int RT_REQUESTTRAFFICINFORMATION = 1002;
    public static final int RT_REQUESTPOIINFORMATION = 1003;
    public static final int RT_GETBOUNDINGRECTANGLEOFCOMBINEDROUTELISTELEMENTS = 1004;
    public static final int RT_REQUESTPRICEINFO = 1005;
    public static final int RP_COMBINEDROUTELISTRESULT = 2000;
    public static final int RP_TRAFFICINFORMATIONRESULT = 2001;
    public static final int RP_POIINFORMATIONRESULT = 2002;
    public static final int RP_GETBOUNDINGRECTANGLEOFCOMBINEDROUTELISTELEMENTSRESULT = 2003;
    public static final int RP_REQUESTPRICEINFORESULT = 2004;
    public static final int IN_WINDOWCHANGED = 3000;
    public static final int ATTR_ELEMENTSTOTAL = 1;

    public void requestCombinedRouteListWindow(int var1, int var2, long[] var3, long var4);

    public void requestTrafficInformation(long var1);

    public void requestPOIInformation(long var1);

    public void getBoundingRectangleOfCombinedRouteListElements(long[] var1);

    public void requestPriceInfo(long var1);
}

