/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate;

public interface ASIHMISyncCarClimate {
    public static final String IPL_COMM_UUID = "ff03f2f6-eceb-470b-8239-62939e77c4ac";
    public static final String IPL_COMM_INTERFACE_KEY = "c5ac76c2-2476-5a12-9346-cccd09428a82";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 7;
        public static final short updateRequestIDs = 12;
        public static final short updateReplyIDs = 11;
        public static final short updateAirconTempZone1 = 9;
        public static final short updateAirconTempZone2 = 10;
        public static final short updateAirconMaxAC = 8;

        public static short[] getIDs() {
            return new short[]{7, 12, 11, 9, 10, 8};
        }
    }

    public static class RequestIDs {
        public static final short setAirconAC = 3;
        public static final short setNotification_4 = 4;
        public static final short setNotification_6 = 6;
        public static final short setNotification_5 = 5;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{3, 4, 6, 5, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 7L;
        public static final long RequestIDs = 12L;
        public static final long ReplyIDs = 11L;
        public static final long AirconTempZone1 = 9L;
        public static final long AirconTempZone2 = 10L;
        public static final long AirconMaxAC = 8L;
    }
}

