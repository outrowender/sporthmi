/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.system;

public interface DSIHMIWatchDog {
    public static final String IPL_COMM_UUID = "c6dbc5bd-24a2-53b2-837f-0fa20e31905a";
    public static final String IPL_COMM_INTERFACE_KEY = "abf06958-052d-5701-838a-49b34c4accee";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public static interface Consts {
        public static final String VERSION = "2.11.0";
        public static final int RESULTCODE_OK = 0;
        public static final int RESULTCODE_FAIL = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

