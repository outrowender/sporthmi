/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIOnlineESIMTrafficNotification {
    public static final String IPL_COMM_UUID = "bcc69e7f-d107-5b5a-a6a5-0216a2cdb952";
    public static final String IPL_COMM_INTERFACE_KEY = "9263ea87-4f96-5e7a-9cc4-c26720d77907";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int ESIMNOTIFICATION_LOW = 1;
        public static final int ESIMNOTIFICATION_EXPIRE = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

