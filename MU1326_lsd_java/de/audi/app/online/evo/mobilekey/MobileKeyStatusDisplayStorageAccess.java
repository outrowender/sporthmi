/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.mobilekey;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class MobileKeyStatusDisplayStorageAccess {
    private static final boolean STORAGE_ACCESS_DEFAULT;
    private IStorageAccess storageAccess;
    private LogChannel logChannel;

    public MobileKeyStatusDisplayStorageAccess(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.logChannel = logChannel;
    }

    public void updateSmartCardStatus(boolean bl) {
        this.logChannel.log(1078071040, "MobileKeyStatusDisplayStorageAccess#updateSmartCardStatus enabled: %1", bl);
        this.storageAccess.setBoolean(1023, 41, bl);
    }

    public boolean wasSmartCardPreviouslyEnabled() {
        boolean bl = this.storageAccess.getBoolean(1023, 41, false);
        this.logChannel.log(1078071040, "MobileKeyStatusDisplayStorageAccess#wasSmartCardPreviouslyEnabled result: %1", bl);
        return bl;
    }
}

