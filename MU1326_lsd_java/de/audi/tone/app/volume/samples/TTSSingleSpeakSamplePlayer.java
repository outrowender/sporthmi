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

    @Override
    public void play() {
        if (this.ttsService != null) {
            this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.play] text :%1", (Object)this.text);
            this.ttsService.speak(this.text);
        } else {
            this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.play] ttsSevice == null");
        }
    }

    @Override
    public void stop() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.stop] stop called");
    }

    @Override
    public void registerService(Object object) {
        if (object instanceof TTSService) {
            this.ttsService = (TTSService)object;
        }
    }

    @Override
    public void deregisterService(Object object) {
        if (this.ttsService.equals(object)) {
            this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.deregisterService] service%1 service ", object);
            this.ttsService = new NullTTSSessionBasedService(this.env.lcMain);
        }
    }

    @Override
    public void sessionStarted() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.sessionStarted] sessionStarted called");
    }

    @Override
    public void sessionStopped() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.sessionStopped] sessionStopped called");
    }

    @Override
    public void speakingFinished() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.speakingFinished] speakingFinished called");
    }

    @Override
    public void speakingAborted() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.speakingAborted] speakingAborted called");
    }

    @Override
    public void sessionPaused() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.sessionPaused] sessionPaused called");
    }

    @Override
    public void sessionResumed() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.sessionResumed] sessionResumed called");
    }

    @Override
    public void speakingFailed() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.speakingFailed] speakingFailed called");
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.audioAvailable] audioAvailable called");
    }

    @Override
    public void speakingStarted() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.speakingStarted] speakingStarted called");
    }

    @Override
    public void speakingPaused() {
        this.env.lcMain.log(1078071040, "[TTSSingleSpeakSamplePlayer.speakingPaused] speakingPaused called");
    }
}

