/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPMethodFSGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPMethodFSGREQ;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerMethodFSG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;

public class BAPFunctionMethodFSG
extends AbstractBAPFunction
implements IBAPMethodFSGIND,
IBAPMethodFSGREQ,
TimerListener {
    private static final int NO_RESULT_WAITING = -1;
    private StartResultMethod startResultSerializer = null;
    private final IBAPIndicationHandlerMethodFSG indicationHandler;
    private volatile boolean methodProcessing = false;
    private volatile int resultWaiting = -1;
    private volatile boolean abortPending = false;
    protected static final int NO_RESPONSE_TIMEOUT_START_RESULT = 130000;
    private final Timer noResponseTimer = new Timer("NoResponseTimer", 130000L, true, new TimerSyncer(this));
    public static final int CONCURRENT_OPERATION_MODE_NOT_ALLOWED = 0;
    public static final int CONCURRENT_OPERATION_MODE_LAST_WINS = 1;
    private int concurrentOperationMode = 0;

    public BAPFunctionMethodFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        super(abstractBAPModuleFSG, n);
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 3: 
            case 4: {
                return this.startResultSerializer;
            }
            case 5: 
            case 10: {
                return null;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionMethodFSG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    public void setConcurrentOperationMode(int n) {
        this.concurrentOperationMode = n;
    }

    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionMethodFSG#reset] called");
        this.resetIndication();
    }

    private void resetIndication() {
        this.noResponseTimer.cancel();
        this.abortPending = false;
        this.methodProcessing = false;
        this.resultWaiting = -1;
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 5 || n == 3 || n == 4 || n == 6;
    }

    protected synchronized void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 5: {
                this.abortIND((AbortResultMethod)bAPEntity);
                break;
            }
            case 3: {
                this.startIND((StartResultMethod)bAPEntity);
                break;
            }
            case 4: {
                this.startResultIND((StartResultMethod)bAPEntity);
                break;
            }
            case 6: {
                this.processingCNF();
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionMethodFSG#doProcessIndication] indicationType not supported by function type METHOD: %1 (lsgID=%2, fctID=%3)", (Object)IndicationTypes.getDescription(n), (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    public void abortIND() {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#abortIND]");
        this.abortIND(null);
    }

    public void abortIND(AbortResultMethod abortResultMethod) {
        if (this.methodProcessing) {
            this.logChannel.log(10000000, "[BAPFunctionMethodFSG#abortIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        } else {
            this.logChannel.log(10000, "[BAPFunctionMethodFSG#abortIND] lsgID=%1, fctID=%2, can't abort a method that hasn't been started!", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        }
        this.abortPending = true;
        this.noResponseTimer.restart();
        this.indicationHandler.processIndicationAbort(this);
    }

    public void startIND(StartResultMethod startResultMethod) {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#startIND] lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationStartResult(this, startResultMethod);
    }

    public void startResultIND(StartResultMethod startResultMethod) {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#startResultIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        if (this.methodProcessing && this.concurrentOperationMode == 0) {
            this.logChannel.log(10000, "[BAPFunctionMethodFSG#startResultIND] The method was already started. Waiting for result (The new request will be dismissed).");
        } else {
            this.methodProcessing = true;
            this.noResponseTimer.restart();
            this.startIND(startResultMethod);
        }
    }

    public void processingCNF() {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#processingCNF] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        if (this.methodProcessing) {
            this.processingREQ();
        }
    }

    public void methodAborted() {
        this.requestHandler.requestError(this.lsgID, this.fctID, 3);
        this.resetIndication();
    }

    public void errorInvalidArgument() {
        this.requestHandler.requestError(this.lsgID, this.fctID, 5);
        this.resetIndication();
    }

    public void resultREQ(ResultMethod resultMethod) {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#resultREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        if (this.methodProcessing) {
            this.sendRequest(9, resultMethod);
        } else {
            this.logChannel.log(10000000, "[BAPFunctionMethodFSG#resultREQ] No result was requested by the ASG -> dismiss result (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        }
        this.resetIndication();
    }

    public void resultAbortNotSuccessfulREQ(ResultMethod resultMethod) {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#resultAbortNotSuccessfulREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        if (this.abortPending) {
            this.sendRequest(9, resultMethod);
            this.resetIndication();
        } else {
            this.logChannel.log(10000, "[BAPFunctionMethodFSG#resultAbortREQ] abort was not requested by ASG");
        }
    }

    public void processingREQ() {
        this.logChannel.log(10000000, "[BAPFunctionMethodFSG#processingREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.sendRequest(8);
    }

    public boolean isMethodProcessing() {
        return this.methodProcessing;
    }

    public boolean isResultWaiting() {
        return this.resultWaiting != -1;
    }

    public void setResultWaiting(int n) {
        this.resultWaiting = n;
    }

    public int getWaitingResult() {
        return this.resultWaiting;
    }

    public boolean isAbortPending() {
        return this.abortPending;
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.noResponseTimer)) {
            this.logChannel.log(10000, "[BAPFunctionMethodFSG#fireTimer] lsgID=%1, fctID=%2, Timeout - no response receveived - abort method", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.methodAborted();
        }
    }

    public void setStartResultSerializer(StartResultMethod startResultMethod) {
        this.startResultSerializer = startResultMethod;
    }
}

