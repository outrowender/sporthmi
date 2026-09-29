/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface HMIApplication {
    public static final int VIRTUAL_BUTTON_INVALID;
    public static final int VIRTUAL_BUTTON_HK_PREV;
    public static final int VIRTUAL_BUTTON_HK_NEXT;
    public static final int VIRTUAL_BUTTON_ON_OFF;
    public static final int VIRTUAL_BUTTON_MFL_VOLUME;
    public static final int VIRTUAL_BUTTON_STATION_1;
    public static final int VIRTUAL_BUTTON_STATION_2;
    public static final int VIRTUAL_BUTTON_STATION_3;
    public static final int VIRTUAL_BUTTON_STATION_4;
    public static final int VIRTUAL_BUTTON_STATION_5;
    public static final int VIRTUAL_BUTTON_STATION_6;
    public static final int VIRTUAL_BUTTON_ECALL_1;
    public static final int VIRTUAL_BUTTON_ECALL_2;
    public static final int VIRTUAL_BUTTON_HK_INFO;
    public static final int VIRTUAL_BUTTON_JOKER1;
    public static final int VIRTUAL_BUTTON_HOOK;
    public static final int VIRTUAL_BUTTON_BREAK_DOWN;
    public static final int VIRTUAL_BUTTON_3TMR;
    public static final int VIRTUAL_BUTTON_3TMC;
    public static final int VIRTUAL_BUTTON_3TML;
    public static final int VIRTUAL_BUTTON_TUNER_HK;
    public static final int VIRTUAL_BUTTON_MEDIA_HK;
    public static final int VIRTUAL_BUTTON_MAIL_HK;
    public static final int VIRTUAL_BUTTON_PHONE_HK;
    public static final int VIRTUAL_BUTTON_NAVI_HK;
    public static final int VIRTUAL_BUTTON_TRAFFIC_HK;
    public static final int VIRTUAL_BUTTON_CAR_HK;
    public static final int VIRTUAL_BUTTON_TONE_HK;
    public static final int VIRTUAL_BUTTON_MODE_HK;
    public static final int VIRTUAL_BUTTON_COMBO_REM;
    public static final int VIRTUAL_BUTTON_COMBO_GEM;
    public static final int VIRTUAL_BUTTON_COMBO_HMI_EM;
    public static final int VIRTUAL_BUTTON_DRIVE_SELECTC_HK;
    public static final int VIRTUAL_BUTTON_AC_HK;
    public static final int VIRTUAL_BUTTON_MENU_HK;
    public static final int VIRTUAL_BUTTON_PTT;
    public static final int VIRTUAL_BUTTON_PTT_LONG_PRESSED;
    public static final int VIRTUAL_BUTTON_PTT_DOUBLE_PRESSED;
    public static final int VIRTUAL_BUTTON_STATION_7;
    public static final int VIRTUAL_BUTTON_STATION_8;
    public static final int VIRTUAL_BUTTON_JOKER1_LONGPRESSED;
    public static final int VIRTUAL_BUTTON_MAP_HK;
    public static final int VIRTUAL_BUTTON_OPTION_HK;
    public static final int VIRTUAL_BUTTON_SOURCE_HK;
    public static final int VIRTUAL_BUTTON_TP;
    public static final int VIRTUAL_BUTTON_HANGUP;
    public static final int VIRTUAL_BUTTON_SEAT_HK;
    public static final int VIRTUAL_BUTTON_HYBRID_HK;
    public static final int VIRTUAL_BUTTON_OFFROAD_HK;
    public static final int VIRTUAL_BUTTON_INFO_SCREEN_HK;
    public static final int VIRTUAL_BUTTON_ASSIST_HK;
    public static final int VIRTUAL_BUTTON_VOLUME_DOWN_HK;
    public static final int VIRTUAL_BUTTON_VOLUME_UP_HK;
    public static final int VIRTUAL_BUTTON_BENTLEY_PREV_HK;
    public static final int VIRTUAL_BUTTON_BENTLEY_NEXT_HK;
    public static final int VIRTUAL_BUTTON_JOKER2;
    public static final int VIRTUAL_BUTTON_MAX;
    public static final String PROP_KEY_APP_NAME;
    public static final String PROP_KEY_MODULE_ID;

    default public int getId() {
    }

    default public ButtonModelApp getVirtualButton(int n) {
    }

    default public void popupVisible(int n, int n2) {
    }

    default public void popupHidden(int n, int n2) {
    }

    default public void popupRemoved(int n, int n2) {
    }

    default public void screenVisible(int n, int n2) {
    }

    default public void screenHidden(int n, int n2) {
    }

    default public void screenFadedOut(int n, int n2) {
    }

    default public void screenConnected(int n, int n2) {
    }
}

