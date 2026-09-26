/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.PrivacySetup$Builder;

public final class PrivacySetup {
    private final boolean privacyModeOn;
    private final boolean canBeModified;
    private final int modificationReason;

    public static PrivacySetup$Builder builder() {
        return new PrivacySetup$Builder();
    }

    private PrivacySetup(boolean bl, boolean bl2, int n) {
        this.privacyModeOn = bl;
        this.canBeModified = bl2;
        this.modificationReason = n;
    }

    public boolean isPrivacyModeOn() {
        return this.privacyModeOn;
    }

    public boolean canBeModified() {
        return this.canBeModified;
    }

    public int getModificationReason() {
        return this.modificationReason;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.canBeModified ? 1231 : 1237);
        n = 31 * n + this.modificationReason;
        n = 31 * n + (this.privacyModeOn ? 1231 : 1237);
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
        PrivacySetup privacySetup = (PrivacySetup)object;
        if (this.canBeModified != privacySetup.canBeModified) {
            return false;
        }
        if (this.modificationReason != privacySetup.modificationReason) {
            return false;
        }
        return this.privacyModeOn == privacySetup.privacyModeOn;
    }

    public String toString() {
        return new StringBuffer().append("PrivacySetup [privacyModeOn=").append(this.privacyModeOn).append(", canBeModified=").append(this.canBeModified).append(", modificationReason=").append(this.modificationReason).append("]").toString();
    }
}

