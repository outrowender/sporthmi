/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.predictivenavigation;

public interface DSIPredictiveNavigation {
    public static final String IPL_COMM_UUID = "544e7dc8-7f3f-5404-85fc-248e9e470a44";
    public static final String IPL_COMM_INTERFACE_KEY = "90ccc0ce-a5f4-5d9b-b96f-a4a2ff55c1a2";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public static interface Consts {
        public static final String VERSION = "2.11.3";
        public static final int OPERATIONMODE_INACTIVE = 0;
        public static final int OPERATIONMODE_PASSIVE = 1;
        public static final int OPERATIONMODE_ACTIVE = 2;
        public static final int ROUTECALCULATIONSTATE_NOT_CALCULATED = 0;
        public static final int ROUTECALCULATIONSTATE_CALCULATING = 1;
        public static final int ROUTECALCULATIONSTATE_CALCULATED = 2;
        public static final int ROUTECALCULATIONSTATE_RECALCULATING = 3;
        public static final int ROUTECOLOR_0 = 0;
        public static final int ROUTECOLOR_1 = 1;
        public static final int ROUTECOLOR_2 = 2;
        public static final int ROUTECOLOR_3 = 3;
        public static final int ROUTECOLOR_4 = 4;
        public static final int ROUTECOLOR_5 = 5;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

