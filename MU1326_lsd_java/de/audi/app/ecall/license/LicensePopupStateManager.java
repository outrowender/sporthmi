/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.license;

import de.audi.app.ecall.core.storage.ILicensePopupListener;
import de.audi.app.ecall.license.ILicenseScreenState;

public class LicensePopupStateManager
implements ILicensePopupListener,
ILicenseScreenState {
    private volatile int currentLicenseScreenId = 0;

    public int getLincenseScreenId() {
        return this.currentLicenseScreenId;
    }

    public void onLicensePopupOpened(int n) {
        this.currentLicenseScreenId = n;
    }

    public void onLicensePopupConfirmed() {
        this.currentLicenseScreenId = 0;
    }
}

