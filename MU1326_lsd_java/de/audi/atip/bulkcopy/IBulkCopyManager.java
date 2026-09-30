/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.bulkcopy;

import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.IBulkCopyClient;

public interface IBulkCopyManager {
    public boolean lock(IBulkCopyClient var1);

    public boolean unlock(IBulkCopyClient var1);

    public void setClientState(IBulkCopyClient var1, int var2) throws BulkCopyException;

    public boolean isIdle();
}

