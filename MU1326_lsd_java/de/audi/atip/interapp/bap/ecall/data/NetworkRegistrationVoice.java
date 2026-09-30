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
        if (this.getClass() != object.getClass()) {
            return false;
        }
        NetworkRegistrationVoice networkRegistrationVoice = (NetworkRegistrationVoice)object;
        if (this.networkKind != networkRegistrationVoice.networkKind) {
            return false;
        }
        return this.registrationState == networkRegistrationVoice.registrationState;
    }

    public String toString() {
        return "NetworkRegistrationVoice [registrationState=" + this.registrationState + ", networkKind=" + this.networkKind + "]";
    }

    public static final class State {
        public static final int NOT_REGISTERED_AND_NOT_SEARCHING = 0;
        public static final int REGISTERED = 1;
        public static final int NOT_REGISTERED_AND_SEARCHING = 2;
        public static final int REGISTRATION_DENIED = 3;
        public static final int REGISTERED_AND_ROAMING = 4;
        public static final int REGISTERED_AND_ROAMING_ALTERNATIVE = 5;
        public static final int FUNCTION_NOT_SUPPORTED_BY_MOBILE_EQUIPEMENT = 255;

        private State() {
            throw new AssertionError((Object)"NetworkRegistrationVoice.State is not intended to be instantiated.");
        }
    }

    public static final class NetworkKind {
        public static final int UNKNOWN = 0;
        public static final int GSM = 1;
        public static final int UMTS = 2;
        public static final int CDMA = 3;
        public static final int LTE = 4;

        private NetworkKind() {
            throw new AssertionError((Object)"NetworkRegistrationVoice.NetworkKind is not intended to be instantiated.");
        }
    }
}

