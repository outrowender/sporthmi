/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface HMIApplication {
    public static final int VIRTUAL_BUTTON_INVALID = -1;
    public static final int VIRTUAL_BUTTON_HK_PREV = 0;
    public static final int VIRTUAL_BUTTON_HK_NEXT = 1;
    public static final int VIRTUAL_BUTTON_ON_OFF = 2;
    public static final int VIRTUAL_BUTTON_MFL_VOLUME = 3;
    public static final int VIRTUAL_BUTTON_STATION_1 = 4;
    public static final int VIRTUAL_BUTTON_STATION_2 = 5;
    public static final int VIRTUAL_BUTTON_STATION_3 = 6;
    public static final int VIRTUAL_BUTTON_STATION_4 = 7;
    public static final int VIRTUAL_BUTTON_STATION_5 = 8;
    public static final int VIRTUAL_BUTTON_STATION_6 = 9;
    public static final int VIRTUAL_BUTTON_ECALL_1 = 10;
    public static final int VIRTUAL_BUTTON_ECALL_2 = 11;
    public static final int VIRTUAL_BUTTON_HK_INFO = 12;
    public static final int VIRTUAL_BUTTON_JOKER1 = 13;
    public static final int VIRTUAL_BUTTON_HOOK = 14;
    public static final int VIRTUAL_BUTTON_BREAK_DOWN = 15;
    public static final int VIRTUAL_BUTTON_3TMR = 16;
    public static final int VIRTUAL_BUTTON_3TMC = 17;
    public static final int VIRTUAL_BUTTON_3TML = 18;
    public static final int VIRTUAL_BUTTON_TUNER_HK = 19;
    public static final int VIRTUAL_BUTTON_MEDIA_HK = 20;
    public static final int VIRTUAL_BUTTON_MAIL_HK = 21;
    public static final int VIRTUAL_BUTTON_PHONE_HK = 22;
    public static final int VIRTUAL_BUTTON_NAVI_HK = 23;
    public static final int VIRTUAL_BUTTON_TRAFFIC_HK = 24;
    public static final int VIRTUAL_BUTTON_CAR_HK = 25;
    public static final int VIRTUAL_BUTTON_TONE_HK = 26;
    public static final int VIRTUAL_BUTTON_MODE_HK = 27;
    public static final int VIRTUAL_BUTTON_COMBO_REM = 28;
    public static final int VIRTUAL_BUTTON_COMBO_GEM = 29;
    public static final int VIRTUAL_BUTTON_COMBO_HMI_EM = 30;
    public static final int VIRTUAL_BUTTON_DRIVE_SELECTC_HK = 31;
    public static final int VIRTUAL_BUTTON_AC_HK = 32;
    public static final int VIRTUAL_BUTTON_MENU_HK = 33;
    public static final int VIRTUAL_BUTTON_PTT = 34;
    public static final int VIRTUAL_BUTTON_PTT_LONG_PRESSED = 35;
    public static final int VIRTUAL_BUTTON_PTT_DOUBLE_PRESSED = 36;
    public static final int VIRTUAL_BUTTON_STATION_7 = 37;
    public static final int VIRTUAL_BUTTON_STATION_8 = 38;
    public static final int VIRTUAL_BUTTON_JOKER1_LONGPRESSED = 39;
    public static final int VIRTUAL_BUTTON_MAP_HK = 40;
    public static final int VIRTUAL_BUTTON_OPTION_HK = 41;
    public static final int VIRTUAL_BUTTON_SOURCE_HK = 42;
    public static final int VIRTUAL_BUTTON_TP = 43;
    public static final int VIRTUAL_BUTTON_HANGUP = 44;
    public static final int VIRTUAL_BUTTON_SEAT_HK = 45;
    public static final int VIRTUAL_BUTTON_HYBRID_HK = 46;
    public static final int VIRTUAL_BUTTON_OFFROAD_HK = 47;
    public static final int VIRTUAL_BUTTON_INFO_SCREEN_HK = 48;
    public static final int VIRTUAL_BUTTON_ASSIST_HK = 49;
    public static final int VIRTUAL_BUTTON_VOLUME_DOWN_HK = 50;
    public static final int VIRTUAL_BUTTON_VOLUME_UP_HK = 51;
    public static final int VIRTUAL_BUTTON_BENTLEY_PREV_HK = 52;
    public static final int VIRTUAL_BUTTON_BENTLEY_NEXT_HK = 53;
    public static final int VIRTUAL_BUTTON_JOKER2 = 54;
    public static final int VIRTUAL_BUTTON_MAX = 55;
    public static final String PROP_KEY_APP_NAME = "ApplicationName";
    public static final String PROP_KEY_MODULE_ID = "moduleID";

    public int getId();

    public ButtonModelApp getVirtualButton(int var1);

    public void popupVisible(int var1, int var2);

    public void popupHidden(int var1, int var2);

    public void popupRemoved(int var1, int var2);

    public void screenVisible(int var1, int var2);

    public void screenHidden(int var1, int var2);

    public void screenFadedOut(int var1, int var2);

    public void screenConnected(int var1, int var2);
}

