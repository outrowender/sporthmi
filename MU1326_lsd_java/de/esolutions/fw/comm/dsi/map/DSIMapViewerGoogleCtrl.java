/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

public interface DSIMapViewerGoogleCtrl {
    public static final String IPL_COMM_UUID = "e47f3481-29e1-5677-a2cc-6de88b0916fb";
    public static final String IPL_COMM_INTERFACE_KEY = "dfac13da-c25c-582e-a177-03e1c52e6c16";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public static interface Consts {
        public static final String VERSION = "2.11.62";
        public static final int CONNECTIONSTATE_NONE = 0;
        public static final int CONNECTIONSTATE_CONNECTING = 1;
        public static final int CONNECTIONSTATE_GPRS = 2;
        public static final int CONNECTIONSTATE_UMTS = 3;
        public static final int CONNECTIONSTATE_LAN = 4;
        public static final int CONNECTIONSTATE_FORBIDDENROAMING = 5;
        public static final int CONNECTIONSTATE_ROAMING = 6;
        public static final int CONNECTIONSTATE_WIFI = 7;
        public static final int CONNECTIONSTATE_INVALID_CONNECTIONSTATE = 255;
        public static final int CONNECTIONSTATE_ALLOWCONNECTIONWHENPENDING = 0;
        public static final int CONNECTIONSTATE_FORBIDCONNECTIONWHENPENDING = 255;
        public static final int LAYERTYPE_USER_LAYER = 0;
        public static final int LAYERTYPE_SYSTEM = 1;
        public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_NO_DATA = 0;
        public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_LOGIN = 1;
        public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_NOT_RECOMMENDED = 2;
        public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_RENDERER_RECOMMENDED = 3;
        public static final int DATACONNECTIONSTATE_DATA_CONNECTION_NEEDED_DB_CORRUPTED = 4;
        public static final int LABELPOSITION_UNDEFINED = 0;
        public static final int LABELPOSITION_TOPLEFT = 1;
        public static final int LABELPOSITION_TOP = 2;
        public static final int LABELPOSITION_TOPRIGHT = 3;
        public static final int LABELPOSITION_LEFT = 4;
        public static final int LABELPOSITION_CENTER = 5;
        public static final int LABELPOSITION_RIGHT = 6;
        public static final int LABELPOSITION_BOTTOMLEFT = 7;
        public static final int LABELPOSITION_BOTTOM = 8;
        public static final int LABELPOSITION_BOTTOMRIGHT = 9;
        public static final int LABELALIGNMENT_UNDEFINED = 0;
        public static final int LABELALIGNMENT_LEFT = 1;
        public static final int LABELALIGNMENT_CENTER = 2;
        public static final int LABELALIGNMENT_RIGHT = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

