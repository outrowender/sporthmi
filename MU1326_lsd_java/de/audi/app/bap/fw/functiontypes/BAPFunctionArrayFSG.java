/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunctionWithAck;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdogWithTimer;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPArrayFSGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPArrayFSGREQ;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerArrayFSG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;
import de.vw.mib.bap.requests.StatusArray;
import java.util.ArrayList;
import java.util.List;

public class BAPFunctionArrayFSG
extends AbstractBAPFunctionWithAck
implements IBAPArrayFSGIND,
IBAPArrayFSGREQ,
TimerListener {
    private GetArray getArraySerializer;
    private SetGetArray setGetArraySerializer;
    private final AbstractBAPModuleFSG moduleFsg;
    private final IBAPIndicationHandlerArrayFSG indicationHandler;
    private final ArrayRequestDispatcher arrayRequestDispatcher;
    private final List getArrayIndicationsQueue = new ArrayList();
    private volatile boolean requestInFlight = false;
    private static final int GET_ARRAY_NO_RESPONSE_TIMEOUT_DELAY_MS = 2100;
    private final Timer noResponseTimer;
    private ArrayHandler arrayHandler;

    public BAPFunctionArrayFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.noResponseTimer = new Timer("NoResponseTimer", 2100L, true, new TimerSyncer(this));
        this.arrayRequestDispatcher = new ArrayRequestDispatcher();
        this.addAcknowledgeListener(this.arrayRequestDispatcher);
    }

    public BAPFunctionArrayFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n, AcknowledgeWatchdog acknowledgeWatchdog) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.noResponseTimer = new Timer("NoResponseTimer", 2100L, true, new TimerSyncer(this));
        this.arrayRequestDispatcher = new ArrayRequestDispatcher(acknowledgeWatchdog);
        this.addAcknowledgeListener(this.arrayRequestDispatcher);
    }

    public BAPFunctionArrayFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n, Timer timer) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.noResponseTimer = timer;
        this.arrayRequestDispatcher = new ArrayRequestDispatcher();
        this.addAcknowledgeListener(this.arrayRequestDispatcher);
    }

    public void setArrayHandler(ArrayHandler arrayHandler) {
        this.arrayHandler = arrayHandler;
    }

    public ArrayHandler getArrayHandler() {
        return this.arrayHandler;
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 7: {
                this.logChannel.log(100000, "[BAPFunctionArrayFSG#getIndicationSerializer] Ack is not supported");
                return null;
            }
            case 2: {
                return this.getArraySerializer;
            }
            case 1: {
                this.logChannel.log(100000, "[BAPFunctionArrayFSG#getIndicationSerializer] Set is not supported");
                return null;
            }
            case 0: {
                return this.setGetArraySerializer;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionArrayFSG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public GetArrayIndication getPendingGetArrayIndication() {
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            return (GetArrayIndication)this.getArrayIndicationsQueue.get(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getGetArrayIndicationQueue() {
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            return new ArrayList(this.getArrayIndicationsQueue);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionArrayFSG#reset] called");
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            this.noResponseTimer.cancel();
            this.getArrayIndicationsQueue.clear();
            this.requestInFlight = false;
        }
        this.arrayRequestDispatcher.reset();
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 7 || n == 2 || n == 1 || n == 0;
    }

    public void processIndicationError(int n) {
        if (n == 55) {
            this.logChannel.log(10000000, "[BAPFunctionArrayFSG#processIndicationError] received error %1. Assume that max data length is exceeded", (Object)ErrorCodes.getDescription(this.lsgID, n));
            this.moduleFsg.getRequestHandler().requestError(this.lsgID, this.fctID, 9);
        } else {
            this.logChannel.log(10000000, "[BAPFunctionArrayFSG#processIndicationError] indication error ignored (lsgID=%1, fctID=%2, errorCode=%3)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)ErrorCodes.getDescription(this.lsgID, n));
        }
    }

    protected synchronized void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 7: {
                this.ackArrayIND();
                break;
            }
            case 2: {
                this.getArrayIND((GetArray)bAPEntity);
                break;
            }
            case 1: {
                this.setArrayIND((SetGetArray)bAPEntity);
                break;
            }
            case 0: {
                this.setGetArrayIND((SetGetArray)bAPEntity);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionArrayFSG#doProcessIndication] indicationType not supported by function type ARRAY: %1", (Object)IndicationTypes.getDescription(n));
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    public void ackArrayIND() {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#ackArrayIND]");
        this.ackArrayIND(null);
    }

    public void ackArrayIND(BAPArray bAPArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#ackArrayIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationAckArray(this, bAPArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getArrayIND(GetArray getArray) {
        if (this.arrayHandler == null) {
            this.logChannel.log(10000, "[BAPFunctionArrayFSG#getArrayIND] lsgID=%1, fctID=%2 arrayHandler not available", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.requestHandler.requestError(this.lsgID, this.fctID, 0);
            return;
        }
        GetArrayIndication getArrayIndication = this.indicationHandler.evaluateGetArrayIndication(this.fctID, getArray);
        if (getArrayIndication == null) {
            this.logChannel.log(10000, "[BAPFunctionArrayFSG#getArrayIND] lsgID=%1, fctID=%2 invalid array indication received", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            return;
        }
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#getArrayIND] lsgID=%1, fctID=%2 received getArrayIndication: ASG_ID=%3, TA_ID=%4", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)Integer.toString(getArrayIndication.getAsgID()), (long)getArrayIndication.getTaID());
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            if (this.getArrayIndicationsQueue.contains(getArrayIndication)) {
                this.logChannel.log(100000, "[BAPFunctionArrayFSG#getArrayIND] lsgID=%1, fctID=%2 ignoring retry for already received GetArray Indication. ASG_ID=%3, TA_ID=%4", (Object)this.lsgIDDesc, (Object)this.fctIDDesc, (Object)Integer.toString(getArrayIndication.getAsgID()), (long)getArrayIndication.getTaID());
                return;
            }
            this.getArrayIndicationsQueue.add(getArrayIndication);
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processQueue() {
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            if (!this.requestInFlight) {
                this.requestInFlight = true;
                this.noResponseTimer.restart();
                this.arrayHandler.requestListElements((GetArrayIndication)this.getArrayIndicationsQueue.get(0));
            }
        }
    }

    public void finishGetArrayIndicationWithError(int n) {
        this.moduleFsg.getRequestHandler().requestErrorCode(this.lsgID, this.fctID, n);
        this.finishGetArrayIndication();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void finishGetArrayIndication() {
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            this.noResponseTimer.cancel();
            this.requestInFlight = false;
            if (!this.getArrayIndicationsQueue.isEmpty()) {
                GetArrayIndication getArrayIndication = (GetArrayIndication)this.getArrayIndicationsQueue.remove(0);
                int n = getArrayIndication.getAsgID();
                int n2 = getArrayIndication.getTaID();
                if (this.getArrayIndicationsQueue.isEmpty()) {
                    this.logChannel.log(10000000, "[BAPFunctionArrayFSG#finishGetArrayIndication] ASG_ID=%1, TA_ID=%2 queue empty.", (long)n, (long)n2);
                } else {
                    this.logChannel.log(10000000, "[BAPFunctionArrayFSG#finishGetArrayIndication] ASG_ID=%1, TA_ID=%2 elements in queue %3.", (long)n, (long)n2, (long)this.getArrayIndicationsQueue.size());
                    this.processQueue();
                }
            } else {
                this.logChannel.log(100000, "[BAPFunctionArrayFSG#finishGetArrayIndication] indication already finished; queue is empty");
            }
        }
    }

    public void setArrayIND(SetGetArray setGetArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#setArrayIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationSetArray(this, setGetArray);
    }

    public void setGetArrayIND(SetGetArray setGetArray) {
        this.logChannel.log(10000000, "[BAPFunctionProperty#setGetIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationSetGetArray(this, setGetArray);
    }

    public synchronized void changedArrayREQ(ChangedArray changedArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#changedArrayREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.arrayRequestDispatcher.dispatch(new ArrayRequestJob(changedArray));
        this.setDataValid(true);
        this.notifyListenersDataChanged();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void statusArrayREQ(int n, StatusArray statusArray) {
        this.logChannel.log(10000000, "[BAPFunctionArrayFSG#statusArrayREQ] lsgID=%1, fctID=%2,", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        List list = this.getArrayIndicationsQueue;
        synchronized (list) {
            if (!this.getArrayIndicationsQueue.isEmpty()) {
                GetArrayIndication getArrayIndication = (GetArrayIndication)this.getArrayIndicationsQueue.get(0);
                if (getArrayIndication.getTaID() == n) {
                    this.arrayRequestDispatcher.dispatch(new ArrayRequestJob(statusArray));
                    this.finishGetArrayIndication();
                } else if (n == 0) {
                    this.arrayRequestDispatcher.dispatch(new ArrayRequestJob(statusArray));
                } else {
                    this.logChannel.log(10000, "[BAPFunctionArrayFSG#statusArrayREQ] invalid taID (%1), statusArray is not evaluated!", (long)n);
                }
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.noResponseTimer)) {
            this.logChannel.log(10000, "[BAPFunctionArrayFSG#fireTimer] lsgID=%1, fctID=%2, Timeout - no response received.", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.abortPendingGetArrayIndication();
        }
    }

    private void abortPendingGetArrayIndication() {
        this.requestHandler.requestError(this.lsgID, this.fctID, 6);
        this.finishGetArrayIndication();
    }

    public boolean sendFullRangeUpdate() {
        if (this.arrayHandler == null) {
            this.logChannel.log(10000, "[BAPFunctionArrayFSG#sendFullRangeUpdate] no array handler available for function (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            return false;
        }
        return this.arrayHandler.sendFullRangeUpdate();
    }

    public void setGetArraySerializer(GetArray getArray) {
        this.getArraySerializer = getArray;
    }

    public void setSetGetArraySerializer(SetGetArray setGetArray) {
        this.setGetArraySerializer = setGetArray;
    }

    private static final class ArrayRequestJob {
        private final int requestType;
        private final BAPArray serializer;

        private ArrayRequestJob(ChangedArray changedArray) {
            this.requestType = 10;
            this.serializer = changedArray;
        }

        private ArrayRequestJob(StatusArray statusArray) {
            this.requestType = 7;
            this.serializer = statusArray;
        }
    }

    private final class ArrayRequestDispatcher
    implements IAcknowledgeListener,
    AcknowledgeWatchdog.AcknowledgeWatchdogListener {
        private static final int NO_ACKNOWLEDGE_TIMEOUT_DELAY_ARRAY = 500;
        private final AcknowledgeWatchdog acknowledgeWatchdog;
        private final List arrayRequestQueue = new ArrayList(10);
        private volatile ArrayRequestJob currentJob;

        private ArrayRequestDispatcher() {
            this.acknowledgeWatchdog = new AcknowledgeWatchdogWithTimer(500);
            this.acknowledgeWatchdog.setListener(this);
        }

        private ArrayRequestDispatcher(AcknowledgeWatchdog acknowledgeWatchdog) {
            this.acknowledgeWatchdog = acknowledgeWatchdog;
            this.acknowledgeWatchdog.setListener(this);
        }

        private synchronized void dispatch(ArrayRequestJob arrayRequestJob) {
            this.arrayRequestQueue.add(arrayRequestJob);
            if (this.currentJob == null) {
                this.dispatchNext();
            } else {
                BAPFunctionArrayFSG.this.logChannel.log(10000000, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#dispatch] isIdle=false, %1 queuedRequests", (long)this.arrayRequestQueue.size());
            }
        }

        private synchronized void dispatchNext() {
            if (!this.arrayRequestQueue.isEmpty()) {
                BAPFunctionArrayFSG.this.logChannel.log(10000000, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2, remaining requests: %3", (Object)BAPFunctionArrayFSG.this.lsgIDDesc, (Object)BAPFunctionArrayFSG.this.fctIDDesc, (long)(this.arrayRequestQueue.size() - 1));
                this.currentJob = (ArrayRequestJob)this.arrayRequestQueue.remove(0);
                this.acknowledgeWatchdog.activate();
                if (!BAPFunctionArrayFSG.this.sendRequest(this.currentJob.requestType, this.currentJob.serializer)) {
                    this.acknowledgeWatchdog.deactivate();
                    this.currentJob = null;
                }
            }
        }

        public synchronized void processAcknowledge(int n, int n2) {
            if (n == BAPFunctionArrayFSG.this.fctID && this.currentJob != null && (this.currentJob.requestType == 10 && n2 == 4 || this.currentJob.requestType == 7 && n2 == 3)) {
                this.acknowledgeWatchdog.deactivate();
                this.currentJob = null;
                this.dispatchNext();
            }
        }

        public void acknowledgeMissing() {
            BAPFunctionArrayFSG.this.logChannel.log(100000, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#acknowledgeMissing] lsgID=%1, fctID=%2, Timeout - no acknowledge received", (Object)BAPFunctionArrayFSG.this.lsgIDDesc, (Object)BAPFunctionArrayFSG.this.fctIDDesc);
            if (this.currentJob != null && this.currentJob.requestType == 10) {
                this.processAcknowledge(BAPFunctionArrayFSG.this.fctID, 4);
            } else if (this.currentJob != null && this.currentJob.requestType == 7) {
                this.processAcknowledge(BAPFunctionArrayFSG.this.fctID, 3);
            }
            BAPFunctionArrayFSG.this.notifyListenersAcknowledgeTimeout();
        }

        public synchronized void reset() {
            this.acknowledgeWatchdog.deactivate();
            this.arrayRequestQueue.clear();
            this.currentJob = null;
        }
    }
}

