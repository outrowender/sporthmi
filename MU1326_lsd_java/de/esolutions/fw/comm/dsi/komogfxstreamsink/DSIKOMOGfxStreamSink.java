/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komogfxstreamsink;

public interface DSIKOMOGfxStreamSink {
    public static final String IPL_COMM_UUID = "e431fc99-c578-5fa8-b280-ce902809bd5d";
    public static final String IPL_COMM_INTERFACE_KEY = "7f54a915-2fc6-5ec3-81a7-a15e19315a24";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public static interface Consts {
        public static final String VERSION = "2.11.2";
        public static final int GFXSTATE_UNAVAILABLE = 0;
        public static final int GFXSTATE_AVAILABLE = 1;
        public static final int FGREFPIC_EMPTY = 0;
        public static final int FGREFPIC_KDK = 1;
        public static final int FGREFPIC_EV = 2;
        public static final int FGREFPIC_MAP = 3;
        public static final int FADESPEED_BLIT = 0;
        public static final int FADESPEED_FADE = 1;
        public static final int SYNCREQUEST_SYNCSATISFIED = 0;
        public static final int SYNCREQUEST_SYNCNEEDED = 1;
        public static final int DATARATE_OFF = 0;
        public static final int DATARATE_REDUCEDBANDWIDTH = 1;
        public static final int DATARATE_FULL = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

