/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.audio.VolumeOnOffPressListener;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSToneListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.TTSInitialization;
import de.audi.tghu.tts.TTSServiceImpl;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.DSITTSListener;

public abstract class AbstractSpeaker
implements TTSListener,
TTSToneListener,
TTSInitialization,
ISDSServiceStatusListener,
VolumeOnOffPressListener {
    protected TTSServiceImpl ttsService;
    protected TTSListener ttsListener;
    protected LogChannel logCh;
    protected static final int SESSION_PAUSE_HANDLING_IGNORE = 0;
    protected static final int SESSION_PAUSE_HANDLING_ABORT_SESSION = 1;
    protected static final int SESSION_PAUSE_HANDLING_PAUSE_RESUME = 2;
    protected static final int SESSION_PAUSE_HANDLING_ABORT_SPEAKING = 3;
    protected int sessionPauseHandling = 1;

    public AbstractSpeaker(LogChannel logChannel, DSITTSCaller dSITTSCaller, int n, short s) {
        this.logCh = logChannel;
        this.ttsService = new TTSServiceImpl(false, logChannel, dSITTSCaller, s, n);
        this.ttsService.setTTSListener(this);
    }

    public AbstractSpeaker(boolean bl, LogChannel logChannel, DSITTSCaller dSITTSCaller, int n, short s) {
        this.logCh = logChannel;
        this.ttsService = new TTSServiceImpl(bl, logChannel, dSITTSCaller, s, n);
        this.ttsService.setTTSListener(this);
    }

    TTSServiceImpl getTTSServiceImpl() {
        return this.ttsService;
    }

    public void setAudioService(HMIAudioService hMIAudioService) {
        this.ttsService.setDSIAudioManagement(hMIAudioService);
    }

    public HMIAudioServiceListener getAudioListener() {
        return this.ttsService.getAudioListener();
    }

    public void setTTSDSI(DSITTS dSITTS) {
        this.ttsService.setTTSDSI(dSITTS);
    }

    public DSITTSListener getDSITTSListener() {
        return this.ttsService.getTTSListener();
    }

    public void setTTSListener(TTSListener tTSListener) {
        this.ttsListener = tTSListener;
        boolean bl = this.ttsService.isaMAvailable();
        this.logCh.log(10000000, "[AbstractSpeaker#setTTSListener] delegating initial audioAvailable status from the AudioManagement: %1", bl);
        this.ttsListener.audioAvailable(bl);
    }

    public synchronized void abortSpeaking() {
        this.ttsService.abortSpeaking();
    }

    public abstract void speakImpl(String var1);

    public synchronized void speak(String string) {
        this.speakImpl(string);
    }

    public void init() {
        this.ttsService.init();
    }

    public void setLanguage(Language language) {
        this.ttsService.setLanguage(language);
    }

    public void sessionResumed() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#sessionResumed] Call TTSListener INSTANCE...");
            this.ttsListener.sessionResumed();
        }
    }

    public void sessionStarted() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#sessionStarted] Call TTSListener INSTANCE...");
            this.ttsListener.sessionStarted();
        }
    }

    public void sessionStopped() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#sessionStopped] Call TTSListener INSTANCE...");
            this.ttsListener.sessionStopped();
        }
        this.abortSpeaking();
    }

    public void speakingAborted() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#speakingAborted] Call TTSListener INSTANCE...");
            this.ttsListener.speakingAborted();
        }
    }

    public void speakingFailed() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#speakingFailed] Call TTSListener INSTANCE...");
            this.ttsListener.speakingFailed();
        }
    }

    public void speakingFinished() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#speakingFinished] Call TTSListener INSTANCE...");
            this.ttsListener.speakingFinished();
        }
    }

    public void sessionPaused() {
        this.logCh.log(10000000, "[AbstractSpeaker#sessionPaused] handled pausedSession=%1", (long)this.sessionPauseHandling);
        switch (this.sessionPauseHandling) {
            case 1: {
                this.ttsService.abortSpeaking();
                this.ttsService.stopSession();
                return;
            }
            case 3: {
                this.ttsService.abortSpeaking();
                break;
            }
            case 2: {
                this.ttsService.pause();
                break;
            }
            case 0: {
                break;
            }
        }
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#sessionPaused] Call TTSListener INSTANCE...");
            this.ttsListener.sessionPaused();
        }
    }

    public void audioAvailable(boolean bl) {
        this.logCh.log(1000000, "[AbstractSpeaker#audioAvailable] flag=%1, ttsListener=%2", bl, (Object)this.ttsListener);
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#audioAvailable] Call TTSListener INSTANCE...");
            this.ttsListener.audioAvailable(bl);
        } else {
            this.logCh.log(10000, "[TTSServiceImpl#updateAMAvailable] No TTSListener for AbstractSpeaker available!, amAvailable=%1", bl);
        }
    }

    public void speakingStarted() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#speakingStarted] Call TTSListener INSTANCE...");
            this.ttsListener.speakingStarted();
        }
    }

    public void speakingPaused() {
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[AbstractSpeaker#speakingPaused] Call TTSListener INSTANCE...");
            this.ttsListener.speakingPaused();
        }
    }

    public void toneStarted() {
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(10000000, "[AbstractSpeaker#toneStarted] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneStarted();
        }
    }

    public void toneFinished() {
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(10000000, "[AbstractSpeaker#toneFinished] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneFinished();
        }
    }

    public void notifySDSDialogStarted() {
        this.logCh.log(10000000, "[AbstractSpeaker#notifySDSDialogStarted] Called -> abort speaking");
        this.ttsService.abortSpeaking();
    }

    public void notifySDSDialogEnded() {
    }

    public void notifySDSDialogAborting() {
    }

    public void volumeOnOffPressed(int n) {
        this.logCh.log(10000000, "[AbstractSpeaker#volumeOnOffPressed] Called");
        if (n == -1) {
            return;
        }
        this.ttsService.abortSpeaking();
        this.ttsService.stopSession();
    }

    public VolumeOnOffPressListener getVolumeOnOffPressListener() {
        return this;
    }
}

