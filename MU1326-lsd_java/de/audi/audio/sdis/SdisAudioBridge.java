/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.sdis.IHMISyncAudioReplies;
import de.audi.atip.sdis.IHMISyncAudioRequests;
import de.audi.audio.AudioEnv;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.sdis.NullHMISyncAudioReplies;
import de.audi.audio.sdis.SdisAudioBridge$AudioListener;
import de.audi.audio.sdis.SdisAudioBridge$SoundListener;
import de.audi.audio.store.ConnectionStore;
import de.audi.audio.volume.VolumeMap;
import org.dsi.ifc.audio.DSISound;

public class SdisAudioBridge
implements IHMISyncAudioRequests {
    public final ISoundListener soundListener = new SdisAudioBridge$SoundListener(this, null);
    public final IAudioListener audioListener = new SdisAudioBridge$AudioListener(this, null);
    private final AudioEnv env;
    private volatile IHMISyncAudioReplies audioReplies;
    private volatile boolean connected;
    private DSISound dsiSound;
    private volatile int currentEntertainmentVolume = 1;

    public SdisAudioBridge(AudioEnv audioEnv) {
        this.env = audioEnv;
        this.audioReplies = new NullHMISyncAudioReplies(audioEnv.lcSDIS);
    }

    public void setService(IHMISyncAudioReplies iHMISyncAudioReplies) {
        this.audioReplies = iHMISyncAudioReplies != null ? iHMISyncAudioReplies : new NullHMISyncAudioReplies(this.env.lcSDIS);
    }

    public void setDSISound(DSISound dSISound) {
        this.env.lcSDIS.log(-2137614336, "[SDISAudioBridge.setDSISound] %1", (Object)dSISound);
        this.dsiSound = dSISound;
    }

    @Override
    public void connectionStatus(boolean bl) {
        this.env.lcSDIS.log(-2137614336, "[SDISAudioBridge.connectionStatus] connected:%1", bl);
        this.connected = bl;
        this.callUpdateCurrentVolume();
    }

    @Override
    public void setVolume(int n) {
        this.env.lcSDIS.log(-2137614336, "[SDISAudioBridge.setVolume] volume:%1", (long)n);
        this.dsiSound.setVolume(2, 1, (short)n);
    }

    private void callUpdateCurrentVolume() {
        this.env.lcSDIS.log(-2137614336, "[SDISAudioBridge.callUpdateCurrentVolume] connected:%1", this.connected);
        if (this.connected) {
            int n = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(1);
            int n2 = VolumeMap.INSTANCE.getVolume(1, n);
            this.env.lcSDIS.log(-2137614336, "[SDISAudioBridge.callUpdateCurrentVolume] AEC:%1 volume:%2", (long)n, (long)this.currentEntertainmentVolume);
            if (n2 != -1 && n2 != this.currentEntertainmentVolume) {
                this.currentEntertainmentVolume = n2;
                this.audioReplies.updateCurrentVolume(n2);
            }
        }
    }

    static /* synthetic */ void access$200(SdisAudioBridge sdisAudioBridge) {
        sdisAudioBridge.callUpdateCurrentVolume();
    }
}

