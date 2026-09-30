/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullTTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class TTSSingleSpeakSamplePlayer
implements ISamplePlayer,
TTSListener {
    private final ToneEnv env;
    private TTSService ttsService;
    private static String defaultText = "Not defined";
    private String text;

    public TTSSingleSpeakSamplePlayer(ToneEnv toneEnv, int n) {
        this(toneEnv, toneEnv.getTranslatedText(n, defaultText));
    }

    public TTSSingleSpeakSamplePlayer(ToneEnv toneEnv, String string) {
        this.env = toneEnv;
        this.ttsService = new NullTTSSessionBasedService(toneEnv.lcMain);
        this.text = string;
    }

    public void setText(String string) {
        this.text = string;
    }

    public void play() {
        if (this.ttsService != null) {
            this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.play] text :%1", (Object)this.text);
            this.ttsService.speak(this.text);
        } else {
            this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.play] ttsSevice == null");
        }
    }

    public void stop() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.stop] stop called");
    }

    public void registerService(Object object) {
        if (object instanceof TTSService) {
            this.ttsService = (TTSService)object;
        }
    }

    public void deregisterService(Object object) {
        if (this.ttsService.equals(object)) {
            this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.deregisterService] service%1 service ", object);
            this.ttsService = new NullTTSSessionBasedService(this.env.lcMain);
        }
    }

    public void sessionStarted() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.sessionStarted] sessionStarted called");
    }

    public void sessionStopped() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.sessionStopped] sessionStopped called");
    }

    public void speakingFinished() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.speakingFinished] speakingFinished called");
    }

    public void speakingAborted() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.speakingAborted] speakingAborted called");
    }

    public void sessionPaused() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.sessionPaused] sessionPaused called");
    }

    public void sessionResumed() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.sessionResumed] sessionResumed called");
    }

    public void speakingFailed() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.speakingFailed] speakingFailed called");
    }

    public void audioAvailable(boolean bl) {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.audioAvailable] audioAvailable called");
    }

    public void speakingStarted() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.speakingStarted] speakingStarted called");
    }

    public void speakingPaused() {
        this.env.lcMain.log(1000000, "[TTSSingleSpeakSamplePlayer.speakingPaused] speakingPaused called");
    }
}

