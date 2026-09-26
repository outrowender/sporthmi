/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class NetworkRegistrationVoice {
    private final int registrationState;
    private final int networkKind;

    public static NetworkRegistrationVoice getInstance(int n, int n2) {
        return new NetworkRegistrationVoice(n, n2);
    }

    private NetworkRegistrationVoice(int n, int n2) {
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
        NetworkRegistrationVoice networkRegistrationVoice = (NetworkRegistrationVoice)object;
        if (this.networkKind != networkRegistrationVoice.networkKind) {
            return false;
        }
        return this.registrationState == networkRegistrationVoice.registrationState;
    }

    public String toString() {
        return new StringBuffer().append("NetworkRegistrationVoice [registrationState=").append(this.registrationState).append(", networkKind=").append(this.networkKind).append("]").toString();
    }
}

