/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.SDSStorageHandler;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSEventHandler;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.commands.SystemListLineRequestCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDS;
import de.audi.app.sdsmanager.common.SDSListener;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.AbstractSDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.command.CommandList;
import java.util.HashSet;
import java.util.Set;

public class SDSAdapter
implements SDSHandlerService,
SDSListener,
MsgListener,
PowerEventListener {
    private final LogChannel lc = Logger.getMainLog();
    private final SpeechRecognitionHandler speechRecHandler;
    private final AppSDSManager appSDSManager;
    private final SDSHMIListener sdsHMIListener;
    private final SDSAudioHandler sdsAudioHandler;
    private final ISDSDispatcher sdsDispatcher;
    private final SDSStorageHandler storageHandler;
    private final SDSEventHandler sdsEventHandler;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private final SDS javaSDS;
    private boolean beepOn;
    private boolean expertMode;
    private boolean commandScreen;
    private boolean quickMode;
    private boolean voiceBargeIn;
    private float topEntryThreshold;
    private float followupEntryThreshold;
    private boolean sdsReady = false;
    private boolean ttsReady = false;
    private boolean waitingforLanguage = false;
    private boolean pttRunning = false;
    private boolean numberDialingActive = false;
    private boolean removeSDSProgressIconAfterPrompt = true;
    private boolean abortWaitingStateOnCorrection = false;
    private int selectedRow = -1;
    private int selectedModel = -1;
    private boolean onlineRecogResultsInvalid = false;
    private final Object onlineRecogInvalidMutex = new Object();
    private final Set pttDisablers = new HashSet();
    public final Object pttRunningMutex = new Object();
    public final Object syscallMutex = new Object();
    private final IFrameworkAccess frameworkAccess;
    private byte initStep;
    private boolean DDSFlag = false;
    private MsgListener secondarylistener = null;

    public SDSAdapter(IFrameworkAccess iFrameworkAccess, SpeechRecognitionHandler speechRecognitionHandler, AppSDSManager appSDSManager, SDSHMIListener sDSHMIListener, SDSAudioHandler sDSAudioHandler, ISDSDispatcher iSDSDispatcher, SDSTimeoutHandler sDSTimeoutHandler, SDS sDS) {
        this.frameworkAccess = iFrameworkAccess;
        this.sdsDispatcher = iSDSDispatcher;
        this.sdsEventHandler = new SDSEventHandler(this, appSDSManager, sDSTimeoutHandler, iFrameworkAccess.getHMIService(), sDSHMIListener);
        this.storageHandler = new SDSStorageHandler(iFrameworkAccess.getStorageMgr());
        this.speechRecHandler = speechRecognitionHandler;
        this.appSDSManager = appSDSManager;
        this.sdsHMIListener = sDSHMIListener;
        this.sdsAudioHandler = sDSAudioHandler;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.javaSDS = sDS;
        this.initDialogSettingsFromStorage();
        this.lc.log(-2137614336, "SDSAdapter initialized.");
    }

    public void stop() {
        this.lc.log(-2137614336, "SDSAdapter#stop: Resetting status!");
        SDSModelAccess.setSDSReady(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isPttRunning() {
        Object object = this.pttRunningMutex;
        synchronized (object) {
            return this.pttRunning;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPttRunning(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#setPttRunning: running=%1", bl);
        Object object = this.pttRunningMutex;
        synchronized (object) {
            this.pttRunning = bl;
        }
    }

    private void initDialogSettingsFromStorage() {
        this.lc.log(-2137614336, "SDSAdapter#----------------- initDialogSettingsFromStorage: Reading persistence");
        this.commandScreen = this.storageHandler.loadCommandScreen();
        this.expertMode = this.storageHandler.loadExpertMode();
        this.beepOn = this.storageHandler.loadBeepOn();
        this.quickMode = this.storageHandler.loadQuickMode();
        this.voiceBargeIn = this.storageHandler.loadVoiceBargeIn();
        this.topEntryThreshold = this.storageHandler.loadTopEntryThreshold();
        this.followupEntryThreshold = this.storageHandler.loadFollowupEntryThreshold();
        SDSModelAccess.initDialogModels(this.beepOn, this.expertMode, this.quickMode, this.commandScreen, this.voiceBargeIn);
    }

    private void resetDialogSettings() {
        this.lc.log(-2137614336, "SDSAdapter#----------------- resetDialogSettings: store default values");
        this.commandScreen = true;
        this.storageHandler.storeCommandScreen(this.commandScreen);
        this.expertMode = false;
        this.storageHandler.storeExpertMode(this.expertMode);
        this.beepOn = true;
        this.storageHandler.storeBeepOn(this.beepOn);
        this.quickMode = false;
        this.storageHandler.storeQuickMode(this.quickMode);
        this.voiceBargeIn = true;
        this.storageHandler.storeVoiceBargeIn(this.voiceBargeIn);
        this.topEntryThreshold = -842216387;
        this.storageHandler.storeTopEntryThreshold(this.topEntryThreshold);
        this.followupEntryThreshold = 181871421;
        this.storageHandler.storeFollowupEntryThreshold(this.followupEntryThreshold);
        SDSModelAccess.initDialogModels(this.beepOn, this.expertMode, this.quickMode, this.commandScreen, this.voiceBargeIn);
    }

    private static boolean isPauseRelatedResponse(int n) {
        return n == 3003 || n == 3002;
    }

    private static boolean isWaitingRelatedResponse(int n) {
        return n == 3011 || n == 3010;
    }

    public void setRecognitionMode(int n) {
        this.speechRecHandler.setRecognitionMode(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void sendResult(int n) {
        CommandList commandList = SDSManagerBaseActivator.getSysCallCmdListManager().getActiveCommandList();
        if (commandList == null) {
            this.lc.log(-1601830656, "SDSAdapter#sendResult: No active system call command list for responseID=%1 => syncing on syscallMutex!", (long)n);
        }
        Object object = commandList != null ? commandList : this.syscallMutex;
        synchronized (object) {
            this.sdsTimeoutHandler.resetSysCallTimer();
            if (this.isSDSPaused() && !this.isSDSAborting() && !SDSAdapter.isPauseRelatedResponse(n) && !SDSAdapter.isWaitingRelatedResponse(n)) {
                this.lc.log(-2137614336, "SDSAdapter#sendResult: Ignoring responseID %1 during pause!", (long)n);
                return;
            }
            if (this.isSDSWaiting() && !this.isSDSAborting() && !SDSAdapter.isWaitingRelatedResponse(n) && !SDSAdapter.isPauseRelatedResponse(n)) {
                this.lc.log(-2137614336, "SDSAdapter#sendResult: Ignoring responseID %1 during waiting state!", (long)n);
                return;
            }
            this.javaSDS.sendEvent(n, false);
            this.lc.log(-2137614336, "SDSAdapter#sendResult: Sent responseID %1!", (long)n);
        }
    }

    @Override
    public void switchEntertainment(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#switchEntertainment: switchOn=%1", bl);
        this.sdsAudioHandler.setKeepDownlink(!bl);
    }

    @Override
    public boolean isSDSPaused() {
        return this.appSDSManager.isSDSPauseStateActive() || this.sdsEventHandler.isSDSPauseEventSent();
    }

    @Override
    public boolean isSDSWaiting() {
        return this.appSDSManager.isSDSWaitStateActive();
    }

    @Override
    public boolean isExternalSDSRequested() {
        return this.appSDSManager.isExternalSDSRequested();
    }

    @Override
    public synchronized void disablePTT(boolean bl, boolean bl2, byte by) {
        Byte by2 = new Byte(by);
        this.lc.log(-2137614336, "SDSAdapter#disablePTT: status=%1, forceAbort=%2, disableCaller=%3", bl, (Object)bl2, (Object)by2);
        byte by3 = this.getTopPTTDisabler(by2, bl);
        boolean bl3 = by3 != 0;
        this.lc.log(-2137614336, "SDSAdapter#disablePTT: topDisabler=%2, disableStatus=%1", bl3, (long)by3);
        this.appSDSManager.setPttBlocked(by3);
        if (!bl3 && !bl) {
            return;
        }
        this.sdsHMIListener.updateSDSCombiState(!bl3, by3);
        if (!bl3) {
            return;
        }
        if (bl2) {
            boolean bl4 = by != 2 && by != 9;
            this.lc.log(-2137614336, "SDSAdapter#disablePTT: forceAbort=true, aborting session%1!", (Object)(bl4 ? " silently" : ""));
            this.appSDSManager.abortSDSSession(bl4);
            return;
        }
        if (this.isSDSNumberDialingActive()) {
            this.lc.log(-2137614336, "SDSAdapter#disablePTT: Number dialing active, NOT aborting session!");
            return;
        }
        if (this.isSDSPaused()) {
            this.lc.log(-2137614336, "SDSAdapter#disablePTT: SDS paused, NOT aborting session!");
            return;
        }
        if (this.isSDSWaiting()) {
            this.lc.log(-2137614336, "SDSAdapter#disablePTT: SDS in waiting state, aborting session!");
        }
        if (SDSModelAccess.getPosttrainingActiveValue() == 1) {
            this.lc.log(-2137614336, "SDSAdapter#disablePTT: PTT blocked, posttraining active, aborting it!");
            this.abortPostTraining();
        }
        this.lc.log(-2137614336, "SDSAdapter#disablePTT: PTT blocked, aborting session silently!");
        this.appSDSManager.abortSDSSession(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final byte getTopPTTDisabler(Byte by, boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#getTopPTTDisabler: disabler=%2, status=%1", bl, (Object)by);
        boolean bl2 = bl;
        Set set = this.pttDisablers;
        synchronized (set) {
            if (bl2) {
                this.pttDisablers.add(by);
            } else {
                this.pttDisablers.remove(by);
                bl2 = !this.pttDisablers.isEmpty();
            }
            this.lc.log(-2137614336, "SDSAdapter#getTopPTTDisabler: disableStatus=%1, pttDisablers=%2, pttDisablerPrio=%3!", bl2, (Object)this.pttDisablers, (Object)AbstractSDSService.pttDisablerPrio);
            if (!bl2) {
                return 0;
            }
            int n = AbstractSDSService.pttDisablerPrio.length;
            for (int i2 = 0; i2 < n; ++i2) {
                Byte by2 = new Byte(AbstractSDSService.pttDisablerPrio[i2]);
                if (!this.pttDisablers.contains(by2)) continue;
                return by2;
            }
        }
        this.lc.log(-1601830656, "SDSAdapter#getTopPTTDisabler: No match for pttDisablers found in priority list, returning disabler!", (Object)by);
        return by;
    }

    @Override
    public boolean isPTTDisabled() {
        boolean bl = this.appSDSManager.isPTTBlocked();
        this.lc.log(-2137614336, "isPTTDisabled: PTT is%1 disabled!", (Object)(bl ? "" : " not"));
        return bl;
    }

    @Override
    public void abortPostTraining() {
        this.sendEvent(1004);
    }

    @Override
    public boolean isSDSActive() {
        boolean bl = this.appSDSManager.isSDSActive();
        this.lc.log(14808325, "SDSAdapter#isSDSActive: SDS session is %1active!", (Object)(bl ? "" : "in"));
        return bl;
    }

    @Override
    public int resetSelectedRow() {
        int n = this.selectedRow;
        this.lc.log(-2137614336, "SDSAdapter#resetSelectedRow: row=%1 => -1!", (long)n);
        this.selectedRow = -1;
        this.selectedModel = -1;
        SDSModelAccess.setEnumerationNumberStatus(-1);
        SDSModelAccess.setEnumerationNumberValue(0);
        return n;
    }

    @Override
    public int getSelectedRow() {
        return this.selectedRow;
    }

    @Override
    public void setSelectedRow(int n) {
        this.lc.log(-2137614336, "SDSAdapter#setSelectedRow: row=%1!", (long)n);
        this.selectedRow = n;
        this.selectedModel = -1;
    }

    @Override
    public int getSelectedModel() {
        return this.selectedModel;
    }

    @Override
    public void setSelectedModel(int n) {
        this.selectedModel = n;
    }

    @Override
    public boolean isSDSVolumeSettingActive() {
        return this.sdsEventHandler.isVolumeSettingActive();
    }

    @Override
    public void setSDSVolumeSettingActive(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#setSDSVolumeSettingActive: Setting volume setting to %1active!", (Object)(bl ? "" : "not "));
        this.sdsEventHandler.setVolumeSettingActive(bl);
    }

    @Override
    public void sendDDSEvent(int n, int n2) {
        this.lc.log(-2137614336, "SDSAdapter#sendDDSEvent: eventMappingID=%1", (long)n);
        boolean bl = SDSAdapter.isVBIItemSelectedSystemCall();
        this.handleLeavingWaitingState();
        this.handleWaitingSystemCalls();
        if (bl) {
            this.sendEvent(n, true);
        } else {
            this.sendEvent(n);
        }
    }

    private static boolean isVBIItemSelectedSystemCall() {
        AbstractSystemCallCommand abstractSystemCallCommand;
        return SDSModelAccess.isVoiceBargeInActive() && (abstractSystemCallCommand = SDSUtils.getActiveSystemCall()) instanceof SystemListLineRequestCommand;
    }

    private void handleWaitingSystemCalls() {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand != null && abstractSystemCallCommand.finishWaitingCommandOnDDS()) {
            this.sdsTimeoutHandler.resetSysCallTimer();
        }
    }

    @Override
    public void sendEvent(int n) {
        this.lc.log(-2137614336, "SDSAdapter#sendEvent: eventMappingID=%1!", (long)n);
        this.sendEvent(n, false);
    }

    private void sendEvent(int n, boolean bl) {
        this.sdsEventHandler.sendSDSEvent(n, bl);
    }

    @Override
    public void sendResumeEvent(boolean bl) {
        this.sdsEventHandler.sendSDSResumeEvent(bl);
    }

    @Override
    public void sendSpeechSMEvent(int n, boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSAdapter#sendSpeechSMEvent: eventID=%3, direct=%1, checkAbort=%2", (Object)bl, (Object)bl2, (long)n);
        if (this.isSDSPaused() || this.isSDSWaiting()) {
            this.sdsTimeoutHandler.cancelEventTimer();
            this.lc.log(-1601830656, "SDSAdapter#sendSpeechSMEvent: SDS paused or in waiting state, rejecting speech event %1!", (long)n);
            return;
        }
        this.sdsEventHandler.sendSpeechSMEvent(n, bl, bl2);
    }

    @Override
    public void sendDDSSpeechSMEvent(int n) {
        this.lc.log(-2137614336, "SDSAdapter#sendDDSSpeechSMEvent: eventID=%1", (long)n);
        boolean bl = SDSAdapter.isVBIItemSelectedSystemCall();
        this.handleLeavingWaitingState();
        this.handleWaitingSystemCalls();
        if (bl) {
            this.sdsEventHandler.sendSpeechSMEvent(n, true, false);
        } else {
            this.sdsEventHandler.sendSpeechSMEvent(n, true, true);
        }
    }

    @Override
    public void handleLeavingWaitingState() {
        if (!this.isSDSWaiting()) {
            return;
        }
        this.lc.log(-2137614336, "SDSAdapter#handleLeavingWaitingState: called");
        this.sdsTimeoutHandler.cancelEventTimer();
        this.appSDSManager.triggerSDSWaitState(false, true);
    }

    @Override
    public void handleLeavingPauseState() {
        if (!this.isSDSPaused()) {
            return;
        }
        this.lc.log(-2137614336, "SDSAdapter#handleLeavingPauseState: called");
        this.sdsTimeoutHandler.cancelEventTimer();
        this.appSDSManager.triggerSDSPauseState(false, true);
    }

    @Override
    public void sendResultEvent(int n) {
        this.sendResultEvent(n, true);
    }

    @Override
    public void sendResultEvent(int n, boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#sendResultEvent: eventID=%2; checkAbort=%1", bl, (long)n);
        this.sdsTimeoutHandler.resetSysCallTimer();
        this.sendSpeechSMEvent(n, true, bl);
    }

    @Override
    public void abortSDSSession(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#abortSDSSession: silent=%1", bl);
        this.appSDSManager.abortSDSSession(bl);
    }

    @Override
    public void triggerPauseStateAbortTimer(boolean bl) {
        this.sdsEventHandler.triggerPauseStateAbortTimer(bl);
    }

    @Override
    public void triggerWaitStateAbortTimer(boolean bl) {
        this.sdsEventHandler.triggerWaitStateAbortTimer(bl);
    }

    @Override
    public void turnDDSWheel() {
        this.lc.log(-2137614336, "SDSAdapter#turnDDSWheel: called!");
        this.sdsTimeoutHandler.restartRecognizerProlongOnceTimer();
    }

    @Override
    public void movedDDSJoystick(JoystickEvent joystickEvent) {
        this.sdsHMIListener.movedDDSJoystick(joystickEvent);
    }

    public void abortSession(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#abortSession: silent=%1", bl);
        if (SDSModelAccess.getSDSStatusValue() != 8) {
            SDSModelAccess.setSDSStatus(0);
        }
        this.lc.log(-2137614336, "SDSAdapter#abortSession: sdsStatusChoice.value=%1, SDS status bar initialized!", (long)SDSModelAccess.getSDSStatusValue());
        this.sendEvent(SDSModelAccess.getPosttrainingActiveValue() == 1 ? 1004 : (bl ? 1002 : 1001));
    }

    public void sendPTTEvent() {
        this.lc.log(-2137614336, "SDSAdapter#sendPTTEvent: called");
        this.sdsTimeoutHandler.restartPTTRunningTimer();
        this.sendEvent(1);
    }

    public boolean isSDSWaitingForLanguage() {
        return this.waitingforLanguage;
    }

    private void resetSDS() {
        this.lc.log(-2137614336, "SDSAdapter#resetSDS: called");
        this.resetDialogSettings();
        this.speechRecHandler.deleteProfile(235);
        this.speechRecHandler.restoreFactorySettings();
    }

    @Override
    public boolean isSDSAborting() {
        return this.appSDSManager.isSDSAborting();
    }

    public boolean isSDSEnding() {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand == null) {
            return false;
        }
        return abstractSystemCallCommand.isSDSSessionEndCommand();
    }

    public int getActiveEventMappingID() {
        return this.sdsEventHandler.getEventMappingID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processCommand(ISystemCall iSystemCall) {
        this.lc.log(-2137614336, "SDSAdapter#processCommand: systemCall=%1", (Object)iSystemCall);
        ISDSApplication iSDSApplication = this.sdsDispatcher.determineSyscallHandler(iSystemCall);
        if (iSDSApplication == null) {
            this.sendResult(3001);
            return;
        }
        CommandList commandList = SDSManagerBaseActivator.getSysCallCmdListManager().getActiveCommandList();
        if (commandList == null) {
            this.lc.log(-1601830656, "SDSAdapter#processCommand: No active system call command list for systemCall=%1 => syncing on syscallMutex!", (Object)iSystemCall);
        }
        Object object = commandList != null ? commandList : this.syscallMutex;
        synchronized (object) {
            this.sdsDispatcher.checkAbortCurrentCommand(iSystemCall);
        }
        this.sdsTimeoutHandler.cancelPTTRunningTimer();
        if (iSystemCall.requiresResponse()) {
            int n = iSystemCall.getId();
            this.sdsTimeoutHandler.cancelEventTimer();
            this.sdsTimeoutHandler.restartSysCallTimer(n);
        }
        iSDSApplication.processCommand(iSystemCall.getId(), iSystemCall.getParameters());
    }

    public void updateSDSState(byte by) {
        this.lc.log(-2137614336, "SDSAdapter#updateSDSState: sdsState=%1", (long)by);
        switch (by) {
            case 0: {
                this.lc.log(-2137614336, "SDSAdapter#updateSDSState: sdsState update SDS_NOT_READY!");
                this.setWaitingforLanguage(false);
                SDSModelAccess.setSDSReady(0);
                this.sdsHMIListener.updateSDSCombiState(false, (byte)1);
                break;
            }
            case 4: {
                this.lc.log(-2137614336, "SDSAdapter#updateSDSState: sdsState update SDS_LANGUAGE_LOADING!");
                this.setWaitingforLanguage(true);
                SDSModelAccess.setSDSReady(0);
                this.sdsHMIListener.updateSDSCombiState(false, (byte)6);
                break;
            }
            case 2: {
                this.lc.log(-2137614336, "SDSAdapter#updateSDSState: sdsState update SDS_NO_LANGUAGE!");
                this.setWaitingforLanguage(true);
                SDSModelAccess.setSDSReady(0);
                this.sdsHMIListener.updateSDSCombiState(false, (byte)7);
                break;
            }
            case 3: {
                this.lc.log(-2137614336, "SDSAdapter#updateSDSState: sdsState update SDS_NO_TTS!");
                this.setWaitingforLanguage(false);
                SDSModelAccess.setSDSReady(0);
                break;
            }
            case 1: {
                if (!this.sdsReady) {
                    this.lc.log(-2137614336, "SDSAdapter#updateSDSState: TTS ready, but SDS not ready (yet)!");
                    return;
                }
                if (!this.ttsReady) {
                    this.lc.log(-2137614336, "SDSAdapter#updateSDSState: SDS ready, but TTS not ready (yet)!");
                    return;
                }
                this.setWaitingforLanguage(false);
                SDSModelAccess.setSDSStatus(0);
                this.lc.log(-2137614336, "SDSAdapter#updateSDSState: SDS and TTS ready, sdsStatusChoice.value=%1, SDS status bar initialized!", (long)SDSModelAccess.getSDSStatusValue());
                SDSModelAccess.setSDSReady(1);
                this.sdsHMIListener.updateSDSCombiState(true, (byte)6);
                this.frameworkAccess.getStartupMgr().logStartupEvent("[Startup SDS] Phase 5: SDS available!");
                break;
            }
            default: {
                this.lc.log(10000, "SDSAdapter#updateSDSState: Unhandled sdsState %1!", (long)by);
            }
        }
    }

    @Override
    public void processMsg(int n) {
        if (this.secondarylistener != null) {
            this.secondarylistener.processMsg(n);
        }
        switch (n) {
            case 25: {
                this.lc.log(-2137614336, "SDSAdapter#processMessage: Resetting SDS settings!");
                this.resetSDS();
                break;
            }
            case 11: {
                this.lc.log(-2137614336, "SDSAdapter#processMessage: Units changed!");
                break;
            }
            default: {
                return;
            }
        }
    }

    public boolean isSDSAndTTSReady() {
        boolean bl;
        boolean bl2 = bl = SDSModelAccess.getSDSReady() == 1;
        if (!bl) {
            this.lc.log(-2137614336, "SDSAdapter#isSDSAndTTSReady: sdsReady=%1!", (Object)(this.sdsReady ? "true" : "false"));
            if (!this.sdsReady) {
                this.lc.log(-2137614336, "SDSAdapter#isSDSAndTTSReady: isWaitingForLanguage=%1!", (Object)(this.isSDSWaitingForLanguage() ? "true" : "false"));
            }
            if (this.initStep != 9) {
                this.lc.log(-1601830656, "SDSAdapter#isSDSAndTTSReady: initialization incomplete=%1!", (Object)this.getInitializationStatus());
            }
            this.lc.log(-2137614336, "SDSAdapter#isSDSAndTTSReady: ttsReady=%1!", (Object)(this.ttsReady ? "true" : "false"));
        }
        return bl;
    }

    public void removeSDSProgressIcon() {
        this.sdsTimeoutHandler.cancelProgressIconTimer();
        SDSModelAccess.setProgressIconVisible(0);
    }

    public boolean checkSDSProgressIconRemovalAfterPrompt() {
        if (this.removeSDSProgressIconAfterPrompt) {
            this.removeSDSProgressIcon();
        }
        return this.removeSDSProgressIconAfterPrompt;
    }

    public void setSDSProgressIconRemovalAfterPrompt(boolean bl) {
        this.removeSDSProgressIconAfterPrompt = bl;
    }

    public void setInitializationStep(byte by) {
        this.initStep = by;
    }

    public String getInitializationStatus() {
        switch (this.initStep) {
            case 0: {
                return "Initialization started";
            }
            case 1: {
                return "DSI initialization";
            }
            case 2: {
                return "Language set";
            }
            case 3: {
                return "N-best slot list set";
            }
            case 4: {
                return "N-best command list set";
            }
            case 6: {
                return "DB partition checked";
            }
            case 7: {
                return "Languages enabled";
            }
            case 8: {
                return "Grammars to be loaded";
            }
            case 9: {
                return "Initialization successful";
            }
        }
        return "State unknown";
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.lc.log(-2137614336, "SDSAdapter#notifyPowerListenerOnEnterState: pwrevt=%1", (long)n);
        switch (n) {
            case 2: {
                this.lc.log(-2137614336, "SDSAdapter#notifyPowerListenerOnEnterState: Standby reached, aborting SDS session silently!");
                this.appSDSManager.abortSDSSession(true);
                break;
            }
            default: {
                this.lc.log(-1601830656, "SDSAdapter#notifyPowerListenerOnEnterState: Unhandled event %1!", (long)n);
            }
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.lc.log(-2137614336, "SDSAdapter#notifyPowerListenerOnEnterState: pwrevt=%1", (long)n);
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
        this.lc.log(-2137614336, "SDSAdapter#notifyPowerTriggerAction: trigger=%1", (long)n);
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.lc.log(-2137614336, "SDSAdapter#updateClampState: called");
    }

    @Override
    public boolean isBeepOn() {
        return this.beepOn;
    }

    @Override
    public boolean isExpertMode() {
        return this.expertMode;
    }

    @Override
    public boolean isQuickMode() {
        return this.quickMode;
    }

    @Override
    public boolean isCommandScreen() {
        return this.commandScreen;
    }

    @Override
    public boolean isVoiceBargeIn() {
        return this.voiceBargeIn;
    }

    public void setWaitingforLanguage(boolean bl) {
        if (this.waitingforLanguage != bl) {
            this.waitingforLanguage = bl;
            this.lc.log(-2137614336, "SDSAdapter#setWaitingforLanguage: waitingforLanguage=%1", this.waitingforLanguage);
        }
    }

    public void changeBeepOn(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#changeBeepOn: beep on value changed to %1", bl);
        this.beepOn = bl;
        this.storageHandler.storeBeepOn(bl);
    }

    public void changeExpertMode(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#changeExpertMode: export mode value changed to %1", bl);
        this.expertMode = bl;
        this.storageHandler.storeExpertMode(bl);
    }

    public void changeQuickMode(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#changeQuickMode: quick mode value changed to %1", bl);
        this.quickMode = bl;
        this.storageHandler.storeQuickMode(bl);
    }

    public void changeCommandScreen(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#changeCommandScreen: command screen value changed to %1", bl);
        this.commandScreen = bl;
        this.storageHandler.storeCommandScreen(bl);
    }

    public void changeVoiceBargeIn(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#changeVoiceBargeIn: voice barge in value changed to %1", bl);
        this.voiceBargeIn = bl;
        this.storageHandler.storeVoiceBargeIn(bl);
    }

    SDS getJavaSDS() {
        return this.javaSDS;
    }

    public SDSEventHandler getEventHandler() {
        return this.sdsEventHandler;
    }

    public void setSDSReady(boolean bl) {
        this.sdsReady = bl;
        this.lc.log(-2137614336, "[SDSAdapter.setSDSReady] %1", (Object)(this.sdsReady ? "READY" : "NOT READY"));
        this.updateSDSState(this.sdsReady ? (byte)1 : 0);
    }

    public void setTTSReady(boolean bl) {
        this.ttsReady = bl;
        this.lc.log(-2137614336, "SDSAdapter#setTTSReady: ttsReady=%1", this.ttsReady);
        this.updateSDSState(this.ttsReady ? (byte)1 : 3);
    }

    public void setFactory(SDSAppFactory sDSAppFactory) {
        this.sdsEventHandler.setFactory(sDSAppFactory);
    }

    public boolean isSDSNumberDialingActive() {
        return this.numberDialingActive;
    }

    @Override
    public void setSDSNumberDialingActive(boolean bl) {
        this.lc.log(-2137614336, "SDSAdapter#setSDSNumberDialingActive: active=%1", bl);
        this.numberDialingActive = bl;
    }

    @Override
    public void cancelTimers() {
        this.sdsTimeoutHandler.cancelTTSTimer();
    }

    @Override
    public void setAbortWaitingStateOnCorrection(boolean bl) {
        this.abortWaitingStateOnCorrection = bl;
    }

    @Override
    public boolean isAbortWaitingStateOnCorrection() {
        return this.abortWaitingStateOnCorrection;
    }

    @Override
    public void resetEventID() {
        this.sdsEventHandler.setEventMappingID(-1);
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.frameworkAccess;
    }

    @Override
    public boolean getDDSFlag() {
        return this.DDSFlag;
    }

    @Override
    public void setDDSFlag(boolean bl) {
        this.DDSFlag = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isOnlineRecogResultsInvalid() {
        Object object = this.onlineRecogInvalidMutex;
        synchronized (object) {
            return this.onlineRecogResultsInvalid;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setOnlineRecogResultsInvalid(boolean bl) {
        Object object = this.onlineRecogInvalidMutex;
        synchronized (object) {
            this.onlineRecogResultsInvalid = bl;
        }
    }

    public void setSecondaryMsgHandler(MsgListener msgListener) {
        this.secondarylistener = msgListener;
    }

    public void changeTopEntryThreshold(float f2) {
        this.lc.log(-2137614336, "SDSAdapter#changeTopEntryThreshold: top entry threshold value changed to %1", (double)f2);
        this.topEntryThreshold = f2;
        this.storageHandler.storeTopEntryThreshold(f2);
    }

    public float getTopEntryThreshold() {
        return this.topEntryThreshold;
    }

    public void changeFollowupEntryThreshold(float f2) {
        this.lc.log(-2137614336, "SDSAdapter#changeFollowupEntryThreshold: follow up entry threshold value changed to %1", (double)f2);
        this.followupEntryThreshold = f2;
        this.storageHandler.storeFollowupEntryThreshold(f2);
    }

    public float getFollowupEntryThreshold() {
        return this.followupEntryThreshold;
    }
}

