/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests$Builder;
import de.esolutions.fw.util.commons.Buffer;

public final class PendingServiceRequests {
    private final boolean breakdownServicePending;
    private final boolean accidentalDamageManagementPending;
    private final boolean infoCallPending;
    private final boolean automaticCrashNotificationPending;
    private final boolean manualEmergencyCallPending;
    private final boolean testModePending;

    public static PendingServiceRequests$Builder builder() {
        return new PendingServiceRequests$Builder();
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
        if (super.getClass() != object.getClass()) {
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
}

