/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;

public interface HMIAudioManager {
    public static final int CLIENT_TUNER;
    public static final int CLIENT_MEDIA;
    public static final int CLIENT_POWER;
    public static final int CLIENT_TIM;
    public static final int CLIENT_SWDL;
    public static final int CLIENT_PHONE;
    public static final int CLIENT_TONE;
    public static final int CLIENT_CAR;
    public static final int CLIENT_INFO;
    public static final int CLIENT_TTS_OL;
    public static final int CLIENT_TTS_DV;
    public static final int CLIENT_TTS_TIM;
    public static final int CLIENT_TTS_URR;
    public static final int CLIENT_TTS_CAR;
    public static final int CLIENT_NAVI;
    public static final int CLIENT_SDS;
    public static final int CLIENT_BT;
    public static final int CLIENT_TOUCHPAD;
    public static final int CLIENT_TOUCHPAD_VOLUME_MENU;
    public static final int CLIENT_TTS_ADB;
    public static final int CLIENT_TTS_MESSAGING;
    public static final int CLIENT_TTS_REMOTE_HMI;

    default public HMIAudioService getAudioService(int n) {
    }

    default public void registerListener(HMIAudioServiceListener hMIAudioServiceListener, int n) {
    }
}

