/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.IBulkCopyClient;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BulkCopyManagerImpl
implements IBulkCopyManager,
DumpInfoProvider {
    private final LogChannel m_log;
    private Object m_syncer = new Object();
    private final int[] m_waiting;
    private boolean m_ignoreWaitingClients = false;
    private volatile boolean m_areAllWaitingClientsRegistered = false;
    private Map m_clients = new HashMap();
    private volatile IBulkCopyClient m_locked = null;
    private volatile int m_state = 0;

    public BulkCopyManagerImpl(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int[] nArray) {
        this.m_log = logChannel;
        this.m_waiting = nArray;
        this.m_log.log(1000000, "[BulkCopyManagerImpl] <init>(framework=%1, log=%2, waiting[]=%3)", (Object)iFrameworkAccess, (Object)logChannel, (Object)nArray);
        if (null != iFrameworkAccess) {
            new Surveillant(this, iFrameworkAccess, logChannel);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setClientState(IBulkCopyClient iBulkCopyClient, int n) throws BulkCopyException {
        this.m_log.log(1000000, "[BulkCopyManagerImpl] setClientState(client=%1, state=%2)", (Object)iBulkCopyClient, (long)n);
        Object object = this.m_syncer;
        synchronized (object) {
            switch (n) {
                case 3: 
                case 4: {
                    Integer n2 = (Integer)this.m_clients.get(iBulkCopyClient);
                    if (null == n2 || 1 == n2) {
                        this.m_clients.put(iBulkCopyClient, new Integer(n));
                        if (3 != n) break;
                        this.m_locked = iBulkCopyClient;
                        break;
                    }
                    throw new BulkCopyException("State already set by client! Can not set twice!");
                }
                default: {
                    throw new BulkCopyException("State " + n + " denied!");
                }
            }
            this.updateState(iBulkCopyClient.getClientType());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean lock(IBulkCopyClient iBulkCopyClient) {
        this.m_log.log(1000000, "[BulkCopyManagerImpl] lock(client=%1)", (Object)iBulkCopyClient);
        Object object = this.m_syncer;
        synchronized (object) {
            if (!this.m_clients.containsKey(iBulkCopyClient)) {
                return false;
            }
            if (iBulkCopyClient == this.m_locked) {
                return true;
            }
            if (null == this.m_locked && 4 == this.m_state) {
                this.m_locked = iBulkCopyClient;
                this.m_clients.put(iBulkCopyClient, new Integer(3));
                this.updateState(iBulkCopyClient.getClientType());
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean unlock(IBulkCopyClient iBulkCopyClient) {
        this.m_log.log(1000000, "[BulkCopyManagerImpl] unlock(client=%1)", (Object)iBulkCopyClient);
        Object object = this.m_syncer;
        synchronized (object) {
            if (!this.m_clients.containsKey(iBulkCopyClient)) {
                return false;
            }
            if (this.m_locked == iBulkCopyClient) {
                this.m_locked = null;
                this.m_clients.put(iBulkCopyClient, new Integer(4));
                this.updateState(iBulkCopyClient.getClientType());
                return true;
            }
            return false;
        }
    }

    public boolean isIdle() {
        return 4 == this.m_state;
    }

    public boolean isAnyClientInRegisteredState() {
        Iterator iterator = this.m_clients.keySet().iterator();
        while (iterator.hasNext()) {
            IBulkCopyClient iBulkCopyClient = (IBulkCopyClient)iterator.next();
            Integer n = (Integer)this.m_clients.get(iBulkCopyClient);
            if (null == n || 1 != n) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        this.dump(printStream, "");
        printStream.flush();
        return byteArrayOutputStream.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean registerClient(IBulkCopyClient iBulkCopyClient) throws BulkCopyException {
        if (null == iBulkCopyClient) {
            return false;
        }
        Object object = this.m_syncer;
        synchronized (object) {
            int n = iBulkCopyClient.getClientType();
            if (this.m_clients.containsKey(iBulkCopyClient)) {
                return true;
            }
            Iterator iterator = this.m_clients.keySet().iterator();
            while (iterator.hasNext()) {
                IBulkCopyClient iBulkCopyClient2 = (IBulkCopyClient)iterator.next();
                if (iBulkCopyClient2.getClientType() != n) continue;
                throw new BulkCopyException("BulkCopyClient with type=" + n + " already exists!");
            }
            this.m_clients.put(iBulkCopyClient, new Integer(1));
            if (!this.updateState(n)) {
                iBulkCopyClient.onChangeStateBulkCopy(this.m_state, n);
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean unregisterClient(IBulkCopyClient iBulkCopyClient) {
        if (null == iBulkCopyClient) {
            return false;
        }
        Object object = this.m_syncer;
        synchronized (object) {
            int n = iBulkCopyClient.getClientType();
            if (null == this.m_clients.remove(iBulkCopyClient)) {
                return false;
            }
            if (this.m_locked == iBulkCopyClient) {
                this.m_locked = null;
            }
            this.updateState(n);
            return true;
        }
    }

    int getInternalState() {
        return this.m_state;
    }

    boolean isLocked() {
        return null != this.m_locked;
    }

    boolean areAllWaitingClientsRegistered() {
        return this.m_areAllWaitingClientsRegistered;
    }

    void setIgnoreWaitingClients(boolean bl) {
        if (this.m_ignoreWaitingClients != bl) {
            this.m_ignoreWaitingClients = bl;
            this.updateState(-1);
        }
    }

    public void dump(PrintStream printStream, String string) {
        printStream.println(" ## Legend ##");
        printStream.println(" ClientTypes: 1: SWDL, 2: MEDIA, ..., 0xFFFFFFFF: SURVEILLANT");
        printStream.println(" KnownStates: 0: UNINITIALIZED, 1: REGISTERED, 2: WAITING, 3: BUSY, 4: IDLE");
        printStream.println();
        printStream.println(" ## Internal State ##");
        printStream.print(" waiting : ");
        for (int i2 = 0; i2 < this.m_waiting.length; ++i2) {
            printStream.print(this.m_waiting[i2] + "(" + this.type2String(this.m_waiting[i2]) + "), ");
        }
        printStream.println();
        printStream.println(" state     : " + this.m_state + "(" + this.state2String(this.m_state) + ")");
        printStream.println(" lock      : " + this.m_locked);
        printStream.println(" ignore    : " + (this.m_ignoreWaitingClients ? "!!!yes - ignore waiting list!!!" : "no"));
        printStream.println(" registered: " + (this.m_areAllWaitingClientsRegistered ? "yes" : "!!!no - waiting for clients yet!!!"));
        printStream.println();
        printStream.println(" ## Registered Clients (" + this.m_clients.keySet().size() + ") ##");
        Iterator iterator = this.m_clients.keySet().iterator();
        while (iterator.hasNext()) {
            IBulkCopyClient iBulkCopyClient = (IBulkCopyClient)iterator.next();
            int n = (Integer)this.m_clients.get(iBulkCopyClient);
            printStream.println(" type=" + iBulkCopyClient.getClientType() + "(" + this.type2String(iBulkCopyClient.getClientType()) + "), state=" + n + "(" + this.state2String(n) + "), name=" + iBulkCopyClient);
        }
    }

    public String getName() {
        return "BulkCopyManager";
    }

    private void notifyClients(int n, int n2) {
        Iterator iterator = this.m_clients.keySet().iterator();
        while (iterator.hasNext()) {
            IBulkCopyClient iBulkCopyClient = (IBulkCopyClient)iterator.next();
            iBulkCopyClient.onChangeStateBulkCopy(n, n2);
        }
    }

    private boolean updateState(int n) {
        this.m_log.log(1000000, "[BulkCopyManagerImpl] updateState(%1)", (long)n);
        int n2 = 4;
        Iterator iterator = this.m_clients.keySet().iterator();
        block5: while (iterator.hasNext()) {
            IBulkCopyClient iBulkCopyClient = (IBulkCopyClient)iterator.next();
            Integer n3 = (Integer)this.m_clients.get(iBulkCopyClient);
            switch (n3) {
                case 3: {
                    if (4 != n2 && 2 != n2) continue block5;
                    n2 = 3;
                    continue block5;
                }
                case 1: {
                    if (this.m_ignoreWaitingClients || 4 != n2) continue block5;
                    n2 = 2;
                    continue block5;
                }
                case 4: {
                    continue block5;
                }
            }
            this.m_log.log(10000, "[BulkCopyManagerImpl] Invalid client state: %1 -> %2", (Object)iBulkCopyClient, (Object)n3);
        }
        boolean bl = true;
        int n4 = this.m_waiting.length;
        block6: for (int i2 = 0; i2 < n4; ++i2) {
            Iterator iterator2 = this.m_clients.keySet().iterator();
            while (iterator2.hasNext()) {
                IBulkCopyClient iBulkCopyClient = (IBulkCopyClient)iterator2.next();
                if (iBulkCopyClient.getClientType() != this.m_waiting[i2]) continue;
                continue block6;
            }
            if (!this.m_ignoreWaitingClients && 3 != n2 && 2 != n2) {
                n2 = 2;
            }
            bl = false;
            break;
        }
        this.m_areAllWaitingClientsRegistered = bl;
        if (this.m_state != n2) {
            this.m_log.log(10000000, "[BulkCopyManagerImpl] change state to %1", (long)n2);
            this.m_state = n2;
            this.notifyClients(n2, n);
            return true;
        }
        this.m_log.log(10000000, "[BulkCopyManagerImpl] state not changed (old=%1)", (long)this.m_state);
        return false;
    }

    private String state2String(int n) {
        switch (n) {
            case 0: {
                return "UNINITIALIZED";
            }
            case 1: {
                return "REGISTERED";
            }
            case 2: {
                return "WAITING";
            }
            case 3: {
                return "BUSY";
            }
            case 4: {
                return "IDLE";
            }
        }
        return "?";
    }

    private String type2String(int n) {
        switch (n) {
            case 1: {
                return "SWDL";
            }
            case 2: {
                return "MEDIA";
            }
            case -1: {
                return "SURVEILLANT";
            }
        }
        return "?";
    }

    private static class Surveillant
    implements IBulkCopyClient,
    Runnable {
        private static final long TIMEOUT = 120000L;
        private final BulkCopyManagerImpl m_parent;
        private final IFrameworkAccess m_framework;
        private final LogChannel m_log;

        public Surveillant(BulkCopyManagerImpl bulkCopyManagerImpl, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
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

        public int getClientType() {
            return -1;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onChangeStateBulkCopy(int n, int n2) {
            Surveillant surveillant = this;
            synchronized (surveillant) {
                this.notifyAll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            Thread thread = Thread.currentThread();
            long l = this.m_framework.getMonotonicTime();
            thread.setName(thread.getName() + "BulkCopyManager.Surveillant");
            if (null != this.m_log) {
                this.m_log.log(1000000, "[BulkCopyManager.Surveillant.run] start: %1", l);
            }
            while (true) {
                long l2;
                Surveillant surveillant = this;
                synchronized (surveillant) {
                    try {
                        long l3 = this.m_framework.getMonotonicTime() - l;
                        long l4 = 120000L - l3;
                        if (null != this.m_log) {
                            this.m_log.log(10000000, "[BulkCopyManager.Surveillant.run] wait: %1, gone: %2", l4, l3);
                        }
                        if (l4 > 0L) {
                            this.wait(l4);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                }
                if (this.m_parent.areAllWaitingClientsRegistered() && !this.m_parent.isAnyClientInRegisteredState()) {
                    if (null != this.m_log) {
                        this.m_log.log(10000000, "[BulkCopyManager.Surveillant.run] all waiting clients registered");
                    }
                    this.m_parent.setIgnoreWaitingClients(false);
                    do {
                        surveillant = this;
                        synchronized (surveillant) {
                            try {
                                this.wait();
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
                    this.m_log.log(10000000, "[BulkCopyManager.Surveillant.run] not all waiting clients registered");
                }
                if ((l2 = this.m_framework.getMonotonicTime() - l) < 120000L) continue;
                if (null != this.m_log) {
                    this.m_log.log(10000000, "[BulkCopyManager.Surveillant.run] TIMED OUT -> DO NOT WAIT ANYMORE!");
                }
                this.m_parent.setIgnoreWaitingClients(true);
                do {
                    Surveillant surveillant2 = this;
                    synchronized (surveillant2) {
                        try {
                            this.wait();
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
}

