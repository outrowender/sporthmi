/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices;

import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler;
import de.audi.app.phone.evo.suppservices.TelEvoSuppServiceDialHandler$1;

class TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable
implements Runnable {
    private static final long MIN_SHOW_TIME;
    private static final int POPUP_NONE;
    private final int requestPopupId;
    private final Object minShowTimeMutext = new Object();
    private final Object responseMutex = new Object();
    private final boolean waitForResponse;
    private volatile boolean responseReceived;
    private volatile int responsePopupId;
    private final /* synthetic */ TelEvoSuppServiceDialHandler this$0;

    private TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler, int n, boolean bl) {
        this.this$0 = telEvoSuppServiceDialHandler;
        this.requestPopupId = n;
        this.waitForResponse = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        TelEvoSuppServiceDialHandler.access$200(this.this$0).log(-2137614336, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] showing request popup %1", (long)this.requestPopupId);
        TelEvoSuppServiceDialHandler.access$300(this.this$0, this.requestPopupId);
        Object object = this.minShowTimeMutext;
        synchronized (object) {
            try {
                this.minShowTimeMutext.wait(0);
            }
            catch (InterruptedException interruptedException) {
                TelEvoSuppServiceDialHandler.access$400(this.this$0).log(-1601830656, "[TelEvoSuppServiceDialHandler.SuppServicePopupRunnable#run]", (Throwable)interruptedException);
                Thread.interrupted();
            }
        }
        if (this.waitForResponse) {
            object = this.responseMutex;
            synchronized (object) {
                if (!this.responseReceived) {
                    try {
                        this.responseMutex.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        TelEvoSuppServiceDialHandler.access$500(this.this$0).log(-1601830656, "[TelEvoSuppServiceDialHandler.SuppServicePopupRunnable#run]", (Throwable)interruptedException);
                        Thread.interrupted();
                    }
                }
            }
            if (this.responseReceived && this.responsePopupId != 0) {
                TelEvoSuppServiceDialHandler.access$600(this.this$0).log(-2137614336, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] showing response popup %1", (long)this.responsePopupId);
                TelEvoSuppServiceDialHandler.access$300(this.this$0, this.responsePopupId);
                TelEvoSuppServiceDialHandler.access$700(this.this$0).log(-2137614336, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] removing request popup %1", (long)this.requestPopupId);
                TelEvoSuppServiceDialHandler.access$800(this.this$0, this.requestPopupId);
            }
        } else {
            TelEvoSuppServiceDialHandler.access$900(this.this$0).log(-2137614336, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#run] removing request popup %1", (long)this.requestPopupId);
            TelEvoSuppServiceDialHandler.access$800(this.this$0, this.requestPopupId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void responseReceived(int n) {
        TelEvoSuppServiceDialHandler.access$1000(this.this$0).log(-2137614336, "[TelEvoSuppServiceDialHandler.SuppServiceShowPopupRunnable#responseReceived] responsePopupId=%1", (long)n);
        Object object = this.responseMutex;
        synchronized (object) {
            this.responsePopupId = n;
            this.responseReceived = true;
            this.responseMutex.notifyAll();
        }
    }

    static /* synthetic */ void access$000(TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable telEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable, int n) {
        telEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable.responseReceived(n);
    }

    /* synthetic */ TelEvoSuppServiceDialHandler$SuppServiceShowPopupRunnable(TelEvoSuppServiceDialHandler telEvoSuppServiceDialHandler, int n, boolean bl, TelEvoSuppServiceDialHandler$1 telEvoSuppServiceDialHandler$1) {
        this(telEvoSuppServiceDialHandler, n, bl);
    }
}

