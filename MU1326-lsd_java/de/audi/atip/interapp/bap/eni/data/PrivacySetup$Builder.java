/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.PrivacySetup;

public final class PrivacySetup$Builder {
    private boolean privacyModeOn;
    private boolean canBeModified;
    private int modificationReason;

    public PrivacySetup$Builder setPrivacyModeOn(boolean bl) {
        this.privacyModeOn = bl;
        return this;
    }

    public PrivacySetup$Builder setCanBeModified(boolean bl) {
        this.canBeModified = bl;
        return this;
    }

    public PrivacySetup$Builder setModificationReason(int n) {
        this.modificationReason = n;
        return this;
    }

    public PrivacySetup build() {
        return new PrivacySetup(this.privacyModeOn, this.canBeModified, this.modificationReason);
    }
}

