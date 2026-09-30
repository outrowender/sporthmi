/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.AbstractETCTextFactory;
import de.audi.app.settings.etc.NullETCTTSSpeakService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class ETCTTSHandler
implements TTSListener {
    private static final int PRIO_NONE = -1;
    private static final int PRIO_INFO = 0;
    private static final int PRIO_ERROR = 1;
    private final LogChannel lc;
    private AbstractETCTextFactory textFactory;
    private boolean isSpeaking = false;
    private TTSSingleSpeakService ttsServiceETCWarning;
    private TTSSingleSpeakService ttsServiceETCInfo;
    private NullETCTTSSpeakService nullTTSService;
    private volatile int currentPrio;

    public ETCTTSHandler(LogChannel logChannel) {
        this.lc = logChannel;
        this.nullTTSService = new NullETCTTSSpeakService(logChannel);
        this.ttsServiceETCWarning = this.nullTTSService;
        this.ttsServiceETCInfo = this.nullTTSService;
    }

    public void setTextFactory(AbstractETCTextFactory abstractETCTextFactory) {
        this.textFactory = abstractETCTextFactory;
    }

    public void setTTSService(int n, TTSSingleSpeakService tTSSingleSpeakService) {
        if (tTSSingleSpeakService == null) {
            tTSSingleSpeakService = this.nullTTSService;
        }
        this.lc.log(10000000, "ETCTTSHandler.setTTSService(): set TTS service %1 for ID %2", (Object)tTSSingleSpeakService.getClass().getName(), (long)n);
        if (n == 13) {
            this.setWarningTTSService(tTSSingleSpeakService);
        } else if (n == 14) {
            this.setInfoTTSService(tTSSingleSpeakService);
        } else {
            this.lc.log(10000, "ETCTTSHandler.setTTSService(): unknown TTS client ID %1", (long)n);
        }
    }

    void speakErrorMessage(int n) {
        if (this.textFactory != null) {
            String string = this.textFactory.getErrorMessageText(n);
            this.lc.log(10000000, "ETCTTSHandler.speakErrorMessage(%1)", (Object)string);
            if (string.length() > 0) {
                this.speak(1, string);
            }
        } else {
            this.lc.log(10000, "ETCTTSHandler.speakErrorMessage(): Text factory is not defined");
        }
    }

    void speakTollInfo(boolean bl, boolean bl2, int n) {
        if (this.textFactory != null) {
            String string = this.textFactory.getTollInfoText(bl, bl2);
            string = this.insertAmount(string, n);
            this.lc.log(10000000, "ETCTTSHandler.speakTollInfo(): %1 [\u00a5%2]", (Object)string, (long)n);
            this.speak(0, string);
        } else {
            this.lc.log(10000, "ETCTTSHandler.speakTollInfo(): Text factory is not defined");
        }
    }

    void speakWarningMessage(boolean bl) {
        if (this.textFactory != null) {
            String string = this.textFactory.getWarningMessageCardInsertedText(bl);
            this.lc.log(10000000, "ETCTTSHandler.speakWarningMessage(%1)", (Object)string);
            this.speak(0, string);
        } else {
            this.lc.log(10000, "ETCTTSHandler.speakWarningMessage(): Text factory is not defined");
        }
    }

    private synchronized void speak(int n, String string) {
        if (string != null && string.length() > 0) {
            if (n >= this.currentPrio) {
                if (this.currentPrio < n && this.isSpeaking) {
                    this.getTTSService(this.currentPrio).abortSpeaking();
                }
                this.currentPrio = n;
                this.lc.log(10000000, "ETCTTSHandler.speak(prio=%1): '%2'", (Object)string);
                this.getTTSService(this.currentPrio).speak(string);
            } else {
                this.lc.log(1000000, "ETCTTSHandler.speak(): Hight priority speaking is active, ignore speaking ['%1'] because of lower priority", (Object)string);
            }
        } else {
            this.lc.log(10000, "ETCTTSHandler.speak(%1,%2): undefined message!", (Object)Integer.toString(n), (Object)string);
        }
    }

    private String insertAmount(String string, int n) {
        Buffer buffer = new Buffer();
        if (string != null) {
            int n2 = string.indexOf(37);
            if (n2 >= 0) {
                buffer.append(string.substring(0, n2)).append(n).append(string.substring(n2 + 2));
            } else {
                buffer.append(string);
            }
        }
        return buffer.toString();
    }

    TTSSingleSpeakService getTTSService(int n) {
        switch (n) {
            case 0: {
                return this.ttsServiceETCInfo;
            }
            case 1: {
                return this.ttsServiceETCWarning;
            }
        }
        return this.nullTTSService;
    }

    private void setWarningTTSService(TTSSingleSpeakService tTSSingleSpeakService) {
        this.ttsServiceETCWarning = tTSSingleSpeakService;
    }

    private void setInfoTTSService(TTSSingleSpeakService tTSSingleSpeakService) {
        this.ttsServiceETCInfo = tTSSingleSpeakService;
    }

    public void speakingStarted() {
        this.lc.log(10000000, "ETCTTSHandler.speakingStarted");
        this.isSpeaking = true;
    }

    public void speakingPaused() {
        this.lc.log(10000000, "ETCTTSHandler.speakingPaused");
        this.isSpeaking = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void speakingFinished() {
        this.lc.log(10000000, "ETCTTSHandler.speakingFinished");
        this.isSpeaking = false;
        ETCTTSHandler eTCTTSHandler = this;
        synchronized (eTCTTSHandler) {
            this.currentPrio = -1;
        }
    }

    public void speakingAborted() {
        this.lc.log(10000000, "ETCTTSHandler.speakingAborted");
        this.isSpeaking = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void speakingFailed() {
        this.lc.log(10000000, "ETCTTSHandler.speakingFailed");
        this.isSpeaking = false;
        ETCTTSHandler eTCTTSHandler = this;
        synchronized (eTCTTSHandler) {
            this.currentPrio = -1;
        }
    }

    public void sessionStarted() {
        this.lc.log(10000000, "ETCTTSHandler.sessionStarted");
    }

    public void sessionPaused() {
        this.lc.log(10000000, "ETCTTSHandler.sessionPaused");
    }

    public void sessionResumed() {
        this.lc.log(10000000, "ETCTTSHandler.sessionResumed");
    }

    public void audioAvailable(boolean bl) {
        this.lc.log(10000000, "ETCTTSHandler.audioAvailable");
    }

    public void sessionStopped() {
        this.lc.log(10000000, "ETCTTSHandler.sessionStopped");
    }
}

