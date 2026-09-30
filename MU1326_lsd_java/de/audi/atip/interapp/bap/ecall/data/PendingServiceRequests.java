/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.esolutions.fw.util.commons.Buffer;

public final class PendingServiceRequests {
    private final boolean breakdownServicePending;
    private final boolean accidentalDamageManagementPending;
    private final boolean infoCallPending;
    private final boolean automaticCrashNotificationPending;
    private final boolean manualEmergencyCallPending;
    private final boolean testModePending;

    public static Builder builder() {
        return new Builder();
    }

    private PendingServiceRequests(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.breakdownServicePending = bl;
        this.accidentalDamageManagementPending = bl2;
        this.infoCallPending = bl3;
        this.automaticCrashNotificationPending = bl4;
        this.manualEmergencyCallPending = bl5;
        this.testModePending = bl6;
    }

    public boolean isBreakdownServicePending() {
        return this.breakdownServicePending;
    }

    public boolean isAccidentalDamageManagementPending() {
        return this.accidentalDamageManagementPending;
    }

    public boolean isInfoCallPending() {
        return this.infoCallPending;
    }

    public boolean isAutomaticCrashNotificationPending() {
        return this.automaticCrashNotificationPending;
    }

    public boolean isManualEmergencyCallPending() {
        return this.manualEmergencyCallPending;
    }

    public boolean isTestModePending() {
        return this.testModePending;
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
        PendingServiceRequests pendingServiceRequests = (PendingServiceRequests)object;
        if (this.accidentalDamageManagementPending != pendingServiceRequests.accidentalDamageManagementPending) {
            return false;
        }
        if (this.automaticCrashNotificationPending != pendingServiceRequests.automaticCrashNotificationPending) {
            return false;
        }
        if (this.breakdownServicePending != pendingServiceRequests.breakdownServicePending) {
            return false;
        }
        if (this.infoCallPending != pendingServiceRequests.infoCallPending) {
            return false;
        }
        if (this.manualEmergencyCallPending != pendingServiceRequests.manualEmergencyCallPending) {
            return false;
        }
        return this.testModePending == pendingServiceRequests.testModePending;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.accidentalDamageManagementPending ? 1231 : 1237);
        n = 31 * n + (this.automaticCrashNotificationPending ? 1231 : 1237);
        n = 31 * n + (this.breakdownServicePending ? 1231 : 1237);
        n = 31 * n + (this.infoCallPending ? 1231 : 1237);
        n = 31 * n + (this.manualEmergencyCallPending ? 1231 : 1237);
        n = 31 * n + (this.testModePending ? 1231 : 1237);
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer("PendingServiceRequests [breakdownServicePending=");
        buffer.append(this.breakdownServicePending);
        buffer.append(", accidentalDamageManagementPending=");
        buffer.append(this.accidentalDamageManagementPending);
        buffer.append(", infoCallPending=");
        buffer.append(this.infoCallPending);
        buffer.append(", automaticCrashNotificationPending=");
        buffer.append(this.automaticCrashNotificationPending);
        buffer.append(", manualEmergencyCallPending=");
        buffer.append(this.manualEmergencyCallPending);
        buffer.append(", testModePending=");
        buffer.append(new StringBuffer().append(this.testModePending).append("]").toString());
        return buffer.toString();
    }

    public static final class Builder {
        private boolean breakdownServicePending;
        private boolean accidentalDamageManagementPending;
        private boolean infoCallPending;
        private boolean automaticCrashNotificationPending;
        private boolean manualEmergencyCallPending;
        private boolean testModePending;

        public Builder setBreakdownServicePending(boolean bl) {
            this.breakdownServicePending = bl;
            return this;
        }

        public Builder setAccidentalDamageManagementPending(boolean bl) {
            this.accidentalDamageManagementPending = bl;
            return this;
        }

        public Builder setInfoCallPending(boolean bl) {
            this.infoCallPending = bl;
            return this;
        }

        public Builder setAutomaticCrashNotificationPending(boolean bl) {
            this.automaticCrashNotificationPending = bl;
            return this;
        }

        public Builder setManualEmergencyCallPending(boolean bl) {
            this.manualEmergencyCallPending = bl;
            return this;
        }

        public Builder setTestModePending(boolean bl) {
            this.testModePending = bl;
            return this;
        }

        public PendingServiceRequests build() {
            return new PendingServiceRequests(this.breakdownServicePending, this.accidentalDamageManagementPending, this.infoCallPending, this.automaticCrashNotificationPending, this.manualEmergencyCallPending, this.testModePending);
        }
    }
}

