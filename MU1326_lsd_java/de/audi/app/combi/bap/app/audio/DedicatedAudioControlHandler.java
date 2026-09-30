/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status;
import de.vw.mib.bap.generated.audiosd.serializer.CurrentStation_Handle_Status;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_Result;
import de.vw.mib.bap.generated.audiosd.serializer.SourceState_Status;

public class DedicatedAudioControlHandler {
    private final LogChannel logChannel;
    private final CombiModuleAudio module;
    private final BAPFunctionMethodFSG function;
    private static final int FAST_FORWARD_BACKWARD_TIMEOUT_DELAY = 600000;
    private final Timer fastForwardBackwardTimeoutTimer;
    private DedicatedAudioControlCommand currentControlCommand = null;

    protected DedicatedAudioControlHandler(CombiModuleAudio combiModuleAudio) {
        this.module = combiModuleAudio;
        this.logChannel = combiModuleAudio.getLogChannel();
        this.function = combiModuleAudio.getBAPFunctionMethodFSG(24);
        this.fastForwardBackwardTimeoutTimer = new Timer("FastForwardBackwardTimeoutTimer", 600000L, true, new FastForwardBackwardTimerListener());
    }

    protected void process(int n, int n2, int n3, CombiBAPServiceAudioListener combiBAPServiceAudioListener) {
        this.logChannel.log(10000000, "[DedicatedAudioControlHandler#process] controlType=%1, additionalControlInformation=%2, listType=%3", (long)n, (long)n2, (long)n3);
        if (this.currentControlCommand != null && this.currentControlCommand.getControlType() == n) {
            this.logChannel.log(100000, "[DedicatedAudioControlHandler#process] control with same controlType (%1) was already started before -> do nothing!", (long)n);
            return;
        }
        if (combiBAPServiceAudioListener == null) {
            this.logChannel.log(100000, "[DedicatedAudioControlHandler#process] no active audio service listener");
            this.sendResultNotSuccessful(false);
            return;
        }
        if (this.currentControlCommand != null) {
            this.currentControlCommand.cancel(n);
        }
        this.currentControlCommand = new DedicatedAudioControlCommand(n, n2, n3, combiBAPServiceAudioListener);
        this.currentControlCommand.execute();
    }

    protected void processAbort() {
        if (this.currentControlCommand == null) {
            this.logChannel.log(100000, "[DedicatedAudioControlHandler#processAbort] DedicatedAudioControl was not started -> nothing to abort");
            this.function.methodAborted();
        } else {
            this.currentControlCommand.abort();
        }
    }

    private void sendAbortNotSuccessful() {
        DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
        dedicatedAudioControl_Result.dedicatedAudioControlResult = 3;
        this.function.resultAbortNotSuccessfulREQ(dedicatedAudioControl_Result);
        this.processingFinished();
    }

    protected void updateSeekStatus(boolean bl) {
        if (this.currentControlCommand == null) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#updateSeekRunning] DedicatedAudioControl was not started -> dismiss result");
            return;
        }
        if (this.currentControlCommand.getControlType() == 3 || this.currentControlCommand.getControlType() == 4) {
            if (this.function.isMethodProcessing()) {
                if (bl) {
                    this.logChannel.log(10000000, "[DedicatedAudioControlHandler#updateSeekStatus] seek is now running");
                } else if (this.function.isAbortPending()) {
                    this.sendResultRequest(2);
                } else {
                    this.function.methodAborted();
                    this.processingFinished();
                }
            }
            if (!bl) {
                this.fastForwardBackwardTimeoutTimer.cancel();
            }
        } else if (this.currentControlCommand.getControlType() == 7) {
            if (this.function.isMethodProcessing()) {
                if (bl) {
                    this.sendResultRequest(1);
                } else {
                    this.sendResultRequest(0);
                }
            }
            if (!bl) {
                this.fastForwardBackwardTimeoutTimer.cancel();
            }
        } else {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#updateSeekProcessing] seek was not started by the ASG -> do nothing");
        }
    }

    public synchronized void processingFinished() {
        if (this.currentControlCommand != null) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#processingFinished] finished processing of controlType %1", (long)this.currentControlCommand.getControlType());
            this.currentControlCommand = null;
        }
    }

    public void skipResult(boolean bl) {
        if (this.currentControlCommand == null) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#skipResult] DedicatedAudioControl was not started -> dismiss result");
            return;
        }
        if (this.currentControlCommand.getControlType() == 1 || this.currentControlCommand.getControlType() == 2) {
            int n = bl ? 0 : 1;
            this.sendResultRequest(n);
        } else {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#skipResult] skip was not started by the ASG -> do nothing");
        }
    }

    protected void processResult(int n, int n2) {
        if (this.currentControlCommand == null) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#sendResult] DedicatedAudioControl was not started -> dismiss result (controlType=%1)", (long)n);
            return;
        }
        int n3 = this.currentControlCommand.getControlType();
        if (n3 == 6 && n == 5 && n2 == 1) {
            n = 6;
        }
        if (n3 == n) {
            this.sendResultRequest(n2);
        } else {
            this.logChannel.log(100000, "[DedicatedAudioControlHandler#sendResult] controlType of result doesn't match controlType of startResult request (%1<->%2)", (long)n, (long)n3);
        }
    }

    private void sendResultNotSuccessful(boolean bl) {
        this.sendResultRequest(1);
        if (bl) {
            this.module.getRequestHandler().requestErrorCode(49, 24, 65);
        }
    }

    private void sendResultRequest(int n) {
        if (this.function.isAbortPending()) {
            if (n == 0) {
                n = 2;
            } else if (n == 1) {
                n = 3;
            }
        }
        DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
        dedicatedAudioControl_Result.dedicatedAudioControlResult = n;
        if (this.currentControlCommand != null && this.currentControlCommand.getControlType() == 0) {
            this.handleSelectListEntryResult(n);
        } else {
            this.function.resultREQ(dedicatedAudioControl_Result);
            this.processingFinished();
        }
    }

    private void handleSelectListEntryResult(int n) {
        FunctionSynchronizationHandlerAudio functionSynchronizationHandlerAudio = (FunctionSynchronizationHandlerAudio)this.module.getFunctionSynchronizationHandler();
        if (!this.function.isResultWaiting() && !functionSynchronizationHandlerAudio.isSyncTypeTrackOrStationChange() && functionSynchronizationHandlerAudio.getCurrentSyncType() != 0) {
            DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
            dedicatedAudioControl_Result.dedicatedAudioControlResult = n;
            this.function.resultREQ(dedicatedAudioControl_Result);
            this.processingFinished();
        } else if (n == 1 || n == 3) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#handleSelectListEntryResult] unsuccessful result received -> complete sync and send result");
            this.function.setResultWaiting(n);
            functionSynchronizationHandlerAudio.completeSync();
        } else {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#handleSelectListEntryResult] result received, track change in progress -> send result after function synchronization is completed");
            this.function.setResultWaiting(n);
        }
    }

    protected void processLastResult() {
        this.logChannel.log(1000000, "[DedicatedAudioControlHandler#processLastResult] called for result %1", (long)this.function.getWaitingResult());
        if (this.function.isResultWaiting()) {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#processLastResult] send result now!");
            DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
            dedicatedAudioControl_Result.dedicatedAudioControlResult = this.function.getWaitingResult();
            this.function.resultREQ(dedicatedAudioControl_Result);
            this.processingFinished();
        } else {
            this.logChannel.log(10000000, "[DedicatedAudioControlHandler#processLastResult] no result to send!");
        }
    }

    private class DedicatedAudioControlCommand {
        private int controlType;
        private final int additionalControlInformation;
        private final int listType;
        private final CombiBAPServiceAudioListener audioService;
        private static final String LOGGER_CLASS_NAME = "DedicatedAudioControlHandler.DedicatedAudioControlCommand";

        public DedicatedAudioControlCommand(int n, int n2, int n3, CombiBAPServiceAudioListener combiBAPServiceAudioListener) {
            this.controlType = n;
            this.additionalControlInformation = n2;
            this.listType = n3;
            this.audioService = combiBAPServiceAudioListener;
        }

        public int getControlType() {
            return this.controlType;
        }

        public void cancel(int n) {
            DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] cancel control with controlType %2", (Object)LOGGER_CLASS_NAME, (long)this.controlType);
            switch (this.controlType) {
                case 3: 
                case 4: {
                    if (n == 7) break;
                    this.cancelSeek();
                    break;
                }
                case 5: {
                    if (n == 6) break;
                    this.cancelStationListUpdate();
                    break;
                }
            }
        }

        public void abort() {
            DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#abort] abort control with controlType %2", (Object)LOGGER_CLASS_NAME, (long)this.controlType);
            switch (this.controlType) {
                case 3: 
                case 4: {
                    this.cancelSeek();
                    break;
                }
                case 5: {
                    this.controlType = 6;
                    if (this.cancelStationListUpdate()) break;
                    DedicatedAudioControlHandler.this.sendAbortNotSuccessful();
                    break;
                }
                default: {
                    DedicatedAudioControlHandler.this.sendAbortNotSuccessful();
                }
            }
        }

        public void execute() {
            switch (this.controlType) {
                case 0: {
                    this.selectListEntry();
                    break;
                }
                case 1: {
                    this.skip(this.additionalControlInformation == 0 ? 1 : this.additionalControlInformation);
                    break;
                }
                case 2: {
                    this.skip(this.additionalControlInformation == 0 ? -1 : -this.additionalControlInformation);
                    break;
                }
                case 3: {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] call 'startSeek(SEEK_FORWARD)' at active audio service", (Object)LOGGER_CLASS_NAME);
                    this.audioService.startSeek(0);
                    DedicatedAudioControlHandler.this.fastForwardBackwardTimeoutTimer.restart();
                    break;
                }
                case 4: {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] call 'startSeek(SEEK_BACKWARD)' at active audio service", (Object)LOGGER_CLASS_NAME);
                    this.audioService.startSeek(1);
                    DedicatedAudioControlHandler.this.fastForwardBackwardTimeoutTimer.restart();
                    break;
                }
                case 7: {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] call 'cancelSeek()' at active audio service", (Object)LOGGER_CLASS_NAME);
                    this.cancelSeek();
                    break;
                }
                case 5: {
                    this.startStationListUpdate();
                    break;
                }
                case 6: {
                    if (this.cancelStationListUpdate()) break;
                    DedicatedAudioControlHandler.this.sendResultNotSuccessful(false);
                    break;
                }
                default: {
                    DedicatedAudioControlHandler.this.logChannel.log(10000, "[%1#process] invalid controlType: %2", (Object)LOGGER_CLASS_NAME, (long)this.controlType);
                }
            }
        }

        private void selectListEntry() {
            switch (this.listType) {
                case 1: {
                    this.selectListEntryReceptionList();
                    break;
                }
                case 2: {
                    this.selectListEntryPresetList();
                    break;
                }
                case 3: {
                    this.selectListEntryMediaBrowser();
                    break;
                }
                case 4: {
                    DedicatedAudioControlHandler.this.logChannel.log(10000, "[%1#selectListEntry] TPMemoList not supported yet", (Object)LOGGER_CLASS_NAME);
                    DedicatedAudioControlHandler.this.sendResultNotSuccessful(false);
                    break;
                }
                case 0: {
                    DedicatedAudioControlHandler.this.sendResultNotSuccessful(false);
                    break;
                }
                default: {
                    DedicatedAudioControlHandler.this.sendResultNotSuccessful(true);
                }
            }
        }

        private void selectListEntryReceptionList() {
            if (DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isTunerInFocus() || DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isTVInFocus()) {
                CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(22).getLastStatus();
                SourceState_Status sourceState_Status = (SourceState_Status)DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(20).getLastStatus();
                if (currentStation_Handle_Status.fsgHandle != this.additionalControlInformation || sourceState_Status.stateInfo == 6) {
                    if (DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isTunerInFocus()) {
                        DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryReceptionList] calling tuner service 'selectListEntry(%2)'", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                        DedicatedAudioControlHandler.this.module.getTunerServiceListener().selectListEntry(this.additionalControlInformation);
                    } else if (DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isTVInFocus()) {
                        DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryReceptionList] calling TV service 'selectListEntry(%2)'", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                        DedicatedAudioControlHandler.this.module.getTVServiceListener().selectListEntry(this.additionalControlInformation);
                    }
                } else {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryReceptionList] entry with id=%2 is already active", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.sendResultRequest(0);
                }
            } else {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryReceptionList] tuner not active", (Object)LOGGER_CLASS_NAME);
                DedicatedAudioControlHandler.this.sendResultRequest(1);
            }
        }

        private void selectListEntryPresetList() {
            CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(22).getLastStatus();
            SourceState_Status sourceState_Status = (SourceState_Status)DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(20).getLastStatus();
            if (currentStation_Handle_Status.presetList_Ref != this.additionalControlInformation || sourceState_Status.stateInfo == 6) {
                ArrayHandler arrayHandler = DedicatedAudioControlHandler.this.module.getBAPFunctionArrayFSG(33).getArrayHandler();
                CombiBAPPresetListEntry combiBAPPresetListEntry = (CombiBAPPresetListEntry)arrayHandler.getArrayElement(this.additionalControlInformation);
                if (combiBAPPresetListEntry == null) {
                    DedicatedAudioControlHandler.this.logChannel.log(100000, "[$#1#selectListEntryPresetList] element with id=%2 not found in preset list", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.sendResultRequest(1);
                } else if (combiBAPPresetListEntry.getWaveband() == 9 || combiBAPPresetListEntry.getWaveband() == 8) {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryPresetList] calling 'selectListEntryPresetList(%2)' at media service", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.module.getTVServiceListener().selectListEntryPresetList(this.additionalControlInformation);
                } else if (DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isTunerInFocus()) {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryPresetList] calling 'selectListEntryPresetList(%2)' at tuner service", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryPresetList] set result waiting successful", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.function.setResultWaiting(0);
                    DedicatedAudioControlHandler.this.module.getTunerServiceListener().selectListEntryPresetList(this.additionalControlInformation);
                } else {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryPresetList] tuner not active", (Object)LOGGER_CLASS_NAME);
                    DedicatedAudioControlHandler.this.sendResultRequest(1);
                }
            } else {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryPresetList] entry with id=%2 is already active", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                DedicatedAudioControlHandler.this.sendResultRequest(0);
            }
        }

        private void selectListEntryMediaBrowser() {
            if (DedicatedAudioControlHandler.this.module.getAudioApplicationFocusHandler().isMediaInFocus()) {
                CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(22).getLastStatus();
                if (currentStation_Handle_Status.fsgHandle != this.additionalControlInformation) {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryMediaBrowser] calling media service 'selectListEntry(%1)'", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.module.getMediaServiceListener().selectListEntry(this.additionalControlInformation);
                } else {
                    DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryMediaBrowser] entry with id=%2 is already active", (Object)LOGGER_CLASS_NAME, (long)this.additionalControlInformation);
                    DedicatedAudioControlHandler.this.sendResultRequest(0);
                }
            } else {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#selectListEntryMediaBrowser] media not active", (Object)LOGGER_CLASS_NAME);
                DedicatedAudioControlHandler.this.sendResultRequest(1);
            }
        }

        private void skip(int n) {
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = DedicatedAudioControlHandler.this.module.getBAPFunctionPropertyFSG(16);
            if (((ActiveSource_Status)bAPFunctionPropertyFSG.getLastStatus()).sourceType == 12) {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] call 'skip(%2)' at CombiBAPServiceInfoListener", (Object)LOGGER_CLASS_NAME, (long)n);
                DedicatedAudioControlHandler.this.module.getInfoServiceListener().skip(n);
            } else {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#process] call 'skip(%2)' at active audio service", (Object)LOGGER_CLASS_NAME, (long)n);
                this.audioService.skip(n);
            }
        }

        private void cancelSeek() {
            DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#cancelSeek] call 'cancel seek' at active audio service", (Object)LOGGER_CLASS_NAME);
            this.audioService.cancelSeek();
        }

        private void startStationListUpdate() {
            if (this.audioService instanceof CombiBAPServiceTunerListener) {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#startStationListUpdate] call 'startStationListUpdate' at TunerService", (Object)LOGGER_CLASS_NAME);
                ((CombiBAPServiceTunerListener)this.audioService).startStationListUpdate();
            } else {
                DedicatedAudioControlHandler.this.logChannel.log(100000, "[%1#startStationListUpdate] station list update only applicable for tuner", (Object)LOGGER_CLASS_NAME);
                DedicatedAudioControlHandler.this.sendResultNotSuccessful(false);
            }
        }

        private boolean cancelStationListUpdate() {
            if (this.audioService instanceof CombiBAPServiceTunerListener) {
                DedicatedAudioControlHandler.this.logChannel.log(10000000, "[%1#cancelStationListUpdate] call 'cancelStationListUpdate' at TunerService", (Object)LOGGER_CLASS_NAME);
                ((CombiBAPServiceTunerListener)this.audioService).cancelStationListUpdate();
                return true;
            }
            DedicatedAudioControlHandler.this.logChannel.log(100000, "[%1#cancelStationListUpdate] cancel station list update only applicable for tuner", (Object)LOGGER_CLASS_NAME);
            return false;
        }
    }

    private class FastForwardBackwardTimerListener
    implements TimerListener {
        private FastForwardBackwardTimerListener() {
        }

        public void fireTimer(Timer timer) {
            DedicatedAudioControlHandler.this.logChannel.log(10000, "[DedicatedAudioControlHandler.FastForwardBackwardTimerListener#fireTimer] timeout, no response receveived after %1ms -> abort method", timer.getDelay());
            DedicatedAudioControlHandler.this.function.methodAborted();
        }

        public void cancelTimer(Timer timer) {
        }
    }
}

