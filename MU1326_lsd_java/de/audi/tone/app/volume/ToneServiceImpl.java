/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.AbstractPhoneVolumeRange;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.PhoneMicGainVolumeRange;
import de.audi.tone.app.volume.RingtoneSelectionVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;

public class ToneServiceImpl
implements ToneService {
    private final LogChannel lc;
    private final IDSISoundHandler dsiSound;
    private final VolumeRangeManager volMenuManager;

    ToneServiceImpl(VolumeRangeManager volumeRangeManager) {
        this.lc = volumeRangeManager.env.lcMain;
        this.dsiSound = volumeRangeManager.dsiSound;
        this.volMenuManager = volumeRangeManager;
    }

    @Override
    public void updateMicGainLevel(int n) {
    }

    @Override
    public void updateMicGainRange(int n, int n2) {
    }

    @Override
    public void updatePhoneAudioScenario(int n) {
        AbstractVolumeRange abstractVolumeRange;
        AbstractVolumeRange abstractVolumeRange2;
        this.lc.log(-2137614336, "[ToneServiceImpl.updatePhoneAudioScenario] scenario:%1", (long)n);
        AbstractVolumeRange abstractVolumeRange3 = this.volMenuManager.getMenuByID(3);
        if (abstractVolumeRange3 instanceof AbstractPhoneVolumeRange) {
            abstractVolumeRange2 = (AbstractPhoneVolumeRange)abstractVolumeRange3;
            abstractVolumeRange2.setPhoneAudioScenario(n);
        }
        if ((abstractVolumeRange2 = this.volMenuManager.getMenuByID(9)) instanceof RingtoneSelectionVolumeRange) {
            abstractVolumeRange = (RingtoneSelectionVolumeRange)abstractVolumeRange2;
            abstractVolumeRange.setPhoneAudioScenario(n);
        }
        if ((abstractVolumeRange = this.volMenuManager.getMenuByID(10)) instanceof PhoneMicGainVolumeRange) {
            PhoneMicGainVolumeRange phoneMicGainVolumeRange = (PhoneMicGainVolumeRange)abstractVolumeRange;
            phoneMicGainVolumeRange.setPhoneAudioScenario(n);
        }
    }

    @Override
    public void updateBTLinkKeyAvailable(int n, boolean bl) {
        this.lc.log(-2137614336, "[ToneServiceImpl.updateBTLinkKeyAvailable] available:%1 HT:%2", (Object)String.valueOf(bl), (long)n);
    }

    @Override
    public void setMicGainLevel(int n) {
        this.dsiSound.setMicGainLevel(n);
    }

    @Override
    public void setThreeDMode(int n) {
        this.lc.log(-2137614336, "[ToneServiceImpl.setThreeDMode] media online connection: %1,  mode: %2", (long)0, (long)n);
        this.dsiSound.setThreeDMode(45, 0, n);
    }

    @Override
    public void setSurround(boolean bl) {
        this.lc.log(-2137614336, "[ToneServiceImpl.setSurroundLevel] media online enable: %1,connection: %2", bl, (long)0);
        this.dsiSound.setSurround(45, 0, bl);
    }

    @Override
    public void setSurroundForActiveEntertainment(boolean bl) {
        this.lc.log(-2137614336, "[ToneServiceImpl.setSurroundOnOff] set surround for the AEC, enable: %1", bl);
        if (this.dsiSound.getAmplifierVariant().isAmplifierPorscheSurround()) {
            this.dsiSound.setSurround(0, bl);
        }
    }

    @Override
    public void setInputGainOffSet(short s) {
        this.lc.log(-2137614336, "[ToneServiceImpl.setInputGainOffSet] media online connection: %1,  value: %2", (long)0, (long)s);
        this.dsiSound.setInputGainOffSet(45, 0, s);
    }

    @Override
    public void setDuration(int n, int n2) {
        this.lc.log(-2137614336, "[ToneServiceImpl.setDuration] conncetion:%1 duration:%2", (long)n, (long)n2);
        this.dsiSound.setDuration(n, n2);
    }

    @Override
    public void updateUserDefinedRingtone(String string, String string2) {
        this.lc.log(-2137614336, "[ToneServiceImpl.updateUserDefinedRingtone] url:%1 filename:%2", (Object)string, (Object)string2);
        AbstractPhoneVolumeRange abstractPhoneVolumeRange = (AbstractPhoneVolumeRange)this.volMenuManager.getMenuByID(3);
        abstractPhoneVolumeRange.setUserDefinedRingtone(string, string2);
    }
}

