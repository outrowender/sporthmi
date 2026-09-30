/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

public class JokerKeyMeaning {
    public static final int NOT_ASSIGNED = 0;
    public static final int AUXILIARY_HEATING_ON_OFF = 1;
    public static final int CHANGE_DRIVE_SELECT_MODE = 2;
    public static final int NAV_ANNOUNCEMENT_ON_OFF = 3;
    public static final int NAV_MAP_COLOR_DAY_NIGHT = 4;
    public static final int NAV_MAP_ADDITIONAL_INFO = 5;
    public static final int NAVIGATE_TO_HOME = 6;
    public static final int TRAFFIC_ANNOUNCEMENT_ON_OFF = 7;
    public static final int SWITCH_TUNER_MEDIA = 8;
    public static final int SKIP_FORWARD = 9;
    public static final int TMC_MESSAGES_SHOW_HIDE = 10;
    public static final int POI_CALL = 11;
    public static final int REPEAT_DRIVING_INSTRUCTION = 12;
    public static final int CHANGE_SOURCE = 13;
    public static final int SKIP_BACKWARD = 14;
    public static final int CLUSTER_SCREENSAVER_ON_OFF = 15;
    public static final int CLUSTER_TRAFFIC_SIGNS_ON_OFF = 16;
    public static final int CLUSTER_SWITCH_TO_PHONEBOOK = 17;
    public static final int CLUSTER_SWITCH_TO_LASTDEST = 18;
    public static final int CLUSTER_SWITCH_TO_TRAFFICSIGN_INFO = 19;
    public static final int CLUSTER_SWITCH_TO_DIGITAL_SPEED = 20;
    public static final int HORN = 30;
    public static final int CANCEL_TP = 40;
    public static final int PUSH_TO_TALK = 50;
    public static final int DISPLAY_PARK_ASSISTENT = 60;
    public static final int SPORTCHRONO_TOGGLE = 70;
    public static final int SPORTCHRONO_NEW_LAP = 71;
    public static final int CHARISMA_SPORT_EXHAUST = 80;
    public static final int CHARISMA_ESOUND = 81;
    public static final int CHARISMA_START_STOP_OFF = 82;

    public static boolean isClusterFunction(int n) {
        return n == 15 || n == 16 || n == 17 || n == 18 || n == 19 || n == 20;
    }
}

