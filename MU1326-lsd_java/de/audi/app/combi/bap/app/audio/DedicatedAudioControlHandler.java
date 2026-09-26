/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler$DedicatedAudioControlCommand;
import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler$FastForwardBackwardTimerListener;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceAudioListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.vw.mib.bap.generated.audiosd.serializer.DedicatedAudioControl_Result;

public class DedicatedAudioControlHandler {
    private final LogChannel logChannel;
    private final CombiModuleAudio module;
    private final BAPFunctionMethodFSG function;
    private static final int FAST_FORWARD_BACKWARD_TIMEOUT_DELAY;
    private final Timer fastForwardBackwardTimeoutTimer;
    private DedicatedAudioControlHandler$DedicatedAudioControlCommand currentControlCommand = null;

    protected DedicatedAudioControlHandler(CombiModuleAudio combiModuleAudio) {
        this.module = combiModuleAudio;
        this.logChannel = combiModuleAudio.getLogChannel();
        this.function = combiModuleAudio.getBAPFunctionMethodFSG(24);
        this.fastForwardBackwardTimeoutTimer = new Timer("FastForwardBackwardTimeoutTimer", 0, true, new DedicatedAudioControlHandler$FastForwardBackwardTimerListener(this, null));
    }

    protected void process(int n, int n2, int n3, CombiBAPServiceAudioListener combiBAPServiceAudioListener) {
        this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#process] controlType=%1, additionalControlInformation=%2, listType=%3", (long)n, (long)n2, (long)n3);
        if (this.currentControlCommand != null && this.currentControlCommand.getControlType() == n) {
            this.logChannel.log(-1601830656, "[DedicatedAudioControlHandler#process] control with same controlType (%1) was already started before -> do nothing!", (long)n);
            return;
        }
        if (combiBAPServiceAudioListener == null) {
            this.logChannel.log(-1601830656, "[DedicatedAudioControlHandler#process] no active audio service listener");
            this.sendResultNotSuccessful(false);
            return;
        }
        if (this.currentControlCommand != null) {
            this.currentControlCommand.cancel(n);
        }
        this.currentControlCommand = new DedicatedAudioControlHandler$DedicatedAudioControlCommand(this, n, n2, n3, combiBAPServiceAudioListener);
        this.currentControlCommand.execute();
    }

    protected void processAbort() {
        if (this.currentControlCommand == null) {
            this.logChannel.log(-1601830656, "[DedicatedAudioControlHandler#processAbort] DedicatedAudioControl was not started -> nothing to abort");
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
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#updateSeekRunning] DedicatedAudioControl was not started -> dismiss result");
            return;
        }
        if (this.currentControlCommand.getControlType() == 3 || this.currentControlCommand.getControlType() == 4) {
            if (this.function.isMethodProcessing()) {
                if (bl) {
                    this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#updateSeekStatus] seek is now running");
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
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#updateSeekProcessing] seek was not started by the ASG -> do nothing");
        }
    }

    public synchronized void processingFinished() {
        if (this.currentControlCommand != null) {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#processingFinished] finished processing of controlType %1", (long)this.currentControlCommand.getControlType());
            this.currentControlCommand = null;
        }
    }

    public void skipResult(boolean bl) {
        if (this.currentControlCommand == null) {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#skipResult] DedicatedAudioControl was not started -> dismiss result");
            return;
        }
        if (this.currentControlCommand.getControlType() == 1 || this.currentControlCommand.getControlType() == 2) {
            int n = bl ? 0 : 1;
            this.sendResultRequest(n);
        } else {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#skipResult] skip was not started by the ASG -> do nothing");
        }
    }

    protected void processResult(int n, int n2) {
        if (this.currentControlCommand == null) {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#sendResult] DedicatedAudioControl was not started -> dismiss result (controlType=%1)", (long)n);
            return;
        }
        int n3 = this.currentControlCommand.getControlType();
        if (n3 == 6 && n == 5 && n2 == 1) {
            n = 6;
        }
        if (n3 == n) {
            this.sendResultRequest(n2);
        } else {
            this.logChannel.log(-1601830656, "[DedicatedAudioControlHandler#sendResult] controlType of result doesn't match controlType of startResult request (%1<->%2)", (long)n, (long)n3);
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
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#handleSelectListEntryResult] unsuccessful result received -> complete sync and send result");
            this.function.setResultWaiting(n);
            functionSynchronizationHandlerAudio.completeSync();
        } else {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#handleSelectListEntryResult] result received, track change in progress -> send result after function synchronization is completed");
            this.function.setResultWaiting(n);
        }
    }

    protected void processLastResult() {
        this.logChannel.log(1078071040, "[DedicatedAudioControlHandler#processLastResult] called for result %1", (long)this.function.getWaitingResult());
        if (this.function.isResultWaiting()) {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#processLastResult] send result now!");
            DedicatedAudioControl_Result dedicatedAudioControl_Result = (DedicatedAudioControl_Result)this.module.createResultSerializer(24);
            dedicatedAudioControl_Result.dedicatedAudioControlResult = this.function.getWaitingResult();
            this.function.resultREQ(dedicatedAudioControl_Result);
            this.processingFinished();
        } else {
            this.logChannel.log(-2137614336, "[DedicatedAudioControlHandler#processLastResult] no result to send!");
        }
    }

    static /* synthetic */ LogChannel access$000(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        return dedicatedAudioControlHandler.logChannel;
    }

    static /* synthetic */ void access$100(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        dedicatedAudioControlHandler.sendAbortNotSuccessful();
    }

    static /* synthetic */ Timer access$200(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        return dedicatedAudioControlHandler.fastForwardBackwardTimeoutTimer;
    }

    static /* synthetic */ void access$300(DedicatedAudioControlHandler dedicatedAudioControlHandler, boolean bl) {
        dedicatedAudioControlHandler.sendResultNotSuccessful(bl);
    }

    static /* synthetic */ CombiModuleAudio access$400(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        return dedicatedAudioControlHandler.module;
    }

    static /* synthetic */ void access$500(DedicatedAudioControlHandler dedicatedAudioControlHandler, int n) {
        dedicatedAudioControlHandler.sendResultRequest(n);
    }

    static /* synthetic */ BAPFunctionMethodFSG access$600(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        return dedicatedAudioControlHandler.function;
    }
}

