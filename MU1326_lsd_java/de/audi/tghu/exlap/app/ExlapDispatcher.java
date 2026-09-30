/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.app.IExlapWorker;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExlapDispatcher
implements Runnable {
    private final Object barrier = new Object();
    private Thread currentThread = new Thread();
    private final Set triggerQueue = new HashSet();
    private final Set sendQueue = new HashSet();
    private volatile boolean running = true;
    private final LogChannel log;

    public ExlapDispatcher(IFrameworkAccess iFrameworkAccess) {
        this.log = iFrameworkAccess.getLogChannel("App.Exlap.Dispatcher");
    }

    public void run() {
        this.currentThread = Thread.currentThread();
        while (this.running) {
            this.processQueues();
            long l = 60000L;
            long l2 = System.currentTimeMillis();
            Iterator iterator = this.sendQueue.iterator();
            this.log.log(10000000, "ExlapDispatcher#run(): processing worker");
            while (iterator.hasNext()) {
                IExlapWorker iExlapWorker = (IExlapWorker)iterator.next();
                long l3 = iExlapWorker.getLastExecution() + (long)iExlapWorker.getInterval() - l2;
                if (l3 <= 0L) {
                    this.sendUpdates(iExlapWorker, l2);
                    iterator.remove();
                    continue;
                }
                if (l3 >= l) continue;
                l = l3;
            }
            this.sleep(l);
        }
        this.log.log(1000000, "ExlapDispatcher#run(): stopping ExlapDispatcher thread");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        this.running = false;
        Object object = this.barrier;
        synchronized (object) {
            this.currentThread.interrupt();
        }
        this.log.log(1000000, "ExlapDispatcher#stop(): stopping ExlapDispatcher");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processQueues() {
        Object object = this.barrier;
        synchronized (object) {
            Iterator iterator = this.triggerQueue.iterator();
            while (iterator.hasNext()) {
                IExlapWorker iExlapWorker = (IExlapWorker)iterator.next();
                iterator.remove();
                this.sendQueue.add(iExlapWorker);
            }
        }
    }

    private void sendUpdates(IExlapWorker iExlapWorker, long l) {
        try {
            iExlapWorker.sendUpdates();
            iExlapWorker.setLastExecution(l);
        }
        catch (Exception exception) {
            this.log.log(1000000, "ExlapDispatcher#sendUpdates(): Exception in worker while sending: " + exception.getMessage());
            this.log.log(10000000, "ExlapDispatcher#sendUpdates(): Exception in worker while sending: ", (Throwable)exception);
            return;
        }
    }

    public void sleep(long l) {
        if (Thread.interrupted()) {
            return;
        }
        try {
            this.log.log(10000000, "ExlapDispatcher#sleep(): ExlapDispatcher sleeping for %1 milliseconds: ", l);
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void trigger(IExlapWorker iExlapWorker) {
        Object object = this.barrier;
        synchronized (object) {
            if (!this.triggerQueue.contains(iExlapWorker)) {
                this.triggerQueue.add(iExlapWorker);
                this.currentThread.interrupt();
            }
        }
    }
}

