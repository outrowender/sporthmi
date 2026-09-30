/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

public interface ASIHMISyncCarBordComputer {
    public static final String IPL_COMM_UUID = "7bf67018-bebb-46f4-bf0f-0d5345fcf213";
    public static final String IPL_COMM_INTERFACE_KEY = "2a6a543b-0fe6-5170-9fb4-6c05144dfe9c";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 6;
        public static final short updateRequestIDs = 24;
        public static final short updateReplyIDs = 23;
        public static final short updateBCShortTermAverageConsumption1Visibility = 18;
        public static final short updateBCShortTermAverageConsumption1 = 17;
        public static final short updateBCShortTermAverageConsumption2Visibility = 20;
        public static final short updateBCShortTermAverageConsumption2 = 19;
        public static final short updateBCLongTermAverageConsumption1Visibility = 12;
        public static final short updateBCLongTermAverageConsumption1 = 11;
        public static final short updateBCLongTermAverageConsumption2Visibility = 14;
        public static final short updateBCLongTermAverageConsumption2 = 13;
        public static final short updateBCCurrentRange1Visibility = 8;
        public static final short updateBCCurrentRange1 = 7;
        public static final short updateBCCurrentRange2Visibility = 10;
        public static final short updateBCCurrentRange2 = 9;
        public static final short updateBCShortTermGeneralVisibility = 22;
        public static final short updateBCShortTermGeneral = 21;
        public static final short updateBCLongTermGeneralVisibility = 16;
        public static final short updateBCLongTermGeneral = 15;

        public static short[] getIDs() {
            return new short[]{6, 24, 23, 18, 17, 20, 19, 12, 11, 14, 13, 8, 7, 10, 9, 22, 21, 16, 15};
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
        public static final long RequestIDs = 24L;
        public static final long ReplyIDs = 23L;
        public static final long BCShortTermAverageConsumption1Visibility = 18L;
        public static final long BCShortTermAverageConsumption1 = 17L;
        public static final long BCShortTermAverageConsumption2Visibility = 20L;
        public static final long BCShortTermAverageConsumption2 = 19L;
        public static final long BCLongTermAverageConsumption1Visibility = 12L;
        public static final long BCLongTermAverageConsumption1 = 11L;
        public static final long BCLongTermAverageConsumption2Visibility = 14L;
        public static final long BCLongTermAverageConsumption2 = 13L;
        public static final long BCCurrentRange1Visibility = 8L;
        public static final long BCCurrentRange1 = 7L;
        public static final long BCCurrentRange2Visibility = 10L;
        public static final long BCCurrentRange2 = 9L;
        public static final long BCShortTermGeneralVisibility = 22L;
        public static final long BCShortTermGeneral = 21L;
        public static final long BCLongTermGeneralVisibility = 16L;
        public static final long BCLongTermGeneral = 15L;
    }
}

