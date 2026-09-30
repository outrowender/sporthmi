/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance;

public interface ASIHMISyncInstance {
    public static final String IPL_COMM_UUID = "ec3859ab-0660-4557-8339-69dc874fe86b";
    public static final String IPL_COMM_INTERFACE_KEY = "b0085475-d550-520a-8dc6-1d1e3293432f";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int RESULTCODE_SUCCESS = 0;
        public static final int RESULTCODE_UNKNOWN = 1;
        public static final int RESULTCODE_UNAVAILABLE = 2;
    }

    public static class ReplyIDs {
        public static final short responseInstanceId = 4;
        public static final short updateASIVersion = 8;
        public static final short updateRequestIDs = 10;
        public static final short updateReplyIDs = 9;

        public static short[] getIDs() {
            return new short[]{4, 8, 10, 9};
        }
    }

    public static class RequestIDs {
        public static final short requestInstanceId = 3;
        public static final short setNotification_5 = 5;
        public static final short setNotification_7 = 7;
        public static final short setNotification_6 = 6;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{3, 5, 7, 6, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 8L;
        public static final long RequestIDs = 10L;
        public static final long ReplyIDs = 9L;
    }
}

