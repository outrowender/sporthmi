/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.PlayPrioPromptCallback;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.VolumeSettingSessionCallback;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.system.commands.SystemStartRecognitionCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.ISDSKeyInterceptor;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class SDSServiceImpl
implements SDSService,
TimerListener {
    private final LogChannel lc = Logger.getMainLog();
    protected final AppSDSManager sdsManager;
    protected final SDSHandlerService sdsAdapter;
    private final SpeechTTSHandler ttsHandler;
    protected final SDSAppFactory factory;
    private final MobileSpeechRecognitionHandler mobileSRHandler;
    protected final HMIService hmi;
    private final Timer returnKeyTimer = new Timer("SDSReturnKeyTimer", 5, this.lc, this, 1000L, true);

    public SDSServiceImpl(AppSDSManager appSDSManager, SDSHandlerService sDSHandlerService, HMIService hMIService, SpeechTTSHandler speechTTSHandler, SDSAppFactory sDSAppFactory, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler) {
        this.sdsManager = appSDSManager;
        this.sdsAdapter = sDSHandlerService;
        this.ttsHandler = speechTTSHandler;
        this.factory = sDSAppFactory;
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
        this.hmi = hMIService;
        this.lc.log(10000000, "SDSServiceImpl initialized.");
    }

    public void abortPostTraining() {
        this.lc.log(10000000, "SDSServiceImpl#abortPostTraining: called");
        this.sdsAdapter.abortPostTraining();
    }

    public void abortSDSSession(boolean bl, byte by) {
        String string;
        switch (by) {
            case -1: {
                string = "NONE";
                break;
            }
            case 0: {
                string = "VOICE";
                break;
            }
            case 4: {
                string = "ADB";
                break;
            }
            case 1: {
                string = "PARKING";
                break;
            }
            case 2: {
                string = "KEYBOARD";
                break;
            }
            case 5: {
                string = "MEDIA";
                break;
            }
            case 6: {
                string = "NAVI";
                break;
            }
            case 7: {
                string = "PHONE";
                break;
            }
            case 8: {
                string = "TUNER";
                break;
            }
            case 3: {
                string = "WIDGET";
                break;
            }
            case 9: {
                string = "VOLUME";
                break;
            }
            case 10: {
                string = "ONLINE";
                break;
            }
            case 11: {
                string = "POPUP";
                break;
            }
            case 12: {
                string = "PTT DOUBLE";
                break;
            }
            case 13: {
                string = "PTT LONG";
                break;
            }
            default: {
                string = "UNK";
            }
        }
        this.lc.log(10000000, "SDSServiceImpl#abortSDSSession: Aborted by %2, silent=%1!", bl, (Object)string);
        SDSModelAccess.setSDSAborterType(by);
        if (by == 2 && this.sdsManager.isSDSWaitStateActive()) {
            this.lc.log(10000000, "SDSServiceImpl#abortSDSSession: HK-Abort during waiting state -> silent abort!", (Object)string);
            this.sdsManager.abortSDSSession(true);
        } else if (by == 2 && this.sdsAdapter.isSDSVolumeSettingActive()) {
            this.lc.log(10000000, "SDSServiceImpl#abortSDSSession: Abort during volume session but aborter is Keyboard -> NOP!", (Object)string);
        } else {
            this.sdsManager.abortSDSSession(bl);
        }
    }

    public boolean startDDSPress() {
        return this.sdsAdapter.isSDSActive();
    }

    public void cancelDDSPress() {
    }

    public void endDDSPress() {
    }

    public void turnDDSWheel() {
        this.sdsAdapter.turnDDSWheel();
    }

    public void movedDDSJoystick(JoystickEvent joystickEvent) {
        this.sdsAdapter.movedDDSJoystick(joystickEvent);
    }

    public void disablePTT(boolean bl, boolean bl2, byte by) {
        this.lc.log(10000000, "SDSServiceImpl#disablePTT: status=%1, forceAbort=%2, disabler=%3", bl, (Object)bl2, (Object)new Byte(by));
        this.sdsAdapter.disablePTT(bl, bl2, by);
    }

    public void sendResult(int n) {
        this.lc.log(10000000, "SDSServiceImpl#sendResult: responseID=%1, finishing active systemcall!", (long)n);
        try {
            SDSUtils.getActiveSystemCall().processingFinished();
        }
        catch (ClassCastException classCastException) {
            this.lc.log(10000, "SDSServiceImpl#sendResult: Active command is no AbstractSystemCallCommand!");
        }
        catch (NullPointerException nullPointerException) {
            this.lc.log(10000, "SDSServiceImpl#sendResult: NullpointerException. No active systemcall!");
        }
        this.sdsAdapter.sendResult(n);
    }

    public void itemSelected(int n, int n2) {
        this.lc.log(10000000, "SDSServiceImpl#itemSelected: modelID=%1, row=%2", (long)n, (long)n2);
        this.lc.log(10000000, "SDSServiceImpl#itemSelected: enumStatus=%1, enumValue=%2", (long)SDSModelAccess.getEnumerationNumberStatus(), (long)SDSModelAccess.getEnumerationNumberValue());
        if (this.sdsManager.isSDSAborting()) {
            this.lc.log(10000000, "SDSServiceImpl#itemSelected: SDS already aborting -> do not send event!");
            return;
        }
        this.sdsAdapter.setSelectedRow(n2);
        this.sdsAdapter.setSelectedModel(n);
        if (SDSUtils.isPicklistModel(n)) {
            SDSUtils.lockPicklistModel(n, this.hmi.getBaseListModel(n), this.hmi, this.lc);
            this.sdsAdapter.sendDDSEvent(1000, n2);
            return;
        }
        this.treatOtherModels(n, n2);
    }

    protected void treatOtherModels(int n, int n2) {
        int n3 = SDSManagerBaseActivator.getMapping().getModelMappingID(n);
        this.lc.log(10000000, "SDSServiceImpl#treatOtherModels: modelMappingID=%1!", (long)n3);
        switch (n3) {
            case 10: 
            case 11: {
                this.factory.getSDSHandlerADB().handleItemSelectionInAdbList(n, n2);
                break;
            }
        }
        this.sdsAdapter.sendDDSEvent(1000, n2);
    }

    public void itemSelected(int n, int n2, int n3) {
        this.lc.log(10000000, "SDSServiceImpl#itemSelected: modelID=%1, absoluteRow=%2, relativeRow=%3", (long)n, (long)n2, (long)n3);
        SDSModelAccess.setEnumerationNumberStatus(n2);
        SDSModelAccess.setEnumerationNumberValue(n3);
        this.itemSelected(n, n2);
    }

    public void folderUpSelected() {
        this.lc.log(10000000, "SDSServiceImpl#folderUpSelected");
        this.sdsAdapter.sendEvent(1007);
    }

    public void keyTyped(int n, int n2) {
        this.lc.log(10000000, "SDSServiceImpl#keyTyped: modelID=%1, ruleID=%2", (long)n, (long)n2);
        if (this.sdsManager.isSDSAborting()) {
            this.lc.log(10000000, "SDSServiceImpl#keyTyped: SDS already aborting -> do not send event!");
            return;
        }
        int n3 = SDSManagerBaseActivator.getMapping().getEventIdForRule(n2);
        this.lc.log(10000000, "SDSServiceImpl#keyTyped: eventID=%1!", (long)n3);
        int n4 = SDSManagerBaseActivator.getMapping().getRemoteHMILineNumberForEvent(n3);
        if (n4 != Integer.MIN_VALUE) {
            this.factory.getSDSHandlerRemoteHMI().setSelectedHelpLine(n4);
            n3 = SDSManagerBaseActivator.getMapping().getEventID(1020);
        } else {
            this.factory.getSDSHandlerRemoteHMI().setSelectedHelpLine(-1);
        }
        this.sdsAdapter.sendDDSSpeechSMEvent(n3);
    }

    public boolean isSDSAborting() {
        return this.sdsAdapter.isSDSAborting();
    }

    public boolean isSDSActive() {
        boolean bl = this.sdsAdapter.isSDSActive();
        this.lc.log(10000000, "SDSServiceImpl#isSDSActive: active=%1!", bl);
        return bl;
    }

    public void registerStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        this.lc.log(10000000, "SDSServiceImpl#registerStatusListener: add SDS-status listener %1!", (Object)iSDSServiceStatusListener.getClass().getName());
        this.sdsManager.registerStatusListener(iSDSServiceStatusListener);
        if (iSDSServiceStatusListener instanceof ISDSKeyInterceptor) {
            this.sdsManager.registerSDSKeyInterceptor(iSDSServiceStatusListener);
        }
    }

    public void unregisterStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        this.lc.log(10000000, "SDSServiceImpl#unregisterStatusListener: remove SDS-status listener %1!", (Object)iSDSServiceStatusListener.getClass().getName());
        this.sdsManager.unregisterStatusListener(iSDSServiceStatusListener);
        if (iSDSServiceStatusListener instanceof ISDSKeyInterceptor) {
            this.sdsManager.unregisterSDSKeyInterceptor(iSDSServiceStatusListener);
        }
    }

    public void playPrioPrompt(String string) {
        if (SDSUtils.getActiveSystemCall() instanceof SystemStartRecognitionCommand) {
            ((SystemSDSHandlerImpl)this.factory.getSDSHandlerSystem()).setPlayPrioPromptCallback(new PlayPrioPromptCallback(this, string));
            this.lc.log(10000000, "SDSServiceImpl#playPrioPrompt: current command is recognition, wait until processed", (Object)string);
            this.sdsAdapter.sendSpeechSMEvent(1012, false, true);
            return;
        }
        this.lc.log(10000000, "SDSServiceImpl#playPrioPrompt: text=%1", (Object)string);
        this.ttsHandler.playText(string);
    }

    public void cancelTimers() {
        this.sdsAdapter.cancelTimers();
    }

    public void returnKeyPressed() {
        if (this.returnKeyTimer.isRunning()) {
            this.lc.log(10000000, "SDSServiceImpl#returnKeyPressed: Doublepress recognized, aborting session!");
            this.returnKeyTimer.cancel();
            this.sdsAdapter.abortSDSSession(false);
            return;
        }
        this.lc.log(10000000, "SDSServiceImpl#returnKeyPressed: Singlepress recognized, restarting timer!");
        this.returnKeyTimer.restart();
    }

    public void startVolumeSettingSession() {
        this.lc.log(10000000, "SDSServiceImpl#startVolumeSettingSession: called");
        if (this.isVolumeSettingSessionActive()) {
            if (this.isSDSAborting()) {
                this.lc.log(10000000, "SDSServiceImpl#startVolumeSettingSession: SDS is aborting! We have to wait.");
                this.sdsManager.setCallback(new VolumeSettingSessionCallback(this));
            } else {
                this.lc.log(10000000, "SDSServiceImpl#startVolumeSettingSession: volume setting session is already active -> NOP!");
            }
        } else {
            this.disablePTT(true, true, (byte)5);
            this.sdsAdapter.sendEvent(4);
        }
    }

    public void stopVolumeSettingSession() {
        this.disablePTT(false, true, (byte)5);
        this.abortSDSSession(true, (byte)9);
    }

    public void textChanged(int n, String string, char c2) {
        this.lc.log(10000000, "SDSServiceImpl#textChanged: modelID=%2, modelString=%1, lastCharacter=%3", (Object)string, (long)n, (long)c2);
        switch (n) {
            case 300205: {
                this.factory.getSDSHandlerPhone().matchTextWithNumberSequenceDirect(string);
                break;
            }
            case 301156: {
                this.factory.getSDSHandlerPhone().matchTextWithMailboxSequenceDirect(string);
                break;
            }
            case 300594: {
                this.factory.getSDSHandlerPhone().matchTextWithPINSequenceDirect(string);
                break;
            }
            default: {
                this.lc.log(100000, "SDSServiceImpl#textChanged: Unhandled modelID %1, checking for modelMappingID!", (long)n);
            }
        }
        int n2 = SDSManagerBaseActivator.getMapping().getModelMappingID(n);
        this.lc.log(10000000, "SDSServiceImpl#textChanged: modelMappingID=%1!", (long)n2);
        switch (n2) {
            case 1: {
                this.factory.getSDSHandlerPhone().matchTextWithNumberSequenceDirect(string);
                break;
            }
            default: {
                this.lc.log(100000, "SDSServiceImpl#textChanged: Unhandled modelMappingID %1!", (long)n2);
            }
        }
    }

    public boolean isExternalSDSActive() {
        boolean bl = this.mobileSRHandler.isMobileSpeechRecognitionActive();
        this.lc.log(10000000, "SDSServiceImpl#isExternalSDSActive: mobileSRActive=%1", bl);
        return bl;
    }

    public void screenConnected(int n, int n2, boolean bl) {
        this.lc.log(10000000, "SDSServiceImpl#screenConnected: screenID=%1, terminalID=%2, isScrollable=%3", (long)n, (long)n2, bl);
        this.sdsManager.updateConnectedScreenScrollable(n, n2, bl);
    }

    public void screenConnectedWithSDSData(int n, int n2, SDSService.ScreenConnectedSDSData screenConnectedSDSData) {
        this.lc.log(10000000, "SDSServiceImpl#screenConnectedWithSDSData: screenID=%1, terminalID=%2, SDSData=%3", (Object)new Integer(n), (Object)new Integer(n2), (Object)screenConnectedSDSData.toString());
        this.sdsManager.updateConnectedScreenWithSDSData(n, n2, screenConnectedSDSData);
    }

    public void fireTimer(Timer timer) {
        if (timer != this.returnKeyTimer) {
            this.lc.log(100000, "SDSServiceImpl#fireTimer: Unhandled timer %1!", (Object)timer);
            return;
        }
        if (this.sdsManager.isSDSAborting()) {
            this.lc.log(10000000, "SDSServiceImpl#fireTimer: returnKeyTimer fired but SDS is already aborting -> ignore HK_Back");
            return;
        }
        boolean bl = this.sdsAdapter.isSDSWaiting();
        this.lc.log(10000000, "SDSServiceImpl#fireTimer: returnKeyTimer fired without second return key, sdsWaiting=%1!", bl);
        int n = 1011;
        if (bl) {
            boolean bl2 = this.sdsAdapter.isAbortWaitingStateOnCorrection();
            n = bl2 ? 1001 : 1014;
            this.sdsAdapter.setAbortWaitingStateOnCorrection(!bl2);
            if (bl2) {
                this.sdsAdapter.handleLeavingWaitingState();
            }
        }
        this.lc.log(10000000, "SDSServiceImpl#fireTimer: Sending %1 event with eventID %2!", (Object)(n == 1001 ? "ABORT" : "CORRECTION"), (long)n);
        this.sdsAdapter.sendEvent(n);
    }

    public void cancelTimer(Timer timer) {
        this.lc.log(10000000, "SDSServiceImpl#cancelTimer: called");
    }

    public boolean isVolumeSettingSessionActive() {
        return this.sdsAdapter.isSDSVolumeSettingActive();
    }

    public void sendResponse(int n, int n2) {
        this.lc.log(10000000, "SDSServiceImpl#sendResponse: not implemented!");
    }

    public void setSpeechRecHandler(SpeechRecognitionHandler speechRecognitionHandler) {
    }

    public void notifySpellerUserInteraction(int n) {
    }

    public void updateExternalSDSActive() {
        if (this.sdsManager.isSDSActive()) {
            this.abortSDSSession(true, (byte)7);
        }
    }
}

