/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaOnline {
    public static final String IPL_COMM_UUID = "2bd7d950-8262-5e37-9e8a-0d0e953ef3cb";
    public static final String IPL_COMM_INTERFACE_KEY = "c990b910-60e5-5ca6-ac98-870fb9033a5d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int BUFFERSTATE_UNKNOWN = 0;
        public static final int BUFFERSTATE_UNDERRUN = 1;
        public static final int BUFFERSTATE_FILLED = 2;
        public static final int AUDIOTYPE_UNKNOWN = 0;
        public static final int AUDIOTYPE_SURROUNDSOUND = 1;
        public static final int AUDIOTYPE_3DSOUND = 2;
        public static final int AUDIOTYPE_VOLUMEOFFSET = 4;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

