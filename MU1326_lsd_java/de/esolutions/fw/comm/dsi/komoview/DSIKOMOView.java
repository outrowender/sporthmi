/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview;

public interface DSIKOMOView {
    public static final String IPL_COMM_UUID = "4152be76-57b5-5a4d-a6f6-69587a25d01b";
    public static final String IPL_COMM_INTERFACE_KEY = "e661e4a9-2fb1-5280-8ee8-4c2c186b2698";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.15";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.15";

    public static interface Consts {
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

