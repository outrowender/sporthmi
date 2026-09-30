/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

public interface DSIObjectPush {
    public static final String IPL_COMM_UUID = "2ef8cbcc-49c4-501d-bf2e-34f0112feb90";
    public static final String IPL_COMM_INTERFACE_KEY = "fcc52b95-f929-5290-a442-b325d41b2867";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public static interface Consts {
        public static final String VERSION = "2.11.13";
        public static final int OBJECTTYPE_ADDRESS = 0;
        public static final int OBJECTTYPE_APPOINTMENT = 1;
        public static final int OBJECTTYPE_MESSAGE = 2;
        public static final int OBJECTTYPE_BINARY = 3;
        public static final int OBJECTTYPE_UNKNOWN = 4;
        public static final int OBJECTTYPE_TODO = 5;
        public static final int OBJECTTYPE_NOTE = 6;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

