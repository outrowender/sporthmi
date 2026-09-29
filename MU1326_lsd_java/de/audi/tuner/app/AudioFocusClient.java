/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.tuner.app.AppChangeHandler;
import de.audi.tuner.app.AudioFocusClient$ActionProxyListener;
import de.audi.tuner.app.AudioFocusInfo;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.ap.TunerActionProxyListener;

public class AudioFocusClient
implements IAudioFocusClient {
    public final TunerActionProxyListener actionProxyListener = new AudioFocusClient$ActionProxyListener(this);
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerAudioMgmt audio;
    private final AppChangeHandler appChange;
    private IAudioFocusManager audioFocusManager;
    private int targetBand = 8;
    private AudioFocusInfo[] listeners = new AudioFocusInfo[0];
    private TunerObjectContainer targetToc;
    private AudioDrawerContext audioDrawerContext;

    AudioFocusClient(TunerBasics tunerBasics, AppChangeHandler appChangeHandler, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.audio = tunerAudioMgmt;
        this.audioFocusManager = new NullAudioFocusManager(this.logger.audio);
        this.audioDrawerContext = new NullAudioDrawerContext(this.logger.audio);
        this.appChange = appChangeHandler;
    }

    void register(IAudioFocusManager iAudioFocusManager) {
        this.audioFocusManager = iAudioFocusManager != null ? iAudioFocusManager : new NullAudioFocusManager(this.logger.audio);
    }

    public void register(AudioDrawerContext audioDrawerContext) {
        if (audioDrawerContext != null) {
            this.audioDrawerContext = audioDrawerContext;
            if (this.status.hasAudioFocus(0)) {
                audioDrawerContext.setContext(AudioDrawerContext.SOURCE_RADIO, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
            }
        } else {
            this.audioDrawerContext = new NullAudioDrawerContext(this.logger.audio);
        }
    }

    public void register(AudioFocusInfo audioFocusInfo) {
        AudioFocusInfo[] audioFocusInfoArray = new AudioFocusInfo[this.listeners.length + 1];
        System.arraycopy((Object)this.listeners, 0, (Object)audioFocusInfoArray, 0, this.listeners.length);
        audioFocusInfoArray[this.listeners.length] = audioFocusInfo;
        this.listeners = audioFocusInfoArray;
    }

    @Override
    public void updateAudioFocus(int n, int n2) {
        int n3;
        this.logger.audio.log(-2137614336, "[AudioFocusClient.updateAudioFocus] terminal %1 app %2", (long)n, (long)n2);
        AudioFocusInfo[] audioFocusInfoArray = this.listeners;
        for (n3 = 0; n3 < audioFocusInfoArray.length; ++n3) {
            audioFocusInfoArray[n3].updateAudioFocus(n, n2);
        }
        if (n2 == 1) {
            n3 = this.targetBand == 8 ? this.models.getActiveTuner() : this.targetBand;
            this.targetBand = 8;
            this.appChange.appChangeToTuner(n, n3, this.targetToc, true);
            this.targetToc = null;
            for (int i2 = 0; i2 < audioFocusInfoArray.length; ++i2) {
                audioFocusInfoArray[i2].audioFocus(n, n3);
            }
        } else {
            this.status.setAudioFocus(false, n);
            for (n3 = 0; n3 < audioFocusInfoArray.length; ++n3) {
                audioFocusInfoArray[n3].audioFocusLost();
            }
            n3 = 0;
            for (int i3 = 0; i3 < 8; ++i3) {
                if (!this.status.hasAudioFocus(i3)) continue;
                n3 = 1;
                break;
            }
            if (n3 == 0) {
                TunerProxyManager tunerProxyManager = TunerProxyManager.getInstance();
                tunerProxyManager.stopActiveActions();
                tunerProxyManager.getActiveTuner().setComponentUnused();
            }
        }
        if (n == 0) {
            if (n2 == 1) {
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_RADIO, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
            } else {
                this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_RADIO, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
            }
        }
    }

    public void switchSource(int n, int n2, TunerObjectContainer tunerObjectContainer) {
        TunerObjectContainer tunerObjectContainer2 = tunerObjectContainer = tunerObjectContainer != null ? TunerProxyManager.getInstance().fillMissingName(tunerObjectContainer) : null;
        if (this.status.hasAudioFocus(n)) {
            this.logger.audio.log(-2137614336, "[AudioFocusClient.switchSource] we have already audiofocus for terminal %1", (long)n);
            this.appChange.appChangeToTuner(n, n2, tunerObjectContainer, false);
        } else {
            this.targetBand = n2;
            this.targetToc = tunerObjectContainer;
            this.logger.audio.log(-2137614336, "[AudioFocusClient.switchSource] request audiofocus for terminal %1", (long)n);
            this.audioFocusManager.setActiveAudioApp(n, 1);
        }
        if (n != 0 && this.status.hasAudioFocus(0)) {
            this.logger.audio.log(-2137614336, "[AudioFocusClient.switchSource] Joint usecase detected -> switch FU to band %1", (long)n2);
            this.audio.restoreActiveAudio(n);
        }
    }

    static /* synthetic */ IAudioFocusManager access$000(AudioFocusClient audioFocusClient) {
        return audioFocusClient.audioFocusManager;
    }
}

