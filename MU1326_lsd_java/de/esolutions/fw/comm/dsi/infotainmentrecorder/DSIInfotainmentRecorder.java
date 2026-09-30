/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.infotainmentrecorder;

public interface DSIInfotainmentRecorder {
    public static final String IPL_COMM_UUID = "a394f52d-b3ac-5ebe-92eb-66c1046c706a";
    public static final String IPL_COMM_INTERFACE_KEY = "a49d5980-6f8f-563a-8c41-090a1fcbcbf7";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public static interface Consts {
        public static final String VERSION = "2.11.0";
        public static final int TTRIGGERTYPES_IRC_EXCEPTION_TRIGGER = 61;
        public static final int TTRIGGERTYPES_IRC_HOTKEY_TRIGGER = 63;
        public static final int TTRIGGERTYPES_IRC_RESET_TRIGGER = 62;
        public static final int TTRIGGERTYPES_SYSTEM_DRIVE_ERROR = 12;
        public static final int TTRIGGERTYPES_SYSTEM_DRIVE_READERROR = 8;
        public static final int TTRIGGERTYPES_SYSTEM_HDD_DEFECT = 9;
        public static final int TTRIGGERTYPES_SYSTEM_HDD_PRESURE = 10;
        public static final int TTRIGGERTYPES_SYSTEM_OVER_HEAT = 11;
        public static final int TTRIGGERTYPES_TEL_PHONE_NOT_FUNCTIONAL = 13;
        public static final int TTRIGGERTYPES_TEL_PHONE_TEMPERATURE_OFF = 14;
        public static final int TTRIGGERTYPES_TEL_SECCO_BLOCKED = 15;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_DAMAGED = 7;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPHIGH = 3;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPLOW = 5;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_DAMAGED = 6;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPHIGH = 2;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPLOW = 4;
        public static final int TTRIGGERTYPES_TEMP_SYSTEM_TEMP = 1;
        public static final int TTRIGGERTYPES_UNUSED = 0;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

