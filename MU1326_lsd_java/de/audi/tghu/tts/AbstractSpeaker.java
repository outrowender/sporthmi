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
    protected static final int SESSION_PAUSE_HANDLING_IGNORE;
    protected static final int SESSION_PAUSE_HANDLING_ABORT_SESSION;
    protected static final int SESSION_PAUSE_HANDLING_PAUSE_RESUME;
    protected static final int SESSION_PAUSE_HANDLING_ABORT_SPEAKING;
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

    @Override
    public void setAudioService(HMIAudioService hMIAudioService) {
        this.ttsService.setDSIAudioManagement(hMIAudioService);
    }

    @Override
    public HMIAudioServiceListener getAudioListener() {
        return this.ttsService.getAudioListener();
    }

    @Override
    public void setTTSDSI(DSITTS dSITTS) {
        this.ttsService.setTTSDSI(dSITTS);
    }

    @Override
    public DSITTSListener getDSITTSListener() {
        return this.ttsService.getTTSListener();
    }

    public void setTTSListener(TTSListener tTSListener) {
        this.ttsListener = tTSListener;
        boolean bl = this.ttsService.isaMAvailable();
        this.logCh.log(-2137614336, "[AbstractSpeaker#setTTSListener] delegating initial audioAvailable status from the AudioManagement: %1", bl);
        this.ttsListener.audioAvailable(bl);
    }

    public synchronized void abortSpeaking() {
        this.ttsService.abortSpeaking();
    }

    public abstract void speakImpl(String string) {
    }

    public synchronized void speak(String string) {
        this.speakImpl(string);
    }

    @Override
    public void init() {
        this.ttsService.init();
    }

    public void setLanguage(Language language) {
        this.ttsService.setLanguage(language);
    }

    @Override
    public void sessionResumed() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#sessionResumed] Call TTSListener INSTANCE...");
            this.ttsListener.sessionResumed();
        }
    }

    @Override
    public void sessionStarted() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#sessionStarted] Call TTSListener INSTANCE...");
            this.ttsListener.sessionStarted();
        }
    }

    @Override
    public void sessionStopped() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#sessionStopped] Call TTSListener INSTANCE...");
            this.ttsListener.sessionStopped();
        }
        this.abortSpeaking();
    }

    @Override
    public void speakingAborted() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#speakingAborted] Call TTSListener INSTANCE...");
            this.ttsListener.speakingAborted();
        }
    }

    @Override
    public void speakingFailed() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#speakingFailed] Call TTSListener INSTANCE...");
            this.ttsListener.speakingFailed();
        }
    }

    @Override
    public void speakingFinished() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#speakingFinished] Call TTSListener INSTANCE...");
            this.ttsListener.speakingFinished();
        }
    }

    @Override
    public void sessionPaused() {
        this.logCh.log(-2137614336, "[AbstractSpeaker#sessionPaused] handled pausedSession=%1", (long)this.sessionPauseHandling);
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
            this.logCh.log(-2137614336, "[AbstractSpeaker#sessionPaused] Call TTSListener INSTANCE...");
            this.ttsListener.sessionPaused();
        }
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.logCh.log(1078071040, "[AbstractSpeaker#audioAvailable] flag=%1, ttsListener=%2", bl, (Object)this.ttsListener);
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#audioAvailable] Call TTSListener INSTANCE...");
            this.ttsListener.audioAvailable(bl);
        } else {
            this.logCh.log(10000, "[TTSServiceImpl#updateAMAvailable] No TTSListener for AbstractSpeaker available!, amAvailable=%1", bl);
        }
    }

    @Override
    public void speakingStarted() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#speakingStarted] Call TTSListener INSTANCE...");
            this.ttsListener.speakingStarted();
        }
    }

    @Override
    public void speakingPaused() {
        if (this.ttsListener != null) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#speakingPaused] Call TTSListener INSTANCE...");
            this.ttsListener.speakingPaused();
        }
    }

    @Override
    public void toneStarted() {
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#toneStarted] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneStarted();
        }
    }

    @Override
    public void toneFinished() {
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(-2137614336, "[AbstractSpeaker#toneFinished] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneFinished();
        }
    }

    @Override
    public void notifySDSDialogStarted() {
        this.logCh.log(-2137614336, "[AbstractSpeaker#notifySDSDialogStarted] Called -> abort speaking");
        this.ttsService.abortSpeaking();
    }

    @Override
    public void notifySDSDialogEnded() {
    }

    @Override
    public void notifySDSDialogAborting() {
    }

    @Override
    public void volumeOnOffPressed(int n) {
        this.logCh.log(-2137614336, "[AbstractSpeaker#volumeOnOffPressed] Called");
        if (n == -1) {
            return;
        }
        this.ttsService.abortSpeaking();
        this.ttsService.stopSession();
    }

    @Override
    public VolumeOnOffPressListener getVolumeOnOffPressListener() {
        return this;
    }
}

