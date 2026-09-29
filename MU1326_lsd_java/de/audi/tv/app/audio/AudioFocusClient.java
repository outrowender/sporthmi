/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.audio.AudioFocusClient$Properties;
import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.TVEnv;

public class AudioFocusClient
implements IAudioFocusClient {
    private IAudioFocusManager manager;
    private AudioDrawerContext audioDrawerContext;
    private final LogChannel log;
    private final IAudioListener audioFocusListener;
    private boolean[] audioFocus = new boolean[8];
    private boolean isFirstAudioFocusUpdate = true;
    private final AudioFocusClient$Properties myProperties;

    public AudioFocusClient(TVEnv tVEnv, LogChannel logChannel, IAudioListener iAudioListener) {
        this.log = logChannel;
        this.myProperties = tVEnv.properties.audioFocus;
        this.audioFocusListener = iAudioListener;
        this.manager = new NullAudioFocusManager(logChannel);
        this.audioDrawerContext = new NullAudioDrawerContext(logChannel);
    }

    public void register(IAudioFocusManager iAudioFocusManager) {
        this.manager = iAudioFocusManager;
    }

    public void register(AudioDrawerContext audioDrawerContext) {
        this.audioDrawerContext = audioDrawerContext;
        if (this.hasAudioFocus(0)) {
            audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TV, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAudioFocus(boolean bl, int n) {
        boolean[] blArray = this.audioFocus;
        synchronized (this.audioFocus) {
            if (n == 0) {
                this.audioFocus[0] = bl;
                this.audioFocus[1] = bl;
            }
            this.audioFocus[n] = bl;
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasAudioFocus(int n) {
        boolean[] blArray = this.audioFocus;
        synchronized (this.audioFocus) {
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return n == -1 ? false : this.audioFocus[n];
        }
    }

    @Override
    public synchronized void updateAudioFocus(int n, int n2) {
        this.log.log(-2137614336, "[AudioFocusClient.updateAudioFocus] terminal %1 app %2", (long)n, (long)n2);
        if (n2 == 38) {
            this.setAudioFocus(true, n);
            if (n == 0) {
                this.audioFocusListener.onMuGotTvAudioFocus(this.isFirstAudioFocusUpdate);
                AudioFocusClient$Properties.access$000(this.myProperties).accept(new Boolean(true));
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TV, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                this.isFirstAudioFocusUpdate = false;
            } else {
                this.audioFocusListener.onSdisGotTvAudioFocus();
                AudioFocusClient$Properties.access$100(this.myProperties).accept(new Boolean(true));
            }
        } else {
            this.setAudioFocus(false, n);
            if (n == 0) {
                this.audioFocusListener.onMuLostTvAudioFocus();
                AudioFocusClient$Properties.access$000(this.myProperties).accept(new Boolean(false));
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_TV, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.isFirstAudioFocusUpdate = false;
            } else {
                this.audioFocusListener.onSdisLostTvAudioFocus();
                AudioFocusClient$Properties.access$100(this.myProperties).accept(new Boolean(false));
            }
        }
    }

    public void activateTVAudio(int n) {
        if (!this.hasAudioFocus(n)) {
            this.log.log(-2137614336, "[AudioFocusClient.activateTVAudio] request audio focus for terminal %1", (long)n);
            this.manager.setActiveAudioApp(n, 38);
        }
    }
}

