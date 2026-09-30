/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSToneListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.DSITTSListener;

public class TTSServiceImpl
implements HMIAudioServiceListener,
TTSListener,
TTSToneListener {
    private HMIAudioService dsiAudio;
    private String text;
    private DSITTSCaller dsiTTSCaller;
    protected LogChannel logCh;
    private int audioConnectionID;
    protected volatile boolean sessionActive = false;
    private volatile boolean audioRequestActive = false;
    private volatile boolean audioConnectionPaused = false;
    private volatile boolean pauseUserTriggered = false;
    private TTSListener ttsListener;
    private short sourceId;
    private boolean pauseResumeAvailable;
    private volatile boolean aMAvailable = false;

    public TTSServiceImpl(boolean bl, LogChannel logChannel, DSITTSCaller dSITTSCaller, short s, int n) {
        this.logCh = logChannel;
        this.pauseResumeAvailable = bl;
        this.sourceId = s;
        this.audioConnectionID = n;
        this.dsiTTSCaller = dSITTSCaller;
        if (this.audioConnectionID == -1) {
            this.sessionActive = true;
        }
    }

    void setTTSDSI(DSITTS dSITTS) {
        this.dsiTTSCaller.setTTSDSI(dSITTS);
    }

    public void speak(String string) {
        this.logCh.log(10000000, "[TTSServiceImpl#speak] Called, text: %1", (Object)string);
        if (this.audioConnectionPaused) {
            this.speakingFailed();
            return;
        }
        this.dsiTTSCaller.speak(string, this.sourceId, this);
    }

    public void speak(String string, int n) {
        this.logCh.log(10000000, "[TTSServiceImpl#speak] Called, text: %1, promptType: %2", (Object)string, (long)n);
        if (this.audioConnectionPaused) {
            this.speakingFailed();
            return;
        }
        this.dsiTTSCaller.speak(string, n, this.sourceId, this);
    }

    public void speakCharacters(String string) {
        this.logCh.log(10000000, "[TTSServiceImpl#speakCharacters] Called, text: %1, sourceId: %2", (Object)string, (long)this.sourceId);
        if (this.audioConnectionPaused) {
            this.speakingFailed();
            return;
        }
        this.dsiTTSCaller.speakCharacters(string, this.sourceId, this);
    }

    boolean isRequestQueueIdle() {
        return this.dsiTTSCaller.isRequestQueueIdle();
    }

    public void pause() {
        if (!this.pauseResumeAvailable) {
            this.logCh.log(10000, "[TTSServiceImpl#pause] Called, sourceId: %1 -> not supported!!", (long)this.sourceId);
            return;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#pause] Called, sourceId: %1", (long)this.sourceId);
        if (!this.audioConnectionPaused) {
            this.pauseUserTriggered = true;
        }
        this.dsiTTSCaller.pause(this.sourceId, this);
    }

    public void resume() {
        if (!this.pauseResumeAvailable) {
            this.logCh.log(10000, "[TTSServiceImpl#resume] Called, sourceId: %1 -> not supported!!", (long)this.sourceId);
            return;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#resume] Called, sourceId: %1", (long)this.sourceId);
        if (this.audioConnectionPaused) {
            // empty if block
        }
        this.pauseUserTriggered = false;
        this.dsiTTSCaller.resume(this.sourceId, this);
    }

    public void playTone(int n) {
        this.logCh.log(10000000, "[TTSServiceImpl#playTone] Called.");
        if (this.audioConnectionPaused) {
            this.speakingFailed();
            return;
        }
        this.dsiTTSCaller.playTone(n, this.sourceId, this);
    }

    public void singleSpeak(String string) {
        this.logCh.log(10000000, "[TTSServiceImpl#singleSpeak] Called, text: '%1' ", (Object)string);
        this.text = string;
        if (this.sessionActive) {
            if (!this.audioConnectionPaused) {
                if (this.ttsListener != null) {
                    this.logCh.log(10000000, "[TTSServiceImpl#singleSpeak] Calling TTSManagerListener instance...");
                    this.ttsListener.sessionStarted();
                }
                this.checkSingleSpeak();
            } else {
                this.logCh.log(10000000, "[TTSServiceImpl#singleSpeak] audio session is paused! single speak request will be skipped!");
            }
        } else {
            this.startSession();
        }
    }

    void init() {
        this.logCh.log(10000000, "[TTSServiceImpl#init] Called.");
        this.dsiTTSCaller.initTTSEngine(this.ttsListener);
    }

    public void startSession() {
        if (this.dsiAudio == null) {
            this.logCh.log(10000, "[TTSServiceImpl#startSession] No Audio-DSI available! ");
            return;
        }
        this.audioRequestActive = true;
        this.pauseUserTriggered = false;
        this.logCh.log(10000000, "[TTSServiceImpl#startSession] Request audio channel..., connection ID: %1 ", (long)this.audioConnectionID);
        this.dsiAudio.requestConnection(this.audioConnectionID);
    }

    public void errorConnection(int n, int n2, int n3) {
        if (this.audioConnectionID != n) {
            return;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#errorConnection] Called for connection '%1', error code: '%2' ", (long)n, (long)n3);
        this.logCh.log(10000000, "[TTSServiceImpl#errorConnection] Error on audio connection of the TTS manager, stop audio request and session... ");
        if (this.audioRequestActive) {
            this.audioRequestActive = false;
        }
        if (this.sessionActive) {
            this.sessionActive = false;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#errorConnection] Session for audio connection '%1' stopped. Call listener... ", (long)this.audioConnectionID);
        this.sessionStopped();
    }

    public void fadedIn(int n, int n2) {
        if (this.audioConnectionID != n) {
            return;
        }
        if (!this.sessionActive && !this.audioRequestActive) {
            this.logCh.log(10000000, "[TTSServiceImpl#fadedIn] Connection ID '%1' was not requested by TTSInstance -> set session to active", (long)n);
            this.sessionActive = true;
            return;
        }
        this.sessionActive = true;
        this.audioRequestActive = false;
        if (this.audioConnectionPaused) {
            this.audioConnectionPaused = false;
            if (this.pauseUserTriggered) {
                this.logCh.log(10000000, "[TTSServiceImpl#fadedIn] Session for audio connection '%1' could be resumed, but pause was triggered by user beforehand. ", (long)this.audioConnectionID);
            } else {
                this.logCh.log(10000000, "[TTSServiceImpl#fadedIn] Session for audio connection '%1' is resumed. Call listener... ", (long)this.audioConnectionID);
                this.sessionResumed();
            }
        } else {
            this.logCh.log(10000000, "[TTSServiceImpl#fadedIn] Session for audio connection '%1' started. Call listener... ", (long)this.audioConnectionID);
            this.sessionStarted();
        }
    }

    public void pauseConnection(int n, int n2) {
        if (this.audioConnectionID != n) {
            return;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#pauseConnection] Pause speaking, audio connection: '%1'. ", (long)n);
        if (this.audioConnectionPaused) {
            this.logCh.log(10000000, "[TTSServiceImpl#pauseConnection] Speaking already paused, do nothing. ");
            return;
        }
        this.audioConnectionPaused = true;
        this.sessionPaused();
    }

    public void startConnection(int n, int n2) {
        if (this.audioConnectionID != n) {
            return;
        }
        if (this.audioRequestActive || this.audioConnectionPaused) {
            this.logCh.log(10000000, "[TTSServiceImpl#startConnection] Fade to connection '%1'.... ", (long)n);
            this.dsiAudio.fadeToConnection(this.audioConnectionID);
        } else {
            this.logCh.log(10000000, "[TTSServiceImpl#startConnection] no fade in due to audioRequestActive='%1' audioConnectionPaused='%2' ", this.audioRequestActive, this.audioConnectionPaused);
        }
    }

    public void stopConnection(int n, int n2) {
        if (this.audioConnectionID != n) {
            return;
        }
        this.audioRequestActive = false;
        this.sessionActive = false;
        this.audioConnectionPaused = false;
        this.logCh.log(10000000, "[TTSServiceImpl#stopConnection] Session for audio connection '%1' stopped. Call listener... ", (long)this.audioConnectionID);
        this.sessionStopped();
    }

    public void updateAMAvailable(boolean bl) {
        this.aMAvailable = bl;
        this.logCh.log(1000000, "[TTSServiceImpl#updateAMAvailable] Called, AM available: %1, TTSService for audioConection=%2", bl, (long)this.audioConnectionID);
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#updateAMAvailable] Calling TTSManagerListener instance...");
            this.ttsListener.audioAvailable(bl);
        } else {
            this.logCh.log(1000000, "[TTSServiceImpl#updateAMAvailable] No TTSManagerListener instance available!, amAvailable=%1", bl);
        }
    }

    public void abortSpeaking() {
        this.logCh.log(10000000, "[TTSServiceImpl#abortSpeaking] Called.");
        this.dsiTTSCaller.abortSpeaking(this.sourceId, this.ttsListener);
    }

    public void checkSingleSpeak() {
        this.logCh.log(10000000, "[TTSServiceImpl#checkSingleSpeak] Called ");
        if (this.text != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#checkSingleSpeak] Single speak is active, play text '%1'... ", (Object)this.text);
            this.speak(this.text);
        }
    }

    public void setTTSListener(TTSListener tTSListener) {
        this.logCh.log(10000000, "[TTSServiceImpl#setTTSListener] Called.");
        this.ttsListener = tTSListener;
    }

    public void setDSIAudioManagement(HMIAudioService hMIAudioService) {
        this.logCh.log(10000000, "[TTSServiceImpl#setDSIAudioManagement] Called.");
        this.dsiAudio = hMIAudioService;
    }

    public void stopSession() {
        if (!this.sessionActive && !this.audioRequestActive) {
            this.logCh.log(10000000, "[TTSServiceImpl#stopSession] Ignored, because no active session! ");
            return;
        }
        this.logCh.log(10000000, "[TTSServiceImpl#stopSession] Release audio channel..., connection ID: %1 ", (long)this.audioConnectionID);
        this.dsiAudio.releaseConnection(this.audioConnectionID);
    }

    public HMIAudioServiceListener getAudioListener() {
        return this;
    }

    public DSITTSListener getTTSListener() {
        return this.dsiTTSCaller;
    }

    public void setLanguage(Language language) {
        this.logCh.log(10000000, "[TTSServiceImpl#setLanguage] Called, language: %1", (Object)language);
        this.dsiTTSCaller.setLanguage(language, this.ttsListener);
    }

    public void audioAvailable(boolean bl) {
        this.logCh.log(10000000, "[TTSServiceImpl#audioAvailable] Called, available: %1", bl);
        if (this.ttsListener != null) {
            this.ttsListener.audioAvailable(bl);
        }
    }

    public void sessionStarted() {
        this.logCh.log(10000000, "[TTSServiceImpl#sessionStarted] Called. ");
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#sessionStarted] Calling TTSManagerListener instance... ");
            this.ttsListener.sessionStarted();
        }
        this.checkSingleSpeak();
    }

    public void sessionStopped() {
        this.logCh.log(10000000, "[TTSServiceImpl#sessionStopped] Called. ");
        this.pauseUserTriggered = false;
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#sessionStopped] Calling TTSManagerListener instance... ");
            this.ttsListener.sessionStopped();
        }
    }

    public void speakingFinished() {
        this.logCh.log(10000000, "[TTSServiceImpl#speakingFinished] Called. ");
        if (this.text != null && this.dsiTTSCaller.isRequestQueueIdle()) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingFinished] Stop session of single speak... ");
            this.text = null;
            this.stopSession();
        }
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingFinished] Calling TTSManagerListener instance... ");
            this.ttsListener.speakingFinished();
        }
    }

    public void speakingFailed() {
        this.logCh.log(10000000, "[TTSServiceImpl#speakingFailed] Called. ");
        if (this.text != null && this.dsiTTSCaller.isRequestQueueIdle()) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingFailed] Stop session of single speak... ");
            this.text = null;
            this.stopSession();
        }
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingFailed] Calling TTSManagerListener instance... ");
            this.ttsListener.speakingFailed();
        }
    }

    public void speakingAborted() {
        this.logCh.log(10000000, "[TTSServiceImpl#speakingAborted] Called. ");
        if (this.text != null && this.dsiTTSCaller.isRequestQueueIdle()) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingAborted] Stop session of single speak... ");
            this.text = null;
            this.stopSession();
        }
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingAborted] Calling TTSManagerListener instance... ");
            this.ttsListener.speakingAborted();
        }
    }

    public void sessionPaused() {
        this.logCh.log(10000000, "[TTSServiceImpl#sessionPaused] Called. ");
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#sessionPaused] Calling TTSManagerListener instance... ");
            this.ttsListener.sessionPaused();
        }
    }

    public void sessionResumed() {
        this.logCh.log(10000000, "[TTSServiceImpl#sessionResumed] Called. ");
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#sessionResumed] Calling TTSManagerListener instance... ");
            this.ttsListener.sessionResumed();
        } else {
            this.logCh.log(100000, "[TTSServiceImpl#sessionResumed] client has no TTSListener assigned to handle resume use case");
        }
    }

    public void speakingStarted() {
        this.logCh.log(10000000, "[TTSServiceImpl#speakingStarted] Called. ");
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingStarted] Calling TTSManagerListener instance... ");
            this.ttsListener.speakingStarted();
        }
    }

    public void speakingPaused() {
        this.logCh.log(10000000, "[TTSServiceImpl#speakingPaused] Called. ");
        if (this.ttsListener != null) {
            this.logCh.log(10000000, "[TTSServiceImpl#speakingPaused] Calling TTSManagerListener instance... ");
            this.ttsListener.speakingPaused();
        }
    }

    public void toneStarted() {
        this.logCh.log(10000000, "[TTSServiceImpl#toneStarted] Called. ");
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(10000000, "[TTSServiceImpl#toneStarted] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneStarted();
        }
    }

    public void toneFinished() {
        this.logCh.log(10000000, "[TTSServiceImpl#toneFinished] Called. ");
        if (this.ttsListener != null && this.ttsListener instanceof TTSToneListener) {
            this.logCh.log(10000000, "[TTSServiceImpl#toneFinished] Calling TTSManagerListener instance... ");
            ((TTSToneListener)this.ttsListener).toneFinished();
        }
    }

    public boolean isaMAvailable() {
        return this.aMAvailable;
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

