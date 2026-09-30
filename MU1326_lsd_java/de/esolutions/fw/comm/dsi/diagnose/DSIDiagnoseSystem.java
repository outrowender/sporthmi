/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose;

public interface DSIDiagnoseSystem {
    public static final String IPL_COMM_UUID = "8a9ad25b-5b32-5f75-b76b-b9b9dd2a5f3c";
    public static final String IPL_COMM_INTERFACE_KEY = "4c2400ee-45b6-5a9e-9d48-e950e68a27fe";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public static interface Consts {
        public static final String VERSION = "2.11.10";
        public static final int ROUTINE_DELETE_MEMORY = 0;
        public static final int ROUTINE_RESET_PML_PASSWORD = 1;
        public static final int ROUTINEACTION_START = 1;
        public static final int ROUTINEACTION_STOP = 2;
        public static final int ROUTINEACTION_RESULTS = 3;
        public static final int ROUTINESTATE_ACTIVE = 1;
        public static final int ROUTINESTATE_NOT_ACTIVE = 2;
        public static final int ROUTINESTATE_ABORTED = 3;
        public static final int ROUTINERESULT_CORRECT = 0;
        public static final int ROUTINERESULT_INCORRECT = 1;
        public static final int ROUTINERESULT_NOT_AVAILABLE = 2;
        public static final int HMIRESPONSE_OK = 0;
        public static final int HMIRESPONSE_GENERAL_REJECT = 2;
        public static final int HMIRESPONSE_REQUEST_SEQUENCE_ERROR = 3;
        public static final int HMIRESPONSE_REQUEST_OUT_OF_RANGE = 4;
        public static final int DELETE_MEMORY_FACTORY_SETTINGS = 0;
        public static final int DELETE_MEMORY_RESET_INTERNAL_VALUES = 1;
        public static final int ACTUATOR_REMOTE_CONTROL_MODE = 0;
        public static final int ACTUATOR_TEST_PICTURE_DISPLAY_1 = 1;
        public static final int ACTUATOR_TEST_PICTURE_DISPLAY_2 = 2;
        public static final int ACTUATOR_SOURCE_SWITCH = 3;
        public static final int ACTUATOR_NAVIGATION_DEMOROUTE = 4;
        public static final int ACTUATORACTION_START = 0;
        public static final int ACTUATORACTION_STOP = 1;
        public static final int ACTUATOR_INFINITE_TIMING = 255;
        public static final int TEST_PICTURE_DISPLAY_NO_CONTROL = 0;
        public static final int TEST_PICTURE_DISPLAY_STANDARD = 1;
        public static final int TEST_PICTURE_DISPLAY_RED = 2;
        public static final int TEST_PICTURE_DISPLAY_GREEN = 3;
        public static final int TEST_PICTURE_DISPLAY_BLUE = 4;
        public static final int TEST_PICTURE_DISPLAY_WHITE = 5;
        public static final int TEST_PICTURE_DISPLAY_BLACK = 6;
        public static final int TEST_PICTURE_DISPLAY_CHESSBOARD = 7;
        public static final int TEST_PICTURE_DISPLAY_CHESSBOARD_INVERTED = 8;
        public static final int TEST_PICTURE_DISPLAY_64_GRAYSCALES = 9;
        public static final int SOURCESWITCH_RADIO_FM = 0;
        public static final int SOURCESWITCH_RADIO_AM = 1;
        public static final int SOURCESWITCH_RADIO_DAB = 2;
        public static final int SOURCESWITCH_RADIO_SDARS = 3;
        public static final int SOURCESWITCH_CD_CHANGER = 4;
        public static final int SOURCESWITCH_AUX_IN_FRONT = 5;
        public static final int SOURCESWITCH_AUX_IN_EXTRA = 6;
        public static final int SOURCESWITCH_SD1 = 7;
        public static final int SOURCESWITCH_DVD_CHANGER = 8;
        public static final int SOURCESWITCH_BLUETOOTH = 9;
        public static final int SOURCESWITCH_RADIO_DRM = 10;
        public static final int SOURCESWITCH_WLAN = 11;
        public static final int SOURCESWITCH_WIMAX = 12;
        public static final int SOURCESWITCH_JUKEBOX = 15;
        public static final int SOURCESWITCH_INTERNAL_OPTICAL_DRIVE = 16;
        public static final int SOURCESWITCH_TV = 17;
        public static final int SOURCESWITCH_USB = 18;
        public static final int SOURCESWITCH_MEDIA_AV_IN = 19;
        public static final int SOURCESWITCH_TP_MEMO = 20;
        public static final int SOURCESWITCH_SD2 = 21;
        public static final int SOURCESWITCH_USB2 = 22;
        public static final int SOURCESWITCH_USB3 = 23;
        public static final int SOURCESWITCH_USB4 = 24;
        public static final int NAVIGATION_ANNOUNCEMENT_OFF = 0;
        public static final int NAVIGATION_ANNOUNCEMENT_TRAFFIC = 1;
        public static final int NAVIGATION_ANNOUNCEMENT_COMPACT = 2;
        public static final int NAVIGATION_ANNOUNCEMENT_COMPLETE = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

