/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functionsync;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.vw.mib.bap.requests.StatusProperty;

public interface IFunctionSynchronizationHandler {
    public static final int SYNC_TYPE_NO_SYNC = -1;
    public static final int SYNC_STATE_IDLE = 0;
    public static final int SYNC_STATE_STARTING_WAIT_FOR_ACKNOWLEDGE = 1;
    public static final int SYNC_STATE_RUNNING = 2;
    public static final int SYNC_STATE_COMPLETED_WAIT_FOR_ACKNOWLEDGE = 3;
    public static final int SYNC_STATE_COMPLETED = 4;

    public void setFunctionSyncDisabled(boolean var1);

    public boolean isFunctionSyncDisabled();

    public int getCurrentSyncType();

    public boolean isSyncActive();

    public boolean isSyncCancelled();

    public boolean isSyncPending();

    public int getSyncState();

    public void startSync(int var1);

    public void completeSync();

    public boolean enqueuePropertyUpdate(BAPFunctionPropertyFSG var1, StatusProperty var2);

    public boolean isQueuedPropertiesSent();

    public String getStatus();
}

