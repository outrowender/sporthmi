/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunctionWithAck;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdogWithTimer;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyASGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyASGREQ;
import de.audi.app.bap.fw.functiontypes.queuing.Request;
import de.audi.app.bap.fw.functiontypes.queuing.RequestPropertyAck;
import de.audi.app.bap.fw.functiontypes.queuing.RequestPropertyGet;
import de.audi.app.bap.fw.functiontypes.queuing.RequestPropertySetGet;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerPropertyASG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.List;

public class BAPFunctionPropertyASG
extends AbstractBAPFunctionWithAck
implements IBAPPropertyASGIND,
IBAPPropertyASGREQ,
AcknowledgeWatchdog.AcknowledgeWatchdogListener {
    private static final int NO_ACKNOWLEDGE_TIMEOUT_DELAY_MS = 1000;
    private static final int NO_ACKNOWLEDGE = -1;
    private final List requestsQueue = new ArrayList();
    private volatile boolean requestInFlight = false;
    private final AcknowledgeWatchdog acknowledgeWatchdog;
    private BAPEntity resetSerializer;
    private volatile StatusProperty statusSerializer;
    private StatusAckProperty statusAckSerializer;
    private SetGetProperty setGetSerializer;
    private final IBAPIndicationHandlerPropertyASG indicationHandler;
    private final List statusListeners = new ArrayList();

    public BAPFunctionPropertyASG(AbstractBAPModuleASG abstractBAPModuleASG, int n) {
        super(abstractBAPModuleASG, n);
        this.indicationHandler = abstractBAPModuleASG.getIndicationHandler();
        this.acknowledgeWatchdog = new AcknowledgeWatchdogWithTimer(1000);
        this.acknowledgeWatchdog.setListener(this);
    }

    public BAPFunctionPropertyASG(AbstractBAPModuleASG abstractBAPModuleASG, int n, AcknowledgeWatchdog acknowledgeWatchdog) {
        super(abstractBAPModuleASG, n);
        this.indicationHandler = abstractBAPModuleASG.getIndicationHandler();
        this.acknowledgeWatchdog = acknowledgeWatchdog;
        this.acknowledgeWatchdog.setListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#reset]");
        this.setGetSerializer = null;
        List list = this.requestsQueue;
        synchronized (list) {
            this.acknowledgeWatchdog.deactivate();
            this.requestsQueue.clear();
            this.requestInFlight = false;
        }
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 13: {
                return this.resetSerializer;
            }
            case 9: {
                return this.statusSerializer;
            }
            case 8: {
                return this.statusAckSerializer;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionPropertyASG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 9 || n == 8;
    }

    protected void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 9: {
                this.statusIND((StatusProperty)bAPEntity);
                break;
            }
            case 8: {
                this.statusAckIND((StatusAckProperty)bAPEntity);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionPropertyASG#doProcessIndication] indicationType not supported by function type PROPERTY: %1", (Object)IndicationTypes.getDescription(n));
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyASG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    public void statusIND(StatusProperty statusProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyASG#statusIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationStatus(this, statusProperty);
        this.notifyListenersStatusIndicationReceived();
    }

    public void statusAckIND(StatusAckProperty statusAckProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyASG#statusAckIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationStatusAck(this, statusAckProperty);
        this.notifyListenersStatusIndicationReceived();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getREQ() {
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(this.requestGet());
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGetREQ() {
        if (this.setGetSerializer != null) {
            List list = this.requestsQueue;
            synchronized (list) {
                this.requestsQueue.add(this.requestSetGet(this.setGetSerializer));
                this.processQueue();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGetREQ(SetGetProperty setGetProperty) {
        this.setGetSerializer = setGetProperty;
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(this.requestSetGet(setGetProperty));
            this.processQueue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ackREQ(AckProperty ackProperty) {
        List list = this.requestsQueue;
        synchronized (list) {
            this.requestsQueue.add(this.requestAck(ackProperty));
            this.processQueue();
        }
    }

    private void processQueue() {
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#processQueue]");
        if (this.requestInFlight) {
            return;
        }
        Request request = (Request)this.requestsQueue.get(0);
        boolean bl = request.send();
        if (!bl) {
            this.logChannel.log(100000, "[BAPFunctionPropertyASG#processQueue] could not send request");
            this.requestsQueue.remove(0);
            return;
        }
        this.acknowledgeWatchdog.activate();
        this.requestInFlight = true;
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#processQueue] request sent");
    }

    public void processAcknowledge(int n) {
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#processAcknowledge]");
        this.acknowledgeWatchdog.deactivate();
        this.handleNextRequestInQueue(n);
        super.processAcknowledge(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleNextRequestInQueue(int n) {
        List list = this.requestsQueue;
        synchronized (list) {
            if (this.requestsQueue.isEmpty()) {
                this.logChannel.log(10000, "[BAPFunctionPropertyASG#processAcknowledge] ignoring unexpected acknowledge: %1", (long)n);
                return;
            }
            this.requestsQueue.remove(0);
            boolean bl = false;
            while (!bl && !this.requestsQueue.isEmpty()) {
                bl = ((Request)this.requestsQueue.get(0)).send();
                if (!bl) {
                    this.logChannel.log(100000, "[BAPFunctionPropertyASG#processQueue] could not send request");
                    this.requestsQueue.remove(0);
                    continue;
                }
                this.acknowledgeWatchdog.activate();
                this.logChannel.log(100000000, "[BAPFunctionPropertyASG#handleNextRequestInQueue] request sent");
            }
            if (this.requestsQueue.isEmpty()) {
                this.requestInFlight = false;
            }
        }
    }

    public void acknowledgeMissing() {
        this.logChannel.log(100000, "[BAPFunctionPropertyASG#acknowledgeMissing]");
        this.handleNextRequestInQueue(-1);
        this.notifyListenersAcknowledgeTimeout();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addStatusListener(IBAPFunctionStatusListener iBAPFunctionStatusListener) {
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#addStatusListener] listener: %1", (Object)iBAPFunctionStatusListener);
        List list = this.statusListeners;
        synchronized (list) {
            if (!this.statusListeners.contains(iBAPFunctionStatusListener)) {
                this.statusListeners.add(iBAPFunctionStatusListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeStatusListener(IBAPFunctionStatusListener iBAPFunctionStatusListener) {
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#removeStatusListener] listener: %1", (Object)iBAPFunctionStatusListener);
        List list = this.statusListeners;
        synchronized (list) {
            this.statusListeners.remove(iBAPFunctionStatusListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyListenersStatusIndicationReceived() {
        ArrayList arrayList;
        Object object = this.statusListeners;
        synchronized (object) {
            if (this.statusListeners.isEmpty()) {
                return;
            }
            arrayList = new ArrayList(this.statusListeners);
        }
        this.logChannel.log(100000000, "[BAPFunctionPropertyASG#notifyListenersDataChanged] status indication received -> inform listeners (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        object = arrayList.iterator();
        while (object.hasNext()) {
            IBAPFunctionStatusListener iBAPFunctionStatusListener = (IBAPFunctionStatusListener)object.next();
            iBAPFunctionStatusListener.notifyStatusIndicationReceived(this.fctID, this.statusSerializer);
        }
    }

    public BAPEntity getResetSerializer() {
        return this.resetSerializer;
    }

    public void setResetSerializer(BAPEntity bAPEntity) {
        this.resetSerializer = bAPEntity;
    }

    public SetGetProperty getSetGetSerializer() {
        return this.setGetSerializer;
    }

    public void setSetGetSerializer(SetGetProperty setGetProperty) {
        this.setGetSerializer = setGetProperty;
    }

    public StatusProperty getStatusSerializer() {
        return this.statusSerializer;
    }

    public void setStatusSerializer(StatusProperty statusProperty) {
        this.statusSerializer = statusProperty;
    }

    public StatusAckProperty getStatusAckSerializer() {
        return this.statusAckSerializer;
    }

    public void setStatusAckSerializer(StatusAckProperty statusAckProperty) {
        this.statusAckSerializer = statusAckProperty;
    }

    private Request requestAck(AckProperty ackProperty) {
        return new RequestPropertyAck(this, ackProperty);
    }

    private Request requestGet() {
        return new RequestPropertyGet(this);
    }

    private Request requestSetGet(SetGetProperty setGetProperty) {
        return new RequestPropertySetGet(this, setGetProperty);
    }
}

