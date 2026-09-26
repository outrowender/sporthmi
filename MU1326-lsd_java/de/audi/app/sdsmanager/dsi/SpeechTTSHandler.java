/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.log.LogChannel;

public class SpeechTTSHandler {
    private TTSSDSService ttsService;
    private SDSAdapter sdsAdapter;
    private SDSTimeoutHandler sdsTimeoutHandler;
    private ISystemVBIHandler systemVBIHandler;
    private LogChannel lc = Logger.getDSITTSLog();
    private volatile boolean ttsAborting = false;
    private byte promptType = 0;
    private boolean illegalCommand = false;
    private final Object ttsPromptRequestsCounterMutex = new Object();
    private int ttsPromptRequestsCounter = 0;
    private boolean isIgnoreSpeakingFailed = false;

    public SpeechTTSHandler() {
        this.lc.log(-2137614336, "SpeechTTSHandler initialized.");
    }

    public void stop() {
        this.ttsService = null;
    }

    public void setTTSService(TTSSDSService tTSSDSService) {
        if (tTSSDSService == null) {
            this.lc.log(-1601830656, "[SpeechTTSHandler#setTTSService] No TTSSDSService given!");
            return;
        }
        this.ttsService = tTSSDSService;
    }

    public void unsetTTSService() {
        this.lc.log(-2137614336, "[SpeechTTSHandler#unsetTTSService] called");
        this.ttsService = null;
    }

    public void playText(String string, boolean bl) {
        this.setIllegalCommand(bl);
        this.playText(string);
    }

    public void playText(String string) {
        this.lc.log(-2137614336, "[SpeechTTSHandler#playText] text=%1, canceling progress icon timer and removing progress icon!", (Object)string);
        this.sdsAdapter.checkSDSProgressIconRemovalAfterPrompt();
        this.sdsAdapter.setSDSProgressIconRemovalAfterPrompt(true);
        if (this.ttsService == null) {
            this.lc.log(-1601830656, "[SpeechTTSHandler#playText] No TTSSDSService available!");
            this.sdsAdapter.sendSpeechSMEvent(2000, false, false);
            return;
        }
        String string2 = this.handlePromptTypeZIP(string);
        if (!this.isTextSpeakable(string2)) {
            this.lc.log(-1601830656, "[SpeechTTSHandler#playText] Text not speakable!");
            this.sdsAdapter.sendSpeechSMEvent(2000, false, false);
            return;
        }
        if (this.getTTSPromptRequestsCounter() > 0) {
            this.lc.log(-1601830656, "[SpeechTTSHandler#playText] Text will be queued, another prompt is playing!");
        }
        this.incrementTTSPromptRequestsCounter("[SpeechTTSHandler#playText]");
        this.sdsTimeoutHandler.cancelEventTimer();
        SDSModelAccess.setTCRPromptModel(string2);
        if (this.promptType == 1) {
            this.ttsService.speakRemoteHMI(string2);
        } else {
            this.ttsService.speak(string2);
        }
        if (this.promptType == 4) {
            this.setIgnoreSpeakingFailed(true);
        }
    }

    private String handlePromptTypeZIP(String string) {
        if (this.promptType != 3) {
            return string;
        }
        this.lc.log(-2137614336, "[SpeechTTSHandler#handlePromptTypeZIP] Prompt type ZIP active!");
        this.resetPromptType();
        int n = string.indexOf("<say-as");
        int n2 = string.indexOf(44);
        int n3 = string.indexOf("</say-as>");
        String string2 = string;
        if (n >= 0 && n2 >= n && n3 > n2) {
            this.lc.log(-2137614336, "[SpeechTTSHandler#handlePromptTypeZIP] Removing text starting with ',' at pos. %1 within <say-as> between pos. %2 and %3!", (long)n2, (long)n, (long)n3);
            string2 = new StringBuffer().append(string.substring(n, n2)).append(string.substring(n3)).toString();
        }
        this.lc.log(-2137614336, "[SpeechTTSHandler#handlePromptTypeZIP] new promptText=%1!", (Object)string2);
        return string2;
    }

    private boolean isTextSpeakable(String string) {
        if (!SDSUtils.isSpeakable(string)) {
            this.lc.log(-2137614336, "[SpeechTTSHandler#isTextSpeakable] Text '%1' not speakable!", (Object)string);
            return false;
        }
        int n = string.indexOf("interpret-as=\"sms\"");
        if (n == -1) {
            return true;
        }
        int n2 = string.indexOf(62);
        int n3 = string.indexOf("</");
        if (n2 > 0 && n3 > n2) {
            String string2 = string.substring(n2 + 1, n3);
            this.lc.log(-2137614336, "[SpeechTTSHandler#isTextSpeakable] smsText=%1!", (Object)string2);
            return SDSUtils.isSpeakable(string2);
        }
        return true;
    }

    public void playTone(int n) {
        if (this.ttsService == null) {
            this.lc.log(10000, "[SpeechTTSHandler#playTone] No TTSSDSService available!");
            return;
        }
        this.ttsService.playTone(n);
    }

    public boolean abort() {
        if (this.ttsService == null) {
            this.lc.log(10000, "[SpeechTTSHandler#abort] No TTS service available!");
            this.ttsAborting = false;
            return false;
        }
        if (this.isTTSAborting()) {
            this.lc.log(-1601830656, "[SpeechTTSHandler#abort] TTS already aborting!");
            return true;
        }
        if (this.getTTSPromptRequestsCounter() == 0) {
            this.lc.log(-2137614336, "[SpeechTTSHandler#abort] No TTS prompts enqueued!");
            this.ttsAborting = false;
            return false;
        }
        this.ttsAborting = true;
        this.lc.log(-2137614336, "[SpeechTTSHandler#abort] Aborting the current prompt!");
        this.sdsTimeoutHandler.cancelEventTimer();
        this.sdsTimeoutHandler.restartTTSTimer();
        this.ttsService.abortSpeaking();
        return true;
    }

    public boolean isTTSAborting() {
        return this.ttsAborting;
    }

    void setTTSAborting(boolean bl) {
        this.ttsAborting = bl;
    }

    public void setPromptType(byte by) {
        this.lc.log(-2137614336, "[SpeechTTSHandler#setPromptType] type=%1!", (long)by);
        this.promptType = by;
    }

    public void resetPromptType() {
        this.lc.log(-2137614336, "[SpeechTTSHandler#resetPromptType] Set prompt type to PROMPT_TYPE_NONE!");
        this.promptType = 0;
    }

    public byte getPromptType() {
        return this.promptType;
    }

    public void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }

    public void setSDSTimeoutHandler(SDSTimeoutHandler sDSTimeoutHandler) {
        this.sdsTimeoutHandler = sDSTimeoutHandler;
    }

    public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
        this.systemVBIHandler = iSystemVBIHandler;
    }

    boolean isIllegalCommand() {
        return this.illegalCommand;
    }

    void setIllegalCommand(boolean bl) {
        this.lc.log(-2137614336, "[SpeechTTSHandler#setIllegalCommand] value=%1", bl);
        this.illegalCommand = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void incrementTTSPromptRequestsCounter(String string) {
        Object object = this.ttsPromptRequestsCounterMutex;
        synchronized (object) {
            ++this.ttsPromptRequestsCounter;
            if (this.ttsPromptRequestsCounter == 1) {
                this.sdsTimeoutHandler.restartTTSTimer();
            }
            this.lc.log(-2137614336, "[SpeechTTSHandler#incrementTTSPromptRequestsCounter] incremented TTS prompt requests counter to %2, caller=%1!", (Object)string, (long)this.ttsPromptRequestsCounter);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void decrementTTSPromptRequestsCounter(String string) {
        Object object = this.ttsPromptRequestsCounterMutex;
        synchronized (object) {
            this.ttsPromptRequestsCounter = Math.max(0, this.ttsPromptRequestsCounter - 1);
            if (this.ttsPromptRequestsCounter > 0) {
                this.sdsTimeoutHandler.restartTTSTimer();
            } else if (this.sdsAdapter.isSDSAborting()) {
                this.sdsTimeoutHandler.cancelSDSSessionAbortingTTSTimer();
            }
            this.systemVBIHandler.stopRecognitionProlongAtPromptEnd();
            this.lc.log(-2137614336, "[SpeechTTSHandler#decrementTTSPromptRequestsCounter] decremented TTS prompt requests counter to %2, caller=%1!", (Object)string, (long)this.ttsPromptRequestsCounter);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getTTSPromptRequestsCounter() {
        Object object = this.ttsPromptRequestsCounterMutex;
        synchronized (object) {
            return this.ttsPromptRequestsCounter;
        }
    }

    public boolean isIgnoreSpeakingFailed() {
        return this.isIgnoreSpeakingFailed;
    }

    public void setIgnoreSpeakingFailed(boolean bl) {
        this.isIgnoreSpeakingFailed = bl;
    }
}

