/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

public interface ASIHMISyncMasterControl {
    public static final String IPL_COMM_UUID = "bacc7eeb-475f-4a14-ad22-d3b237ca4c1b";
    public static final String IPL_COMM_INTERFACE_KEY = "5e04952b-b55c-5075-a09b-d930bfab035a";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.01";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int LOCKSTATE_UNLOCKED = 0;
        public static final int LOCKSTATE_LOCKED = 1;
        public static final int LOCKSTATE_LOCKED_ALLOW_CLIMATE = 2;
        public static final int BLOCKSTATE_UNBLOCKED = 0;
        public static final int BLOCKSTATE_BLOCKED = 1;
        public static final int BLOCKSTATE_BLOCK_A2LS = 2;
        public static final int BLOCKSTATE_BLOCK_ENTERTAINMENT_SOURCES = 4;
        public static final int BLOCKSTATE_BLOCK_NAVIGATION = 8;
        public static final int BLOCKSTATE_BLOCK_CLIMATE = 16;
        public static final int BLOCKSTATE_BLOCK_SPORT_CHRONO = 32;
        public static final int APPCONTEXT_DEFAULT = 0;
        public static final int APPCONTEXT_REMOTE_RADIO = 1;
        public static final int APPCONTEXT_REMOTE_MEDIA = 2;
        public static final int APPCONTEXT_REMOTE_TV = 3;
        public static final int APPCONTEXT_HOMESCREEN = 4;
        public static final int APPCONTEXT_LOCKSCREEN = 5;
    }

    public static class ReplyIDs {
        public static final short factoryReset = 4;
        public static final short enterAppContext = 3;
        public static final short updateASIVersion = 8;
        public static final short updateRequestIDs = 14;
        public static final short updateReplyIDs = 13;
        public static final short updateHUVersion = 10;
        public static final short updateVIN = 12;
        public static final short updateLockState = 11;
        public static final short updateBlockState = 9;

        public static short[] getIDs() {
            return new short[]{4, 3, 8, 14, 13, 10, 12, 11, 9};
        }
    }

    public static class RequestIDs {
        public static final short setNotification_5 = 5;
        public static final short setNotification_7 = 7;
        public static final short setNotification_6 = 6;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{5, 7, 6, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 8L;
        public static final long RequestIDs = 14L;
        public static final long ReplyIDs = 13L;
        public static final long HUVersion = 10L;
        public static final long VIN = 12L;
        public static final long LockState = 11L;
        public static final long BlockState = 9L;
    }
}

