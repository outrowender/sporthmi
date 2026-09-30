/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPMethodASGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPMethodASGREQ;
import de.audi.app.bap.fw.functiontypes.queuing.Request;
import de.audi.app.bap.fw.functiontypes.queuing.RequestMethodStart;
import de.audi.app.bap.fw.functiontypes.queuing.RequestMethodStartResult;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerMethodASG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;
import java.util.ArrayList;
import java.util.List;

public class BAPFunctionMethodASG
extends AbstractBAPFunction
implements IBAPMethodASGIND,
IBAPMethodASGREQ {
    private final List requestsQueue = new ArrayList();
    private volatile boolean requestInFlight = false;
    private ResultMethod resultSerializer = null;
    private final IBAPIndicationHandlerMethodASG indicationHandler;

    public BAPFunctionMethodASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        super(abstractBAPModuleASG, n);
        this.indicationHandler = abstractBAPModuleASG.getIndicationHandler();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionMethodASG#reset] called");
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.clear();
            this.requestInFlight = false;
        }
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 10: {
                this.logChannel.log(100000000, "[BAPFunctionMethodASG#getIndicationSerializer] Processing");
                return null;
            }
            case 11: {
                return this.resultSerializer;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionMethodASG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 10 || n == 11;
    }

    protected void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 10: {
                this.processingIND();
                break;
            }
            case 11: {
                this.resultIND((ResultMethod)bAPEntity);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionMethodASG#doProcessIndication] indicationType not supported by function type METHOD: %1 (lsgID=%2, fctID=%3)", (Object)IndicationTypes.getDescription(n), (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(1000000, "[BAPFunctionMethodASG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
        switch (n) {
            case 34: {
                this.handleNextRequestInQueue();
                break;
            }
            default: {
                this.indicationHandler.processIndicationResult(this, null);
            }
        }
    }

    public void processingIND() {
    }

    public void resultIND(ResultMethod resultMethod) {
        this.logChannel.log(10000000, "[BAPFunctionMethodASG#resultIND]");
        if (this.lsgID != 55) {
            this.handleNextRequestInQueue();
        }
        this.indicationHandler.processIndicationResult(this, resultMethod);
    }

    public void startREQ() {
        RequestMethodStart requestMethodStart = new RequestMethodStart(this);
        this.addRequestToQueue(requestMethodStart);
    }

    public void startREQ(StartResultMethod startResultMethod) {
        RequestMethodStart requestMethodStart = new RequestMethodStart((AbstractBAPFunction)this, startResultMethod);
        this.addRequestToQueue(requestMethodStart);
    }

    public void startResultREQ() {
        RequestMethodStartResult requestMethodStartResult = new RequestMethodStartResult(this);
        this.addRequestToQueue(requestMethodStartResult);
    }

    public void startResultREQ(StartResultMethod startResultMethod) {
        RequestMethodStartResult requestMethodStartResult = new RequestMethodStartResult((AbstractBAPFunction)this, startResultMethod);
        this.addRequestToQueue(requestMethodStartResult);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addRequestToQueue(Request request) {
        List list = this.requestsQueue;
        synchronized (list) {
            if (this.requestsQueue.contains(request)) {
                this.logChannel.log(1000000, "[BAPFunctionMethodASG#addRequestToQueue] duplicate request=%1 not added", (Object)request);
            } else {
                this.logChannel.log(1000000, "[BAPFunctionMethodASG#addRequestToQueue] add request=%1", (Object)request);
                this.requestsQueue.add(request);
                this.processQueue();
            }
        }
    }

    public void abortREQ() {
        this.sendRequest(5);
    }

    public void abortREQ(AbortResultMethod abortResultMethod) {
        this.sendRequest(5, abortResultMethod);
    }

    public void setResultSerializer(ResultMethod resultMethod) {
        this.resultSerializer = resultMethod;
    }

    private void processQueue() {
        this.logChannel.log(100000000, "[BAPFunctionMethodASG#processQueue]");
        if (this.requestInFlight) {
            return;
        }
        Request request = (Request)this.requestsQueue.get(0);
        boolean bl = request.send();
        if (!bl) {
            this.logChannel.log(100000, "[BAPFunctionMethodASG#processQueue] could not send request");
            this.requestsQueue.remove(0);
            return;
        }
        this.logChannel.log(100000000, "[BAPFunctionMethodASG#processQueue] request sent");
        this.requestInFlight = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleNextRequestInQueue() {
        List list = this.requestsQueue;
        synchronized (list) {
            if (this.requestsQueue.isEmpty()) {
                this.logChannel.log(100000, "[BAPFunctionMethodASG#resultIND] Unexpected result indication received.");
                return;
            }
            this.requestsQueue.remove(0);
            if (this.requestsQueue.isEmpty()) {
                this.requestInFlight = false;
            } else {
                ((Request)this.requestsQueue.get(0)).send();
                this.logChannel.log(100000000, "[BAPFunctionMethodASG#handleNextRequestInQueue] request sent");
            }
        }
    }

    public void onRemoteProcessState(RemoteProcessState remoteProcessState) {
        super.onRemoteProcessState(remoteProcessState);
        if (this.lsgID != 55) {
            return;
        }
        if (remoteProcessState.getState() == 1 || remoteProcessState.getState() == 0) {
            this.handleNextRequestInQueue();
        }
    }
}

