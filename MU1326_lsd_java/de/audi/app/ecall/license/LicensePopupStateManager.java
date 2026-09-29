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

    @Override
    public int getLincenseScreenId() {
        return this.currentLicenseScreenId;
    }

    @Override
    public void onLicensePopupOpened(int n) {
        this.currentLicenseScreenId = n;
    }

    @Override
    public void onLicensePopupConfirmed() {
        this.currentLicenseScreenId = 0;
    }
}

