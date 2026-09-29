/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.apps.system.commands.SystemPlayBeepCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSToneListener;
import de.audi.atip.log.LogChannel;

public class SpeechTTSListener
implements TTSListener,
TTSToneListener {
    private LogChannel lc = Logger.getDSITTSLog();
    private final SpeechTTSHandler ttsHandler;
    private final SDSHandlerService sdsHandlerService;
    private final SDSAppFactory sdsAppFactory;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private ISystemVBIHandler systemVBIHandler;

    public SpeechTTSListener(SpeechTTSHandler speechTTSHandler, SDSAppFactory sDSAppFactory, SDSHandlerService sDSHandlerService, SDSTimeoutHandler sDSTimeoutHandler) {
        this.ttsHandler = speechTTSHandler;
        this.sdsAppFactory = sDSAppFactory;
        this.sdsHandlerService = sDSHandlerService;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.lc.log(-2137614336, "SpeechTTSListener initialized.");
    }

    public void stop() {
        this.lc.log(-2137614336, "[SpeechTTSListener#stop] called");
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.lc.log(-2137614336, "[SpeechTTSListener#audioAvailable] called: flag=%1", bl);
    }

    @Override
    public void sessionResumed() {
        this.lc.log(-2137614336, "[SpeechTTSListener#sessionResumed] called");
    }

    @Override
    public void sessionStarted() {
        this.lc.log(-2137614336, "[SpeechTTSListener#sessionStarted] called");
    }

    @Override
    public void sessionStopped() {
        this.lc.log(-2137614336, "[SpeechTTSListener#sessionStopped] called");
    }

    @Override
    public void speakingAborted() {
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingAborted] called");
        this.sdsTimeoutHandler.cancelTTSTimer();
        this.ttsHandler.decrementTTSPromptRequestsCounter("[SpeechTTSListener#speakingAborted]");
        boolean bl = this.ttsHandler.isTTSAborting();
        this.ttsHandler.setTTSAborting(false);
        SystemSDSHandler systemSDSHandler = this.sdsAppFactory.getSDSHandlerSystem();
        if (bl || systemSDSHandler.getAbortingType() == 2) {
            systemSDSHandler.abortedCurrentPrompt();
        } else {
            this.speakingFailed();
        }
    }

    @Override
    public void speakingFailed() {
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingFailed] called");
        if (this.ttsHandler.isTTSAborting()) {
            this.lc.log(-2137614336, "[SpeechTTSListener#speakingFailed] TTS is aborting, calling speakingAborted!");
            this.speakingAborted();
            return;
        }
        this.sdsTimeoutHandler.cancelTTSTimer();
        this.ttsHandler.decrementTTSPromptRequestsCounter("[SpeechTTSListener#speakingFailed]");
        if (this.systemVBIHandler.informTTSAbortCommandAboutPromptEnd()) {
            return;
        }
        if (this.ttsHandler.isIgnoreSpeakingFailed()) {
            this.lc.log(-2137614336, "[SpeechTTSListener#speakingFailed] Will be ignored and follow up event sent!");
            this.sdsHandlerService.sendSpeechSMEvent(2008, false, false);
            this.ttsHandler.setIgnoreSpeakingFailed(false);
            return;
        }
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingFailed] Aborting session!");
        this.sdsHandlerService.abortSDSSession(true);
    }

    @Override
    public void speakingFinished() {
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingFinished] called");
        if (this.ttsHandler.isTTSAborting()) {
            this.lc.log(-2137614336, "[SpeechTTSListener#speakingFinished] ttsAbort called => NOP!");
            this.speakingAborted();
            return;
        }
        this.ttsHandler.decrementTTSPromptRequestsCounter("[SpeechTTSListener#speakingFinished]");
        this.ttsHandler.setTTSAborting(false);
        if (this.systemVBIHandler.informTTSAbortCommandAboutPromptEnd() || this.systemVBIHandler.isTTSFinishAlreadySent()) {
            return;
        }
        if (this.ttsHandler.isIllegalCommand()) {
            this.ttsHandler.setIllegalCommand(false);
            this.sdsAppFactory.getSDSHandlerSystem().responseHandleIllegalCommand();
            return;
        }
        this.ttsHandler.resetPromptType();
        this.sdsHandlerService.sendSpeechSMEvent(2000, false, false);
    }

    @Override
    public void sessionPaused() {
        this.lc.log(-2137614336, "[SpeechTTSListener#sessionPaused] called!");
    }

    @Override
    public void speakingStarted() {
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingStarted] called!");
        this.sdsTimeoutHandler.cancelTTSTimer();
        this.systemVBIHandler.sendTTSFinishAtPromptRequestForLastQueuedPrompt(this.ttsHandler.getPromptType());
        if (SDSModelAccess.getSDSPromptTypeUnchanging() == 0) {
            this.ttsHandler.resetPromptType();
        }
        if (this.sdsHandlerService.isSDSAborting() && !this.systemVBIHandler.isRegularPromptAtSessionEndActive()) {
            this.sdsTimeoutHandler.restartSDSSessionAbortingTTSTimer();
        }
    }

    @Override
    public void speakingPaused() {
        this.lc.log(-2137614336, "[SpeechTTSListener#speakingPaused] called!");
    }

    @Override
    public void toneStarted() {
        this.lc.log(-2137614336, "[SpeechTTSListener#toneStarted] called!");
    }

    @Override
    public void toneFinished() {
        try {
            ((SystemPlayBeepCommand)SDSUtils.getActiveSystemCall()).toneFinished();
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SpeechTTSListener#toneFinished: Active command is no SystemPlayBeepCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SpeechTTSListener#toneFinished: NullpointerException. No active command!");
        }
    }

    public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
        this.systemVBIHandler = iSystemVBIHandler;
    }
}

