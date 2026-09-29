/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.License$Builder;

public final class License {
    private final String id;
    private final int state;
    private final String activationDate;
    private final String expirationDate;
    private final String validityDuration;

    public static License$Builder builder() {
        return new License$Builder();
    }

    private License(String string, int n, String string2, String string3, String string4) {
        this.id = string;
        this.state = n;
        this.activationDate = string2;
        this.expirationDate = string3;
        this.validityDuration = string4;
    }

    public String getId() {
        return this.id;
    }

    public int getState() {
        return this.state;
    }

    public String getActivationDate() {
        return this.activationDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public String getValidityDuration() {
        return this.validityDuration;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.activationDate == null ? 0 : this.activationDate.hashCode());
        n = 31 * n + (this.expirationDate == null ? 0 : this.expirationDate.hashCode());
        n = 31 * n + (this.id == null ? 0 : this.id.hashCode());
        n = 31 * n + this.state;
        n = 31 * n + (this.validityDuration == null ? 0 : this.validityDuration.hashCode());
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
        License license = (License)object;
        if (this.activationDate == null ? license.activationDate != null : !this.activationDate.equals(license.activationDate)) {
            return false;
        }
        if (this.expirationDate == null ? license.expirationDate != null : !this.expirationDate.equals(license.expirationDate)) {
            return false;
        }
        if (this.id == null ? license.id != null : !this.id.equals(license.id)) {
            return false;
        }
        if (this.state != license.state) {
            return false;
        }
        return !(this.validityDuration == null ? license.validityDuration != null : !this.validityDuration.equals(license.validityDuration));
    }

    public String toString() {
        return new StringBuffer().append("License [id=").append(this.id).append(", state=").append(this.state).append(", activationDate=").append(this.activationDate).append(", expirationDate=").append(this.expirationDate).append(", validityDuration=").append(this.validityDuration).append("]").toString();
    }
}

