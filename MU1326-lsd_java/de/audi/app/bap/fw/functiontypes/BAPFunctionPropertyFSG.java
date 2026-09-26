/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunctionWithAck;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG$StatusRequestDispatcher;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyFSGIND;
import de.audi.app.bap.fw.functiontypes.protocol.IBAPPropertyFSGREQ;
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
    private final BAPFunctionPropertyFSG$StatusRequestDispatcher statusRequestDispatcher;
    private volatile boolean controlledByFunctionSync = false;
    private volatile boolean isFunctionSyncProperty = false;
    private volatile boolean setGetPending = false;

    public void setControlledByFunctionSync(boolean bl) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#setControlledByFunctionSync] enabled=%1, lsgID=%2, fctID=%3, ", bl, (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
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
        this.statusRequestDispatcher = new BAPFunctionPropertyFSG$StatusRequestDispatcher(this, null);
        this.addAcknowledgeListener(this.statusRequestDispatcher);
    }

    public BAPFunctionPropertyFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, int n, AcknowledgeWatchdog acknowledgeWatchdog) {
        super(abstractBAPModuleFSG, n);
        this.moduleFsg = abstractBAPModuleFSG;
        this.indicationHandler = abstractBAPModuleFSG.getIndicationHandler();
        this.statusRequestDispatcher = new BAPFunctionPropertyFSG$StatusRequestDispatcher(this, acknowledgeWatchdog, null);
        this.addAcknowledgeListener(this.statusRequestDispatcher);
    }

    @Override
    public BAPEntity getIndicationSerializer(int n) {
        switch (n) {
            case 13: {
                return this.resetSerializer;
            }
            case 1: {
                this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#getIndicationSerializer] Set is not supported");
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
    @Override
    public void reset() {
        this.logChannel.log(14808325, "[BAPFunctionPropertyFSG#reset] called");
        BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (bAPFunctionPropertyFSG$StatusRequestDispatcher) {
            this.resetIndication();
            this.statusRequestDispatcher.reset();
        }
    }

    private void resetIndication() {
        this.setGetPending = false;
    }

    @Override
    protected boolean isIndicationTypeSupported(int n) {
        return n == 7 || n == 1 || n == 0;
    }

    @Override
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

    @Override
    protected void doProcessError(int n) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#doProcessError] Received BAP Error: 0x%2, %1", (Object)ErrorCodes.getDescription(n), (long)n);
    }

    @Override
    public void getIND() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setGetIND(SetGetProperty setGetProperty) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#setGetIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (bAPFunctionPropertyFSG$StatusRequestDispatcher) {
            this.setGetPending = true;
        }
        this.indicationHandler.processIndicationSetGet(this, setGetProperty);
    }

    @Override
    public void setIND(SetGetProperty setGetProperty) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#setIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationSet(this, setGetProperty);
    }

    @Override
    public void ackIND(AckProperty ackProperty) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#ackIND] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.indicationHandler.processIndicationAck(this, ackProperty);
    }

    @Override
    public void sendStatus(StatusProperty statusProperty) {
        this.statusREQ(statusProperty, true);
    }

    @Override
    public void sendStatusIfChanged(StatusProperty statusProperty) {
        this.statusREQ(statusProperty, false);
    }

    @Override
    public void resendLastStatus() {
        this.statusREQ(this.getLastStatus(), true);
    }

    @Override
    public void sendStatusAck(StatusAckProperty statusAckProperty) {
        this.logChannel.log(14808325, "[BAPFunctionPropertyFSG#statusAckREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.statusAckSerializer = statusAckProperty;
        if (!this.sendRequest(11, statusAckProperty)) {
            BAPFunctionPropertyFSG$StatusRequestDispatcher.access$402(this.statusRequestDispatcher, true);
        }
        this.setDataValid(true);
        this.notifyListenersDataChanged();
    }

    @Override
    public void resendLastStatusAck() {
        this.sendStatusAck(this.statusAckSerializer);
    }

    @Override
    public void setInitialStatus(StatusProperty statusProperty) {
        this.statusSerializer = statusProperty;
    }

    @Override
    public void setInitialStatusAck(StatusAckProperty statusAckProperty) {
        this.statusAckSerializer = statusAckProperty;
    }

    public boolean isLastStatusAvailable() {
        return this.statusSerializer != null;
    }

    @Override
    public StatusProperty getLastStatus() {
        this.initStatusSerializerIfNeeded();
        return this.statusSerializer;
    }

    public boolean isLastStatusAckAvailable() {
        return this.statusAckSerializer != null;
    }

    @Override
    public StatusAckProperty getLastStatusAck() {
        this.initStatusAckSerializerIfNeeded();
        return this.statusAckSerializer;
    }

    private void statusREQ(StatusProperty statusProperty, boolean bl) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#statusREQ] lsgID=%1, fctID=%2", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
        this.initStatusSerializerIfNeeded();
        IFunctionSynchronizationHandler iFunctionSynchronizationHandler = this.moduleFsg.getFunctionSynchronizationHandler();
        if (this.isControlledByFunctionSync() && iFunctionSynchronizationHandler != null) {
            if (!iFunctionSynchronizationHandler.isQueuedPropertiesSent()) {
                this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#statusREQ] function sync is activated for property %1, %2 but currently not running -> enqueue request in function sync", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
                if (iFunctionSynchronizationHandler.enqueuePropertyUpdate(this, statusProperty)) {
                    return;
                }
            } else if (iFunctionSynchronizationHandler.isQueuedPropertiesSent() && iFunctionSynchronizationHandler.isSyncCancelled()) {
                this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#statusREQ] function sync was cancelled after sending property %1, %2 -> trying to enqueue request in pending function sync", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
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
            BAPFunctionPropertyFSG$StatusRequestDispatcher.access$500(this.statusRequestDispatcher, statusProperty);
        } else {
            this.logChannel.log(14808325, "[BAPFunctionPropertyFSG#statusREQ] value didn't change -> don't send request (lsgID=%1, fctID=%2)", (Object)this.lsgIDDesc, (Object)this.fctIDDesc);
            this.notifyListenersDataNotChanged();
        }
    }

    public void sendQueued(StatusProperty statusProperty) {
        this.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG#sendQueued]");
        this.initStatusSerializerIfNeeded();
        BAPFunctionPropertyFSG$StatusRequestDispatcher.access$500(this.statusRequestDispatcher, statusProperty);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isStatusRequestTransmissionPending() {
        BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (bAPFunctionPropertyFSG$StatusRequestDispatcher) {
            return BAPFunctionPropertyFSG$StatusRequestDispatcher.access$400(this.statusRequestDispatcher);
        }
    }

    public boolean isStatusAcknowledged() {
        return BAPFunctionPropertyFSG$StatusRequestDispatcher.access$600(this.statusRequestDispatcher);
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
        BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (bAPFunctionPropertyFSG$StatusRequestDispatcher) {
            return this.statusSerializer;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStatusSerializer(StatusProperty statusProperty) {
        BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher = this.statusRequestDispatcher;
        synchronized (bAPFunctionPropertyFSG$StatusRequestDispatcher) {
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

    static /* synthetic */ StatusProperty access$000(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        return bAPFunctionPropertyFSG.statusSerializer;
    }

    static /* synthetic */ boolean access$100(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        return bAPFunctionPropertyFSG.setGetPending;
    }

    static /* synthetic */ StatusProperty access$002(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, StatusProperty statusProperty) {
        bAPFunctionPropertyFSG.statusSerializer = statusProperty;
        return bAPFunctionPropertyFSG.statusSerializer;
    }

    static /* synthetic */ boolean access$102(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, boolean bl) {
        bAPFunctionPropertyFSG.setGetPending = bl;
        return bAPFunctionPropertyFSG.setGetPending;
    }
}

