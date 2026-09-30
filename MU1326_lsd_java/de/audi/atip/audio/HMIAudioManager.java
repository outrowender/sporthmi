/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;

public interface HMIAudioManager {
    public static final int CLIENT_TUNER = 0;
    public static final int CLIENT_MEDIA = 1;
    public static final int CLIENT_POWER = 2;
    public static final int CLIENT_TIM = 3;
    public static final int CLIENT_SWDL = 4;
    public static final int CLIENT_PHONE = 5;
    public static final int CLIENT_TONE = 6;
    public static final int CLIENT_CAR = 7;
    public static final int CLIENT_INFO = 8;
    public static final int CLIENT_TTS_OL = 9;
    public static final int CLIENT_TTS_DV = 10;
    public static final int CLIENT_TTS_TIM = 11;
    public static final int CLIENT_TTS_URR = 12;
    public static final int CLIENT_TTS_CAR = 13;
    public static final int CLIENT_NAVI = 14;
    public static final int CLIENT_SDS = 15;
    public static final int CLIENT_BT = 16;
    public static final int CLIENT_TOUCHPAD = 17;
    public static final int CLIENT_TOUCHPAD_VOLUME_MENU = 18;
    public static final int CLIENT_TTS_ADB = 19;
    public static final int CLIENT_TTS_MESSAGING = 20;
    public static final int CLIENT_TTS_REMOTE_HMI = 21;

    public HMIAudioService getAudioService(int var1);

    public void registerListener(HMIAudioServiceListener var1, int var2);
}

