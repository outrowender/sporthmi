/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public interface HMIAudioService {
    public static final String AUDIO_CLIENT_ID = "AUDIO_CLIENT_ID";
    public static final Integer CLIENT_RADIO = new Integer(0);
    public static final Integer CLIENT_MEDIA = new Integer(1);
    public static final Integer CLIENT_POWER = new Integer(2);
    public static final Integer CLIENT_TONE = new Integer(6);
    public static final Integer CLIENT_PHONE = new Integer(5);
    public static final Integer CLIENT_PHONE_RINGTONE = new Integer(24);
    public static final Integer CLIENT_NAVI = new Integer(14);
    public static final Integer CLIENT_SDS = new Integer(15);
    public static final Integer CLIENT_BT = new Integer(16);
    public static final Integer CLIENT_CAR = new Integer(7);
    public static final Integer CLIENT_SWDL = new Integer(4);
    public static final Integer CLIENT_TIM = new Integer(3);
    public static final Integer CLIENT_INFO = new Integer(8);
    public static final Integer CLIENT_TTS_TOUCHPAD = new Integer(17);
    public static final Integer CLIENT_TTS_TOUCHPAD_VOLUMEMENU = new Integer(18);
    public static final Integer CLIENT_TTS_ADB = new Integer(19);
    public static final Integer CLIENT_TTS_CAR = new Integer(13);
    public static final Integer CLIENT_TTS_DV = new Integer(10);
    public static final Integer CLIENT_TTS_MESSAGING = new Integer(20);
    public static final Integer CLIENT_TTS_OL = new Integer(9);
    public static final Integer CLIENT_TTS_REMOTE_HMI = new Integer(21);
    public static final Integer CLIENT_TTS_TIM = new Integer(11);
    public static final Integer CLIENT_TTS_URR = new Integer(12);
    public static final Integer TTS_DSRC_LOW = new Integer(22);
    public static final Integer TTS_DSRC_HIGH = new Integer(23);
    public static final Integer CLIENT_TV = new Integer(25);
    public static final Integer CLIENT_SDIS = new Integer(27);
    public static final Integer CLIENT_STARTUP = new Integer(26);
    public static final Integer CLIENT_ECALL = new Integer(28);
    public static final Integer CLIENT_TTS_WIRELESS_CHARGING = new Integer(29);
    public static final Integer CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU = new Integer(30);
    public static final Integer CLIENT_TTS_ETC_VOLUMEMENU = new Integer(31);
    public static final Integer CLIENT_EXLAP = new Integer(32);
    public static final int CONN_FADEDIN = 0;
    public static final int CONN_FADEIN_REQUESTED = 1;
    public static final int CONN_STARTED = 2;
    public static final int CONN_START_REQUESTED = 3;
    public static final int CONN_PAUSED = 4;
    public static final int CONN_STOPPED = 5;
    public static final int CONN_STOP_REQUESTED = 6;

    public void requestConnection(int var1);

    public void requestConnection(int var1, int var2);

    public void requestConnection(int var1, int var2, int var3);

    public void requestAndFadeToConnection(int var1);

    public void requestAndFadeToConnection(int var1, int var2);

    public void releaseConnection(int var1);

    public void releaseConnection(int var1, int var2);

    public void releaseA2LSConnection();

    public void fadeToConnection(int var1);

    public void fadeToConnection(int var1, int var2);

    public int getActiveConnection(int var1);

    public int getActiveEntertainmentConnection(int var1);

    public int getStatus(int var1);

    public int getStatus(int var1, int var2);

    public boolean isActive(int var1);

    public boolean isActive(int var1, int var2);

    public void setVolumelock(int var1, int var2, boolean var3, Object var4);
}

