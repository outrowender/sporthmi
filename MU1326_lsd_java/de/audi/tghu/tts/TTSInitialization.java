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
    public void init();

    public void setAudioService(HMIAudioService var1);

    public HMIAudioServiceListener getAudioListener();

    public void setTTSDSI(DSITTS var1);

    public DSITTSListener getDSITTSListener();

    public VolumeOnOffPressListener getVolumeOnOffPressListener();
}

