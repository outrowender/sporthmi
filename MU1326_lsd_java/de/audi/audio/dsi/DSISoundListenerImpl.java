/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.dsi;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.util.DefaultDSISoundListener;
import de.audi.audio.AudioEnv;
import de.audi.audio.AudioTools;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.volume.VolumeMap;

public class DSISoundListenerImpl
extends DefaultDSISoundListener {
    private final AudioEnv env;
    private final BaseAudioService audioService;
    private ISoundListener[] soundListeners = new ISoundListener[0];
    private final ChoiceModelApp mutePinActiveChoice;
    private static final int MUTE_PIN_INACTIVE;
    private static final int MUTE_PIN_ACTIVE;
    private final ChoiceModelApp eCallCodedChoice;

    public DSISoundListenerImpl(AudioEnv audioEnv, BaseAudioService baseAudioService, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2) {
        this.env = audioEnv;
        this.audioService = baseAudioService;
        this.mutePinActiveChoice = choiceModelApp;
        this.eCallCodedChoice = choiceModelApp2;
    }

    public void setListeners(ISoundListener[] iSoundListenerArray) {
        this.soundListeners = iSoundListenerArray;
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        if (n == 9) {
            this.env.lcVol.log(1078071040, "<- [DSISoundListenerImpl.updateVolume] vol:%1 Ignore update for ENT_SUPPRESION!", (long)s);
            return;
        }
        if (this.env.lcVol.isDebug()) {
            String string = AudioTools.toString(n, n2, s);
            this.env.lcVol.log(-2137614336, "<- [DSISoundListenerImpl.updateVolume] %1 (valid:%2)", (Object)string, (long)n3);
        }
        if (n3 != 1) {
            return;
        }
        if (this.isEntertainmentConnection(n)) {
            this.setVolume(AudioConnection.ENT_RADIO_CONNS, n2, s);
            this.setVolume(AudioConnection.ENT_MEDIA_CONNS, n2, s);
        } else {
            VolumeMap.INSTANCE.setVolume(n, n2, s);
        }
        try {
            for (int i2 = 0; i2 < this.soundListeners.length; ++i2) {
                this.soundListeners[i2].updateVolume(n, n2, s);
            }
        }
        catch (Exception exception) {
            String string = AudioTools.toString(n, n2, s);
            this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.updateVolume] %1 (valid:%2)", (Object)string, (long)n3);
            this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.updateVolume]", (Throwable)exception);
        }
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        this.env.lcVol.log(-2137614336, "<- [DSISoundListenerImpl.menuVolumeRange] min:%1 max:%2 connection:%3", (long)n3, (long)n4, (long)n);
        try {
            for (int i2 = 0; i2 < this.soundListeners.length; ++i2) {
                this.soundListeners[i2].menuVolumeRange(n, n2, n3, n4);
            }
        }
        catch (Exception exception) {
            this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.menuVolumeRange] min:%1 max:%2 connection:%3", (long)n3, (long)n4, (long)n);
            this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.menuVolumeRange]", (Throwable)exception);
        }
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
        this.env.lcVol.log(-2137614336, "<- [DSISoundListenerImpl.updateVolumeRange] min:%1 max:%2 valid:%3", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            try {
                for (int i2 = 0; i2 < this.soundListeners.length; ++i2) {
                    this.soundListeners[i2].updateVolumeRange(n, n2);
                }
            }
            catch (Exception exception) {
                this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.updateVolumeRange] min:%1 max:%2 valid:%3", (long)n, (long)n2, (long)n3);
                this.env.lcVol.log(10000, "<- [DSISoundListenerImpl.updateVolumeRange]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateMuteTheftProtection] active:%1 valid:%2", bl, (long)n);
        if (n != 1) {
            return;
        }
        if (bl) {
            this.audioService.requestConnection(6, 0);
        } else {
            this.audioService.releaseConnection(6, 0);
        }
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        if (this.eCallCodedChoice.getValue() == 1) {
            this.env.lcDSI.log(1078071040, "<- [DSISoundListenerImpl.updateMutePinState] eCall is coded, mutePin must be handled by eCall app - mutePinState:%1 valid:%2", bl, (long)n);
            return;
        }
        this.env.lcDSI.log(-2137614336, "<- [DSISoundListenerImpl.updateMutePinState] mutePinState:%1 valid:%2", bl, (long)n);
        if (n != 1) {
            return;
        }
        if (bl) {
            this.audioService.requestConnection(210, 0);
            this.mutePinActiveChoice.setValue(1);
        } else {
            this.audioService.releaseConnection(210, 0);
            this.mutePinActiveChoice.setValue(0);
        }
    }

    private void setVolume(int[] nArray, int n, short s) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            VolumeMap.INSTANCE.setVolume(nArray[i2], n, s);
        }
    }

    private boolean isEntertainmentConnection(int n) {
        return AudioConnection.contains(AudioConnection.ENT_RADIO_CONNS, n) || AudioConnection.contains(AudioConnection.ENT_MEDIA_CONNS, n);
    }
}

