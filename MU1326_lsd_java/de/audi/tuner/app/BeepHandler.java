/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;

public class BeepHandler {
    final AudioInfo audioInfoListener = new AudioListener();
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
            this.logger.hmi.log(10000000, "register System Tone Player");
            systemTonePlayer.setListener(new MyWavePlayerListener());
        } else {
            this.logger.hmi.log(10000000, "unregister System Tone Player");
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

    private class AudioListener
    extends AudioInfo {
        private AudioListener() {
        }

        public void handleFadedIn(int n) {
            if (n == 120 && BeepHandler.this.systemToneRequested) {
                ((BeepHandler)BeepHandler.this).logger.audio.log(1000000, "Audio for Tuner system tone connection %1 is audible.", (long)n);
                BeepHandler.this.playBeep();
            }
        }
    }

    private class MyWavePlayerListener
    implements WavePlayerListener {
        private MyWavePlayerListener() {
        }

        public void state(int n) {
            ((BeepHandler)BeepHandler.this).logger.hmi.log(10000000, "beepHandler state %1 ", (long)n);
            if (n != 0) {
                BeepHandler.this.releaseAudio();
            }
        }

        public void playToneInfo(int n) {
            ((BeepHandler)BeepHandler.this).logger.hmi.log(10000000, "beepHandler playTone %1 set.", (long)n);
        }
    }
}

