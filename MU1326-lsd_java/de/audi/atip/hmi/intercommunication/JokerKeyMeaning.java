/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

public class JokerKeyMeaning {
    public static final int NOT_ASSIGNED;
    public static final int AUXILIARY_HEATING_ON_OFF;
    public static final int CHANGE_DRIVE_SELECT_MODE;
    public static final int NAV_ANNOUNCEMENT_ON_OFF;
    public static final int NAV_MAP_COLOR_DAY_NIGHT;
    public static final int NAV_MAP_ADDITIONAL_INFO;
    public static final int NAVIGATE_TO_HOME;
    public static final int TRAFFIC_ANNOUNCEMENT_ON_OFF;
    public static final int SWITCH_TUNER_MEDIA;
    public static final int SKIP_FORWARD;
    public static final int TMC_MESSAGES_SHOW_HIDE;
    public static final int POI_CALL;
    public static final int REPEAT_DRIVING_INSTRUCTION;
    public static final int CHANGE_SOURCE;
    public static final int SKIP_BACKWARD;
    public static final int CLUSTER_SCREENSAVER_ON_OFF;
    public static final int CLUSTER_TRAFFIC_SIGNS_ON_OFF;
    public static final int CLUSTER_SWITCH_TO_PHONEBOOK;
    public static final int CLUSTER_SWITCH_TO_LASTDEST;
    public static final int CLUSTER_SWITCH_TO_TRAFFICSIGN_INFO;
    public static final int CLUSTER_SWITCH_TO_DIGITAL_SPEED;
    public static final int HORN;
    public static final int CANCEL_TP;
    public static final int PUSH_TO_TALK;
    public static final int DISPLAY_PARK_ASSISTENT;
    public static final int SPORTCHRONO_TOGGLE;
    public static final int SPORTCHRONO_NEW_LAP;
    public static final int CHARISMA_SPORT_EXHAUST;
    public static final int CHARISMA_ESOUND;
    public static final int CHARISMA_START_STOP_OFF;

    public static boolean isClusterFunction(int n) {
        return n == 15 || n == 16 || n == 17 || n == 18 || n == 19 || n == 20;
    }
}

