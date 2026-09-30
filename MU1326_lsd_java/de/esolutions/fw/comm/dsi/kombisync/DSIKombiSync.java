/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync;

public interface DSIKombiSync {
    public static final String IPL_COMM_UUID = "10fe841e-7d8c-5802-8d40-e4219083c9e7";
    public static final String IPL_COMM_INTERFACE_KEY = "d02e08c1-ad26-5243-b8ad-ac9dfee27dca";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public static interface Consts {
        public static final String VERSION = "2.11.9";
        public static final int FOCUS_INIT = 0;
        public static final int FOCUS_KOMBI = 1;
        public static final int FOCUS_MMI = 2;
        public static final int FOCUS_MMI_ALL = 3;
        public static final int FOCUS_HMI_ALL_BLOCKED_BUT_VIEW = 4;
        public static final int FOCUS_KOMBI_ALL_QUIT = 5;
        public static final int FOCUS_KOMBI_ALL_QUIT_AND_EXECUTE = 6;
        public static final int SCREENFORMAT_INIT = 0;
        public static final int SCREENFORMAT_SMALL = 1;
        public static final int SCREENFORMAT_LARGE = 2;
        public static final int SCREENFORMAT_FULLSCREEN = 3;
        public static final int MENUSTATE_INIT = 0;
        public static final int MENUSTATE_TEMP_NOT_AVAILABLE = 1;
        public static final int MENUSTATE_AVAILABLE = 2;
        public static final int MENUSTATE_NOT_EXISTING = 3;
        public static final int MMIPOPUPSTATE_REMOVED = 0;
        public static final int MMIPOPUPSTATE_VISIBLE = 1;
        public static final int MMIPOPUPSTATE_HIDDEN = 2;
        public static final int MENUCONTEXT_LEFTSIDEMENU = 1;
        public static final int MENUCONTEXT_RIGHTSIDEMENU = 2;
        public static final int MENUCONTEXT_PARTIALPOPUP = 4;
        public static final int MENUCONTEXT_SECONDSTATUSLINE = 8;
        public static final int MESSAGESTATE_UNKNOWN = 0;
        public static final int MESSAGESTATE_OK = 1;
        public static final int MESSAGESTATE_TIMEOUT = 2;
        public static final int ANIMATIONSPEED_1_00 = 0;
        public static final int ANIMATIONSPEED_1_25 = 1;
        public static final int ANIMATIONSPEED_1_50 = 2;
        public static final int ANIMATIONSPEED_1_75 = 3;
        public static final int ANIMATIONSPEED_2_00 = 4;
        public static final int ANIMATIONSPEED_2_25 = 5;
        public static final int ANIMATIONSPEED_2_50 = 6;
        public static final int ANIMATIONSPEED_2_75 = 7;
        public static final int ANIMATIONSPEED_3_00 = 8;
        public static final int ANIMATIONSPEED_3_25 = 9;
        public static final int ANIMATIONSPEED_3_50 = 10;
        public static final int ANIMATIONSPEED_3_75 = 11;
        public static final int ANIMATIONSPEED_4_00 = 12;
        public static final int ANIMATIONSPEED_5_00 = 13;
        public static final int ANIMATIONSPEED_6_00 = 14;
        public static final int ANIMATIONSPEED_7_00 = 15;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

