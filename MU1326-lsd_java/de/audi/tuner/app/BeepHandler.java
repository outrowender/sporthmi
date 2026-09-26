/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.BeepHandler$AudioListener;
import de.audi.tuner.app.BeepHandler$MyWavePlayerListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;

public class BeepHandler {
    final AudioInfo audioInfoListener = new BeepHandler$AudioListener(this, null);
    private boolean systemToneRequested = false;
    private SystemTonePlayer systemTone;
    private final Logger logger;
    private final TunerAudioMgmt audio;

    BeepHandler(Logger logger, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = logger;
        this.audio = tunerAudioMgmt;
    }

    void registerSystemTonePlayer(SystemTonePlayer systemTonePlayer) {
        if (systemTonePlayer != null) {
            this.logger.hmi.log(-2137614336, "register System Tone Player");
            systemTonePlayer.setListener(new BeepHandler$MyWavePlayerListener(this, null));
        } else {
            this.logger.hmi.log(-2137614336, "unregister System Tone Player");
        }
        this.systemTone = systemTonePlayer;
    }

    public void requestAndFadeInBeep() {
        this.requestAudio();
    }

    private void playBeep() {
        if (this.systemTone != null) {
            try {
                this.systemTone.playTone(0, 14);
            }
            catch (Exception exception) {
                this.logger.hmi.log(10000, "[BeepHandler.playBeep]", (Throwable)exception);
                this.releaseAudio();
            }
        } else {
            this.logger.hmi.log(10000, "SystemTonePlayer is null!");
            this.releaseAudio();
        }
    }

    private void requestAudio() {
        this.audio.requestAndFadeIn(120);
        this.systemToneRequested = true;
    }

    private void releaseAudio() {
        this.systemToneRequested = false;
        this.audio.releaseAudioChannel(120, 0);
    }

    static /* synthetic */ boolean access$200(BeepHandler beepHandler) {
        return beepHandler.systemToneRequested;
    }

    static /* synthetic */ Logger access$300(BeepHandler beepHandler) {
        return beepHandler.logger;
    }

    static /* synthetic */ void access$400(BeepHandler beepHandler) {
        beepHandler.playBeep();
    }

    static /* synthetic */ void access$500(BeepHandler beepHandler) {
        beepHandler.releaseAudio();
    }
}

