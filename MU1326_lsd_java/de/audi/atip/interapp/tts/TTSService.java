/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

public interface TTSService {
    public static final String TTS_CLIENT_ID = "TTS_CLIENT_ID";
    public static final int ID_TOUCHPAD = 0;
    public static final int ID_TOUCHPAD_VOLUME_MENU = 1;
    public static final int ID_TMC_LIST = 2;
    public static final int ID_TMC_DETAIL_VIEW = 3;
    public static final int ID_TMC_ONROAD_ONROUTE_URGENT = 4;
    public static final int ID_SDS = 5;
    public static final int ID_ADB = 6;
    public static final int ID_REMOTE_HMI = 7;
    public static final int ID_MESSAGING = 8;
    public static final int ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL = 9;
    public static final int ID_DSRC_WARNING = 10;
    public static final int ID_DSRC_INFO = 11;
    public static final int ID_DSRC_MESSAGE = 12;
    public static final int ID_ETC_WARNING = 13;
    public static final int ID_ETC_INFO = 14;
    public static final int ID_WIRELESS_CHARGING = 15;
    public static final int ID_WIRELESS_CHARGING_VOLUME_MENU = 16;
    public static final int ID_ETC_VOLUME_MENU = 17;
    public static final int TTS_SERVICES_COUNT = 18;
    public static final Integer CLIENT_ID_TOUCHPAD = new Integer(0);
    public static final Integer CLIENT_ID_TOUCHPAD_VOLUME_MENU = new Integer(1);
    public static final Integer CLIENT_ID_TMC_LIST = new Integer(2);
    public static final Integer CLIENT_ID_TMC_DETAIL_VIEW = new Integer(3);
    public static final Integer CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT = new Integer(4);
    public static final Integer CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL = new Integer(9);
    public static final Integer CLIENT_ID_SDS = new Integer(5);
    public static final Integer CLIENT_ID_ADB = new Integer(6);
    public static final Integer CLIENT_ID_REMOTE_HMI = new Integer(7);
    public static final Integer CLIENT_ID_MESSAGING = new Integer(8);
    public static final Integer CLIENT_ID_DSRC_WARNING = new Integer(10);
    public static final Integer CLIENT_ID_DSRC_INFO = new Integer(11);
    public static final Integer CLIENT_ID_DSRC_MESSAGE = new Integer(12);
    public static final Integer CLIENT_ID_ETC_WARNING = new Integer(13);
    public static final Integer CLIENT_ID_ETC_INFORMATION = new Integer(14);
    public static final Integer CLIENT_ID_ETC_VOLUME_MENU = new Integer(17);
    public static final Integer CLIENT_ID_WIRELESS_CHARGING = new Integer(15);
    public static final Integer CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU = new Integer(16);

    public void speak(String var1);

    public void abortSpeaking();
}

