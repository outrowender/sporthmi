/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse;

public interface DSISSE {
    public static final String IPL_COMM_UUID = "26680425-59c0-508c-9f43-b7aa7428423f";
    public static final String IPL_COMM_INTERFACE_KEY = "12cf7524-58e2-51f9-bc1c-58ea163c205f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public static interface Consts {
        public static final String VERSION = "2.11.3";
        public static final int RESPONSE_OK = 0;
        public static final int RESPONSE_ERROR = 1;
        public static final int MODE_HFP_OFF = 0;
        public static final int MODE_HFP_ON = 1;
        public static final int MODE_SDS_INTERN_ON = 2;
        public static final int MODE_SDS_INTERN_OFF = 3;
        public static final int MODE_SDS_EXTERN_ON = 4;
        public static final int MODE_SDS_EXTERN_OFF = 5;
        public static final int MODE_NONE = 6;
        public static final int MODE_SDS_SMARTPHONE_INT_ON = 7;
        public static final int MODE_SDS_SMARTPHONE_INT_OFF = 8;
        public static final int MODE_TEL_SMARTPHONE_INT_ON = 9;
        public static final int MODE_TEL_SMARTPHONE_INT_OFF = 10;
        public static final int MICMUTESTATE_ON = 0;
        public static final int MICMUTESTATE_OFF = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

