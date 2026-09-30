/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;

public class TTSSingleSpeakerDefaultListener
implements TTSListener {
    private final LogChannel logCh;
    private final TTSSingleSpeakService singleSpeaker;
    private String bufferedText;

    public TTSSingleSpeakerDefaultListener(LogChannel logChannel, TTSSingleSpeakService tTSSingleSpeakService) {
        this.logCh = logChannel;
        this.singleSpeaker = tTSSingleSpeakService;
    }

    public void setBufferedText(String string) {
        this.bufferedText = string;
    }

    public void sessionStarted() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#sessionStarted] Called. ");
    }

    public void sessionStopped() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#sessionStopped] Called. ");
    }

    public void speakingFinished() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#speakingFinished] Called. ");
    }

    public void speakingAborted() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#speakingAborted] Called. ");
    }

    public void speakingPaused() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#speakingPaused] Called. ");
    }

    public void sessionPaused() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#sessionPaused] Called. ");
        this.singleSpeaker.abortSpeaking();
    }

    public void sessionResumed() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#resumeSpeakingPossible] Called. ");
        this.singleSpeaker.speak(this.bufferedText);
    }

    public void speakingFailed() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#speakingFailed] Called. ");
    }

    public void audioAvailable(boolean bl) {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#audioAvailable] Called. ");
    }

    public void speakingStarted() {
        this.logCh.log(10000000, "[TTSSingleSpeakerDefaultListener#speakingStarted] Called. ");
    }
}

