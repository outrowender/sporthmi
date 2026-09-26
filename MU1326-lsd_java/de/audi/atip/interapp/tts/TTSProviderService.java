/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;

public interface TTSProviderService {
    public static final int CLIENT_ID_TOUCHPAD;
    public static final int CLIENT_ID_TOUCHPAD_VOLUME_MENU;
    public static final int CLIENT_ID_TMC_LIST;
    public static final int CLIENT_ID_TMC_DETAIL_VIEW;
    public static final int CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT;
    public static final int CLIENT_ID_SDS;
    public static final int CLIENT_ID_ADB;
    public static final int CLIENT_ID_REMOTE_HMI;
    public static final int CLIENT_ID_MESSAGING;

    default public TTSSessionBasedService getTTSSessionBasedService(int n) {
    }

    default public TTSSingleSpeakService getTTSSingleSpeakService(int n) {
    }

    default public TTSSDSService getTTSSDSService(int n) {
    }
}

