/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

public interface DSIMapViewerZoomEngine {
    public static final String IPL_COMM_UUID = "f7dae942-62c8-5ee3-869f-c352122bc3e2";
    public static final String IPL_COMM_INTERFACE_KEY = "211373f2-b137-5465-93f3-6cb833a66a12";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public static interface Consts {
        public static final String VERSION = "2.11.62";
        public static final int ZOOMENGINESTATE_OFF = 0;
        public static final int ZOOMENGINESTATE_READY = 1;
        public static final int ZOOMENGINESTATE_AUTOZOOM = 2;
        public static final int ZOOMENGINESTATE_MANOEUVREZOOM = 3;
        public static final int ZOOMENGINESTATE_INVALID_ZOOMSTATE = 255;
        public static final int MAPVIEWTYPE_VIEW2D = 0;
        public static final int MAPVIEWTYPE_BIRDVIEW = 1;
        public static final int MAPVIEWTYPE_VIEW3D = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

