/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

class ActiveSourceStorage {
    private static final int MASK_AV_SOURCE_AVAILABLE;
    private static final int MASK_ACTIVE_SOURCE;
    private final IStorageAccess storageAccess;
    private final LogChannel lc;
    private volatile int activeSource;
    private volatile boolean isAvSourceAvailable;

    ActiveSourceStorage(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.lc = logChannel;
        int n = iStorageAccess.getInt(1007, 1, 0);
        this.isAvSourceAvailable = 0 != (n & 0x100);
        this.activeSource = n & 0xFF;
    }

    public int getActiveSource() {
        return this.activeSource;
    }

    public boolean isAvSourceAvailable() {
        return this.isAvSourceAvailable;
    }

    public void setActiveSource(int n) {
        this.lc.log(1078071040, "[ActiveSourceStorage.setActiveSource] %1", (long)n);
        this.activeSource = n;
        int n2 = n & 0xFF | (this.isAvSourceAvailable ? 256 : 0);
        this.storageAccess.setInt(1007, 1, n2);
    }

    public void setAvSourceAvailable(boolean bl) {
        this.lc.log(1078071040, "[ActiveSourceStorage.setAvSourceAvailable] %1", bl);
        this.isAvSourceAvailable = bl;
        int n = this.activeSource & 0xFF | (bl ? 256 : 0);
        this.storageAccess.setInt(1007, 1, n);
    }
}

