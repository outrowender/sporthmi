/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

import de.audi.atip.bulkcopy.IBulkCopyClient;

public interface IBulkCopyManager {
    default public boolean lock(IBulkCopyClient iBulkCopyClient) {
    }

    default public boolean unlock(IBulkCopyClient iBulkCopyClient) {
    }

    default public void setClientState(IBulkCopyClient iBulkCopyClient, int n) {
    }

    default public boolean isIdle() {
    }
}

