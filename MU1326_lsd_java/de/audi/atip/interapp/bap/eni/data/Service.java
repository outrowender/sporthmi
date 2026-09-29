/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.Service$Builder;

public class Service {
    private boolean disablingByDriverAllowed;
    private boolean serviceAllowedByVehicle;
    private final int internalId;
    private final String id;
    private final String name;
    private final String version;
    private final boolean enabled;
    private final boolean roamingAllowed;
    private final boolean hasExpirationWarning;
    private final boolean isProtected;
    private final boolean enabledByUser;
    private final License license;
    private final boolean gpsRequired;

    public static Service$Builder builder() {
        return new Service$Builder();
    }

    private Service(int n, String string, String string2, String string3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, License license, boolean bl6, boolean bl7, boolean bl8) {
        this.internalId = n;
        this.id = string;
        this.name = string2;
        this.version = string3;
        this.enabled = bl;
        this.roamingAllowed = bl2;
        this.hasExpirationWarning = bl3;
        this.isProtected = bl4;
        this.enabledByUser = bl5;
        this.license = license;
        this.gpsRequired = bl6;
        this.disablingByDriverAllowed = bl7;
        this.serviceAllowedByVehicle = bl8;
    }

    public int getInternalId() {
        return this.internalId;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isRoamingAllowed() {
        return this.roamingAllowed;
    }

    public boolean hasExpirationWarning() {
        return this.hasExpirationWarning;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public boolean isEnabledByUser() {
        return this.enabledByUser;
    }

    public License getLicense() {
        return this.license;
    }

    public boolean isGPSRequired() {
        return this.gpsRequired;
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
        Service service = (Service)object;
        if (this.enabled != service.enabled) {
            return false;
        }
        if (this.enabledByUser != service.enabledByUser) {
            return false;
        }
        if (this.hasExpirationWarning != service.hasExpirationWarning) {
            return false;
        }
        if (this.id == null ? service.id != null : !this.id.equals(service.id)) {
            return false;
        }
        if (this.internalId != service.internalId) {
            return false;
        }
        if (this.isProtected != service.isProtected) {
            return false;
        }
        if (this.license == null ? service.license != null : !this.license.equals(service.license)) {
            return false;
        }
        if (this.gpsRequired != service.gpsRequired) {
            return false;
        }
        if (this.name == null ? service.name != null : !this.name.equals(service.name)) {
            return false;
        }
        if (this.roamingAllowed != service.roamingAllowed) {
            return false;
        }
        return !(this.version == null ? service.version != null : !this.version.equals(service.version));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.enabled ? 1231 : 1237);
        n = 31 * n + (this.enabledByUser ? 1231 : 1237);
        n = 31 * n + (this.hasExpirationWarning ? 1231 : 1237);
        n = 31 * n + (this.id == null ? 0 : this.id.hashCode());
        n = 31 * n + this.internalId;
        n = 31 * n + (this.isProtected ? 1231 : 1237);
        n = 31 * n + (this.license == null ? 0 : this.license.hashCode());
        n = 31 * n + (this.gpsRequired ? 1231 : 1237);
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        n = 31 * n + (this.roamingAllowed ? 1231 : 1237);
        n = 31 * n + (this.version == null ? 0 : this.version.hashCode());
        return n;
    }

    public String toString() {
        return new StringBuffer().append("Service [internalId=").append(this.internalId).append(", id=").append(this.id).append(", name=").append(this.name).append(", version=").append(this.version).append(", enabled=").append(this.enabled).append(", roamingAllowed=").append(this.roamingAllowed).append(", hasExpirationWarning=").append(this.hasExpirationWarning).append(", isProtected=").append(this.isProtected).append(", enabledByUser=").append(this.enabledByUser).append(", license=").append(this.license).append(", gpsRequired=").append(this.gpsRequired).append("]").toString();
    }

    public boolean isDisablingByDriverAllowed() {
        return this.disablingByDriverAllowed;
    }

    public boolean isServiceAllowedByVehicle() {
        return this.serviceAllowedByVehicle;
    }
}

