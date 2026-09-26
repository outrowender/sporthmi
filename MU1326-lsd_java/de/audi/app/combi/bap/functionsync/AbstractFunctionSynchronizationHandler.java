/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functionsync.IFunctionSynchronizationHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationHandler$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractFunctionSynchronizationHandler
implements IFunctionSynchronizationHandler {
    protected volatile boolean functionSyncDisabled = false;
    protected final AbstractBAPModuleFSG moduleFsg;
    protected final LogChannel logChannel;
    private final CommandListManager cmdListManager;
    private volatile AbstractFunctionSynchronization currentSync;
    private volatile AbstractFunctionSynchronization pendingSync;
    private final Object syncMutex = new Object();
    private final Monitor monitor;

    public AbstractFunctionSynchronizationHandler(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        this.moduleFsg = abstractBAPModuleFSG;
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.monitor = new AbstractFunctionSynchronizationHandler$1(this, this.logChannel);
        this.cmdListManager = new CommandListManager("FunctionSyncCmdListManager", abstractBAPModuleFSG.getFrameworkAccess(), abstractBAPModuleFSG.getLogChannel(), null, null);
        this.cmdListManager.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleSyncFinished(AbstractFunctionSynchronization abstractFunctionSynchronization) {
        this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#handleSyncFinished] sync with type %1 finished", (Object)abstractFunctionSynchronization.getSyncTypeDescription());
        abstractFunctionSynchronization.setSyncState(0);
        Object object = this.syncMutex;
        synchronized (object) {
            if (abstractFunctionSynchronization.equals(this.currentSync)) {
                if (this.pendingSync != null) {
                    this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#handleSyncFinished] start pending sync with type %1", (Object)this.pendingSync.getSyncTypeDescription());
                    this.executeSync(this.pendingSync);
                    this.pendingSync = null;
                } else {
                    this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#handleSyncFinished] no sync pending -> finished");
                    this.currentSync = null;
                }
            }
        }
    }

    public CommandListManager getCommandListManager() {
        return this.cmdListManager;
    }

    @Override
    public void setFunctionSyncDisabled(boolean bl) {
        this.functionSyncDisabled = bl;
    }

    @Override
    public boolean isFunctionSyncDisabled() {
        return this.functionSyncDisabled;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private AbstractFunctionSynchronization getCurrentSync() {
        Object object = this.syncMutex;
        synchronized (object) {
            return this.currentSync;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getCurrentSyncType() {
        Object object = this.syncMutex;
        synchronized (object) {
            if (this.currentSync == null) {
                return -1;
            }
            return this.currentSync.getSyncType();
        }
    }

    @Override
    public int getSyncState() {
        AbstractFunctionSynchronization abstractFunctionSynchronization = this.getCurrentSync();
        if (abstractFunctionSynchronization == null) {
            return 0;
        }
        return abstractFunctionSynchronization.getSyncState();
    }

    @Override
    public boolean isSyncCancelled() {
        AbstractFunctionSynchronization abstractFunctionSynchronization = this.getCurrentSync();
        if (abstractFunctionSynchronization == null) {
            return false;
        }
        return abstractFunctionSynchronization.isCanceled();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isSyncActive() {
        Object object = this.syncMutex;
        synchronized (object) {
            return this.currentSync != null;
        }
    }

    public AbstractFunctionSynchronization getPendingSync() {
        return this.pendingSync;
    }

    public int getPendingSyncType() {
        if (this.pendingSync == null) {
            return -1;
        }
        return this.pendingSync.getSyncType();
    }

    @Override
    public boolean isSyncPending() {
        return this.pendingSync != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void startSync(int n) {
        if (this.functionSyncDisabled) {
            this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] function synchronization is disabled");
            return;
        }
        if (this.moduleFsg.getInitializationManager().getHMIState() == 0) {
            this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] HMIState not ready -> don't start function synchronization");
            return;
        }
        AbstractFunctionSynchronization abstractFunctionSynchronization = this.getCurrentSync();
        if (abstractFunctionSynchronization != null) {
            if (n == this.getCurrentSyncType()) {
                this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] sync is already active -> restart sync with type=%1", (long)n);
                abstractFunctionSynchronization.cancel(0);
            } else {
                this.logChannel.log(-1601830656, "[AbstractFunctionSynchronizationHandler#startSync] new syncType=%2; sync is already active -> abort current sync (syncType=%1)", (Object)abstractFunctionSynchronization.getSyncTypeDescription(), (long)n);
                abstractFunctionSynchronization.cancel(1);
            }
        }
        if (this.pendingSync != null) {
            this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] replace pending sync (syncType=%1)", (Object)this.pendingSync.getSyncTypeDescription());
            this.pendingSync.cancel(1);
        }
        Object object = this.syncMutex;
        synchronized (object) {
            if (this.isSyncActive()) {
                AbstractFunctionSynchronization abstractFunctionSynchronization2 = this.createFunctionSync(n);
                this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] new pending sync (syncType=%1) (sync active)", (Object)abstractFunctionSynchronization2.getSyncTypeDescription());
                this.pendingSync = abstractFunctionSynchronization2;
            } else {
                AbstractFunctionSynchronization abstractFunctionSynchronization3 = this.createFunctionSync(n);
                this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#startSync] new sync (syncType=%1) (no sync active)", (Object)abstractFunctionSynchronization3.getSyncTypeDescription());
                this.executeSync(abstractFunctionSynchronization3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void executeSync(AbstractFunctionSynchronization abstractFunctionSynchronization) {
        this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#executeSync] syncType=%1", (long)abstractFunctionSynchronization.getSyncType());
        this.cmdListManager.start();
        Object object = this.syncMutex;
        synchronized (object) {
            this.currentSync = abstractFunctionSynchronization;
        }
        abstractFunctionSynchronization.addMonitor(this.monitor);
        abstractFunctionSynchronization.execute(abstractFunctionSynchronization.getSyncTypeDescription());
    }

    @Override
    public void completeSync() {
        AbstractFunctionSynchronization abstractFunctionSynchronization = this.getCurrentSync();
        if (abstractFunctionSynchronization != null) {
            abstractFunctionSynchronization.cancel(2);
        } else {
            this.logChannel.log(10000, "[AbstractFunctionSynchronizationHandler#completeSync] currentSync is null");
        }
    }

    protected abstract AbstractFunctionSynchronization createFunctionSync(int n) {
    }

    public String getSyncStateDescription(int n) {
        switch (n) {
            case 0: {
                return "IDLE";
            }
            case 1: {
                return "STARTING_WAIT_FOR_ACKNOWLEDGE";
            }
            case 2: {
                return "RUNNING";
            }
            case 3: {
                return "COMPLETED_WAIT_FOR_ACKNOWLEDGE";
            }
            case 4: {
                return "COMPLETED";
            }
        }
        return "UNKNOWN";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean enqueuePropertyUpdate(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, StatusProperty statusProperty) {
        Object object = this.syncMutex;
        synchronized (object) {
            if (this.currentSync == null) {
                this.logChannel.log(10000, "[AbstractFunctionSynchronizationHandler#enqueuePropertyUpdate] can't enqeue update: currentSync=%1, pendingSync=%2", (Object)this.currentSync, (Object)this.pendingSync);
                return false;
            }
            if (this.currentSync.isCanceled()) {
                if (this.pendingSync != null) {
                    this.logChannel.log(-2137614336, "[AbstractFunctionSynchronizationHandler#enqueuePropertyUpdate] current sync cancelled, enqueue in pending sync.");
                    return this.pendingSync.enqueuePropertyUpdate(bAPFunctionPropertyFSG, statusProperty);
                }
                this.logChannel.log(10000, "[AbstractFunctionSynchronizationHandler#enqueuePropertyUpdate] current sync canceled and there is no pending sync");
                return this.currentSync.enqueuePropertyUpdate(bAPFunctionPropertyFSG, statusProperty);
            }
            return this.currentSync.enqueuePropertyUpdate(bAPFunctionPropertyFSG, statusProperty);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isQueuedPropertiesSent() {
        Object object = this.syncMutex;
        synchronized (object) {
            if (this.currentSync == null) {
                return true;
            }
            return this.currentSync.isQueuedPropertiesSent();
        }
    }

    @Override
    public String getStatus() {
        Buffer buffer = new Buffer();
        buffer.append("current sync:\n");
        buffer.append(this.getCurrentSync());
        buffer.append("\npending sync:\n");
        buffer.append(this.getPendingSync());
        return buffer.toString();
    }

    static /* synthetic */ void access$000(AbstractFunctionSynchronizationHandler abstractFunctionSynchronizationHandler, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        abstractFunctionSynchronizationHandler.handleSyncFinished(abstractFunctionSynchronization);
    }
}

