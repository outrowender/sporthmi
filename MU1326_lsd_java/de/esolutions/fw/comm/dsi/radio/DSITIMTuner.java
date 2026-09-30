/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

public interface DSITIMTuner {
    public static final String IPL_COMM_UUID = "3a57ebc1-5b8d-5f2a-8631-ee1bec900d7d";
    public static final String IPL_COMM_INTERFACE_KEY = "e960820c-721d-538a-aa4c-692648635062";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public static interface Consts {
        public static final String VERSION = "2.11.36";
        public static final int TIMSTATUS_UNDEFINED = 0;
        public static final int TIMSTATUS_STOP = 1;
        public static final int TIMSTATUS_PLAY = 2;
        public static final int TIMSTATUS_PAUSE = 3;
        public static final int TIMSTATUS_FAST_FORWARD = 4;
        public static final int TIMSTATUS_FAST_BACKWARD = 5;
        public static final int TIMSTATUS_RECORD = 6;
        public static final int TIMPLAYBACKMODE_UNDEFINED = 0;
        public static final int TIMPLAYBACKMODE_STOP = 1;
        public static final int TIMPLAYBACKMODE_PLAY = 2;
        public static final int TIMPLAYBACKMODE_PAUSE = 3;
        public static final int TIMPLAYBACKMODE_FAST_FORWARD = 4;
        public static final int TIMPLAYBACKMODE_FAST_BACKWARD = 5;
        public static final int TIMPLAYBACKMETHODSTATUS_UNDEFINED = 0;
        public static final int TIMPLAYBACKMETHODSTATUS_RUNNING = 1;
        public static final int TIMPLAYBACKMETHODSTATUS_DONE = 2;
        public static final int TIMPLAYBACKMETHODSTATUS_INVALID = 3;
        public static final int TIMPLAYBACKMETHODSTATUS_TIM_NOT_AVAILABLE = 4;
        public static final int TIMRESETTYPE_UNDEFINED = 0;
        public static final int TIMRESETTYPE_TO_DEFAULT = 1;
        public static final int TIMRESETTYPE_ANONYMIZE = 2;
        public static final int TIMAVAILABLE_UNDEFINED = 0;
        public static final int TIMAVAILABLE_NO = 1;
        public static final int TIMAVAILABLE_DEVICE_ONLY = 2;
        public static final int TIMAVAILABLE_YES = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

