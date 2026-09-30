/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.wirelesscharging;

public interface DSIWirelessCharging {
    public static final String IPL_COMM_UUID = "9e32ff1c-d58b-52cb-be94-93c9612e6748";
    public static final String IPL_COMM_INTERFACE_KEY = "5536b794-4ea5-521b-b621-5bb7efd1ce30";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public static interface Consts {
        public static final String VERSION = "2.11.1";
        public static final int CHARGINGINFO_OFF = 0;
        public static final int CHARGINGINFO_EMPTY = 1;
        public static final int CHARGINGINFO_NONWLC = 2;
        public static final int CHARGINGINFO_WLCFOD = 3;
        public static final int CHARGINGINFO_WLCHARGE = 4;
        public static final int CHARGINGINFO_WLCFULL = 5;
        public static final int CHARGERSTATE_OFF = 0;
        public static final int CHARGERSTATE_ON = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

