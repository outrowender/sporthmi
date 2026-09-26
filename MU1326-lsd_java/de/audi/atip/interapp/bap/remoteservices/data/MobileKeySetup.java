/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup$Builder;

public final class MobileKeySetup {
    private final boolean mobileDeviceKeyEnabled;
    private boolean smartCardEnabled;
    private boolean mobileDeviceKeyReset;
    private boolean smartCardActivationRequested;
    private final boolean canBeModified_Setup;
    private final int modificationReason_Setup;
    private final boolean canBeModified_Smartcard;
    private final int modificationReason_Smartcard;
    private final boolean canBeModified_Reset;
    private final int modificationReason_Reset;

    public static MobileKeySetup$Builder builder() {
        return new MobileKeySetup$Builder();
    }

    private MobileKeySetup(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n, boolean bl6, int n2, boolean bl7, int n3) {
        this.mobileDeviceKeyEnabled = bl;
        this.smartCardEnabled = bl2;
        this.mobileDeviceKeyReset = bl3;
        this.smartCardActivationRequested = bl4;
        this.canBeModified_Setup = bl5;
        this.modificationReason_Setup = n;
        this.canBeModified_Smartcard = bl6;
        this.modificationReason_Smartcard = n2;
        this.canBeModified_Reset = bl7;
        this.modificationReason_Reset = n3;
    }

    public boolean isMobDevKeyEnabled() {
        return this.mobileDeviceKeyEnabled;
    }

    public boolean isSmartCardEnabled() {
        return this.smartCardEnabled;
    }

    public boolean isMobileDeviceKeyReset() {
        return this.mobileDeviceKeyReset;
    }

    public boolean isSmartCardActivationRequested() {
        return this.smartCardActivationRequested;
    }

    public boolean canBeModified_Setup() {
        return this.canBeModified_Setup;
    }

    public int getModificationReason_Setup() {
        return this.modificationReason_Setup;
    }

    public boolean canBeModified_Smartcard() {
        return this.canBeModified_Smartcard;
    }

    public int getModificationReason_Smartcard() {
        return this.modificationReason_Smartcard;
    }

    public boolean canBeModified_Reset() {
        return this.canBeModified_Reset;
    }

    public int getModificationReason_Reset() {
        return this.modificationReason_Reset;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.canBeModified_Setup ? 1231 : 1237);
        n = 31 * n + this.modificationReason_Setup;
        n = 31 * n + (this.canBeModified_Smartcard ? 1231 : 1237);
        n = 31 * n + this.modificationReason_Smartcard;
        n = 31 * n + (this.canBeModified_Reset ? 1231 : 1237);
        n = 31 * n + this.modificationReason_Reset;
        n = 31 * n + (this.mobileDeviceKeyEnabled ? 1231 : 1237);
        n = 31 * n + (this.smartCardEnabled ? 1231 : 1237);
        n = 31 * n + (this.mobileDeviceKeyReset ? 1231 : 1237);
        n = 31 * n + (this.smartCardActivationRequested ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MobileKeySetup mobileKeySetup = (MobileKeySetup)object;
        if (this.canBeModified_Setup != mobileKeySetup.canBeModified_Setup) {
            return false;
        }
        if (this.modificationReason_Setup != mobileKeySetup.modificationReason_Setup) {
            return false;
        }
        if (this.canBeModified_Smartcard != mobileKeySetup.canBeModified_Smartcard) {
            return false;
        }
        if (this.modificationReason_Smartcard != mobileKeySetup.modificationReason_Smartcard) {
            return false;
        }
        if (this.canBeModified_Reset != mobileKeySetup.canBeModified_Reset) {
            return false;
        }
        if (this.modificationReason_Reset != mobileKeySetup.modificationReason_Reset) {
            return false;
        }
        if (this.mobileDeviceKeyEnabled != mobileKeySetup.mobileDeviceKeyEnabled) {
            return false;
        }
        if (this.smartCardEnabled != mobileKeySetup.smartCardEnabled) {
            return false;
        }
        if (this.mobileDeviceKeyReset != mobileKeySetup.mobileDeviceKeyReset) {
            return false;
        }
        return this.smartCardActivationRequested == mobileKeySetup.smartCardActivationRequested;
    }

    public String toString() {
        return new StringBuffer().append("MobileKeySetup [mobileDeviceKeyEnabled=").append(this.mobileDeviceKeyEnabled).append(", smartCardEnabled=").append(this.smartCardEnabled).append(", mobileDeviceKeyReset=").append(this.mobileDeviceKeyReset).append(", smartCardActivationRequested=").append(this.smartCardActivationRequested).append(", canBeModified_Setup=").append(this.canBeModified_Setup).append(", modificationReason_Setup=").append(this.modificationReason_Setup).append("]").append(", canBeModified_Smartcard=").append(this.canBeModified_Smartcard).append(", modificationReason_Smartcard=").append(this.modificationReason_Smartcard).append("]").append(", canBeModified_Reset=").append(this.canBeModified_Reset).append(", modificationReason_Reset=").append(this.modificationReason_Reset).append("]").toString();
    }
}

