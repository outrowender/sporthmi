/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

public interface DSIMapViewerManeuverView {
    public static final String IPL_COMM_UUID = "eee253d7-b7b4-5a8e-a664-221c34b47406";
    public static final String IPL_COMM_INTERFACE_KEY = "28c71c4f-1f0a-5111-94fc-f259bf83d8f1";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public static interface Consts {
        public static final String VERSION = "2.11.62";
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

