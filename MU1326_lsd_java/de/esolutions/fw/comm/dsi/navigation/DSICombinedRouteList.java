/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

public interface DSICombinedRouteList {
    public static final String IPL_COMM_UUID = "a53afa5f-b389-5405-acda-e03312c65d87";
    public static final String IPL_COMM_INTERFACE_KEY = "aae6318c-7a16-5849-9925-3da160c69c88";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.71";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.71";

    public static interface Consts {
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

