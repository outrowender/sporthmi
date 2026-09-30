/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tts;

import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;

public interface TTSProviderService {
    public static final int CLIENT_ID_TOUCHPAD = 0;
    public static final int CLIENT_ID_TOUCHPAD_VOLUME_MENU = 1;
    public static final int CLIENT_ID_TMC_LIST = 2;
    public static final int CLIENT_ID_TMC_DETAIL_VIEW = 3;
    public static final int CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT = 4;
    public static final int CLIENT_ID_SDS = 5;
    public static final int CLIENT_ID_ADB = 6;
    public static final int CLIENT_ID_REMOTE_HMI = 7;
    public static final int CLIENT_ID_MESSAGING = 8;

    public TTSSessionBasedService getTTSSessionBasedService(int var1);

    public TTSSingleSpeakService getTTSSingleSpeakService(int var1);

    public TTSSDSService getTTSSDSService(int var1);
}

