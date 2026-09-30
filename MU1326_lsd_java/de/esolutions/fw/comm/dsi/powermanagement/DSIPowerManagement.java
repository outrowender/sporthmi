/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement;

public interface DSIPowerManagement {
    public static final String IPL_COMM_UUID = "61e1c5fa-94ae-558d-afb5-945bc71781da";
    public static final String IPL_COMM_INTERFACE_KEY = "9e7a46a4-594a-549f-a3ef-11ea5b2199fe";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public static interface Consts {
        public static final String VERSION = "2.11.13";
        public static final int POWERSTATE_OFF = 0;
        public static final int POWERSTATE_ON = 1;
        public static final int POWERSTATE_STANDBY = 2;
        public static final int POWERSTATE_CRIT_TEMPR = 3;
        public static final int POWERSTATE_STANDBY_RESTRICTED = 4;
        public static final int POWERSTATE_ON_DIAG = 5;
        public static final int POWERSTATE_CUSTOMER_SWDL = 6;
        public static final int POWERSTATE_ON_TEL = 7;
        public static final int POWERSTATE_ON_SWDL = 8;
        public static final int POWERSTATE_STANDBY_PWR_SAVE = 9;
        public static final int POWERSTATE_ON_DELAY = 10;
        public static final int BEMSTATE_0 = 0;
        public static final int BEMSTATE_1 = 1;
        public static final int BEMSTATE_2 = 2;
        public static final int BEMSTATE_3 = 3;
        public static final int BEMSTATE_4 = 4;
        public static final int BEMSTATE_7 = 5;
        public static final int BEMSTATE_21 = 6;
        public static final int CHILDLOCK_DISABLED = 0;
        public static final int CHILDLOCK_ENABLED = 1;
        public static final int LASTON_MMI_STANDBY = 0;
        public static final int LASTON_MMI_ON = 1;
        public static final int LASTON_MMI_ON_NO_DISPLAY = 2;
        public static final int LASTON_MMI_IOC = 3;
        public static final int POWEREVENT_CLAMP_S_ON = 0;
        public static final int POWEREVENT_CLAMP_S_OFF = 1;
        public static final int POWEREVENT_CLAMP_15_ON = 2;
        public static final int POWEREVENT_CLAMP_15_OFF = 3;
        public static final int POWEREVENT_HK_DISPLAY = 4;
        public static final int POWEREVENT_HK = 5;
        public static final int POWEREVENT_ONOFF = 6;
        public static final int POWEREVENT_OTHER = 7;
        public static final int POWEREVENT_HK_RADIO = 8;
        public static final int POWEREVENT_HK_MEDIA = 9;
        public static final int POWEREVENT_HK_TEL = 10;
        public static final int POWEREVENT_HK_NAV = 11;
        public static final int POWEREVENT_HK_MENU = 12;
        public static final int POWEREVENT_HK_CAR = 13;
        public static final int POWEREVENT_HK_TONE = 14;
        public static final int POWEREVENT_HK_MAP = 15;
        public static final int POWEREVENT_HK_SOURCE = 16;
        public static final int DEVICETYPE_POWERMANAGEMENT = 0;
        public static final int ANIMATIONSTATUS_OFF = 0;
        public static final int ANIMATIONSTATUS_RUNNING = 1;
        public static final int ANIMATIONSTATUS_END = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

