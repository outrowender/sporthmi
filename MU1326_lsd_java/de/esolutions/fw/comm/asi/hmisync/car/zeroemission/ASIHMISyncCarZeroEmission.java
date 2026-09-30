/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

public interface ASIHMISyncCarZeroEmission {
    public static final String IPL_COMM_UUID = "ca36882d-502d-46af-ab3e-d2c6400c0f8f";
    public static final String IPL_COMM_INTERFACE_KEY = "a6b4ab1f-6788-5ff8-830d-83712694c53c";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final byte ZE_ENTRY_STATE_INIT = 0;
        public static final byte ZE_ENTRY_STATE_NORMAL = 1;
        public static final byte ZE_ENTRY_STATE_INVALID = 2;
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 6;
        public static final short updateRequestIDs = 9;
        public static final short updateReplyIDs = 8;
        public static final short updateZEVisibilityState = 11;
        public static final short updateZeroEmissionValues = 10;
        public static final short updateCurrentZeroEmissionValue = 7;

        public static short[] getIDs() {
            return new short[]{6, 9, 8, 11, 10, 7};
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
        public static final long RequestIDs = 9L;
        public static final long ReplyIDs = 8L;
        public static final long ZEVisibilityState = 11L;
        public static final long ZeroEmissionValues = 10L;
        public static final long CurrentZeroEmissionValue = 7L;
    }
}

