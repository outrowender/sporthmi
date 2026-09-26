/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog$AcknowledgeWatchdogListener;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdogWithTimer;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG$1;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.vw.mib.bap.requests.StatusProperty;

class BAPFunctionPropertyFSG$StatusRequestDispatcher
implements IAcknowledgeListener,
AcknowledgeWatchdog$AcknowledgeWatchdogListener {
    private volatile boolean isIdle = true;
    private volatile boolean statusAcknowledged = false;
    private volatile boolean statusRequestTransmissionPending = false;
    protected static final int NO_ACKNOWLEDGE_TIMEOUT_DELAY;
    private final AcknowledgeWatchdog acknowledgeWatchdog;
    private final /* synthetic */ BAPFunctionPropertyFSG this$0;

    private BAPFunctionPropertyFSG$StatusRequestDispatcher(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
        this.this$0 = bAPFunctionPropertyFSG;
        this.acknowledgeWatchdog = new AcknowledgeWatchdogWithTimer(1000);
        this.acknowledgeWatchdog.setListener(this);
    }

    private BAPFunctionPropertyFSG$StatusRequestDispatcher(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AcknowledgeWatchdog acknowledgeWatchdog) {
        this.this$0 = bAPFunctionPropertyFSG;
        this.acknowledgeWatchdog = acknowledgeWatchdog;
        this.acknowledgeWatchdog.setListener(this);
    }

    private synchronized void dispatch(StatusProperty statusProperty) {
        this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] serializer: %1", (Object)statusProperty);
        this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] member statusSerializer: %1", (Object)BAPFunctionPropertyFSG.access$000(this.this$0));
        this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] setGetPending=%1 ", BAPFunctionPropertyFSG.access$100(this.this$0));
        this.statusRequestTransmissionPending = true;
        if (!BAPFunctionPropertyFSG.access$000(this.this$0).equalTo(statusProperty)) {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] Set: statusSerializer = serializer");
            BAPFunctionPropertyFSG.access$002(this.this$0, statusProperty);
        }
        if (this.isIdle) {
            if (this.isSendingAllowed()) {
                BAPFunctionPropertyFSG.access$102(this.this$0, false);
                this.dispatchNext();
            } else {
                this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] (fctID=%1) module state before initialization (state=%2) -> don't send status request", (Object)this.this$0.fctIDDesc, (long)this.this$0.moduleFsg.getInitializationManager().getInitState());
            }
        } else {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatch] (fctID=%1) isIdle=false", (Object)this.this$0.fctIDDesc);
        }
    }

    private boolean isSendingAllowed() {
        return this.this$0.moduleFsg.getInitializationManager().getInitState() >= 4 || this.this$0.moduleFsg.isUpdateBeforeInit(this.this$0.fctID) && this.this$0.moduleFsg.getInitializationManager().getHMIState() != 0 || BAPFunctionPropertyFSG.access$100(this.this$0) && this.this$0.moduleFsg.getInitializationManager().getHMIState() != 0;
    }

    private synchronized void dispatchNext() {
        if (this.statusRequestTransmissionPending) {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc);
            this.statusAcknowledged = false;
            this.statusRequestTransmissionPending = false;
            this.this$0.setDataValid(true);
            this.this$0.notifyListenersDataChanged();
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] sending: %1", (Object)BAPFunctionPropertyFSG.access$000(this.this$0));
            if (this.this$0.sendRequest(7, BAPFunctionPropertyFSG.access$000(this.this$0))) {
                if (!this.statusAcknowledged) {
                    this.isIdle = false;
                    this.acknowledgeWatchdog.activate();
                } else {
                    this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] status already acknowledged");
                }
            } else {
                this.statusRequestTransmissionPending = true;
            }
        } else {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2, no pending status serializer", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc);
        }
    }

    @Override
    public synchronized void processAcknowledge(int n, int n2) {
        if (n == this.this$0.fctID && n2 == 0) {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#processAcknowledge] lsgID=%1, fctID=%2", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc);
            this.acknowledgeWatchdog.deactivate();
            this.statusAcknowledged = true;
            this.isIdle = true;
            this.dispatchNext();
        }
    }

    @Override
    public void acknowledgeMissing() {
        this.this$0.logChannel.log(-1601830656, "[BAPFunctionPropertyFSG.StatusRequestDispatcher#acknowledgeMissing] lsgID=%1, fctID=%2, Timeout - no acknowledge received", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc);
        this.processAcknowledge(this.this$0.fctID, 0);
        this.this$0.notifyListenersAcknowledgeTimeout();
    }

    public void reset() {
        this.acknowledgeWatchdog.deactivate();
        this.statusAcknowledged = false;
        this.isIdle = true;
    }

    /* synthetic */ BAPFunctionPropertyFSG$StatusRequestDispatcher(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, BAPFunctionPropertyFSG$1 bAPFunctionPropertyFSG$1) {
        this(bAPFunctionPropertyFSG);
    }

    /* synthetic */ BAPFunctionPropertyFSG$StatusRequestDispatcher(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, AcknowledgeWatchdog acknowledgeWatchdog, BAPFunctionPropertyFSG$1 bAPFunctionPropertyFSG$1) {
        this(bAPFunctionPropertyFSG, acknowledgeWatchdog);
    }

    static /* synthetic */ boolean access$402(BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher, boolean bl) {
        bAPFunctionPropertyFSG$StatusRequestDispatcher.statusRequestTransmissionPending = bl;
        return bAPFunctionPropertyFSG$StatusRequestDispatcher.statusRequestTransmissionPending;
    }

    static /* synthetic */ void access$500(BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher, StatusProperty statusProperty) {
        bAPFunctionPropertyFSG$StatusRequestDispatcher.dispatch(statusProperty);
    }

    static /* synthetic */ boolean access$400(BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher) {
        return bAPFunctionPropertyFSG$StatusRequestDispatcher.statusRequestTransmissionPending;
    }

    static /* synthetic */ boolean access$600(BAPFunctionPropertyFSG$StatusRequestDispatcher bAPFunctionPropertyFSG$StatusRequestDispatcher) {
        return bAPFunctionPropertyFSG$StatusRequestDispatcher.statusAcknowledged;
    }
}

