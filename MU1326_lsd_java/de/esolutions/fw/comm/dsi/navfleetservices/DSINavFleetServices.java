/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navfleetservices;

public interface DSINavFleetServices {
    public static final String IPL_COMM_UUID = "fb82b86b-080e-5edd-9890-a317ba47cef4";
    public static final String IPL_COMM_INTERFACE_KEY = "b4a27e25-9891-5072-844c-89e8a452bef1";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public static interface Consts {
        public static final String VERSION = "2.11.1";
        public static final int APPSTATE_ACTIVE = 0;
        public static final int APPSTATE_FORBIDDENROAMING = 1;
        public static final int APPSTATE_DEACTIVATE = 2;
        public static final int NCFSRESULTCODE_OK = 0;
        public static final int NCFSRESULTCODE_ERROR = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

