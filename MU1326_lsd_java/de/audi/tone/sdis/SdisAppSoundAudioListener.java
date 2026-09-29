/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.sdis;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.log.LogChannel;
import de.audi.tone.sdis.ASIHMISyncSoundImpl;
import de.esolutions.fw.comm.core.method.MethodException;

public class SdisAppSoundAudioListener
extends DefaultHMIAudioServiceListener
implements IAudioSdisListener {
    private LogChannel lc;
    private ASIHMISyncSoundImpl asiSound;

    public SdisAppSoundAudioListener(ASIHMISyncSoundImpl aSIHMISyncSoundImpl, LogChannel logChannel) {
        this.lc = logChannel;
        this.asiSound = aSIHMISyncSoundImpl;
    }

    @Override
    public void updateActiveConnection(int n, int n2) {
        this.lc.log(-2137614336, "[SdisAppSoundListener.updateActiveConnection] AC%1", (long)n);
        this.asiSound.updateActiveConnection(n, n2);
        try {
            if (n == 3 || n == 8 || n == 9 || AudioConnection.contains(AudioConnection.GREY_OUT_ALL, n) || AudioConnection.contains(AudioConnection.VOLUME_MENU_CONNECTIONS, n)) {
                this.asiSound.updateSoundState(128);
            } else {
                this.asiSound.updateSoundState(0);
            }
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateActiveConnection] error on updating sound state:");
        }
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.lc.log(-2137614336, "[SdisAppSoundListener.updateActiveEntertainmentConnection] AC%1", (long)n);
        this.asiSound.updateActiveEntertainmentConnection(n, n2);
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.lc.log(-2137614336, "[SdisAppSoundListener.updateAMAvailable] %1", bl);
        if (bl) {
            try {
                this.asiSound.updateSoundState(0);
            }
            catch (MethodException methodException) {
                this.lc.log(10000, "[SdisAppSoundListener.updateAMAvailable] error on updating sound state: %1", 0L);
            }
        } else {
            try {
                this.asiSound.updateSoundState(1);
            }
            catch (MethodException methodException) {
                this.lc.log(10000, "[SdisAppSoundListener.updateAMAvailable] error on updating sound state: %1", 1L);
            }
        }
    }
}

