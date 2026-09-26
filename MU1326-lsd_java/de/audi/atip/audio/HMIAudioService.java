/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public interface HMIAudioService {
    public static final String AUDIO_CLIENT_ID;
    public static final Integer CLIENT_RADIO;
    public static final Integer CLIENT_MEDIA;
    public static final Integer CLIENT_POWER;
    public static final Integer CLIENT_TONE;
    public static final Integer CLIENT_PHONE;
    public static final Integer CLIENT_PHONE_RINGTONE;
    public static final Integer CLIENT_NAVI;
    public static final Integer CLIENT_SDS;
    public static final Integer CLIENT_BT;
    public static final Integer CLIENT_CAR;
    public static final Integer CLIENT_SWDL;
    public static final Integer CLIENT_TIM;
    public static final Integer CLIENT_INFO;
    public static final Integer CLIENT_TTS_TOUCHPAD;
    public static final Integer CLIENT_TTS_TOUCHPAD_VOLUMEMENU;
    public static final Integer CLIENT_TTS_ADB;
    public static final Integer CLIENT_TTS_CAR;
    public static final Integer CLIENT_TTS_DV;
    public static final Integer CLIENT_TTS_MESSAGING;
    public static final Integer CLIENT_TTS_OL;
    public static final Integer CLIENT_TTS_REMOTE_HMI;
    public static final Integer CLIENT_TTS_TIM;
    public static final Integer CLIENT_TTS_URR;
    public static final Integer TTS_DSRC_LOW;
    public static final Integer TTS_DSRC_HIGH;
    public static final Integer CLIENT_TV;
    public static final Integer CLIENT_SDIS;
    public static final Integer CLIENT_STARTUP;
    public static final Integer CLIENT_ECALL;
    public static final Integer CLIENT_TTS_WIRELESS_CHARGING;
    public static final Integer CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU;
    public static final Integer CLIENT_TTS_ETC_VOLUMEMENU;
    public static final Integer CLIENT_EXLAP;
    public static final int CONN_FADEDIN;
    public static final int CONN_FADEIN_REQUESTED;
    public static final int CONN_STARTED;
    public static final int CONN_START_REQUESTED;
    public static final int CONN_PAUSED;
    public static final int CONN_STOPPED;
    public static final int CONN_STOP_REQUESTED;

    default public void requestConnection(int n) {
    }

    default public void requestConnection(int n, int n2) {
    }

    default public void requestConnection(int n, int n2, int n3) {
    }

    default public void requestAndFadeToConnection(int n) {
    }

    default public void requestAndFadeToConnection(int n, int n2) {
    }

    default public void releaseConnection(int n) {
    }

    default public void releaseConnection(int n, int n2) {
    }

    default public void releaseA2LSConnection() {
    }

    default public void fadeToConnection(int n) {
    }

    default public void fadeToConnection(int n, int n2) {
    }

    default public int getActiveConnection(int n) {
    }

    default public int getActiveEntertainmentConnection(int n) {
    }

    default public int getStatus(int n) {
    }

    default public int getStatus(int n, int n2) {
    }

    default public boolean isActive(int n) {
    }

    default public boolean isActive(int n, int n2) {
    }

    default public void setVolumelock(int n, int n2, boolean bl, Object object) {
    }

    static {
        CLIENT_RADIO = new Integer(0);
        CLIENT_MEDIA = new Integer(1);
        CLIENT_POWER = new Integer(2);
        CLIENT_TONE = new Integer(6);
        CLIENT_PHONE = new Integer(5);
        CLIENT_PHONE_RINGTONE = new Integer(24);
        CLIENT_NAVI = new Integer(14);
        CLIENT_SDS = new Integer(15);
        CLIENT_BT = new Integer(16);
        CLIENT_CAR = new Integer(7);
        CLIENT_SWDL = new Integer(4);
        CLIENT_TIM = new Integer(3);
        CLIENT_INFO = new Integer(8);
        CLIENT_TTS_TOUCHPAD = new Integer(17);
        CLIENT_TTS_TOUCHPAD_VOLUMEMENU = new Integer(18);
        CLIENT_TTS_ADB = new Integer(19);
        CLIENT_TTS_CAR = new Integer(13);
        CLIENT_TTS_DV = new Integer(10);
        CLIENT_TTS_MESSAGING = new Integer(20);
        CLIENT_TTS_OL = new Integer(9);
        CLIENT_TTS_REMOTE_HMI = new Integer(21);
        CLIENT_TTS_TIM = new Integer(11);
        CLIENT_TTS_URR = new Integer(12);
        TTS_DSRC_LOW = new Integer(22);
        TTS_DSRC_HIGH = new Integer(23);
        CLIENT_TV = new Integer(25);
        CLIENT_SDIS = new Integer(27);
        CLIENT_STARTUP = new Integer(26);
        CLIENT_ECALL = new Integer(28);
        CLIENT_TTS_WIRELESS_CHARGING = new Integer(29);
        CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU = new Integer(30);
        CLIENT_TTS_ETC_VOLUMEMENU = new Integer(31);
        CLIENT_EXLAP = new Integer(32);
    }
}

