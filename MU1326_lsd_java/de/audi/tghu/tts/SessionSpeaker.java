/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.AbstractSpeaker;
import de.audi.tghu.tts.DSITTSCaller;

public class SessionSpeaker
extends AbstractSpeaker
implements TTSSessionBasedService {
    protected static final byte STATUS_INACTIVE = 0;
    protected static final byte STATUS_STARTING = 1;
    protected static final byte STATUS_ACTIVE = 2;
    protected static final byte STATUS_STOPPING = 3;
    protected byte sessionStatus = 0;
    protected final Object statusMutex = new Object();
    protected volatile boolean isRestartSessionTriggered = false;

    public SessionSpeaker(boolean bl, LogChannel logChannel, DSITTSCaller dSITTSCaller, int n, short s) {
        super(bl, logChannel, dSITTSCaller, n, s);
        this.sessionPauseHandling = bl ? 2 : 3;
        this.logCh.log(10000000, "[SessionSpeaker#ctor] Called.");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void speakImpl(String string) {
        this.logCh.log(10000000, "[SessionSpeaker#speak] Called, text: %1", (Object)string);
        Object object = this.statusMutex;
        synchronized (object) {
            if (this.getSessionStatus() != 2) {
                this.logCh.log(10000000, "[SessionSpeaker#speak] Session is stopped, do nothing.");
                return;
            }
        }
        this.ttsService.speak(string);
    }

    public void pause() {
        this.logCh.log(10000000, "[SessionSpeaker#pause] Called.");
        this.ttsService.pause();
    }

    public void resume() {
        this.logCh.log(10000000, "[SessionSpeaker#resume] Called.");
        this.ttsService.resume();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void startSession() {
        this.logCh.log(10000000, "[SessionSpeaker#startSession] Called.");
        Object object = this.statusMutex;
        synchronized (object) {
            byte by = this.getSessionStatus();
            if (by == 3) {
                this.setRestartSessionFlag(true);
                this.logCh.log(10000000, "[SessionSpeaker#startSession] Session is being stopped or currently starting (%1) -> NOP!", (long)by);
                return;
            }
            if (by == 1 || by == 2) {
                this.logCh.log(10000000, "[SessionSpeaker#startSession] Session is already starting/started (%1)-> NOP!", (long)by);
                return;
            }
            this.setSessionStatus((byte)1);
        }
        this.ttsService.startSession();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sessionStarted() {
        this.logCh.log(10000000, "[SessionSpeaker#sessionStarted] Called.");
        Object object = this.statusMutex;
        synchronized (object) {
            if (this.getSessionStatus() == 3) {
                this.logCh.log(10000000, "[SessionSpeaker#stopSession] Session is stopping -> NOP!");
                return;
            }
            this.setSessionStatus((byte)2);
        }
        super.sessionStarted();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stopSession() {
        this.logCh.log(10000000, "[SessionSpeaker#stopSession] Called.");
        Object object = this.statusMutex;
        synchronized (object) {
            this.setRestartSessionFlag(false);
            if (this.getSessionStatus() == 3 || this.getSessionStatus() == 0) {
                this.logCh.log(10000000, "[SessionSpeaker#stopSession] Session already stopped/stopping -> NOP!");
                return;
            }
            this.setSessionStatus((byte)3);
        }
        this.logCh.log(10000000, "[SessionSpeaker#stopSession] Abort speaking before stopping session.");
        this.abortSpeaking();
        this.ttsService.stopSession();
    }

    public void sessionStopped() {
        this.logCh.log(10000000, "[SessionSpeaker#sessionStopped] Called.");
        this.setSessionStatus((byte)0);
        super.sessionStopped();
        if (this.resetRestartSessionTriggered()) {
            this.logCh.log(10000000, "[SessionSpeaker#sessionStopped] -> restarting session");
            this.startSession();
        }
    }

    public byte getSessionStatus() {
        return this.sessionStatus;
    }

    protected void setSessionStatus(byte by) {
        this.logCh.log(10000000, "[SessionSpeaker#setSessionStatus] Called -> new value=%1", (long)by);
        this.sessionStatus = by;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean resetRestartSessionTriggered() {
        Object object = this.statusMutex;
        synchronized (object) {
            if (this.isRestartSessionTriggered) {
                this.isRestartSessionTriggered = false;
                return true;
            }
            return false;
        }
    }

    public void setRestartSessionFlag(boolean bl) {
        this.isRestartSessionTriggered = bl;
    }

    public void sessionResumed() {
        this.logCh.log(10000000, "[SessionSpeaker#sessionResumed] Called.");
        this.setSessionStatus((byte)2);
        super.sessionResumed();
        if (this.sessionPauseHandling == 2) {
            this.resume();
        }
    }

    public void playTone(int n) {
        this.ttsService.playTone(n);
    }

    public void notifySDSDialogStarted() {
        this.logCh.log(10000000, "[SessionSpeaker#notifySDSDialogStarted] Called -> stop session");
        this.stopSession();
    }

    public void volumeOnOffPressed(int n) {
        this.logCh.log(10000000, "[SessionSpeaker#volumeOnOffPressed] Called.");
        if (n == -1) {
            return;
        }
        if (this.sessionStatus == 2 || this.sessionStatus == 1) {
            this.stopSession();
        }
    }
}

