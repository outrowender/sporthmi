/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

public interface ASIHMISyncCarGeneric {
    public static final String IPL_COMM_UUID = "5b840a23-d8e1-48db-bd23-f4040e6a7520";
    public static final String IPL_COMM_INTERFACE_KEY = "53d5f21b-54ec-5e84-8236-10ea0e3da972";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int VISIBLITY_STATE_NOT_CODED = 0;
        public static final int VISIBLITY_STATE_INVISIBLE = 1;
        public static final int VISIBLITY_STATE_NORMAL = 2;
        public static final int VISIBLITY_STATE_HINT_ERROR = 3;
        public static final int VISIBLITY_STATE_HINT_CLAMP15 = 4;
        public static final int VISIBLITY_STATE_HINT_VTHR = 5;
        public static final int VISIBLITY_STATE_HINT_STANDSTILL = 6;
        public static final int VISIBLITY_STATE_HINT_ENGINE = 7;
        public static final int VISIBLITY_STATE_HINT_SYSTEM_OFF = 8;
        public static final int VISIBLITY_STATE_SPECIAL_ERROR = 9;
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 6;
        public static final short updateRequestIDs = 8;
        public static final short updateReplyIDs = 7;

        public static short[] getIDs() {
            return new short[]{6, 8, 7};
        }
    }

    public static class RequestIDs {
        public static final short setNotification_3 = 3;
        public static final short setNotification_5 = 5;
        public static final short setNotification_4 = 4;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{3, 5, 4, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 6L;
        public static final long RequestIDs = 8L;
        public static final long ReplyIDs = 7L;
    }
}

