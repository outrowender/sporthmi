/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAInterappServiceHandler;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusListener;

class PLAInterappServiceHandler$1
implements Runnable {
    private final /* synthetic */ IPLAStatusListener val$listener;
    private final /* synthetic */ PLAInterappServiceHandler this$0;

    PLAInterappServiceHandler$1(PLAInterappServiceHandler pLAInterappServiceHandler, IPLAStatusListener iPLAStatusListener) {
        this.this$0 = pLAInterappServiceHandler;
        this.val$listener = iPLAStatusListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Object object = PLAInterappServiceHandler.access$000(this.this$0);
        synchronized (object) {
            try {
                switch (PLAInterappServiceHandler.access$100(this.this$0)) {
                    case 6: {
                        this.val$listener.updatePLAStatusStandbyMode(PLAInterappServiceHandler.access$200(this.this$0));
                        break;
                    }
                    case 1: {
                        this.val$listener.updatePLAStatusSearchMode(PLAInterappServiceHandler.access$200(this.this$0));
                        break;
                    }
                    case 2: {
                        this.val$listener.updatePLAStatusInSelectionMode(PLAInterappServiceHandler.access$200(this.this$0));
                        break;
                    }
                    case 3: {
                        this.val$listener.updatePLAStatusOutSelectionMode(PLAInterappServiceHandler.access$200(this.this$0));
                        break;
                    }
                    default: {
                        PLAInterappServiceHandler.access$300(this.this$0).log(1078071040, "[PLAInterappServiceHandler#registerStatusListener] Invalid mode for asynchronous update detected! Update ignored.");
                        break;
                    }
                }
            }
            catch (Exception exception) {
                PLAInterappServiceHandler.access$300(this.this$0).log(1000, "[PLAInterappServiceHandler#registerStatusListener] Exception occured within the listener.", (Throwable)exception);
            }
        }
    }
}

