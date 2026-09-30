/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

public interface ASIHMISyncNavigation {
    public static final String IPL_COMM_UUID = "43ddd4bf-1185-405b-ad9d-d74c07925b2a";
    public static final String IPL_COMM_INTERFACE_KEY = "59fbcec2-b8b2-5f69-a9e5-b65f2d9a124c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int NAVRESULTCODE_OK = 0;
        public static final int NAVRESULTCODE_NOT_OPERABLE = 1;
        public static final int NAVRESULTCODE_ERROR = 2;
        public static final int NAVRESULTCODE_UNSUPPORTED = 3;
    }

    public static class ReplyIDs {
        public static final short startGuidanceToDestinationsResult = 9;
        public static final short updateASIVersion = 10;
        public static final short updateRequestIDs = 19;
        public static final short updateReplyIDs = 18;
        public static final short updateRouteGuidanceActive = 16;
        public static final short updateCarPosition = 11;
        public static final short updateDestinationInfo = 12;
        public static final short updateDestinationsForGuidance = 13;
        public static final short updateNextDestinationInfo = 15;
        public static final short updateNightDesignRequested = 17;

        public static short[] getIDs() {
            return new short[]{9, 10, 19, 18, 16, 11, 12, 13, 15, 17};
        }
    }

    public static class RequestIDs {
        public static final short startGuidanceToDestinations = 8;
        public static final short setNotification_5 = 5;
        public static final short setNotification_7 = 7;
        public static final short setNotification_6 = 6;
        public static final short clearNotification_0 = 0;
        public static final short clearNotification_2 = 2;
        public static final short clearNotification_1 = 1;

        public static short[] getIDs() {
            return new short[]{8, 5, 7, 6, 0, 2, 1};
        }
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 10L;
        public static final long RequestIDs = 19L;
        public static final long ReplyIDs = 18L;
        public static final long RouteGuidanceActive = 16L;
        public static final long CarPosition = 11L;
        public static final long DestinationInfo = 12L;
        public static final long DestinationsForGuidance = 13L;
        public static final long NextDestinationInfo = 15L;
        public static final long NightDesignRequested = 17L;
    }
}

