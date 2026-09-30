/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class PrivacyFeatureStorageAccess {
    private IStorageAccess storageAccess;
    private LogChannel log;
    private static final boolean STORAGE_ACCESS_DEFAULT = true;

    public PrivacyFeatureStorageAccess(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.log = logChannel;
    }

    public void setStorageValue(boolean bl) {
        this.log.log(1000000, "PrivacyFeatureStorageAccess#setStorageValue: %1", bl);
        this.storageAccess.setBoolean(1023, 42, bl);
    }

    public boolean isPrivacyFeatureAvailable() {
        boolean bl = this.storageAccess.getBoolean(1023, 42, true);
        this.log.log(1000000, "PrivacyFeatureStorageAccess#isPrivacyFeatureAvailable: %1", bl);
        return bl;
    }
}

