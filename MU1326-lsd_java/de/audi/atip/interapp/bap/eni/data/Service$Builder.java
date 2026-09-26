/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.Service;

public final class Service$Builder {
    private int internalId;
    private String id;
    private String name;
    private String version;
    private boolean enabled;
    private boolean roamingAllowed;
    private boolean hasExpirationWarning;
    private boolean isProtected;
    private boolean enabledByUser;
    private License license;
    private boolean gpsRequired;
    private boolean disablingByDriverAllowed = true;
    private boolean serviceAllowedByVehicle;

    public Service$Builder setInternalId(int n) {
        this.internalId = n;
        return this;
    }

    public Service$Builder setId(String string) {
        this.id = string;
        return this;
    }

    public Service$Builder setName(String string) {
        this.name = string;
        return this;
    }

    public Service$Builder setVersion(String string) {
        this.version = string;
        return this;
    }

    public Service$Builder setEnabled(boolean bl) {
        this.enabled = bl;
        return this;
    }

    public Service$Builder setRoamingAllowed(boolean bl) {
        this.roamingAllowed = bl;
        return this;
    }

    public Service$Builder setHasExpirationWarning(boolean bl) {
        this.hasExpirationWarning = bl;
        return this;
    }

    public Service$Builder setProtected(boolean bl) {
        this.isProtected = bl;
        return this;
    }

    public Service$Builder setEnabledByUser(boolean bl) {
        this.enabledByUser = bl;
        return this;
    }

    public Service$Builder setLicense(License license) {
        this.license = license;
        return this;
    }

    public Service$Builder setGPSRequired(boolean bl) {
        this.gpsRequired = bl;
        return this;
    }

    public Service$Builder setDisablingByDriverAllowed(boolean bl) {
        this.disablingByDriverAllowed = bl;
        return this;
    }

    public void setAllowedByVehicle(boolean bl) {
        this.serviceAllowedByVehicle = bl;
    }

    public Service build() {
        return new Service(this.internalId, this.id, this.name, this.version, this.enabled, this.roamingAllowed, this.hasExpirationWarning, this.isProtected, this.enabledByUser, this.license, this.gpsRequired, this.disablingByDriverAllowed, this.serviceAllowedByVehicle);
    }
}

