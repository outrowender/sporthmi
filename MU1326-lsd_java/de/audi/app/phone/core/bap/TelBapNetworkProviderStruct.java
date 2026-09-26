/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.esolutions.fw.util.commons.Buffer;

public class TelBapNetworkProviderStruct {
    private final int networkProviderState;
    private final String networkProviderName;
    private final int serviceProviderState;
    private final String serviceProviderName;

    public TelBapNetworkProviderStruct(int n, String string, int n2, String string2) {
        this.networkProviderState = n;
        this.networkProviderName = string != null ? string : "";
        this.serviceProviderState = n2;
        this.serviceProviderName = string2 != null ? string2 : "";
    }

    public int getNetworkProviderState() {
        return this.networkProviderState;
    }

    public String getNetworkProviderName() {
        return this.networkProviderName;
    }

    public int getServiceProviderState() {
        return this.serviceProviderState;
    }

    public String getServiceProviderName() {
        return this.serviceProviderName;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelBapNetworkProviderStruct(");
        buffer.append("networkProviderState=");
        buffer.append(this.networkProviderState);
        buffer.append(", networkProviderName=");
        buffer.append(this.networkProviderName);
        buffer.append(", serviceProviderState=");
        buffer.append(this.serviceProviderState);
        buffer.append(", serviceProviderName=");
        buffer.append(this.serviceProviderName);
        buffer.append(")");
        return buffer.toString();
    }

    public int hashCode() {
        int n = this.serviceProviderName != null ? this.serviceProviderName.hashCode() : 0;
        int n2 = this.networkProviderName != null ? this.networkProviderName.hashCode() : 0;
        int n3 = 1;
        n3 = 31 * (n3 + this.networkProviderState + this.serviceProviderState + n + n2);
        return n3;
    }

    public boolean equals(Object object) {
        if (object instanceof TelBapNetworkProviderStruct) {
            TelBapNetworkProviderStruct telBapNetworkProviderStruct = (TelBapNetworkProviderStruct)object;
            return this.networkProviderState == telBapNetworkProviderStruct.networkProviderState && this.networkProviderName.equals(telBapNetworkProviderStruct.networkProviderName) && this.serviceProviderState == telBapNetworkProviderStruct.serviceProviderState && this.serviceProviderName.equals(telBapNetworkProviderStruct.serviceProviderName);
        }
        return false;
    }
}

