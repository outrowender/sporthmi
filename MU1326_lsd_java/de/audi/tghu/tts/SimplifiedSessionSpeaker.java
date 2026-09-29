/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.SessionSpeaker;
import de.audi.tghu.tts.TTSSingleSpeakerDefaultListener;

public class SimplifiedSessionSpeaker
extends SessionSpeaker
implements TTSSingleSpeakService {
    private TTSSingleSpeakerDefaultListener defaultListener;
    private String textToSpeak;

    public SimplifiedSessionSpeaker(LogChannel logChannel, DSITTSCaller dSITTSCaller, int n, short s) {
        super(false, logChannel, dSITTSCaller, n, s);
        this.sessionPauseHandling = 1;
        this.defaultListener = new TTSSingleSpeakerDefaultListener(logChannel, this);
        this.setTTSListener(this.defaultListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void speakImpl(String string) {
        this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speak] Called, text: %1", (Object)string);
        this.textToSpeak = string;
        Object object = this.statusMutex;
        synchronized (object) {
            if (this.sessionStatus == 2) {
                this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speak] Session active -> start speaking.", (long)this.sessionStatus);
                this.ttsService.speak(string);
                return;
            }
            if (this.sessionStatus == 1) {
                this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speak] Session starting -> NOP.");
                return;
            }
            if (this.sessionStatus == 3) {
                this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speak] Session stopping -> set restartFlag.", (long)this.sessionStatus);
                this.setRestartSessionFlag(true);
                return;
            }
            this.startSession();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void sessionStarted() {
        this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#sessionStarted] Called.");
        Object object = this.statusMutex;
        synchronized (object) {
            if (this.getSessionStatus() == 3) {
                this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#stopSession] Session is stopping -> NOP!");
                return;
            }
            this.setSessionStatus((byte)2);
        }
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#sessionStarted] Call TTSListener INSTANCE...");
            this.ttsListener.sessionStarted();
        }
        this.ttsService.speak(this.textToSpeak);
    }

    @Override
    public void speakingFinished() {
        this.checkStopSession();
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speakingFinished] Calling TTSManagerListener instance...");
            this.ttsListener.speakingFinished();
        }
    }

    private void checkStopSession() {
        if (this.ttsService.isRequestQueueIdle()) {
            this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speakingFinished] RequestQueue idle -> stop session of single speak...");
            this.stopSession();
        }
    }

    @Override
    public void speakingAborted() {
        this.checkStopSession();
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speakingAborted] Call TTSListener INSTANCE...");
            this.ttsListener.speakingAborted();
        }
    }

    @Override
    public void speakingFailed() {
        this.checkStopSession();
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#speakingFailed] Call TTSListener INSTANCE...");
            this.ttsListener.speakingFailed();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stopSession() {
        this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#stopSession] Called.");
        Object object = this.statusMutex;
        synchronized (object) {
            this.setRestartSessionFlag(false);
            if (this.getSessionStatus() == 3 || this.getSessionStatus() == 0) {
                this.logCh.log(-2137614336, "[SimplifiedSessionSpeaker#stopSession] Session already stopped/stopping -> NOP!");
                return;
            }
            this.setSessionStatus((byte)3);
        }
        this.ttsService.stopSession();
    }
}

