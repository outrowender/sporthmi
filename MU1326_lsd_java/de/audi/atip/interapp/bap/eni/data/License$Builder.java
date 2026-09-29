/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.License;

public final class License$Builder {
    private String id;
    private int state;
    private String activationDate;
    private String expirationDate;
    private String validityDuration;

    public License$Builder setId(String string) {
        this.id = string;
        return this;
    }

    public License$Builder setState(int n) {
        this.state = n;
        return this;
    }

    public License$Builder setActivationDate(String string) {
        this.activationDate = string;
        return this;
    }

    public License$Builder setExpirationDate(String string) {
        this.expirationDate = string;
        return this;
    }

    public License$Builder setValidityDuration(String string) {
        this.validityDuration = string;
        return this;
    }

    public License build() {
        return new License(this.id, this.state, this.activationDate, this.expirationDate, this.validityDuration);
    }
}

