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

    @Override
    public void sessionStarted() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#sessionStarted] Called. ");
    }

    @Override
    public void sessionStopped() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#sessionStopped] Called. ");
    }

    @Override
    public void speakingFinished() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#speakingFinished] Called. ");
    }

    @Override
    public void speakingAborted() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#speakingAborted] Called. ");
    }

    @Override
    public void speakingPaused() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#speakingPaused] Called. ");
    }

    @Override
    public void sessionPaused() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#sessionPaused] Called. ");
        this.singleSpeaker.abortSpeaking();
    }

    @Override
    public void sessionResumed() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#resumeSpeakingPossible] Called. ");
        this.singleSpeaker.speak(this.bufferedText);
    }

    @Override
    public void speakingFailed() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#speakingFailed] Called. ");
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#audioAvailable] Called. ");
    }

    @Override
    public void speakingStarted() {
        this.logCh.log(-2137614336, "[TTSSingleSpeakerDefaultListener#speakingStarted] Called. ");
    }
}

