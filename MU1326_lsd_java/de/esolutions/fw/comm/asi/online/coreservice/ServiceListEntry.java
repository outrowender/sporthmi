/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import java.util.Arrays;
import org.dsi.ifc.online.OSRLicense;

public class ServiceListEntry {
    public String serviceId;
    public String version;
    public String url;
    public String scope;
    public OSRLicense[] licenses;
    public boolean isEnabled;

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String string) {
        this.serviceId = string;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String string) {
        this.version = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String string) {
        this.scope = string;
    }

    public OSRLicense[] getLicenses() {
        return this.licenses;
    }

    public void setLicenses(OSRLicense[] oSRLicenseArray) {
        this.licenses = oSRLicenseArray;
    }

    public boolean isIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(boolean bl) {
        this.isEnabled = bl;
    }

    public ServiceListEntry() {
        this.licenses = null;
    }

    public ServiceListEntry(String string, String string2, String string3, String string4, OSRLicense[] oSRLicenseArray, boolean bl) {
        this.serviceId = string;
        this.version = string2;
        this.url = string3;
        this.scope = string4;
        this.licenses = oSRLicenseArray;
        this.isEnabled = bl;
    }

    public String toString() {
        return "ServiceListEntry{" + "serviceId=" + this.serviceId + ", version=" + this.version + ", url=" + this.url + ", scope=" + this.scope + ", licenses=" + "[" + (this.licenses == null ? "null" : Arrays.asList(this.licenses).toString()) + "]" + ", isEnabled=" + this.isEnabled + "}";
    }
}

