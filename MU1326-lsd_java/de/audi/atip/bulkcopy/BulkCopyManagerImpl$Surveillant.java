/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.BulkCopyManagerImpl;
import de.audi.atip.bulkcopy.IBulkCopyClient;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.threading.ThreadPool;

class BulkCopyManagerImpl$Surveillant
implements IBulkCopyClient,
Runnable {
    private static final long TIMEOUT;
    private final BulkCopyManagerImpl m_parent;
    private final IFrameworkAccess m_framework;
    private final LogChannel m_log;

    public BulkCopyManagerImpl$Surveillant(BulkCopyManagerImpl bulkCopyManagerImpl, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.m_parent = bulkCopyManagerImpl;
        this.m_framework = iFrameworkAccess;
        this.m_log = logChannel;
        ThreadPool threadPool = iFrameworkAccess.getUtilThreadPool();
        if (null == threadPool) {
            this.m_log.log(10000, "[BulkCopyManagerImpl.Surveillant] No ThreadPool exists! Can't start Surveillant-Client!");
            return;
        }
        try {
            bulkCopyManagerImpl.registerClient(this);
            bulkCopyManagerImpl.setClientState(this, 4);
        }
        catch (BulkCopyException bulkCopyException) {
            this.m_log.log(10000, "[BulkCopyManagerImpl.Surveillant] Error during registration of Surveillant-Client", (Throwable)bulkCopyException);
            return;
        }
        threadPool.execute(this);
    }

    @Override
    public int getClientType() {
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onChangeStateBulkCopy(int n, int n2) {
        BulkCopyManagerImpl$Surveillant bulkCopyManagerImpl$Surveillant = this;
        synchronized (bulkCopyManagerImpl$Surveillant) {
            super.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        long l = this.m_framework.getMonotonicTime();
        thread.setName(new StringBuffer().append(thread.getName()).append("BulkCopyManager.Surveillant").toString());
        if (null != this.m_log) {
            this.m_log.log(1078071040, "[BulkCopyManager.Surveillant.run] start: %1", l);
        }
        while (true) {
            long l2;
            BulkCopyManagerImpl$Surveillant bulkCopyManagerImpl$Surveillant = this;
            synchronized (bulkCopyManagerImpl$Surveillant) {
                try {
                    long l3 = this.m_framework.getMonotonicTime() - l;
                    int n = 0 - l3;
                    if (null != this.m_log) {
                        this.m_log.log(-2137614336, "[BulkCopyManager.Surveillant.run] wait: %1, gone: %2", (long)n, l3);
                    }
                    if (n > 0L) {
                        super.wait(n);
                    }
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            if (this.m_parent.areAllWaitingClientsRegistered() && !this.m_parent.isAnyClientInRegisteredState()) {
                if (null != this.m_log) {
                    this.m_log.log(-2137614336, "[BulkCopyManager.Surveillant.run] all waiting clients registered");
                }
                this.m_parent.setIgnoreWaitingClients(false);
                do {
                    bulkCopyManagerImpl$Surveillant = this;
                    synchronized (bulkCopyManagerImpl$Surveillant) {
                        try {
                            super.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            Thread.interrupted();
                        }
                    }
                } while (this.m_parent.areAllWaitingClientsRegistered() && !this.m_parent.isAnyClientInRegisteredState());
                l = this.m_framework.getMonotonicTime();
                continue;
            }
            if (null != this.m_log) {
                this.m_log.log(-2137614336, "[BulkCopyManager.Surveillant.run] not all waiting clients registered");
            }
            if ((l2 = this.m_framework.getMonotonicTime() - l) < 0) continue;
            if (null != this.m_log) {
                this.m_log.log(-2137614336, "[BulkCopyManager.Surveillant.run] TIMED OUT -> DO NOT WAIT ANYMORE!");
            }
            this.m_parent.setIgnoreWaitingClients(true);
            do {
                BulkCopyManagerImpl$Surveillant bulkCopyManagerImpl$Surveillant2 = this;
                synchronized (bulkCopyManagerImpl$Surveillant2) {
                    try {
                        super.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                }
            } while (!this.m_parent.areAllWaitingClientsRegistered() || this.m_parent.isAnyClientInRegisteredState());
            l = this.m_framework.getMonotonicTime();
        }
    }
}

