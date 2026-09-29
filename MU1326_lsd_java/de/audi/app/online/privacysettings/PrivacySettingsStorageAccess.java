/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;

public class PrivacySettingsStorageAccess {
    private IStorageAccess storageAccess;
    private LogChannel log;

    public PrivacySettingsStorageAccess(IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.storageAccess = iStorageAccess;
        this.log = logChannel;
    }

    public void setPersistedPrivacyMode(boolean bl) {
        this.log.log(-2137614336, "PrivacySettingsStorageAccess#setPersistedPrivacyMode: %1", bl);
        this.storageAccess.setBoolean(1023, 40, bl);
    }

    public boolean getPersistedPrivacyMode() {
        boolean bl = this.storageAccess.getBoolean(1023, 40, false);
        this.log.log(-2137614336, "PrivacySettingsStorageAccess#getPersistedPrivacyMode: %1", bl);
        return bl;
    }
}

