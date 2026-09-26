/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

public interface TTSService {
    public static final String TTS_CLIENT_ID;
    public static final int ID_TOUCHPAD;
    public static final int ID_TOUCHPAD_VOLUME_MENU;
    public static final int ID_TMC_LIST;
    public static final int ID_TMC_DETAIL_VIEW;
    public static final int ID_TMC_ONROAD_ONROUTE_URGENT;
    public static final int ID_SDS;
    public static final int ID_ADB;
    public static final int ID_REMOTE_HMI;
    public static final int ID_MESSAGING;
    public static final int ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL;
    public static final int ID_DSRC_WARNING;
    public static final int ID_DSRC_INFO;
    public static final int ID_DSRC_MESSAGE;
    public static final int ID_ETC_WARNING;
    public static final int ID_ETC_INFO;
    public static final int ID_WIRELESS_CHARGING;
    public static final int ID_WIRELESS_CHARGING_VOLUME_MENU;
    public static final int ID_ETC_VOLUME_MENU;
    public static final int TTS_SERVICES_COUNT;
    public static final Integer CLIENT_ID_TOUCHPAD;
    public static final Integer CLIENT_ID_TOUCHPAD_VOLUME_MENU;
    public static final Integer CLIENT_ID_TMC_LIST;
    public static final Integer CLIENT_ID_TMC_DETAIL_VIEW;
    public static final Integer CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT;
    public static final Integer CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL;
    public static final Integer CLIENT_ID_SDS;
    public static final Integer CLIENT_ID_ADB;
    public static final Integer CLIENT_ID_REMOTE_HMI;
    public static final Integer CLIENT_ID_MESSAGING;
    public static final Integer CLIENT_ID_DSRC_WARNING;
    public static final Integer CLIENT_ID_DSRC_INFO;
    public static final Integer CLIENT_ID_DSRC_MESSAGE;
    public static final Integer CLIENT_ID_ETC_WARNING;
    public static final Integer CLIENT_ID_ETC_INFORMATION;
    public static final Integer CLIENT_ID_ETC_VOLUME_MENU;
    public static final Integer CLIENT_ID_WIRELESS_CHARGING;
    public static final Integer CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU;

    default public void speak(String string) {
    }

    default public void abortSpeaking() {
    }

    static {
        CLIENT_ID_TOUCHPAD = new Integer(0);
        CLIENT_ID_TOUCHPAD_VOLUME_MENU = new Integer(1);
        CLIENT_ID_TMC_LIST = new Integer(2);
        CLIENT_ID_TMC_DETAIL_VIEW = new Integer(3);
        CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT = new Integer(4);
        CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL = new Integer(9);
        CLIENT_ID_SDS = new Integer(5);
        CLIENT_ID_ADB = new Integer(6);
        CLIENT_ID_REMOTE_HMI = new Integer(7);
        CLIENT_ID_MESSAGING = new Integer(8);
        CLIENT_ID_DSRC_WARNING = new Integer(10);
        CLIENT_ID_DSRC_INFO = new Integer(11);
        CLIENT_ID_DSRC_MESSAGE = new Integer(12);
        CLIENT_ID_ETC_WARNING = new Integer(13);
        CLIENT_ID_ETC_INFORMATION = new Integer(14);
        CLIENT_ID_ETC_VOLUME_MENU = new Integer(17);
        CLIENT_ID_WIRELESS_CHARGING = new Integer(15);
        CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU = new Integer(16);
    }
}

