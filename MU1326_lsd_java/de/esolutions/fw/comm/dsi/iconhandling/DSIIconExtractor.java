/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling;

public interface DSIIconExtractor {
    public static final String IPL_COMM_UUID = "8668d5c3-8945-56f4-999f-7916a899098a";
    public static final String IPL_COMM_INTERFACE_KEY = "7348c90a-64f5-5b1f-bcaa-b2844067895d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.16";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.16";

    public static interface Consts {
        public static final String VERSION = "2.11.16";
        public static final int ICONSIZE_SMALL = 0;
        public static final int ICONSIZE_MEDIUM = 1;
        public static final int ICONSIZE_LARGE = 2;
        public static final int ICONSIZE_VERY_SMALL = 3;
        public static final int ICONSIZE_VERY_LARGE = 4;
        public static final int ICONRESULT_OK = 0;
        public static final int ICONRESULT_ERROR = 1;
        public static final int TMCICONSUBINDEX_NORMAL = 0;
        public static final int TMCICONSUBINDEX_GRAYED_OUT = 1;
        public static final int TMCICONSUBINDEX_BYPASSED = 2;
        public static final int TMCICONSUBINDEX_BYPASSED_DISAPPEARS = 3;
        public static final int TRAFFICREGULATIONICONSUBINDEX_NORMAL = 0;
        public static final int TRAFFICREGULATIONICONSUBINDEX_GRAYED_OUT = 1;
        public static final int TRAFFICREGULATIONICONSUBINDEX_CROSSED_OUT = 2;
        public static final int BRANDICONSTYLE_ACTUALBRANDICON = 0;
        public static final int BRANDICONSTYLE_GENERIC = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

