/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functionsync;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.vw.mib.bap.requests.StatusProperty;

public interface IFunctionSynchronizationHandler {
    public static final int SYNC_TYPE_NO_SYNC;
    public static final int SYNC_STATE_IDLE;
    public static final int SYNC_STATE_STARTING_WAIT_FOR_ACKNOWLEDGE;
    public static final int SYNC_STATE_RUNNING;
    public static final int SYNC_STATE_COMPLETED_WAIT_FOR_ACKNOWLEDGE;
    public static final int SYNC_STATE_COMPLETED;

    default public void setFunctionSyncDisabled(boolean bl) {
    }

    default public boolean isFunctionSyncDisabled() {
    }

    default public int getCurrentSyncType() {
    }

    default public boolean isSyncActive() {
    }

    default public boolean isSyncCancelled() {
    }

    default public boolean isSyncPending() {
    }

    default public int getSyncState() {
    }

    default public void startSync(int n) {
    }

    default public void completeSync() {
    }

    default public boolean enqueuePropertyUpdate(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, StatusProperty statusProperty) {
    }

    default public boolean isQueuedPropertiesSent() {
    }

    default public String getStatus() {
    }
}

