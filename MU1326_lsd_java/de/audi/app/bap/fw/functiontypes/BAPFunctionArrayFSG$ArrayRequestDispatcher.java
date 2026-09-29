/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog$AcknowledgeWatchdogListener;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdogWithTimer;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG$1;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG$ArrayRequestJob;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import java.util.ArrayList;
import java.util.List;

final class BAPFunctionArrayFSG$ArrayRequestDispatcher
implements IAcknowledgeListener,
AcknowledgeWatchdog$AcknowledgeWatchdogListener {
    private static final int NO_ACKNOWLEDGE_TIMEOUT_DELAY_ARRAY;
    private final AcknowledgeWatchdog acknowledgeWatchdog;
    private final List arrayRequestQueue = new ArrayList(10);
    private volatile BAPFunctionArrayFSG$ArrayRequestJob currentJob;
    private final /* synthetic */ BAPFunctionArrayFSG this$0;

    private BAPFunctionArrayFSG$ArrayRequestDispatcher(BAPFunctionArrayFSG bAPFunctionArrayFSG) {
        this.this$0 = bAPFunctionArrayFSG;
        this.acknowledgeWatchdog = new AcknowledgeWatchdogWithTimer(500);
        this.acknowledgeWatchdog.setListener(this);
    }

    private BAPFunctionArrayFSG$ArrayRequestDispatcher(BAPFunctionArrayFSG bAPFunctionArrayFSG, AcknowledgeWatchdog acknowledgeWatchdog) {
        this.this$0 = bAPFunctionArrayFSG;
        this.acknowledgeWatchdog = acknowledgeWatchdog;
        this.acknowledgeWatchdog.setListener(this);
    }

    private synchronized void dispatch(BAPFunctionArrayFSG$ArrayRequestJob bAPFunctionArrayFSG$ArrayRequestJob) {
        this.arrayRequestQueue.add(bAPFunctionArrayFSG$ArrayRequestJob);
        if (this.currentJob == null) {
            this.dispatchNext();
        } else {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#dispatch] isIdle=false, %1 queuedRequests", (long)this.arrayRequestQueue.size());
        }
    }

    private synchronized void dispatchNext() {
        if (!this.arrayRequestQueue.isEmpty()) {
            this.this$0.logChannel.log(-2137614336, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#dispatchNext] lsgID=%1, fctID=%2, remaining requests: %3", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc, (long)(this.arrayRequestQueue.size() - 1));
            this.currentJob = (BAPFunctionArrayFSG$ArrayRequestJob)this.arrayRequestQueue.remove(0);
            this.acknowledgeWatchdog.activate();
            if (!this.this$0.sendRequest(BAPFunctionArrayFSG$ArrayRequestJob.access$000(this.currentJob), BAPFunctionArrayFSG$ArrayRequestJob.access$100(this.currentJob))) {
                this.acknowledgeWatchdog.deactivate();
                this.currentJob = null;
            }
        }
    }

    @Override
    public synchronized void processAcknowledge(int n, int n2) {
        if (n == this.this$0.fctID && this.currentJob != null && (BAPFunctionArrayFSG$ArrayRequestJob.access$000(this.currentJob) == 10 && n2 == 4 || BAPFunctionArrayFSG$ArrayRequestJob.access$000(this.currentJob) == 7 && n2 == 3)) {
            this.acknowledgeWatchdog.deactivate();
            this.currentJob = null;
            this.dispatchNext();
        }
    }

    @Override
    public void acknowledgeMissing() {
        this.this$0.logChannel.log(-1601830656, "[BAPFunctionArrayFSG.ArrayRequestDispatcher#acknowledgeMissing] lsgID=%1, fctID=%2, Timeout - no acknowledge received", (Object)this.this$0.lsgIDDesc, (Object)this.this$0.fctIDDesc);
        if (this.currentJob != null && BAPFunctionArrayFSG$ArrayRequestJob.access$000(this.currentJob) == 10) {
            this.processAcknowledge(this.this$0.fctID, 4);
        } else if (this.currentJob != null && BAPFunctionArrayFSG$ArrayRequestJob.access$000(this.currentJob) == 7) {
            this.processAcknowledge(this.this$0.fctID, 3);
        }
        this.this$0.notifyListenersAcknowledgeTimeout();
    }

    public synchronized void reset() {
        this.acknowledgeWatchdog.deactivate();
        this.arrayRequestQueue.clear();
        this.currentJob = null;
    }

    /* synthetic */ BAPFunctionArrayFSG$ArrayRequestDispatcher(BAPFunctionArrayFSG bAPFunctionArrayFSG, BAPFunctionArrayFSG$1 bAPFunctionArrayFSG$1) {
        this(bAPFunctionArrayFSG);
    }

    /* synthetic */ BAPFunctionArrayFSG$ArrayRequestDispatcher(BAPFunctionArrayFSG bAPFunctionArrayFSG, AcknowledgeWatchdog acknowledgeWatchdog, BAPFunctionArrayFSG$1 bAPFunctionArrayFSG$1) {
        this(bAPFunctionArrayFSG, acknowledgeWatchdog);
    }

    static /* synthetic */ void access$500(BAPFunctionArrayFSG$ArrayRequestDispatcher bAPFunctionArrayFSG$ArrayRequestDispatcher, BAPFunctionArrayFSG$ArrayRequestJob bAPFunctionArrayFSG$ArrayRequestJob) {
        bAPFunctionArrayFSG$ArrayRequestDispatcher.dispatch(bAPFunctionArrayFSG$ArrayRequestJob);
    }
}

