/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;

public final class MobileKeySetup$Builder {
    private boolean mobileDeviceKeyEnabled;
    private boolean smartCardEnabled;
    private boolean mobileDeviceKeyReset;
    private boolean smartCardActivationRequested;
    private boolean canBeModified_Setup;
    private boolean canBeModified_Smartcard;
    private boolean canBeModified_Reset;
    private int modificationReason_Setup;
    private int modificationReason_Smartcard;
    private int modificationReason_Reset;

    public MobileKeySetup$Builder setMobDevKeyEnabled(boolean bl) {
        this.mobileDeviceKeyEnabled = bl;
        return this;
    }

    public MobileKeySetup$Builder setSmartCardEnabled(boolean bl) {
        this.smartCardEnabled = bl;
        return this;
    }

    public MobileKeySetup$Builder setMobileDeviceKeyReset(boolean bl) {
        this.mobileDeviceKeyReset = bl;
        return this;
    }

    public MobileKeySetup$Builder setSmartcardActivationRequested(boolean bl) {
        this.smartCardActivationRequested = bl;
        return this;
    }

    public MobileKeySetup$Builder setCanBeModified_Setup(boolean bl) {
        this.canBeModified_Setup = bl;
        return this;
    }

    public MobileKeySetup$Builder setModificationReason_Setup(int n) {
        this.modificationReason_Setup = n;
        return this;
    }

    public MobileKeySetup$Builder setCanBeModified_Smartcard(boolean bl) {
        this.canBeModified_Smartcard = bl;
        return this;
    }

    public MobileKeySetup$Builder setModificationReason_Smartcard(int n) {
        this.modificationReason_Smartcard = n;
        return this;
    }

    public MobileKeySetup$Builder setCanBeModified_Reset(boolean bl) {
        this.canBeModified_Reset = bl;
        return this;
    }

    public MobileKeySetup$Builder setModificationReason_Reset(int n) {
        this.modificationReason_Reset = n;
        return this;
    }

    public MobileKeySetup build() {
        return new MobileKeySetup(this.mobileDeviceKeyEnabled, this.smartCardEnabled, this.mobileDeviceKeyReset, this.smartCardActivationRequested, this.canBeModified_Setup, this.modificationReason_Setup, this.canBeModified_Smartcard, this.modificationReason_Smartcard, this.canBeModified_Reset, this.modificationReason_Reset);
    }
}

