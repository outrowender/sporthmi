/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullTTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class TTSSamplePlayer
implements ISamplePlayer,
TTSListener {
    private final ToneEnv env;
    private TTSSessionBasedService ttsService;
    private volatile boolean sessionActive;
    private static String defaultText = "Text not available";
    private String text;

    public TTSSamplePlayer(ToneEnv toneEnv, int n) {
        this(toneEnv, toneEnv.getTranslatedText(n, defaultText));
    }

    public TTSSamplePlayer(ToneEnv toneEnv, String string) {
        this.env = toneEnv;
        this.ttsService = new NullTTSSessionBasedService(toneEnv.lcMain);
        this.text = string;
    }

    public void setText(String string) {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.setText] text: %1", (Object)string);
        this.text = string;
    }

    public void startSession() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.startSession] ttsService: %1", (Object)this.ttsService);
        this.sessionActive = true;
        this.ttsService.startSession();
    }

    public void stopSession() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.stopSession]");
        this.sessionActive = false;
        this.ttsService.stopSession();
    }

    public void play() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.play] must not do anything");
    }

    public void registerService(Object object) {
        if (object instanceof TTSSessionBasedService) {
            this.env.lcMain.log(10000000, "[TTSSamplePlayer.registerService] %1", object);
            this.ttsService = (TTSSessionBasedService)object;
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof TTSSessionBasedService) {
            this.env.lcMain.log(1000000, "[TTSSamplePlayer.deregisterService] %1", object);
            this.ttsService = new NullTTSSessionBasedService(this.env.lcMain);
        }
    }

    public void stop() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.stop] must not do anything");
    }

    public void speakingFailed() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speakingFailed]");
        this.speak();
    }

    public void speakingFinished() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speakingFinished]");
        this.speak();
    }

    public void sessionStarted() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.sessionStarted]");
        this.speak();
    }

    private void speak() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speak] called session active: %1", this.sessionActive);
        if (this.sessionActive) {
            this.env.lcMain.log(10000000, "[TTSSamplePlayer.speak] \"%1\"", (Object)this.text);
            this.ttsService.speak(this.text);
        }
    }

    public void audioAvailable(boolean bl) {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.audioAvailable] available:%1", bl);
    }

    public void sessionResumed() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.sessionResumed]");
        this.speak();
    }

    public void sessionStopped() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.sessionStopped]");
    }

    public void speakingAborted() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speakingAborted]");
    }

    public void sessionPaused() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.sessionPaused]");
    }

    public void speakingStarted() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speakingStarted]");
    }

    public void singleSpeak() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.singleSpeak]");
    }

    public void speakingPaused() {
        this.env.lcMain.log(10000000, "[TTSSamplePlayer.speakingPaused]");
    }
}

