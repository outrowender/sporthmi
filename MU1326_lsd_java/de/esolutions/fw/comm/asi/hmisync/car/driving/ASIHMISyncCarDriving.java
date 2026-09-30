/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

public interface ASIHMISyncCarDriving {
    public static final String IPL_COMM_UUID = "4100596a-a26d-4625-84dc-0b3013890cde";
    public static final String IPL_COMM_INTERFACE_KEY = "a3a2eb6d-2c8e-59dd-b6c4-6d6508e2f15f";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 6;
        public static final short updateRequestIDs = 10;
        public static final short updateReplyIDs = 9;
        public static final short updateTADVehicleInfo = 20;
        public static final short updateTADConfiguration = 22;
        public static final short updateTADCurrentRollAngle = 15;
        public static final short updateTADPosMaxRollAngle = 19;
        public static final short updateTADNegMaxRollAngle = 17;
        public static final short updateTADCurrentPitchAngle = 14;
        public static final short updateTADPosMaxPitch = 18;
        public static final short updateTADNegMaxPitch = 16;
        public static final short updateTADVisibilityState = 21;
        public static final short updateSuspensionControlCurrentLevel = 11;
        public static final short updateSuspensionControlTargetLevel = 12;
        public static final short updateSuspensionVisibilityState = 13;
        public static final short updateDriveSelectActiveProfile = 7;
        public static final short updateDriveSelectActiveProfileVisibilityState = 8;

        public static short[] getIDs() {
            return new short[]{6, 10, 9, 20, 22, 15, 19, 17, 14, 18, 16, 21, 11, 12, 13, 7, 8};
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
        public static final long RequestIDs = 10L;
        public static final long ReplyIDs = 9L;
        public static final long TADVehicleInfo = 20L;
        public static final long TADConfiguration = 22L;
        public static final long TADCurrentRollAngle = 15L;
        public static final long TADPosMaxRollAngle = 19L;
        public static final long TADNegMaxRollAngle = 17L;
        public static final long TADCurrentPitchAngle = 14L;
        public static final long TADPosMaxPitch = 18L;
        public static final long TADNegMaxPitch = 16L;
        public static final long TADVisibilityState = 21L;
        public static final long SuspensionControlCurrentLevel = 11L;
        public static final long SuspensionControlTargetLevel = 12L;
        public static final long SuspensionVisibilityState = 13L;
        public static final long DriveSelectActiveProfile = 7L;
        public static final long DriveSelectActiveProfileVisibilityState = 8L;
    }
}

