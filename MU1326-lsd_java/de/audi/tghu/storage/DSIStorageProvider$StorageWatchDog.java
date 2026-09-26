/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.tghu.storage.DSIStorageProvider;
import de.audi.tghu.storage.DSIStorageProvider$1;
import de.audi.tghu.storage.DSIStorageProvider$Request;
import java.util.ArrayList;
import java.util.List;

class DSIStorageProvider$StorageWatchDog
implements Runnable {
    private boolean active;
    private final List pendingQueue = new ArrayList(10);
    private final /* synthetic */ DSIStorageProvider this$0;

    private DSIStorageProvider$StorageWatchDog(DSIStorageProvider dSIStorageProvider) {
        this.this$0 = dSIStorageProvider;
    }

    private synchronized void addToPendingQueue(DSIStorageProvider$Request dSIStorageProvider$Request) {
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[StorageWatchDog#addToPendingQueue]");
        this.pendingQueue.add(dSIStorageProvider$Request);
        super.notifyAll();
    }

    private synchronized void removeFromPendingQueue(DSIStorageProvider$Request dSIStorageProvider$Request) {
        DSIStorageProvider.access$900(this.this$0).log(-2137614336, "[StorageWatchDog#removeFromPendingQueue]");
        this.pendingQueue.remove(dSIStorageProvider$Request);
        super.notifyAll();
    }

    private synchronized void stop() {
        this.active = false;
        super.notifyAll();
    }

    private synchronized void start() {
        DSIStorageProvider.access$800(this.this$0).getHMIThreadPool().execute(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("StorageWatchDog").toString());
        this.active = true;
        while (this.active) {
            int n = 0;
            DSIStorageProvider$StorageWatchDog dSIStorageProvider$StorageWatchDog = this;
            synchronized (dSIStorageProvider$StorageWatchDog) {
                if (!this.pendingQueue.isEmpty()) {
                    n = (int)((DSIStorageProvider$Request)this.pendingQueue.get(0)).getTimeToWait();
                    DSIStorageProvider.access$900(this.this$0).log(-2137614336, "WatchDog: next timeout in %1 ms", (long)n);
                } else {
                    DSIStorageProvider.access$900(this.this$0).log(-2137614336, "WatchDog: no pending request, waiting %1 ms", (long)n);
                }
                if (n > 0L) {
                    try {
                        super.wait(n);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                } else {
                    DSIStorageProvider$Request dSIStorageProvider$Request = (DSIStorageProvider$Request)this.pendingQueue.remove(0);
                    DSIStorageProvider.access$900(this.this$0).log(-2137614336, "WatchDog: request timed out! %1", (Object)dSIStorageProvider$Request);
                    dSIStorageProvider$Request.doneWrite(100);
                }
            }
        }
    }

    /* synthetic */ DSIStorageProvider$StorageWatchDog(DSIStorageProvider dSIStorageProvider, DSIStorageProvider$1 dSIStorageProvider$1) {
        this(dSIStorageProvider);
    }

    static /* synthetic */ void access$200(DSIStorageProvider$StorageWatchDog dSIStorageProvider$StorageWatchDog) {
        dSIStorageProvider$StorageWatchDog.start();
    }

    static /* synthetic */ void access$300(DSIStorageProvider$StorageWatchDog dSIStorageProvider$StorageWatchDog) {
        dSIStorageProvider$StorageWatchDog.stop();
    }

    static /* synthetic */ void access$600(DSIStorageProvider$StorageWatchDog dSIStorageProvider$StorageWatchDog, DSIStorageProvider$Request dSIStorageProvider$Request) {
        dSIStorageProvider$StorageWatchDog.addToPendingQueue(dSIStorageProvider$Request);
    }

    static /* synthetic */ void access$700(DSIStorageProvider$StorageWatchDog dSIStorageProvider$StorageWatchDog, DSIStorageProvider$Request dSIStorageProvider$Request) {
        dSIStorageProvider$StorageWatchDog.removeFromPendingQueue(dSIStorageProvider$Request);
    }
}

