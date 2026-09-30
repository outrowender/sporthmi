/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

public interface ASIHMISyncCarService {
    public static final String IPL_COMM_UUID = "8ccf0676-352e-4fe1-a86e-ed15a11ea69e";
    public static final String IPL_COMM_INTERFACE_KEY = "a5b91462-5820-555c-8411-698e8ac5864d";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public static interface Consts {
        public static final int OILLEVELWARNINGS_MIN = 0;
        public static final int OILLEVELWARNINGS_UNDERFILL = 1;
        public static final int OILLEVELWARNINGS_OVERFILL = 2;
        public static final int OILLEVELWARNINGS_SENSORERROR = 3;
        public static final int OILLEVELWARNINGS_OILOK = 4;
        public static final int OILLEVELWARNINGS_CHECKOIL = 5;
        public static final int OILLEVELWARNINGS_TILT = 6;
        public static final int OILLEVELWARNINGS_NOTUNDERHOTRUNNINGCONDITIONS = 7;
        public static final int OILLEVELWARNINGS_RUNNINGENGINE = 8;
        public static final int SIADISTANCESTATUS_UNDEFINED = 0;
        public static final int SIADISTANCESTATUS_NOT_CALCULATED_YET = 1;
        public static final int SCRSTATE_NORMAL = 1;
        public static final int SCRSTATE_WARNING1 = 2;
        public static final int SCRSTATE_WARNING2 = 3;
        public static final int SCRSTATE_SYSTEMERROR = 4;
        public static final int SCRSTATE_TILT = 5;
        public static final int SCRSTATE_FROZENMEDIUM = 6;
    }

    public static class ReplyIDs {
        public static final short updateASIVersion = 6;
        public static final short updateRequestIDs = 14;
        public static final short updateReplyIDs = 13;
        public static final short updateOilLevelData = 11;
        public static final short updateOilLevelDataVisibilityState = 12;
        public static final short updateAdBlueInfo = 26;
        public static final short updateAdBlueInfoVisibilityState = 8;
        public static final short updateSIAOilInspection = 15;
        public static final short updateSIAOilInspectionVisibilityState = 16;
        public static final short updateSIAServiceData = 17;
        public static final short updateSIAServiceDataVisibilityState = 18;
        public static final short updateVinData = 24;
        public static final short updateVinDataVisibilityState = 25;
        public static final short updateKeyData = 9;
        public static final short updateKeyDataVisibilityState = 10;
        public static final short updateTireDisplayData = 19;
        public static final short updateTireDisplayDataVisibilityState = 20;
        public static final short updateTireSystem = 21;
        public static final short updateVehicleSpeedVisibility = 23;
        public static final short updateVehicleSpeed = 22;

        public static short[] getIDs() {
            return new short[]{6, 14, 13, 11, 12, 26, 8, 15, 16, 17, 18, 24, 25, 9, 10, 19, 20, 21, 23, 22};
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
        public static final long RequestIDs = 14L;
        public static final long ReplyIDs = 13L;
        public static final long OilLevelData = 11L;
        public static final long OilLevelDataVisibilityState = 12L;
        public static final long AdBlueInfo = 26L;
        public static final long AdBlueInfoVisibilityState = 8L;
        public static final long SIAOilInspection = 15L;
        public static final long SIAOilInspectionVisibilityState = 16L;
        public static final long SIAServiceData = 17L;
        public static final long SIAServiceDataVisibilityState = 18L;
        public static final long VinData = 24L;
        public static final long VinDataVisibilityState = 25L;
        public static final long KeyData = 9L;
        public static final long KeyDataVisibilityState = 10L;
        public static final long TireDisplayData = 19L;
        public static final long TireDisplayDataVisibilityState = 20L;
        public static final long TireSystem = 21L;
        public static final long VehicleSpeedVisibility = 23L;
        public static final long VehicleSpeed = 22L;
    }
}

