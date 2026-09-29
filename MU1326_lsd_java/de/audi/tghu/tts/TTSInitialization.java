/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.audio.VolumeOnOffPressListener;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.DSITTSListener;

public interface TTSInitialization {
    default public void init() {
    }

    default public void setAudioService(HMIAudioService hMIAudioService) {
    }

    default public HMIAudioServiceListener getAudioListener() {
    }

    default public void setTTSDSI(DSITTS dSITTS) {
    }

    default public DSITTSListener getDSITTSListener() {
    }

    default public VolumeOnOffPressListener getVolumeOnOffPressListener() {
    }
}

