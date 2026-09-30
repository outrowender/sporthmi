/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaRouter {
    public static final String IPL_COMM_UUID = "cd9cb76b-b8f8-5cda-942a-554e3ab36b72";
    public static final String IPL_COMM_INTERFACE_KEY = "31c443b1-cc2b-5ea8-b1b3-1c73b8831514";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int SINKFLAG_NONE = 0;
        public static final int SINKFLAG_HEADUNIT = 1;
        public static final int SINKFLAG_NETWORK = 2;
        public static final int AUDIOSOURCE_NONE = 0;
        public static final int AUDIOSOURCE_INTERNAL = 1;
        public static final int AUDIOSOURCE_EXTERNAL = 2;
        public static final int AUDIOSOURCE_NETWORK = 3;
        public static final int VIDEOSOURCE_NONE = 0;
        public static final int VIDEOSOURCE_INTERNAL = 1;
        public static final int VIDEOSOURCE_EXTERNAL = 2;
        public static final int CLIENTSTATUS_UNKNOWN = 0;
        public static final int CLIENTSTATUS_REGISTRATION_SUCCESS = 1;
        public static final int CLIENTSTATUS_REGISTRATION_FAILED = 2;
        public static final int CLIENTSTATUS_DEREGISTRATION_SUCCSSS = 3;
        public static final int CLIENTSTATUS_DEREGISTRATION_FAILED = 4;
        public static final int STREAMINGSTATUS_UNKNOWN = 0;
        public static final int STREAMINGSTATUS_STARTED = 1;
        public static final int STREAMINGSTATUS_STOPPED = 2;
        public static final int STREAMINGSTATUS_STOPPED_WITH_ERROR = 3;
        public static final int STREAMINGSTATUS_STREAM_CHANGED = 4;
        public static final int CONFIGURATIONRESULT_OK = 0;
        public static final int CONFIGURATIONRESULT_NOK = 1;
        public static final int VIRTUALCHANNEL_NONE = 0;
        public static final int VIRTUALCHANNEL_ENT_INTMEDIA = 1;
        public static final int VIRTUALCHANNEL_ENT_A2LS = 2;
        public static final int VIRTUALCHANNEL_ENT_ML = 3;
        public static final int VIRTUALCHANNEL_ENT_MIRRORLINK = 3;
        public static final int VIRTUALCHANNEL_ENT_DIO = 4;
        public static final int VIRTUALCHANNEL_ENT_GAL = 5;
        public static final int VIRTUALCHANNEL_ENT_RSVD1 = 6;
        public static final int VIRTUALCHANNEL_ENT_RSVD2 = 7;
        public static final int VIRTUALCHANNEL_ENT_RSVD3 = 8;
        public static final int VIRTUALCHANNEL_ANN_INT_NAV = 9;
        public static final int VIRTUALCHANNEL_ANN_INT_SPEECH = 10;
        public static final int VIRTUALCHANNEL_ANN_DIO_ALT = 11;
        public static final int VIRTUALCHANNEL_ANN_DIO_VOICE = 12;
        public static final int VIRTUALCHANNEL_ANN_GAL_UI = 13;
        public static final int VIRTUALCHANNEL_ANN_GAL_GUIDANCE = 14;
        public static final int VIRTUALCHANNEL_ANN_GAL_VOICE = 15;
        public static final int VIRTUALCHANNEL_ANN_ML_VOICE = 16;
        public static final int VIRTUALCHANNEL_ANN_ML_GUIDANCE = 17;
        public static final int VIRTUALCHANNEL_TEL_INT = 18;
        public static final int VIRTUALCHANNEL_TEL_DIO = 19;
        public static final int VIRTUALCHANNEL_TEL_GAL = 20;
        public static final int VIRTUALCHANNEL_TEL_ML = 21;
        public static final int VIRTUALCHANNEL_MIC = 22;
        public static final int VIRTUALCHANNEL_MIC_DIO = 23;
        public static final int VIRTUALCHANNEL_MIC_GAL = 24;
        public static final int VIRTUALCHANNEL_MIC_ML = 25;
        public static final int VIRTUALCHANNEL_SSE_INPUT = 26;
        public static final int VIRTUALCHANNEL_INPUT_ENT1 = 27;
        public static final int VIRTUALCHANNEL_INPUT_ENT2 = 28;
        public static final int VIRTUALCHANNEL_INPUT_ENT3 = 29;
        public static final int VIRTUALCHANNEL_INPUT_ENT4 = 30;
        public static final int VIRTUALCHANNEL_ANN_BCL_ALT = 31;
        public static final int VIRTUALCHANNEL_ANN_BCL_VOICE = 32;
        public static final int VIRTUALCHANNEL_ENT_BCL = 33;
        public static final int VIRTUALCHANNEL_MIC_BCL = 34;
        public static final int VIRTUALCHANNEL_TEL_BCL = 35;
        public static final int PHYSICALCHANNEL_NONE = 0;
        public static final int PHYSICALCHANNEL_MPL1 = 1;
        public static final int PHYSICALCHANNEL_MPL2 = 2;
        public static final int PHYSICALCHANNEL_ANN1 = 3;
        public static final int PHYSICALCHANNEL_ANN2 = 4;
        public static final int PHYSICALCHANNEL_TEL = 5;
        public static final int PHYSICALCHANNEL_INPUT_ENT1 = 6;
        public static final int PHYSICALCHANNEL_INPUT_ENT2 = 7;
        public static final int ROUTINGRESULT_OK = 0;
        public static final int ROUTINGRESULT_NOK = 1;
        public static final int ROUTINGRESULT_INVALID_SOURCE = 2;
        public static final int ROUTINGRESULT_INVALID_SINK = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

