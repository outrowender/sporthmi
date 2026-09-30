/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class PrivacySetup {
    private final boolean privacyModeOn;
    private final boolean canBeModified;
    private final int modificationReason;

    public static Builder builder() {
        return new Builder();
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
        if (this.getClass() != object.getClass()) {
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

    public static final class Builder {
        private boolean privacyModeOn;
        private boolean canBeModified;
        private int modificationReason;

        public Builder setPrivacyModeOn(boolean bl) {
            this.privacyModeOn = bl;
            return this;
        }

        public Builder setCanBeModified(boolean bl) {
            this.canBeModified = bl;
            return this;
        }

        public Builder setModificationReason(int n) {
            this.modificationReason = n;
            return this;
        }

        public PrivacySetup build() {
            return new PrivacySetup(this.privacyModeOn, this.canBeModified, this.modificationReason);
        }
    }

    public static final class ModificationReason {
        public static final int NO_REASON = 0;
        public static final int CLAMP_15_NOT_ACTIVE = 2;
        public static final int DEFECTIVE = 4;
        public static final int SYSTEM_OFF = 5;
        public static final int NO_CONTRACT = 6;

        private ModificationReason() {
            throw new AssertionError((Object)"PrivacySetup.ModificationReason is not intended to be instantiated.");
        }
    }
}

