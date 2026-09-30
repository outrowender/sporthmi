/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.TransactionId;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.RetryConfig;
import de.audi.app.bap.fw.functiontypes.RetryWatchdog;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPArrayASGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPArrayASGREQ;
import de.audi.app.bap.fw.functiontypes.queuing.AbstractArrayRequest;
import de.audi.app.bap.fw.functiontypes.queuing.Request;
import de.audi.app.bap.fw.functiontypes.queuing.RequestArrayAck;
import de.audi.app.bap.fw.functiontypes.queuing.RequestArrayGet;
import de.audi.app.bap.fw.functiontypes.queuing.RequestArraySet;
import de.audi.app.bap.fw.functiontypes.queuing.RequestArraySetGet;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerASG;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerArrayASG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.StatusArray;
import java.util.ArrayList;
import java.util.List;

public class BAPFunctionArrayASG
extends AbstractBAPFunction
implements IBAPArrayASGIND,
IBAPArrayASGREQ {
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE = 0;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final boolean INDEX_8_BIT = false;
    public static final boolean INDEX_16_BIT = true;
    private ChangedArray changedArraySerializer;
    private StatusArray statusArraySerializer;
    private static final int INITIAL_TRANSACTION_ID = 1;
    private static final int MAX_TRANSACTION_ID = 15;
    private static final int DEFAULT_RETRY_COUNT = 4;
    private static final int DEFAULT_RETRY_TIMEOUT_MS = 500;
    private final RetryWatchdog retryWatchdog;
    private volatile NoResponseFromFSGHandler noResponseFromFSGHandler = null;
    private final List requestsQueue = new ArrayList();
    private volatile boolean requestInFlight = false;
    private final IBAPIndicationHandlerArrayASG indicationHandler;
    private final TransactionId transactionId = new TransactionId(1, 15);

    public BAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        super(abstractBAPModuleASG, n);
        this.indicationHandler = (IBAPIndicationHandlerASG)abstractBAPModuleASG.getIndicationListener();
        this.retryWatchdog = new RetryWatchdog(this.logChannel, new RetryConfig(4, 500), new RetryWatchdog.ErrorMethod(){

            public void error() {
                BAPFunctionArrayASG.this.noResponseFromFSG();
            }
        });
    }

    public BAPFunctionArrayASG(AbstractBAPModuleASG abstractBAPModuleASG, int n, RetryConfig retryConfig) {
        super(abstractBAPModuleASG, n);
        this.indicationHandler = (IBAPIndicationHandlerASG)abstractBAPModuleASG.getIndicationListener();
        this.retryWatchdog = new RetryWatchdog(this.logChannel, retryConfig, new RetryWatchdog.ErrorMethod(){

            public void error() {
                BAPFunctionArrayASG.this.noResponseFromFSG();
            }
        });
    }

    private void noResponseFromFSG() {
        this.logChannel.log(100000, "[BAPFunctionArrayASG#noResponseFromFSG]");
        this.reset();
        if (this.noResponseFromFSGHandler != null) {
            this.noResponseFromFSGHandler.noResponseFromFSG();
        }
    }

    public void setNoResponseFromFSGHandler(NoResponseFromFSGHandler noResponseFromFSGHandler) {
        this.noResponseFromFSGHandler = noResponseFromFSGHandler;
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 12: {
                return this.changedArraySerializer;
            }
            case 9: {
                return this.statusArraySerializer;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionArrayASG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2.", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionArrayASG#reset]");
        List list = this.requestsQueue;
        synchronized (list) {
            this.retryWatchdog.deactivate();
            this.transactionId.reset();
            this.requestsQueue.clear();
            this.requestInFlight = false;
        }
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 12 || n == 9;
    }

    protected void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 9: {
                this.statusArrayIND((StatusArray)bAPEntity);
                break;
            }
            case 12: {
                this.changedArrayIND((ChangedArray)bAPEntity);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionArrayASG#doProcessIndication] indicationType not supported by function type ARRAY: %1", (Object)IndicationTypes.getDescription(n));
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(10000000, "[BAPFunctionArrayASG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
        this.reset();
    }

    public void statusArrayIND(StatusArray statusArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayASG#statusArrayIND]");
        if (statusArray.getAsgId() == 0) {
            this.logChannel.log(10000000, "[BAPFunctionArrayASG#statusArrayIND] Got spontaneous status array.");
            this.indicationHandler.processIndicationStatusArray(this, statusArray);
        } else if (statusArray.isBroadcast()) {
            this.logChannel.log(10000000, "[BAPFunctionArrayASG#statusArrayIND] Got status array to be evaluated by all ASGs.");
            this.handleStatusArrayForAllASGs(statusArray);
        } else if (statusArray.getAsgId() == 1) {
            this.handleStatusArrayForUs(statusArray);
        } else {
            this.logChannel.log(10000, "[BAPFunctionArrayASG#statusArrayIND] Ignoring status array with unknown asgId. asgId: %1", (long)statusArray.getAsgId());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleStatusArrayForAllASGs(StatusArray statusArray) {
        List list = this.requestsQueue;
        synchronized (list) {
            if (!this.requestsQueue.isEmpty()) {
                AbstractArrayRequest abstractArrayRequest = (AbstractArrayRequest)this.requestsQueue.get(0);
                if (statusArray.getTransactionId() == abstractArrayRequest.expectedTransactionId()) {
                    this.retryWatchdog.deactivate();
                    this.sendQueuedRequestsUntilNextOneThatNeedsAResponse();
                }
            }
        }
        this.indicationHandler.processIndicationStatusArray(this, statusArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleStatusArrayForUs(StatusArray statusArray) {
        List list = this.requestsQueue;
        synchronized (list) {
            if (this.requestsQueue.isEmpty()) {
                this.logChannel.log(10000, "[BAPFunctionArrayASG#handleStatusArrayForUs] Ignoring unexpected status array. %1", (Object)statusArray);
                return;
            }
            AbstractArrayRequest abstractArrayRequest = (AbstractArrayRequest)this.requestsQueue.get(0);
            if (statusArray.getTransactionId() != abstractArrayRequest.expectedTransactionId()) {
                this.logChannel.log(10000, "[BAPFunctionArrayASG#handleStatusArrayForUs] Ignoring status array with wrong transaction ID. Transaction ID: %1 Expected Transaction ID: %2.", (long)statusArray.getTransactionId(), (long)abstractArrayRequest.expectedTransactionId());
                return;
            }
            this.retryWatchdog.deactivate();
            this.sendQueuedRequestsUntilNextOneThatNeedsAResponse();
        }
        this.indicationHandler.processIndicationStatusArray(this, statusArray);
    }

    private void sendQueuedRequestsUntilNextOneThatNeedsAResponse() {
        AbstractArrayRequest abstractArrayRequest;
        if (!this.requestsQueue.isEmpty()) {
            this.logChannel.log(100000000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] removed request from queue.");
            this.requestsQueue.remove(0);
        }
        while (!this.requestsQueue.isEmpty() && !(abstractArrayRequest = (AbstractArrayRequest)this.requestsQueue.get(0)).responseIsExpected()) {
            this.logChannel.log(100000000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] sending and removing from queue because no response expected.");
            abstractArrayRequest.send();
            this.requestsQueue.remove(0);
        }
        if (this.requestsQueue.isEmpty()) {
            this.logChannel.log(100000000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] queue is empty.");
            this.requestInFlight = false;
            return;
        }
        this.logChannel.log(100000000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] sending request that needs a response.");
        abstractArrayRequest = (AbstractArrayRequest)this.requestsQueue.get(0);
        boolean bl = false;
        while (!bl && !this.requestsQueue.isEmpty()) {
            bl = ((Request)this.requestsQueue.get(0)).send();
            if (!bl) {
                this.logChannel.log(100000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] could not send request");
                this.requestsQueue.remove(0);
                continue;
            }
            this.retryWatchdog.activate(abstractArrayRequest);
            this.logChannel.log(100000000, "[BAPFunctionArrayASG#sendQueuedRequestsUntilNextOneThatNeedsAResponse] request sent");
        }
        if (this.requestsQueue.isEmpty()) {
            this.requestInFlight = false;
        }
    }

    public void changedArrayIND(ChangedArray changedArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayASG#changedIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationChangedArray(this, changedArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGetArrayREQ(SetGetArray setGetArray) {
        int n = this.setASGIdAndTransactionId(setGetArray);
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(new RequestArraySetGet(this, n, setGetArray));
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setArrayREQ(SetGetArray setGetArray) {
        int n = this.setASGIdAndTransactionId(setGetArray);
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(new RequestArraySet(this, n, setGetArray));
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getArrayREQ(GetArray getArray) {
        int n = this.setASGIdAndTransactionId(getArray);
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(new RequestArrayGet(this, n, getArray));
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ackArrayREQ() {
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(new RequestArrayAck(this, this.transactionId.getAndIncrement()));
            this.processQueue();
        }
    }

    private int setASGIdAndTransactionId(GetArray getArray) {
        int n = this.transactionId.getAndIncrement();
        getArray.setAsgId(1);
        getArray.setTransactionId(n);
        return n;
    }

    private void processQueue() {
        this.logChannel.log(100000000, "[BAPFunctionArrayASG#processQueue]");
        if (!this.requestInFlight) {
            AbstractArrayRequest abstractArrayRequest = (AbstractArrayRequest)this.requestsQueue.get(0);
            boolean bl = abstractArrayRequest.send();
            if (bl && abstractArrayRequest.responseIsExpected()) {
                this.logChannel.log(100000000, "[BAPFunctionArrayASG#processQueue] send request taid: %1", (long)abstractArrayRequest.expectedTransactionId());
                this.requestInFlight = true;
                this.retryWatchdog.activate(abstractArrayRequest);
            } else {
                this.logChannel.log(100000000, "[BAPFunctionArrayASG#processQueue] removed request from queue.");
                this.requestsQueue.remove(0);
            }
        }
    }

    public ChangedArray getChangedArraySerializer() {
        return this.changedArraySerializer;
    }

    public void setChangedArraySerializer(ChangedArray changedArray) {
        this.changedArraySerializer = changedArray;
    }

    public StatusArray getStatusArraySerializer() {
        return this.statusArraySerializer;
    }

    public void setStatusArraySerializer(StatusArray statusArray) {
        this.statusArraySerializer = statusArray;
    }

    public static interface NoResponseFromFSGHandler {
        public void noResponseFromFSG();
    }
}

