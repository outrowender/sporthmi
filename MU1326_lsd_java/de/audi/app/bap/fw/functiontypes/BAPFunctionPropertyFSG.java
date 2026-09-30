/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunctionWithAck;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdogWithTimer;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyFSGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyFSGREQ;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerPropertyFSG;
import de.audi.app.bap.utils.ErrorCodes;
import de.audi.app.bap.utils.IndicationTypes;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public class BAPFunctionPropertyFSG
extends AbstractBAPFunctionWithAck
implements IBAPPropertyFSGIND,
IBAPPropertyFSGREQ {
    private BAPEntity resetSerializer;
    private SetGetProperty setGetSerializer;
    private volatile StatusProperty statusSerializer;
    private AckProperty ackSerializer;
    private StatusAckProperty statusAckSerializer;
    protected final AbstractBAPModuleFSG moduleFsg;
    private final IBAPIndicationHandlerPropertyFSG indicationHandler;
    private final StatusRequestDispatcher statusRequestDispatcher;
    private volatile boolean controlledByFunctionSync = false;
    private volatile boolean isFunctionSyncProperty = false;
    private volatile boolean setGetPending = false;

    public void setControlledByFunctionSync(boolean bl) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#setControlledByFunctionSync] enabled=%1, lsgID=%2, fctID=%3, ", bl, (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.controlledByFunctionSync = bl;
    }

    public boolean isControlledByFunctionSync() {
        return this.controlledByFunctionSync;
    }

    public void setIsFunctionSyncProperty(boolean bl) {
        this.isFunctionSyncProperty = bl;
    }

    public BAPFunctionPropertyFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.statusRequestDispatcher = new StatusRequestDispatcher();
        this.addAcknowledgeListener(this.statusRequestDispatcher);
    }

    public BAPFunctionPropertyFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n, AcknowledgeWatchdog acknowledgeWatchdog) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.statusRequestDispatcher = new StatusRequestDispatcher(acknowledgeWatchdog);
        this.addAcknowledgeListener(this.statusRequestDispatcher);
    }

    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 13: {
                return this.resetSerializer;
            }
            case 1: {
                this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#getIndicationSerializer] Set is not supported");
                return null;
            }
            case 0: {
                return this.setGetSerializer;
            }
            case 7: {
                return this.ackSerializer;
            }
        }
        this.logChannel.log(10000, "[BAPFunctionPropertyFSG#getIndicationSerializer] fctIDDesc: %1 invalid. indicationType: %2", (Object)this.fctIDDesc, (long)n);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(100000000, "[BAPFunctionPropertyFSG#reset] called");
        StatusRequestDispatcher statusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (statusRequestDispatcher) {
            this.resetIndication();
            this.statusRequestDispatcher.reset();
        }
    }

    private void resetIndication() {
        this.setGetPending = false;
    }

    protected boolean isIndicationTypeSupported(int n) {
        return n == 7 || n == 1 || n == 0;
    }

    protected synchronized void doProcessIndication(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 7: {
                this.ackIND((AckProperty)bAPEntity);
                break;
            }
            case 1: {
                this.setIND((SetGetProperty)bAPEntity);
                break;
            }
            case 0: {
                this.setGetIND((SetGetProperty)bAPEntity);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPFunctionPropertyFSG#doProcessIndication] indicationType not supported by function type PROPERTY: %1", (Object)IndicationTypes.getDescription(n));
                this.requestHandler.requestError(this.lsgID, this.fctID, 4);
            }
        }
    }

    protected void doProcessError(int n) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    public void getIND() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGetIND(SetGetProperty setGetProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#setGetIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        StatusRequestDispatcher statusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (statusRequestDispatcher) {
            this.setGetPending = true;
        }
        this.indicationHandler.processIndicationSetGet(this, setGetProperty);
    }

    public void setIND(SetGetProperty setGetProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#setIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationSet(this, setGetProperty);
    }

    public void ackIND(AckProperty ackProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#ackIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationAck(this, ackProperty);
    }

    public void sendStatus(StatusProperty statusProperty) {
        this.statusREQ(statusProperty, true);
    }

    public void sendStatusIfChanged(StatusProperty statusProperty) {
        this.statusREQ(statusProperty, false);
    }

    public void resendLastStatus() {
        this.statusREQ(this.getLastStatus(), true);
    }

    public void sendStatusAck(StatusAckProperty statusAckProperty) {
        this.logChannel.log(100000000, "[BAPFunctionPropertyFSG#statusAckREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.statusAckSerializer = statusAckProperty;
        if (!this.sendRequest(11, statusAckProperty)) {
            this.statusRequestDispatcher.statusRequestTransmissionPending = true;
        }
        this.setDataValid(true);
        this.notifyListenersDataChanged();
    }

    public void resendLastStatusAck() {
        this.sendStatusAck(this.statusAckSerializer);
    }

    public void setInitialStatus(StatusProperty statusProperty) {
        this.statusSerializer = statusProperty;
    }

    public void setInitialStatusAck(StatusAckProperty statusAckProperty) {
        this.statusAckSerializer = statusAckProperty;
    }

    public boolean isLastStatusAvailable() {
        return this.statusSerializer != null;
    }

    public StatusProperty getLastStatus() {
        this.initStatusSerializerIfNeeded();
        return this.statusSerializer;
    }

    public boolean isLastStatusAckAvailable() {
        return this.statusAckSerializer != null;
    }

    public StatusAckProperty getLastStatusAck() {
        this.initStatusAckSerializerIfNeeded();
        return this.statusAckSerializer;
    }

    private void statusREQ(StatusProperty statusProperty, boolean bl) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#statusREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.initStatusSerializerIfNeeded();
        IFunctionSynchronizationHandler iFunctionSynchronizationHandler = this.moduleFsg.getFunctionSynchronizationHandler();
        if (this.isControlledByFunctionSync() && iFunctionSynchronizationHandler != null) {
            if (!iFunctionSynchronizationHandler.isQueuedPropertiesSent()) {
                this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#statusREQ] function sync is activated for property %1, %2 but currently not running -> enqueue request in function sync", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                if (iFunctionSynchronizationHandler.enqueuePropertyUpdate(this, statusProperty)) {
                    return;
                }
            } else if (iFunctionSynchronizationHandler.isQueuedPropertiesSent() && iFunctionSynchronizationHandler.isSyncCancelled()) {
                this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#statusREQ] function sync was cancelled after sending property %1, %2 -> trying to enqueue request in pending function sync", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                if (iFunctionSynchronizationHandler.enqueuePropertyUpdate(this, statusProperty)) {
                    return;
                }
            }
        }
        boolean bl2 = true;
        if (iFunctionSynchronizationHandler == null || iFunctionSynchronizationHandler.getSyncState() == 0 || this.isFunctionSyncProperty) {
            boolean bl3 = bl2 = !statusProperty.equalTo(this.statusSerializer);
        }
        if (bl2 || !this.isDataValid() || this.setGetPending || bl) {
            this.statusRequestDispatcher.dispatch(statusProperty);
        } else {
            this.logChannel.log(100000000, "[BAPFunctionPropertyFSG#statusREQ] value didn't change -> don't send request (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.notifyListenersDataNotChanged();
        }
    }

    public void sendQueued(StatusProperty statusProperty) {
        this.logChannel.log(10000000, "[BAPFunctionPropertyFSG#sendQueued]");
        this.initStatusSerializerIfNeeded();
        this.statusRequestDispatcher.dispatch(statusProperty);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isStatusRequestTransmissionPending() {
        StatusRequestDispatcher statusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (statusRequestDispatcher) {
            return this.statusRequestDispatcher.statusRequestTransmissionPending;
        }
    }

    public boolean isStatusAcknowledged() {
        return this.statusRequestDispatcher.statusAcknowledged;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public StatusProperty getStatusSerializer() {
        StatusRequestDispatcher statusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (statusRequestDispatcher) {
            return this.statusSerializer;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStatusSerializer(StatusProperty statusProperty) {
        StatusRequestDispatcher statusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (statusRequestDispatcher) {
            this.statusSerializer = statusProperty;
        }
    }

    public AckProperty getAckSerializer() {
        return this.ackSerializer;
    }

    public void setAckSerializer(AckProperty ackProperty) {
        this.ackSerializer = ackProperty;
    }

    public StatusAckProperty getStatusAckSerializer() {
        return this.statusAckSerializer;
    }

    public void setStatusAckSerializer(StatusAckProperty statusAckProperty) {
        this.statusAckSerializer = statusAckProperty;
    }

    private void initStatusSerializerIfNeeded() {
        if (this.statusSerializer == null) {
            this.statusSerializer = this.moduleFsg.createStatusSerializer(this.fctID);
        }
    }

    private void initStatusAckSerializerIfNeeded() {
        if (this.statusAckSerializer == null) {
            this.statusAckSerializer = this.moduleFsg.createStatusAckSerializer(this.fctID);
        }
    }

    private class StatusRequestDispatcher
    implements IAcknowledgeListener,
    AcknowledgeWatchdog.AcknowledgeWatchdogListener {
        private volatile boolean isIdle = true;
        private volatile boolean statusAcknowledged = false;
        private volatile boolean statusRequestTransmissionPending = false;
        protected static final int NO_ACKNOWLEDGE_TIMEOUT_DELAY = 1000;
        private final AcknowledgeWatchdog acknowledgeWatchdog;

        private StatusRequestDispatcher() {
            this.acknowledgeWatchdog = new AcknowledgeWatchdogWithTimer(1000);
            this.acknowledgeWatchdog.setListener(this);
        }

        private StatusRequestDispatcher(AcknowledgeWatchdog acknowledgeWatchdog) {
            this.acknowledgeWatchdog = acknowledgeWatchdog;
            this.acknowledgeWatchdog.setListener(this);
        }

        private synchronized void dispatch(StatusProperty statusProperty) {
            BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] serializer: %1", (Object)statusProperty);
            BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] member statusSerializer: %1", (Object)BAPFunctionPropertyFSG.this.statusSerializer);
            BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] setGetPending=%1 ", BAPFunctionPropertyFSG.this.setGetPending);
            this.statusRequestTransmissionPending = true;
            if (!BAPFunctionPropertyFSG.this.statusSerializer.equalTo(statusProperty)) {
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] Set: statusSerializer = serializer");
                BAPFunctionPropertyFSG.this.statusSerializer = statusProperty;
            }
            if (this.isIdle) {
                if (this.isSendingAllowed()) {
                    BAPFunctionPropertyFSG.this.setGetPending = false;
                    this.dispatchNext();
                } else {
                    BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] (fctID=%1) module state before initialization (state=%2) -> don't send status request", (Object)BAPFunctionPropertyFSG.this.fctIDDesc, (long)BAPFunctionPropertyFSG.this.moduleFsg.getInitializationManager().getInitState());
                }
            } else {
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] (fctID=%1) isIdle=false", (Object)BAPFunctionPropertyFSG.this.fctIDDesc);
            }
        }

        private boolean isSendingAllowed() {
            return BAPFunctionPropertyFSG.this.moduleFsg.getInitializationManager().getInitState() >= 4 || BAPFunctionPropertyFSG.this.moduleFsg.isUpdateBeforeInit(BAPFunctionPropertyFSG.this.fctID) && BAPFunctionPropertyFSG.this.moduleFsg.getInitializationManager().getHMIState() != 0 || BAPFunctionPropertyFSG.this.setGetPending && BAPFunctionPropertyFSG.this.moduleFsg.getInitializationManager().getHMIState() != 0;
        }

        private synchronized void dispatchNext() {
            if (this.statusRequestTransmissionPending) {
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2", (Object)BAPFunctionPropertyFSG.this.lsgIDDesc, (Object)BAPFunctionPropertyFSG.this.fctIDDesc);
                this.statusAcknowledged = false;
                this.statusRequestTransmissionPending = false;
                BAPFunctionPropertyFSG.this.setDataValid(true);
                BAPFunctionPropertyFSG.this.notifyListenersDataChanged();
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] sending: %1", (Object)BAPFunctionPropertyFSG.this.statusSerializer);
                if (BAPFunctionPropertyFSG.this.sendRequest(7, BAPFunctionPropertyFSG.this.statusSerializer)) {
                    if (!this.statusAcknowledged) {
                        this.isIdle = false;
                        this.acknowledgeWatchdog.activate();
                    } else {
                        BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] status already acknowledged");
                    }
                } else {
                    this.statusRequestTransmissionPending = true;
                }
            } else {
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2, no pending status serializer", (Object)BAPFunctionPropertyFSG.this.lsgIDDesc, (Object)BAPFunctionPropertyFSG.this.fctIDDesc);
            }
        }

        public synchronized void processAcknowledge(int n, int n2) {
            if (n == BAPFunctionPropertyFSG.this.fctID && n2 == 0) {
                BAPFunctionPropertyFSG.this.logChannel.log(10000000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#processAcknowledge] lsgID=%1, fctID=%2", (Object)BAPFunctionPropertyFSG.this.lsgIDDesc, (Object)BAPFunctionPropertyFSG.this.fctIDDesc);
                this.acknowledgeWatchdog.deactivate();
                this.statusAcknowledged = true;
                this.isIdle = true;
                this.dispatchNext();
            }
        }

        public void acknowledgeMissing() {
            BAPFunctionPropertyFSG.this.logChannel.log(100000, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#acknowledgeMissing] lsgID=%1, fctID=%2, Timeout - no acknowledge received", (Object)BAPFunctionPropertyFSG.this.lsgIDDesc, (Object)BAPFunctionPropertyFSG.this.fctIDDesc);
            this.processAcknowledge(BAPFunctionPropertyFSG.this.fctID, 0);
            BAPFunctionPropertyFSG.this.notifyListenersAcknowledgeTimeout();
        }

        public void reset() {
            this.acknowledgeWatchdog.deactivate();
            this.statusAcknowledged = false;
            this.isIdle = true;
        }
    }
}

