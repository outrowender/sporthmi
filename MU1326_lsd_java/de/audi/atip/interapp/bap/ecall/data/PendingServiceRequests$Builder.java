/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;

public final class PendingServiceRequests$Builder {
    private boolean breakdownServicePending;
    private boolean accidentalDamageManagementPending;
    private boolean infoCallPending;
    private boolean automaticCrashNotificationPending;
    private boolean manualEmergencyCallPending;
    private boolean testModePending;

    public PendingServiceRequests$Builder setBreakdownServicePending(boolean bl) {
        this.breakdownServicePending = bl;
        return this;
    }

    public PendingServiceRequests$Builder setAccidentalDamageManagementPending(boolean bl) {
        this.accidentalDamageManagementPending = bl;
        return this;
    }

    public PendingServiceRequests$Builder setInfoCallPending(boolean bl) {
        this.infoCallPending = bl;
        return this;
    }

    public PendingServiceRequests$Builder setAutomaticCrashNotificationPending(boolean bl) {
        this.automaticCrashNotificationPending = bl;
        return this;
    }

    public PendingServiceRequests$Builder setManualEmergencyCallPending(boolean bl) {
        this.manualEmergencyCallPending = bl;
        return this;
    }

    public PendingServiceRequests$Builder setTestModePending(boolean bl) {
        this.testModePending = bl;
        return this;
    }

    public PendingServiceRequests build() {
        return new PendingServiceRequests(this.breakdownServicePending, this.accidentalDamageManagementPending, this.infoCallPending, this.automaticCrashNotificationPending, this.manualEmergencyCallPending, this.testModePending);
    }
}

