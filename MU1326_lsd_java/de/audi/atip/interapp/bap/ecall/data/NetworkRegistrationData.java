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
        if (this.getClass() != object.getClass()) {
            return false;
        }
        NetworkRegistrationData networkRegistrationData = (NetworkRegistrationData)object;
        if (this.networkKind != networkRegistrationData.networkKind) {
            return false;
        }
        return this.registrationState == networkRegistrationData.registrationState;
    }

    public String toString() {
        return "NetworkRegistrationData [registrationState=" + this.registrationState + ", networkKind=" + this.networkKind + "]";
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
            throw new AssertionError((Object)"NetworkRegistrationData.State is not intended to be instantiated.");
        }
    }

    public static final class NetworkKind {
        public static final int NO_DATA_SERVICE = 0;
        public static final int GSM_GPRS = 1;
        public static final int GSM_EDGE = 2;
        public static final int HSDPA_HIGH_SPEED_DOWNLINK_PACKET_ACCESS = 3;
        public static final int HSUPA_HIGH_SPEED_UPLINK_PACKET_ACCESS = 4;
        public static final int CDMA = 5;
        public static final int LTE = 6;
        public static final int UNKNOWN = 255;

        private NetworkKind() {
            throw new AssertionError((Object)"NetworkRegistrationData.NetworkKind is not intended to be instantiated.");
        }
    }
}

