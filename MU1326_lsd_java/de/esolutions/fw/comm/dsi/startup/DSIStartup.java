/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.startup;

public interface DSIStartup {
    public static final String IPL_COMM_UUID = "f6db1c7c-7ff9-5fd1-97ba-7298745f1eb1";
    public static final String IPL_COMM_INTERFACE_KEY = "be1098f9-5f0f-5616-b7e3-b9ca49a0507c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.16";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.16";

    public static interface Consts {
        public static final String VERSION = "2.11.16";
        public static final int DOMAINID_STARTUP_DOMAIN_UNKNOWN = 0;
        public static final int DOMAINID_STARTUP_DOMAIN_ROOT = 1;
        public static final int DOMAINID_STARTUP_DOMAIN_TUNER = 2;
        public static final int DOMAINID_STARTUP_DOMAIN_MEDIA = 3;
        public static final int DOMAINID_STARTUP_DOMAIN_ADDRESSBOOK = 4;
        public static final int DOMAINID_STARTUP_DOMAIN_PHONE = 5;
        public static final int DOMAINID_STARTUP_DOMAIN_NAV = 6;
        public static final int DOMAINID_STARTUP_DOMAIN_INFO = 7;
        public static final int DOMAINID_STARTUP_DOMAIN_CAR = 8;
        public static final int DOMAINID_STARTUP_DOMAIN_AUDIO = 9;
        public static final int DOMAINID_STARTUP_DOMAIN_SDS = 10;
        public static final int DOMAINID_STARTUP_DOMAIN_SWDL = 11;
        public static final int DOMAINID_STARTUP_DOMAIN_EARLY_APPS = 12;
        public static final int DOMAINID_STARTUP_DOMAIN_POST = 13;
        public static final int DOMAINID_STARTUP_DOMAIN_COMMUNICATION = 14;
        public static final int DOMAINID_STARTUP_DOMAIN_IPSERVICES = 16;
        public static final int DOMAINID_STARTUP_DOMAIN_GEMMI = 17;
        public static final int DOMAINID_STARTUP_DOMAIN_BAPKOMBI = 18;
        public static final int DOMAINID_STARTUP_DOMAIN_BLUETOOTH = 19;
        public static final int DOMAINID_STARTUP_DOMAIN_BROWSER = 20;
        public static final int DOMAINID_STARTUP_DOMAIN_EXPLORER = 21;
        public static final int DOMAINID_STARTUP_DOMAIN_CALENDAR = 22;
        public static final int DOMAINID_STARTUP_DOMAIN_PICTURESTORE = 23;
        public static final int DOMAINID_STARTUP_DOMAIN_STREETVIEW = 24;
        public static final int DOMAINID_STARTUP_DOMAIN_MOBILITYHORIZON = 25;
        public static final int DOMAINID_STARTUP_DOMAIN_EXBOXM = 26;
        public static final int DOMAINID_STARTUP_DOMAIN_MIRRORLINK = 27;
        public static final int DOMAINID_STARTUP_DOMAIN_SFA = 28;
        public static final int DOMAINID_STARTUP_DOMAIN_SEARCH = 29;
        public static final int DOMAINID_STARTUP_DOMAIN_DIAGNOSIS = 30;
        public static final int DOMAINID_STARTUP_DOMAIN_ASIA_LANGUAGE_SUPPORT = 31;
        public static final int DOMAINID_STARTUP_DOMAIN_EXLAP = 32;
        public static final int DOMAINID_STARTUP_DOMAIN_TVTUNER = 33;
        public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ONLINE = 34;
        public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ROUTER = 35;
        public static final int DOMAINID_STARTUP_DOMAIN_RADIODATA_SERVER = 36;
        public static final int DOMAINID_STARTUP_DOMAIN_SMARTPHONE_INTEGRATION = 37;
        public static final int DOMAINID_STARTUP_DOMAIN_WIRELESS_CHARGER = 38;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_INIT = 0;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_STARTED = 1;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_AUDIBLE = 2;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_OPERABLE = 4;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_FULLY_OPERABLE = 8;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR = 16;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_UNRECOVERABLE = 32;
        public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_NOT_AVAILABLE = 64;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

