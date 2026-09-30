/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

public interface ASIHMISyncGeneric {
    public static final String IPL_COMM_UUID = "8240215d-ce8b-4cad-8c1c-31b07f57874c";
    public static final String IPL_COMM_INTERFACE_KEY = "acbc4ddf-b980-5af2-a38a-506f1125c975";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
    }

    public static class ReplyIDs {
        public static final short sendDataFromUnit = 3;
        public static final short updateASIVersion = 8;
        public static final short updateRequestIDs = 10;
        public static final short updateReplyIDs = 9;

        public static short[] getIDs() {
            return new short[]{3, 8, 10, 9};
        }
    }

    public static class RequestIDs {
        public static final short sendDataToUnit = 4;
        public static final short setNotification_5 = 5;
        public static final short setNotification_7 = 7;
        public static final short setNotification_6 = 6;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{4, 5, 7, 6, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 8L;
        public static final long RequestIDs = 10L;
        public static final long ReplyIDs = 9L;
    }
}

