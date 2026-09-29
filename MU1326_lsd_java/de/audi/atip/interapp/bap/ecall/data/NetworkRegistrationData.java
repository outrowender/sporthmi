/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class NetworkRegistrationData {
    private final int registrationState;
    private final int networkKind;

    public static NetworkRegistrationData getInstance(int n, int n2) {
        return new NetworkRegistrationData(n, n2);
    }

    private NetworkRegistrationData(int n, int n2) {
        this.registrationState = n;
        this.networkKind = n2;
    }

    public int getRegistrationState() {
        return this.registrationState;
    }

    public int getNetworkKind() {
        return this.networkKind;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.networkKind;
        n = 31 * n + this.registrationState;
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
        NetworkRegistrationData networkRegistrationData = (NetworkRegistrationData)object;
        if (this.networkKind != networkRegistrationData.networkKind) {
            return false;
        }
        return this.registrationState == networkRegistrationData.registrationState;
    }

    public String toString() {
        return new StringBuffer().append("NetworkRegistrationData [registrationState=").append(this.registrationState).append(", networkKind=").append(this.networkKind).append("]").toString();
    }
}

