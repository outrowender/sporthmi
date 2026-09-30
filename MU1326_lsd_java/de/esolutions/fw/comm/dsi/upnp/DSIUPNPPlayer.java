/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

public interface DSIUPNPPlayer {
    public static final String IPL_COMM_UUID = "3912f7f2-4218-525b-8c84-e6501e877cb4";
    public static final String IPL_COMM_INTERFACE_KEY = "609340e3-ac04-5752-a339-65bb41f9e295";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public static interface Consts {
        public static final String VERSION = "2.11.2";
        public static final int DEVICETYPE_UNKNOWN = 0;
        public static final int DEVICETYPE_MIB_APP = 1;
        public static final int PLAYMODEFLAG_REPEAT = 1;
        public static final int PLAYMODEFLAG_SHUFFLE = 2;
        public static final int PLAYBACKSCOPE_FILE = 1;
        public static final int PLAYBACKSCOPE_DEVICE = 2;
        public static final int PLAYBACKSCOPE_MEDIUM = 3;
        public static final int PLAYBACKSCOPE_SELECTION = 6;
        public static final int PLAYBACKSTATE_INVALID = 0;
        public static final int PLAYBACKSTATE_PLAYING = 1;
        public static final int PLAYBACKSTATE_PAUSED = 2;
        public static final int PLAYBACKSTATE_SEEKING = 3;
        public static final int PLAYBACKSTATE_STOPPED_WITH_ERROR = 4;
        public static final int DIRECTION_FW = 0;
        public static final int DIRECTION_BW = 1;
        public static final int SKIP_NEXT_ENTRY = 0;
        public static final int SKIP_PREV_ENTRY = 1;
        public static final int SKIP_BEGIN_ENTRY = 2;
        public static final int PLAYBACKRATE_2X = 1;
        public static final int PLAYBACKRATE_4X = 2;
        public static final int PLAYBACKRATE_8X = 4;
        public static final int PLAYBACKRATE_16X = 6;
        public static final int PLAYBACKRATE_32X = 7;
        public static final int PLAYBACKRATE_1BY2X = 8;
        public static final int PLAYBACKRATE_1BY4X = 9;
        public static final int PLAYBACKRATE_1BY8X = 11;
        public static final int PLAYBACKRATE_1BY16X = 13;
        public static final int PLAYBACKRATE_1BY32X = 14;
        public static final int PLAYBACKRATE_64X = 15;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

