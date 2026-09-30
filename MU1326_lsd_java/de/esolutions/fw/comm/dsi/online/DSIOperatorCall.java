/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

public interface DSIOperatorCall {
    public static final String IPL_COMM_UUID = "2a1c5862-a6e9-5faf-8fb0-01c3e94a7f64";
    public static final String IPL_COMM_INTERFACE_KEY = "5affe99d-9abb-58f1-9773-f236212f5c83";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public static interface Consts {
        public static final String VERSION = "2.11.42";
        public static final int TRANSFERTYPE_NOD = 0;
        public static final int TRANSFERTYPE_DTMF = 1;
        public static final int SERVICETYPE_UNKNOWN = 0;
        public static final int SERVICETYPE_CONCIERGE = 1;
        public static final int SERVICETYPE_OPERATOR = 2;
        public static final int RESULTTYPE_OLDSESSION = 0;
        public static final int RESULTTYPE_NEWSESSION = 1;
        public static final int RESULTTYPE_CONNECTIONERROR = 2;
        public static final int RESULTTYPE_INVALIDSESSION = 3;
        public static final int RESULTTYPE_SERVERERROR = 4;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

