/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.apps.system.commands.SystemStartRecognitionCommand;
import de.audi.app.sdsmanager.apps.system.commands.SystemTTSAbortCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.atip.log.LogChannel;

public class SystemVBIHandler
implements ISystemVBIHandler {
    private final LogChannel logChannel;
    private final SDSAdapter sdsAdapter;
    private final AppSDSManager appSDSManager;
    private final SpeechTTSHandler speechTTSHandler;
    private final SpeechRecognitionHandler speechRecognitionHandler;
    private final SystemSDSHandler systemSDSHandler;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private volatile int speechRecognitionState = 1;
    private volatile int promptType = 0;
    private volatile boolean alwaysSendTTSFinishAtPromptEnd = false;

    public SystemVBIHandler(SDSAdapter sDSAdapter, AppSDSManager appSDSManager, SystemSDSHandler systemSDSHandler, SpeechTTSHandler speechTTSHandler, SpeechRecognitionHandler speechRecognitionHandler, SDSTimeoutHandler sDSTimeoutHandler, LogChannel logChannel) {
        this.sdsAdapter = sDSAdapter;
        this.appSDSManager = appSDSManager;
        this.speechTTSHandler = speechTTSHandler;
        this.speechRecognitionHandler = speechRecognitionHandler;
        this.systemSDSHandler = systemSDSHandler;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.logChannel = logChannel;
    }

    @Override
    public void sendTTSFinishAtPromptEnd(boolean bl) {
        this.logChannel.log(-2137614336, "SystemVBIHandler#sendTTSFinishAtPromptEnd: status=%1!", bl);
        this.alwaysSendTTSFinishAtPromptEnd = bl;
    }

    @Override
    public void sendTTSFinishAtPromptRequestForLastQueuedPrompt(int n) {
        this.promptType = n;
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() == 1 && !this.sdsAdapter.isSDSAborting() && this.checkSendTTSFinishAtPromptRequest()) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#sendTTSFinishAtPromptRequestForLastQueuedPrompt: Only current prompt (early TTS-Finish) enqueued and SDS not aborting => sending TTS-Finish response event immediately!");
            this.sdsAdapter.sendSpeechSMEvent(2000, false, false);
        }
    }

    private boolean checkSendTTSFinishAtPromptRequest() {
        if (this.alwaysSendTTSFinishAtPromptEnd || SDSModelAccess.getPosttrainingActiveValue() == 1) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#checkSendTTSFinishAtPromptRequest: Voice barge-in is currently deactivated => TTS-Finish event must be sent at end of prompt!");
            return false;
        }
        switch (this.promptType) {
            case 2: {
                this.logChannel.log(-2137614336, "SystemVBIHandler#checkSendTTSFinishAtPromptRequest: Voice barge-in active with special prompt (late TTS-Finish) => TTS-Finish event must be sent at end of prompt!");
                return false;
            }
        }
        return true;
    }

    @Override
    public void startRecognitionProlongDuringPrompt() {
        if (this.speechRecognitionState == 3 && this.speechTTSHandler.getTTSPromptRequestsCounter() > 0) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#startRecognitionProlongDuringPrompt: Recognizer and prompting active in parallel => start automatic prolonging of open recognizer!");
            this.sdsTimeoutHandler.restartRecognitionProlongLoopTimer();
        }
    }

    @Override
    public boolean isVBIActiveDuringActivePrompt() {
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() > 0) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#isVBIActiveDuringActivePrompt: Prompt active => set beep tone to none!");
            return true;
        }
        if (this.alwaysSendTTSFinishAtPromptEnd) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#isVBIActiveDuringActivePrompt: No prompt active but last prompt was special prompt with late TTS-finish => set beep tone to none!");
            return true;
        }
        return false;
    }

    @Override
    public void initializeRecgonitionMode() {
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() == 0) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#initializeRecgonitionMode: No prompt active => cancel automatic prolonging of recognizer!");
            this.sdsTimeoutHandler.cancelRecognitionProlongLoopTimer();
        } else {
            this.logChannel.log(-2137614336, "SystemVBIHandler#initializeRecgonitionMode: Prompt active => initiate long recognizer mode!");
            this.speechRecognitionHandler.setExpectedLongRecognitionTimeoutMode(true);
        }
    }

    @Override
    public void updateSpeechRecognitionState(int n) {
        this.speechRecognitionState = n;
        this.startRecognitionProlongDuringPrompt();
        this.abortPromptAtUserUtterance();
    }

    private void abortPromptAtUserUtterance() {
        AbstractSystemCallCommand abstractSystemCallCommand;
        if (this.speechRecognitionState == 5 && this.speechTTSHandler.getTTSPromptRequestsCounter() > 0 && (abstractSystemCallCommand = SDSUtils.getActiveSystemCall()) instanceof SystemStartRecognitionCommand) {
            if (!((SystemStartRecognitionCommand)abstractSystemCallCommand).isCurrentRecognitionStopping()) {
                this.logChannel.log(-2137614336, "SystemVBIHandler#abortPromptAtUserUtterance: User utterance started => abort TTS prompt!");
                this.systemSDSHandler.abortCurrentPrompt((byte)2, false, -1);
            } else {
                this.logChannel.log(1078071040, "SystemVBIHandler#abortPromptAtUserUtterance: User utterance started but recognition already stopping!");
            }
        }
    }

    @Override
    public void stopRecognitionProlongAtPromptEnd() {
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() == 0 && this.speechRecognitionState == 3) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#stopRecognitionProlongAtPromptEnd: Last prompt done => cancel automatic prolonging of recognizer and prolong one last time!");
            this.sdsTimeoutHandler.cancelRecognitionProlongLoopTimer();
            this.speechRecognitionHandler.prolongRecognitionTimeout();
        }
    }

    @Override
    public boolean isTTSFinishAlreadySent() {
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() == 0 && this.speechRecognitionState == 3 && this.checkSendTTSFinishAtPromptRequest() || this.speechTTSHandler.getTTSPromptRequestsCounter() > 0 && this.speechRecognitionState == 1 && this.checkSendTTSFinishAtPromptRequest()) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#isTTSFinishAlreadySent: Last prompt (early TTS-Finish) finished and no user utterance yet => do not send another TTS-finish at end of prompt!");
            return true;
        }
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() > 0 && !this.checkSendTTSFinishAtPromptRequest()) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#isTTSFinishAlreadySent: Last prompt in queue is special prompt (late TTS-Finish) => do not send another TTS-finish event yet!");
            return true;
        }
        return false;
    }

    @Override
    public boolean isRegularPromptAtSessionEndActive() {
        if (this.speechTTSHandler.getTTSPromptRequestsCounter() == 1 && !this.appSDSManager.isAbortEventTriggered()) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#isRegularPromptAtSessionEndActive: Last prompt still enqueued but SDS not aborted => wait for end of current prompt!");
            return true;
        }
        return false;
    }

    @Override
    public boolean informTTSAbortCommandAboutPromptEnd() {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand instanceof SystemTTSAbortCommand) {
            this.logChannel.log(-2137614336, "SystemVBIHandler#informTTSAbortCommandAboutPromptEnd: Prompt ended and TTS aborting => inform SystemTTSAbortCommand about prompt end!");
            ((SystemTTSAbortCommand)abstractSystemCallCommand).currentTTSPromptEnded();
            return true;
        }
        return false;
    }
}

