/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect;

public interface DSITollCollect {
    public static final String IPL_COMM_UUID = "82ec560e-0f0a-5aa0-8ffe-4d3f42fa112f";
    public static final String IPL_COMM_INTERFACE_KEY = "2eeb5f84-9ec5-53a2-9327-256dd3dc030d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public static interface Consts {
        public static final String VERSION = "2.11.0";
        public static final int CARDSTATE_UNKNOWN = 0;
        public static final int CARDSTATE_NO_CARD_INSERTED = 1;
        public static final int CARDSTATE_CARD_OK = 2;
        public static final int CARDSTATE_CARD_ERROR = 3;
        public static final int CARDSTATE_SETUP_OK = 4;
        public static final int CARDERROR_UNKNOWN = 0;
        public static final int CARDERROR_NO_ERROR = 1;
        public static final int CARDERROR_ETC_NOT_REGISTERED = 2;
        public static final int CARDERROR_INFRASTRUCTURE_COMMUNICATION_ERROR = 3;
        public static final int CARDERROR_TCCARD_DEFECT = 4;
        public static final int CARDERROR_TCCARD_NOT_INSERTED = 5;
        public static final int CARDERROR_READ_ERROR = 6;
        public static final int CARDERROR_WRITE_ERROR = 7;
        public static final int CARDERROR_ETC_GATE_COMMUNICATION_ERROR = 8;
        public static final int CARDERROR_ETC_GATE_NOT_USABLE = 9;
        public static final int CARDERROR_DANGER_ETC_GATE_NOT_USABLE = 10;
        public static final int CARDERROR_TC_CARD_EXPIRED = 11;
        public static final int CARDERROR_TC_UNIT_ERROR = 12;
        public static final int CARDERROR_TC_SYSTEM_FAILURE = 13;
        public static final int CARDERROR_ETC_READER_NOT_REGISTERED = 14;
        public static final int HWINFO_MODEL_NAME = 0;
        public static final int HWINFO_MANUFACTURE_NAME = 1;
        public static final int HWINFO_IDENTIFICATION_NUMBER = 2;
        public static final int HWINFO_REG_MODEL_NAME = 3;
        public static final int HWINFO_SERIAL_PRODUCT_NUMBER = 4;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

