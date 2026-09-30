/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komonavinfo;

public interface DSIKOMONavInfo {
    public static final String IPL_COMM_UUID = "db1d815b-e37e-5cbe-a442-24a5f3413dd6";
    public static final String IPL_COMM_INTERFACE_KEY = "74b415a1-d338-5625-9411-dd3b52661e75";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public static interface Consts {
        public static final String VERSION = "2.11.10";
        public static final int DISTANCEUNIT_MILES = 0;
        public static final int DISTANCEUNIT_METERS = 1;
        public static final int DISTANCEUNIT_KILOMETERS = 2;
        public static final int DISTANCEUNIT_YARDS = 3;
        public static final int DISTANCEUNIT_FEEDS = 4;
        public static final int DISTANCEUNIT_QUARTERMILE = 5;
        public static final int TIMEFORMAT_24HFORMAT = 0;
        public static final int TIMEFORMAT_12HFORMAT = 1;
        public static final int RGMODE_RGI = 0;
        public static final int RGMODE_KDK = 1;
        public static final int RGMODE_COMPASS = 2;
        public static final int RGMODE_MAP = 3;
        public static final int NAVINFORESULTCODE_OK = 0;
        public static final int NAVINFORESULTCODE_ERROR = 1;
        public static final int NAVINFORESULTCODE_UNSUPPORTED = 2;
        public static final int AUTOZOOM_OFF = 0;
        public static final int AUTOZOOM_ON = 1;
        public static final int AUTOZOOM_ONINTERSECTION = 2;
        public static final int AUTOZOOM_NOTSUPPORTED = 15;
        public static final int SCALE_INVALID = 0;
        public static final int SCALE_MINIMUM = 65533;
        public static final int SCALE_MAXIMUM = 65534;
        public static final int SCALE_INNIT_UNKNOWN = 65535;
        public static final int MAPSCALEUNIT_METER = 0;
        public static final int MAPSCALEUNIT_KILOMETER = 1;
        public static final int MAPSCALEUNIT_YARD = 2;
        public static final int MAPSCALEUNIT_FEET = 3;
        public static final int MAPSCALEUNIT_MILE_UK_US = 4;
        public static final int MAPSCALEUNIT_QUARTERMILE = 5;
        public static final int MAPSCALEUNIT_KILOMETER_HUNDREDTHSTEPS = 6;
        public static final int MAPSCALEUNIT_MILE_HUNDREDTHSTEPS = 7;
        public static final int MAPSCALEUNIT_NOTSUPPORTED_NOINFO = 255;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

